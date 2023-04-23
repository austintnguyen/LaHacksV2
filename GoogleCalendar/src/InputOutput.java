import java.util.*;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InputOutput {
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

    public int[] getDays(Scanner s) {
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        int numClasses[] = new int[5];

        for (int i = 0; i < days.length; i++) {
            System.out.println("Number of classes on "+days[i]+": ");
            numClasses[i] = s.nextInt();
        }

        return numClasses;
    }

    public String getDate(Scanner s) {
        System.out.println("Please input the date of the first day of the quarter in YYYYMMDD format: ");
        String input = s.next();
        return input;
    }

    public String run(JTextArea scheduleI, JTextArea startDayI, 
    JTextArea startMonthI, JTextArea startYearI, ArrayList<JComboBox<Integer>> daysCombo 
    ) {
        String schedule = scheduleI.getText();
        String startD = startDayI.getText();
        String startM = startMonthI.getText();
        String startY = startYearI.getText();

        // Integer mon = (Integer) monI.getSelectedItem();
        // Integer tue = (Integer) tueI.getSelectedItem();
        // Integer wed = (Integer) wedI.getSelectedItem();
        // Integer thu = (Integer) thuI.getSelectedItem();
        // Integer fri = (Integer) friI.getSelectedItem();


        //put schedule into file


        return null;
    }
}
