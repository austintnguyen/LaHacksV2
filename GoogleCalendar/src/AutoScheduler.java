import javax.swing.*;

import net.fortuna.ical4j.validate.ValidationException;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class AutoScheduler extends JFrame {
    private JTextArea scheduleI, startDateI, o;
    private ArrayList<JComboBox<Integer>> daysCombo;
    private ArrayList<JPanel> classes;
    private JButton submitButton;
    public String startDate;
    public int[] numClasses;
    private int padding = 10;
    private InputOutput io;

    private void createDate(JPanel p) {
        JPanel datePanel = new JPanel();
        datePanel.setLayout(new BoxLayout(datePanel, BoxLayout.PAGE_AXIS));
        datePanel.add(Box.createVerticalGlue());

        // create label
        JLabel dateLabel = new JLabel("Enter the date on which instruction began in YYYYMMDD format: ");
        datePanel.add(dateLabel);

        // create start date text box
        startDateI = new JTextArea(5, 10);
        startDateI.setLineWrap(true);
        startDateI.setWrapStyleWord(true);
        datePanel.add(startDateI);

        datePanel.setBorder(BorderFactory.createEmptyBorder(padding, padding, padding, padding));
        p.add(datePanel);
    }

    private void createNumClasses(JPanel p) {
        // create class panel for storing the boxes and labels horizontally
        JPanel classPanel = new JPanel();
        classPanel.setLayout(new BoxLayout(classPanel, BoxLayout.X_AXIS));

        // add panels of combo boxes and labels
        daysCombo = new ArrayList<JComboBox<Integer>>();
        String days[] = { "Mon", "Tue", "Wed", "Thu", "Fri" };

        ArrayList<JPanel> classes = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.add(new JLabel(days[i]));
            daysCombo.add(new JComboBox<Integer>(new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }));
            daysCombo.get(i).setPreferredSize(new Dimension(10, 10));

            panel.add(daysCombo.get(i));
            classes.add(panel);
        }

        for (int i = 0; i < 5; i++) {
            classPanel.add(classes.get(i));
        }

        classPanel.setBorder(BorderFactory.createEmptyBorder(padding, padding, padding, padding));
        p.add(classPanel);
    }

    private void createBody(JPanel p) {
        //create panel
        JPanel bodyPanel = new JPanel();
        bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.Y_AXIS));

        //create label
        JLabel label = new JLabel("Input Schedule");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        bodyPanel.add(label);

        //create schedule text box
        scheduleI = new JTextArea(80, 40);
        scheduleI.setLineWrap(true);
        scheduleI.setWrapStyleWord(true);
        bodyPanel.add(new JScrollPane(scheduleI));

        //create button
        submitButton = new JButton("Submit");
        submitButton.setHorizontalAlignment(SwingConstants.CENTER);
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                

                if (checkConditions()) {
                    InputOutput io = new InputOutput();
                    //store startDate
                    io.storeStartDate(startDateI.getText());


                    //store numClasses
                    io.storeNumClasses(daysCombo);

                    //create file
                    io.createFile(scheduleI.getText());

                    //parse data
                    StringParse sp = new StringParse("input.txt", true);

                    sp.parseData();

                    IcsFileCreator file;
                    try {
                        file = new IcsFileCreator(sp.getCourseList(), io);
                        try {
                            file.addAllCoursesToCalendar();
                        } catch (ValidationException | ParseException | IOException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                    } catch (FileNotFoundException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                
                    }
                }
            }
        });
        bodyPanel.add(submitButton);
        bodyPanel.setBorder(BorderFactory.createEmptyBorder(padding, padding, padding, padding));

        p.add(bodyPanel);
    }

    public InputOutput getIO() {
        return io;
    }

    public AutoScheduler() {
        super("AutoScheduler");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        io = new InputOutput();

        JPanel superPanel = new JPanel();
        superPanel.setLayout(new BoxLayout(superPanel, BoxLayout.Y_AXIS));

        createDate(superPanel);
        createNumClasses(superPanel);
        createBody(superPanel);

        add(superPanel);

    }

    private boolean checkConditions() {
        if (startDateI.getText().length() != 8) {
            return false;
        }

        if (scheduleI.getText().isEmpty()) {
            return false;
        }
        return true;
    }

}
