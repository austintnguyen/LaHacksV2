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
import net.fortuna.ical4j.model.TimeZone;
import net.fortuna.ical4j.model.TimeZoneRegistry;
import net.fortuna.ical4j.model.TimeZoneRegistryFactory;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.CalScale;
import net.fortuna.ical4j.model.property.Method;
import net.fortuna.ical4j.model.property.ProdId;
import net.fortuna.ical4j.model.property.Version;



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
      
        Date startDate = new Date(System.currentTimeMillis());
        //DateTime startDateTime = new DateTime(startDate);
    ;
        Date endDate = new Date(System.currentTimeMillis());
        //DateTime endDateTime = new DateTime(endDate);
        //DateTime startDateTime = new DateTime("2023-05-01T09:00:00", timezone);
        //DateTime endDateTime = new DateTime("2023-05-01T10:00:00", timezone);
        DateTime startDateTime1 = new DateTime("20230422T090000",timezone);
        DateTime endDateTime1 = new DateTime("20230422T095000", timezone);


        VEvent event = new VEvent(startDateTime1, endDateTime1,"CSE 100");
       

        event.getProperties().add(new net.fortuna.ical4j.model.property.Description("Discuss project timeline."));
        event.getProperties().add(new net.fortuna.ical4j.model.property.Location("123 Main St."));

        // Add the event to the calendar
        calendar.getComponents().add(event);

        // Output the calendar to a file
        FileOutputStream fout = new FileOutputStream("event.ics");
        CalendarOutputter outputter = new CalendarOutputter();
        outputter.output(calendar, fout);
    }
}
