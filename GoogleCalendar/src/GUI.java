import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GUI extends JFrame {
    private JTextArea scheduleI, startDateI, o;
    //private JPanel startDatePanel, classPanel, bodyPanel, outputPanel;
    private ArrayList<JComboBox<Integer>> daysCombo;
    private ArrayList<JPanel> classes;
    private JButton submitButton;
    public String startDate;
    public int[] numClasses;

    private void createDate(JPanel p) {
        JPanel datePanel = new JPanel();
        datePanel.setLayout(new BoxLayout(datePanel, BoxLayout.Y_AXIS));
        startDateI = new JTextArea(10, 10);
        startDateI.setLineWrap(true);
        startDateI.setWrapStyleWord(true);
        p.add(datePanel);
    }

    private void createNumClasses(JPanel p) {
        //create class panel for storing the boxes and labels horizontally
        JPanel classPanel = new JPanel();
        classPanel.setLayout(new BoxLayout(classPanel, BoxLayout.X_AXIS));

        //add panels of combo boxes and labels
        daysCombo = new ArrayList<JComboBox<Integer>>();
        String days[] = {"Mon", "Tue", "Wed", "Thu", "Fri"};

        ArrayList<JPanel> classes = new ArrayList<>();

            //initialized combo boxes first
        // for (int i = 0; i < daysCombo.size(); i++) {
        //     daysCombo.add(new JComboBox<Integer>(new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
        //     daysCombo.get(i).setPreferredSize(new Dimension(10, 10));
        //     //classPanel.add(daysCombo.get(i));
        // }

        for (int i = 0; i < 5; i++) {
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.add(new JLabel(days[i]));
            daysCombo.add(new JComboBox<Integer>(new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
            daysCombo.get(i).setPreferredSize(new Dimension(10, 10));
            //Component glue = Box.createVerticalGlue();
            //panel.add(glue);
            //panel.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(daysCombo.get(i));
            classes.add(panel);
        }

        // for (int i = 0; i < daysCombo.size(); i++) {
        //     daysCombo.add(new JComboBox<Integer>(new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
        //     daysCombo.get(i).setPreferredSize(new Dimension(10, 10));
        //     classPanel.add(daysCombo.get(i));
        // }

        for (int i = 0; i < 5; i++) {
            classPanel.add(classes.get(i));
        }

        p.add(classPanel);
    }
    
    private void createBody(JPanel p) {
        //create panel
        JPanel bodyPanel = new JPanel();
        bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.Y_AXIS));

        //create label
        JLabel label = new JLabel("Input Schedule");
        bodyPanel.add(label);
        //bodyPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        //create schedule text box
        scheduleI = new JTextArea(100, 100);
        scheduleI.setLineWrap(true);
        scheduleI.setWrapStyleWord(true);
        //bodyPanel.setMaximumSize(bodyPanel.getPreferredSize());
        bodyPanel.add(new JScrollPane(scheduleI));
        bodyPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        //create button
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InputOutput io = new InputOutput();
                io.storeData(scheduleI, startDateI, daysCombo, startDate, numClasses);
            }
        });
        bodyPanel.add(submitButton);
        p.add(bodyPanel);
    }

    private void createOutput(JPanel p) {

    }

    public GUI() {
        super("AutoScheduler");
        setSize(400, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel superPanel = new JPanel();
        superPanel.setLayout(new BoxLayout(superPanel, BoxLayout.Y_AXIS));

        createDate(superPanel);
        createNumClasses(superPanel);
        createBody(superPanel);
        //createOutput(superPanel);

        add(superPanel);

        // output box
        // o = new JTextArea(20, 40);
        // o.setLineWrap(true);
        // o.setWrapStyleWord(true);
        // o.setEditable(false);

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
