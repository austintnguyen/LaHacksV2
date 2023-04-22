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
        System.out.println("Enter the number of classes you have from Mon to Fri:");
        System.out.println("(For example, 3 1 5 2 3)");
        String days = "";
        boolean validInput = false;

        while (days.length() != 9 && !validInput) {
            days = s.nextLine();
            if (days.length() != 9) {
                System.out.println("Invalid input");
            }
            else {
                for (int i = 0; i < days.length(); i++) {

                }
            }
        }
        
        System.out.println("days "+days);

        for (int i = 0; i < days.length(); i++) {
            System.out.println(i);
        }
        // return days
        return null;
    }

}
