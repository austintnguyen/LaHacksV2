import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GUI extends JFrame {
    private JTextArea scheduleI, startDayI, startMonthI, startYearI, o;
    private ArrayList<JComboBox<Integer>> daysCombo;
    private JButton submitButton;
    private InputOutput io;

    public GUI() {
        super("AutoScheduler");
        setSize(1200, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // input boxes
        scheduleI = new JTextArea(100, 100);
        scheduleI.setMaximumSize(new Dimension(100, 100));
        scheduleI.setLineWrap(true);
        scheduleI.setWrapStyleWord(true);

        startDayI = new JTextArea(10, 10);
        startDayI.setLineWrap(true);
        startDayI.setWrapStyleWord(true);

        startMonthI = new JTextArea(10, 10);
        startMonthI.setLineWrap(true);
        startMonthI.setWrapStyleWord(true);

        startYearI = new JTextArea(10, 10);
        startYearI.setLineWrap(true);
        startYearI.setWrapStyleWord(true);

        // drop down menus
        daysCombo = new ArrayList<JComboBox<Integer>>();
        for (int i = 0; i < daysCombo.size(); i++) {
            daysCombo.add(new JComboBox<Integer>(new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
            //daysCombo.get(i).setPreferredSize(new Dimension(200, 200));
            add(daysCombo.get(i));
        }



        // JComboBox<Integer> monI = new JComboBox<>(new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        // //mon.setPreferredSize(new Dimension(150, 30));
        // add(monI);
        // JComboBox<Integer> tueI = new JComboBox<>(new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        // add(tueI);
        // JComboBox<Integer> wedI = new JComboBox<>(new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        // add(wedI);
        // JComboBox<Integer> thuI = new JComboBox<>(new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        // add(thuI);
        // JComboBox<Integer> friI = new JComboBox<>(new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        // add(friI);

        // output box
        o = new JTextArea(20, 40);
        o.setLineWrap(true);
        o.setWrapStyleWord(true);
        o.setEditable(false);

        // submit button
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                io.run(scheduleI, startDayI, startMonthI, startYearI,
                daysCombo);
            }
        });

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(new JScrollPane(scheduleI), BorderLayout.CENTER);
        inputPanel.add(submitButton, BorderLayout.SOUTH);

        // JPanel outputPanel = new JPanel(new BorderLayout());
        // outputPanel.add(new JScrollPane(outputTextArea), BorderLayout.CENTER);

        getContentPane().setLayout(new GridLayout(2, 1));
        getContentPane().add(inputPanel);
        //getContentPane().add(outputPanel);
    }

    public static void main(String[] args) {
        GUI GUI = new GUI();
        GUI.setVisible(true);
      }
}
