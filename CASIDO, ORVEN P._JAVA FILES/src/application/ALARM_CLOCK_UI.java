package application;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;

public class ALARM_CLOCK_UI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel CLOCK_TIMER_LBL;
    private JList<String> alarmList;
    private DefaultListModel<String> listModel;
    private JLabel CLOCK_ICON;
    private String alarmEntry;
      
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	LANDING_SIMPLIFIED_UI frame = new LANDING_SIMPLIFIED_UI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ALARM_CLOCK_UI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 960, 540);
        contentPane = new JPanel();
        contentPane.setLayout(null);
        setTitle("Health and Fitness Companion");
        setResizable(false);

        ImageIcon mainIcon = new ImageIcon(getClass().getClassLoader().getResource("iconLogoPoster.png"));
        setIconImage(mainIcon.getImage());

        ImageIcon workoutAlarm = new ImageIcon(getClass().getClassLoader().getResource("workout-alarm-3.png"));
        JLabel WORKOUT_ALARM = new JLabel(workoutAlarm);
        WORKOUT_ALARM.setBounds(543, 11, 366, 83);
        contentPane.add(WORKOUT_ALARM);

        // Initialize the list model
        listModel = new DefaultListModel<>();

        // Initialize the JList with the list model
        alarmList = new JList<>(listModel);
        alarmList.setBackground(new Color(236, 255, 239));
        alarmList.setOpaque(true);
        alarmList.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        alarmList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alarmList.setBorder(new EmptyBorder(0, 0, 0, 0));

        // Set cell renderer to wrap text
        alarmList.setCellRenderer(new MultilineCellRenderer());

        // Create a JScrollPane and add the JList to it
        JScrollPane scrollPane = new JScrollPane(alarmList);
        scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        scrollPane.setBounds(568, 115, 300, 200);
        contentPane.add(scrollPane);

        ImageIcon alarmIcon = new ImageIcon(getClass().getClassLoader().getResource("set-alarm.png")); 
        JButton ALARM_BTN = new JButton(alarmIcon); 
        ALARM_BTN.setBorder(null); 
        ALARM_BTN.setOpaque(false); 
        ALARM_BTN.setContentAreaFilled(false);
        ALARM_BTN.setBorderPainted(false);
        ALARM_BTN.setSize(alarmIcon.getIconWidth(), alarmIcon.getIconHeight()); 
        ALARM_BTN.setBounds(162, 275, 164, 55); 
        contentPane.add(ALARM_BTN); 
        ALARM_BTN.addActionListener(ActionListener -> {
        	setAlarm();
        });
        
        ALARM_BTN.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                // Change the opacity of the button icon when clicked
                ImageIcon clickedIcon = new ImageIcon(getClass().getClassLoader().getResource("set-alarm-clicked.png"));
                ALARM_BTN.setIcon(clickedIcon);
            }

            public void mouseExited(MouseEvent e) {
                // Reset to normal icon when mouse exits
            	ALARM_BTN.setIcon(alarmIcon);
            }
        });

        CLOCK_TIMER_LBL = new JLabel("00:00:00"); 
        CLOCK_TIMER_LBL.setHorizontalAlignment(SwingConstants.CENTER);
        CLOCK_TIMER_LBL.setFont(new Font("Century Gothic", Font.BOLD, 90));
        CLOCK_TIMER_LBL.setForeground(Color.decode("#004721")); 
        CLOCK_TIMER_LBL.setBounds(-14, 88, 533, 176);
        contentPane.add(CLOCK_TIMER_LBL);
        clock();
 
        ImageIcon backIcon = new ImageIcon(getClass().getClassLoader().getResource("back-alarm.png")); 
        JButton BACK_BTN = new JButton(backIcon); 
        BACK_BTN.setBounds(775, 440, 147, 40);
        BACK_BTN.setBorder(null); 
        BACK_BTN.setOpaque(false); 
        BACK_BTN.setContentAreaFilled(false);
        BACK_BTN.setBorderPainted(false);
        contentPane.add(BACK_BTN); 
        BACK_BTN.addActionListener(ActionListener -> {
        	LANDING_SIMPLIFIED_UI frame = new LANDING_SIMPLIFIED_UI();
            frame.setVisible(true);
        	dispose();
        });
        BACK_BTN.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                ImageIcon clickedIcon = new ImageIcon(getClass().getClassLoader().getResource("back-alarm-clicked.png"));
                BACK_BTN.setIcon(clickedIcon);
            }
            public void mouseExited(MouseEvent e) {
            	BACK_BTN.setIcon(backIcon);
            }
        });
        
        int topMargin = WORKOUT_ALARM.getY() + WORKOUT_ALARM.getHeight() + 10; // 10 pixels spacing
        int bottomMargin = BACK_BTN.getY() - 20; // 20 pixels spacing
        int listHeight = bottomMargin - topMargin;
        int listWidth = scrollPane.getWidth() + 40; // Extend 20 pixels to the right
        
        scrollPane.setBounds(568, topMargin, listWidth, listHeight);
        contentPane.add(scrollPane);
        
        ImageIcon clearIcon = new ImageIcon(getClass().getClassLoader().getResource("delete-alarm.png")); 
        JButton CLEAR_BTN = new JButton(clearIcon); 
        CLEAR_BTN.setBounds(615, 440, 147, 40);
        CLEAR_BTN.setBorder(null); 
        CLEAR_BTN.setOpaque(false); 
        CLEAR_BTN.setContentAreaFilled(false);
        CLEAR_BTN.setBorderPainted(false);
        contentPane.add(CLEAR_BTN); 
        CLEAR_BTN.addActionListener(ActionListener->{
        	listModel.removeAllElements();
        });
        CLEAR_BTN.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                ImageIcon clickedIcon = new ImageIcon(getClass().getClassLoader().getResource("delete-alarm-clicked.png"));
                CLEAR_BTN.setIcon(clickedIcon);
            }
            public void mouseExited(MouseEvent e) {
            	CLEAR_BTN.setIcon(clearIcon);
            }
        });
  
        ImageIcon backgroundImageIcon = new ImageIcon(getClass().getClassLoader().getResource("ALARM-BG-3.png"));
        JLabel backgroundImageLabel = new JLabel(backgroundImageIcon);
        backgroundImageLabel.setBounds(0, 0, 960, 540);
        contentPane.add(backgroundImageLabel);
        
        contentPane.setOpaque(false);
        setContentPane(contentPane);
    }
    
    public void clock() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");

        ActionListener updateClockAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalDateTime now = LocalDateTime.now();
                CLOCK_TIMER_LBL.setText(dtf.format(now));
                checkAlarm(now);
            }
        };

        Timer timer = new Timer(1000, updateClockAction);
        timer.start();
    }
    
    private void checkAlarm(LocalDateTime now) {
        for (int i = 0; i < listModel.getSize(); i++) {
            String alarmEntry = listModel.getElementAt(i);
            String[] parts = alarmEntry.split(" - ");
            String alarmTimeString = parts[0];
            LocalTime alarmTime = LocalTime.parse(alarmTimeString);

            int currentHour = now.getHour();
            int currentMinute = now.getMinute();
            int currentSecond = now.getSecond();

            int alarmHour = alarmTime.getHour();
            int alarmMinute = alarmTime.getMinute();
            int alarmSecond = alarmTime.getSecond();

            if (currentHour == alarmHour && currentMinute == alarmMinute && currentSecond == alarmSecond) {
                JOptionPane.showMessageDialog(contentPane, "Alarm! Time is up for " + alarmEntry);
                listModel.removeElementAt(i);
                break;
            }
        }
    }
    
    private void setAlarm() {
        String[] hours = new String[24];
        String[] minutes = new String[60];
        String[] seconds = new String[60];

        for (int i = 0; i < 24; i++) {
            hours[i] = String.format("%02d", i);
        }

        for (int i = 0; i < 60; i++) {
            minutes[i] = String.format("%02d", i);
        }
        
        for (int i = 0; i < 60; i++) {
            seconds[i] = String.format("%02d", i);
        }

        JComboBox<String> hourComboBox = new JComboBox<>(hours);
        JComboBox<String> minuteComboBox = new JComboBox<>(minutes);
        JComboBox<String> secondComboBox = new JComboBox<>(seconds);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Hour:"));
        panel.add(hourComboBox);
        panel.add(new JLabel("Minute:"));
        panel.add(minuteComboBox);
        panel.add(new JLabel("Second:"));
        panel.add(secondComboBox);

        int result = JOptionPane.showConfirmDialog(contentPane, panel, "Set Alarm Time", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
        if (result == JOptionPane.OK_OPTION) {
            String selectedHour = (String) hourComboBox.getSelectedItem();
            String selectedMinute = (String) minuteComboBox.getSelectedItem();
            String selectedSecond = (String) secondComboBox.getSelectedItem();
            
            String alarmTime = selectedHour + ":" + selectedMinute + ":" + selectedSecond; 
            String alarmTitle = JOptionPane.showInputDialog(contentPane, "Enter alarm title:");
            
            if (alarmTitle == null || alarmTitle.trim().isEmpty()) {
                alarmTitle = "";
            }

            alarmEntry = alarmTime + " - " + alarmTitle;
            listModel.addElement(alarmEntry);
            JOptionPane.showMessageDialog(contentPane, "Alarm set for " + alarmEntry);
        }
    }
    
    
    public class MultilineCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (c instanceof JLabel) {
                JLabel label = (JLabel) c;
                label.setText("<html>" + value.toString().replace("\n", "<br>") + "</html>");
            }
            return c;
        }
    }
}

