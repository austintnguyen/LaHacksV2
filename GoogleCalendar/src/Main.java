
import java.util.*;

public class Main {
    public static void main(String arg[]) {
        Util u = new Util();
        Scanner s = new Scanner(System.in);
        u.intro();
        u.getRawSchedule(s);
        s.nextLine();
        int[] days = u.getDays(s);

        //System.out.println();
        s.close();
    }
}

