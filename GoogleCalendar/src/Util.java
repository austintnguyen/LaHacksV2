import java.util.*;
import java.io.FileWriter;
import java.io.IOException;

public class Util {
    public void intro() {
        System.out.println("Copy and input your schedule into the terminal "
        +"(Paste without formatting and end input with the keyword STOP):");
        System.out.println();
    }

    public void getRawSchedule(Scanner s) {
        s.useDelimiter("STOP"); // use end-of-input as delimiter
        String schedule = s.next();
        String fn = "input.txt";

        try (FileWriter w = new FileWriter(fn)) {
            w.write(schedule);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public int[] getDays(Scanner s) {
        s.useDelimiter("\n");
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        int numClasses[] = new int[5];

        for (int i = 0; i < days.length; i++) {
            System.out.println("Number of classes on "+days[i]+": ");
            numClasses[i] = s.nextInt();
        }

        return numClasses;
    }

}
