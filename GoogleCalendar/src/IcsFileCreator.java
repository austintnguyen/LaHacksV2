import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Year;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;

import net.fortuna.ical4j.data.CalendarOutputter;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.DateTime;
import net.fortuna.ical4j.model.Recur;
import net.fortuna.ical4j.model.TimeZone;
import net.fortuna.ical4j.model.TimeZoneRegistry;
import net.fortuna.ical4j.model.TimeZoneRegistryFactory;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.CalScale;
import net.fortuna.ical4j.model.property.Method;
import net.fortuna.ical4j.model.property.ProdId;
import net.fortuna.ical4j.model.property.RRule;
import net.fortuna.ical4j.model.property.Version;
import net.fortuna.ical4j.validate.ValidationException;

public class IcsFileCreator {

    TimeZoneRegistry registry;

    TimeZone timezone;

    Calendar calendar;

    FileOutputStream fout;

    CalendarOutputter outputter;

    ArrayList<Course> courseList;

    InputOutput io;

    public IcsFileCreator(ArrayList<Course> courseList, InputOutput io) throws FileNotFoundException {
        registry = TimeZoneRegistryFactory.getInstance().createRegistry();
        timezone = registry.getTimeZone("America/Los_Angeles");
        calendar = new Calendar();
        calendar.getProperties().add(new ProdId("-//My Schedule//EN"));
        calendar.getProperties().add(Version.VERSION_2_0);
        calendar.getProperties().add(Method.PUBLISH);
        calendar.getProperties().add(CalScale.GREGORIAN);
        fout = new FileOutputStream("schedule.ics");
        outputter = new CalendarOutputter();
        this.courseList = courseList;
        this.io = io;

    }

    public void addAllCoursesToCalendar() throws ValidationException, ParseException, IOException {
        int n = 0;
        int[] days = io.getNumClasses(); // change this when austin finishes
        // Get the start date from which to calculate the first Tuesday
        System.out.println(io.getStartDate()[0]);
        System.out.println(io.getStartDate()[1]);
        System.out.println(io.getStartDate()[2]);

        LocalDate startDate = LocalDate.of(io.getStartDate()[0], io.getStartDate()[1], io.getStartDate()[2]);

        System.out.println("hey");

        while (n < courseList.size()) {

            for (int i = 0; i < days.length; i++) {
                if (days[i] != 0) {

                    if (i == 0) {
                        // Calculate the first Tuesday after the start date
                        LocalDate firstMonday = startDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));

                        addCourse(calendar, courseList.get(n), timezone, fout, outputter, firstMonday);
                    } else if (i == 1) {
                        LocalDate firstTuesday = startDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY));
                        addCourse(calendar, courseList.get(n), timezone, fout, outputter, firstTuesday);

                    } else if (i == 2) {
                        LocalDate firstWednesday = startDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.WEDNESDAY));
                        addCourse(calendar, courseList.get(n), timezone, fout, outputter, firstWednesday);

                    } else if (i == 3) {
                        LocalDate firstThursday = startDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.THURSDAY));
                        addCourse(calendar, courseList.get(n), timezone, fout, outputter, firstThursday);

                    } else {
                        LocalDate firstFriday = startDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));
                        addCourse(calendar, courseList.get(n), timezone, fout, outputter, firstFriday);

                    }
                    days[i]--;
                    n++;

                }
            }
        }

        outputter.output(calendar, fout);
        fout.close();
        System.exit(0);

    }

    private void addCourse(Calendar calendar, Course course, TimeZone timezone, FileOutputStream fout,
            CalendarOutputter outputter, LocalDate day) throws ParseException, ValidationException, IOException {

        String rruleValue = "FREQ=WEEKLY;COUNT=10";
        String[] split = course.getstartTime().split(" ");

        DateTime startDateTime = new DateTime(
                day.atTime(LocalTime.of(Integer.parseInt(split[0]), Integer.parseInt(split[1])))
                        .atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());

        DateTime endDateTime = new DateTime(
                day.atTime(LocalTime.of(course.getendTimeFirstHalf(), course.getendTimeSecondHalf()))
                        .atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        VEvent event = new VEvent(startDateTime, endDateTime, course.getName() + " - " + course.getType());

        event.getProperties().add(new net.fortuna.ical4j.model.property.Location(course.getLocation()));
        Recur recur = new Recur(rruleValue);
        RRule rrule = new RRule(recur);
        event.getProperties().add(rrule);

        // Add the event to the calendar
        calendar.getComponents().add(event);

    }
}
