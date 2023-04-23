import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;

import net.fortuna.ical4j.data.CalendarOutputter;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.DateList;
import net.fortuna.ical4j.model.DateTime;
import net.fortuna.ical4j.model.Recur;
import net.fortuna.ical4j.model.TimeZone;
import net.fortuna.ical4j.model.TimeZoneRegistry;
import net.fortuna.ical4j.model.TimeZoneRegistryFactory;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.parameter.Value;
import net.fortuna.ical4j.model.property.CalScale;
import net.fortuna.ical4j.model.property.Method;
import net.fortuna.ical4j.model.property.ProdId;
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
        addToCalendar(calendar, timezone, fout, outputter);
    }

    
    private static void addToCalendar(Calendar calendar, TimeZone timezone, FileOutputStream fout, CalendarOutputter outputter) throws ParseException, ValidationException, IOException{
        String rruleValue = "FREQ=WEEKLY;COUNT=10"; 

        Recur recur = new Recur(rruleValue);

        StringParse sP = new StringParse("input.txt", true);
        sP.parseData();

        int[] arr = {3,1,5,1,5};
        int n = 0;
        int startDay = 24;
        while(n < sP.getCourseList().size()){
        for(int j = 0; j < 5; j++){

        
        DateList dateList = recur.getDates(new DateTime("202304"+(startDay+j)+"T"+sP.getCourseList().get(n).getstartTime()), new DateTime("20250425T"+sP.getCourseList().get(n).getstartTime()), Value.DATE_TIME);
        
        // Add the event to the calendar

        DateList datesToRemove = new DateList();
        // datesToRemove.add(new DateTime("20230401T100000"));
        // datesToRemove.add(new DateTime("20230522T100000"));
        
        if(arr[j]==0){
            continue;
        }

        System.out.println(n>=sP.getCourseList().size());

        System.out.println(n + "HERE!!!");
        System.out.println(sP.getCourseList().size() + "HERE!!!");

        for (Object date : dateList) {
            if (!datesToRemove.contains(date)) {

                DateTime startDateTime = new DateTime(date.toString(),timezone);
                DateTime endDateTime = new DateTime(date.toString(), timezone);


                VEvent event = new VEvent(startDateTime, endDateTime, sP.getCourseList().get(n).getName());

                event.getProperties().add(new net.fortuna.ical4j.model.property.Description("Discuss project timeline."));
                event.getProperties().add(new net.fortuna.ical4j.model.property.Location("123 Main St."));

                // Create a new event with the date and add it to the calendar
                calendar.getComponents().add(event);
                
            }
        }
        n++;
        arr[j]--;
    }
}

        outputter.output(calendar, fout);
        System.out.println(calendar.getComponents().size());

    }

//implement a function that will add each course to the calendar



}
