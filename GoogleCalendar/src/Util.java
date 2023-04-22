import java.util.*;
import java.io.FileWriter;
import java.io.IOException;

public class Util {
    public void intro() {
        System.out.println("Copy and input your schedule into the terminal "
        +"(Paste without formatting and end input with the keyword STOP):");
        System.out.println();
    }

    public void getRawSchedule() {
        Scanner s = new Scanner(System.in);
        s.useDelimiter("STOP"); // use end-of-input as delimiter
        String schedule = s.next();
        //System.out.println("Input string:\n" + schedule);
        String fn = "input.txt";

        try (FileWriter w = new FileWriter(fn)) {
            w.write(schedule);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        s.close();
    }

}
