import java.util.*;

public class Main {
    public static void main(String arg[]) {
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
    }
}

