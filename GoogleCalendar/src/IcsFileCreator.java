import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
    
    public static void main(String[] args) throws IOException, URISyntaxException, ParseException {
        // Create a TimeZoneRegistry
        TimeZoneRegistry registry = TimeZoneRegistryFactory.getInstance().createRegistry();
        TimeZone timezone = registry.getTimeZone("America/Los_Angeles");
       
        System.out.println();
        System.out.println("Timezone "+ "Value: " + timezone.getID());

        // Create a Calendar object and set its properties
        Calendar calendar = new Calendar();
        calendar.getProperties().add(new ProdId("-//My Schedule//EN"));
        calendar.getProperties().add(Version.VERSION_2_0);
        calendar.getProperties().add(Method.PUBLISH);
        calendar.getProperties().add(CalScale.GREGORIAN);
        
        // Create a VEvent object and set its properties
       /* 
        DateTime startDateTime = new DateTime("20230422T090000",timezone);
        DateTime endDateTime = new DateTime("20230422T095000", timezone);


        VEvent event = new VEvent(startDateTime, endDateTime,"CSE 100");
       

        event.getProperties().add(new net.fortuna.ical4j.model.property.Description("Discuss project timeline."));
        event.getProperties().add(new net.fortuna.ical4j.model.property.Location("123 Main St."));

        // Add the event to the calendar
        calendar.getComponents().add(event);

        // Output the calendar to a file
        FileOutputStream fout = new FileOutputStream("event.ics");
        CalendarOutputter outputter = new CalendarOutputter();
        outputter.output(calendar, fout);
        */
        FileOutputStream fout = new FileOutputStream("schedule.ics");
        CalendarOutputter outputter = new CalendarOutputter();
        Course course = new Course("CSE 100", "33", "22", "Center Hall", "Le");
        addToCalendar(calendar, course, timezone, fout, outputter);
    }

    
    private static void addToCalendar(Calendar calendar, Course course, TimeZone timezone, FileOutputStream fout, CalendarOutputter outputter) throws ParseException, ValidationException, IOException{
        String rruleValue = "FREQ=WEEKLY;COUNT=10"; 
        DateTime startDateTime = new DateTime("20230422T110000",timezone);
        DateTime endDateTime = new DateTime("20230422T115000", timezone);
        VEvent event = new VEvent(startDateTime, endDateTime, course.getName());

        event.getProperties().add(new net.fortuna.ical4j.model.property.Description("Discuss project timeline."));
        event.getProperties().add(new net.fortuna.ical4j.model.property.Location("123 Main St."));
        Recur recur = new Recur(rruleValue);
        RRule rrule = new RRule(recur);
        event.getProperties().add(rrule); 
        
        // Add the event to the calendar
        calendar.getComponents().add(event);
        outputter.output(calendar, fout);

    }

//implement a function that will add each course to the calendar



}
