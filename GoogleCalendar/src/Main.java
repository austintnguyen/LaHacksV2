import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

import net.fortuna.ical4j.validate.ValidationException;

public class Main {
    public static void main(String arg[]) throws ValidationException, ParseException, IOException {
        //Code for manual terminal input
        // InputOutput u = new InputOutput();
        // Scanner s = new Scanner(System.in);
        // u.intro();
        // s.useDelimiter("STOP"); // use end-of-input as delimiter
        // u.getRawSchedule(s);
        // s.nextLine();
        // s.useDelimiter("\n");

        // //System.out.println();
        // s.close();

        AutoScheduler as = new AutoScheduler();
        as.pack();
        as.setVisible(true);
        
        

        /* 
        StringParse sp = new StringParse("input.txt");


        

        System.out.println("hey1");

        IcsFileCreator file = new IcsFileCreator(sp.getCourseList(), as);

        System.out.println("hey2");

        

        file.addAllCoursesToCalendar();
        System.out.println("hey3");
        */

    }
}

