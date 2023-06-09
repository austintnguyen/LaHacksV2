import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InputOutput {
    int[] numClasses;
    int[] startDate;

    public InputOutput(){
        numClasses = new int[5];
        startDate = new int[3];
    }

    public void intro() {
        System.out.println("Copy and input your schedule into the terminal "
        +"(Paste without formatting and end input with the keyword STOP):");
        System.out.println();
    }

    public void getRawSchedule(Scanner s) {
        String schedule = s.next();
        String fn = "input.txt";

        try (FileWriter w = new FileWriter(fn)) {
            w.write(schedule);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

   
    public void storeNumClasses(ArrayList<JComboBox<Integer>> daysCombo) {
        numClasses = new int[5];
        for (int i = 0; i < 5; i++) {
            numClasses[i] = (Integer) daysCombo.get(i).getSelectedItem();
        }
    }

    public int[] getNumClasses() {
        return numClasses;
    }

    public int[] getStartDate(){
        return startDate;
    }

    public int[] storeStartDate(String startDateI) {
        //System.out.println("Start Date: " + startDateI);
        startDate[0] = Integer.parseInt(startDateI.substring(0, 4));
        startDate[1] = Integer.parseInt(startDateI.substring(4, 6));
        startDate[2] = Integer.parseInt(startDateI.substring(6, 8));

        return this.startDate;
    }

    public void createFile(String text) {
        String fn = "input.txt";

        try {
            FileWriter fileWriter = new FileWriter(fn);
            fileWriter.write(text);
            fileWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
