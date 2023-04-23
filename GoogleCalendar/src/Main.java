
import java.util.*;

public class Main {
    public static void main(String arg[]) {
        InputOutput u = new InputOutput();
        Scanner s = new Scanner(System.in);
        u.intro();
        s.useDelimiter("STOP"); // use end-of-input as delimiter
        u.getRawSchedule(s);
        s.nextLine();
        s.useDelimiter("\n");
        int[] days = u.getDays(s);
        String date = u.getDate(s);

        //System.out.println();
        s.close();
    }
}

