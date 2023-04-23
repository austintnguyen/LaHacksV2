import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AutoScheduler extends JFrame {
    private JTextArea scheduleI, startDateI, o;
    //private JPanel startDatePanel, classPanel, bodyPanel, outputPanel;
    private ArrayList<JComboBox<Integer>> daysCombo;
    private ArrayList<JPanel> classes;
    private JButton submitButton;
    public String startDate;
    public int[] numClasses;
    private int padding = 10;

    private void createDate(JPanel p) {
        JPanel datePanel = new JPanel();
        //datePanel.setLayout(new BoxLayout(datePanel, BoxLayout.Y_AXIS)); //might remove this
        datePanel.setLayout(new BoxLayout(datePanel, BoxLayout.PAGE_AXIS));
        datePanel.add(Box.createVerticalGlue());

        //create label
        JLabel dateLabel = new JLabel("Enter the date on which instruction began in YYYYMMDD format: ");
        datePanel.add(dateLabel);
        //datePanel.add(Box.createVerticalGlue());
        //dateLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //create start date text box
        startDateI = new JTextArea(5, 10);
        startDateI.setLineWrap(true);
        startDateI.setWrapStyleWord(true);
        datePanel.add(startDateI);
        //datePanel.add(Box.createVerticalGlue());

        //datePanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        datePanel.setBorder(BorderFactory.createEmptyBorder(padding, padding, padding, padding));
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
        //bodyPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        //create schedule text box
        scheduleI = new JTextArea(80, 40);
        scheduleI.setLineWrap(true);
        scheduleI.setWrapStyleWord(true);
        //bodyPanel.setMaximumSize(bodyPanel.getPreferredSize());
        bodyPanel.add(new JScrollPane(scheduleI));
        //bodyPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        //create button
        submitButton = new JButton("Submit");
        submitButton.setHorizontalAlignment(SwingConstants.CENTER);
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InputOutput io = new InputOutput();
                //create file
                io.createFile(scheduleI.getText());
                //parse data
                
                //getNumDays
                //io.storeData(scheduleI, startDateI, daysCombo, startDate, numClasses);
                //call methods?
            }
        });
        bodyPanel.add(submitButton);
        bodyPanel.setBorder(BorderFactory.createEmptyBorder(padding, padding, padding, padding));

        p.add(bodyPanel);
    }

    public AutoScheduler() {
        super("AutoScheduler");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel superPanel = new JPanel();
        superPanel.setLayout(new BoxLayout(superPanel, BoxLayout.Y_AXIS));

        createDate(superPanel);
        createNumClasses(superPanel);
        createBody(superPanel);

        add(superPanel);
        
    }

    public static void main(String[] args) {
        AutoScheduler AutoScheduler = new AutoScheduler();
        AutoScheduler.pack();
        AutoScheduler.setVisible(true);
      }
}
