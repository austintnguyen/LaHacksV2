import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GUI extends JFrame {
    private JTextArea scheduleI, startDateI, o;
    //private JPanel startDatePanel, classPanel, bodyPanel, outputPanel;
    private ArrayList<JComboBox<Integer>> daysCombo;
    private JButton submitButton;
    private InputOutput io;

    private void createBody() {
        //create panel
        JPanel bodyPanel = new JPanel();
        bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.Y_AXIS));

        //create label
        JLabel label = new JLabel("Input Schedule");
        bodyPanel.add(label);

        //create schedule text box
        scheduleI = new JTextArea(100, 100);
        scheduleI.setLineWrap(true);
        scheduleI.setWrapStyleWord(true);
        bodyPanel.setMaximumSize(bodyPanel.getPreferredSize());
        bodyPanel.add(new JScrollPane(scheduleI));

        //create button
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // io.run(scheduleI, startDayI, startMonthI, startYearI,
                // daysCombo);
            }
        });
        bodyPanel.add(submitButton);
        add(bodyPanel);
    }

    public void createNumClasses() {
        daysCombo = new ArrayList<JComboBox<Integer>>();
        for (int i = 0; i < daysCombo.size(); i++) {
            daysCombo.add(new JComboBox<Integer>(new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
            //daysCombo.get(i).setPreferredSize(new Dimension(200, 200));
            add(daysCombo.get(i));
        }
    }

    public GUI() {
        super("AutoScheduler");
        setSize(400, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createBody();
        createNumClasses();

        // output box
        o = new JTextArea(20, 40);
        o.setLineWrap(true);
        o.setWrapStyleWord(true);
        o.setEditable(false);

        //JPanel inputPanel = new JPanel(new BorderLayout());
        //inputPanel.add(new JScrollPane(scheduleI), BorderLayout.CENTER);
        //inputPanel.add(submitButton, BorderLayout.SOUTH);

        // JPanel outputPanel = new JPanel(new BorderLayout());
        // outputPanel.add(new JScrollPane(outputTextArea), BorderLayout.CENTER);

       //getContentPane().setLayout(new GridLayout(2, 1));
        //getContentPane().add(inputPanel);
        //getContentPane().add(outputPanel);
    }

    public static void main(String[] args) {
        GUI GUI = new GUI();
        GUI.setVisible(true);
      }
}
