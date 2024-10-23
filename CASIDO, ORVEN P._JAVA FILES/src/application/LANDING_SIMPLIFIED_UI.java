package application;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class LANDING_SIMPLIFIED_UI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	//Initialize the Frame
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
    public LANDING_SIMPLIFIED_UI() {
    	/*
    	 *  Frame Customization
    	 */
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 960, 540);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        getContentPane().setLayout(null);
        setTitle("Health and Fitness Companion");
        setResizable(false);
        
        ImageIcon mainIcon = new ImageIcon(getClass().getClassLoader().getResource("iconLogoPoster.png"));
        setIconImage(mainIcon.getImage());
                   
        JButton VOLUME_UP_BTN = buttonSetter(
        		"exercise-simplified.png",
        		"exercise-simplified-clicked.png",
        		"exercise-simplified.png"); 
        VOLUME_UP_BTN.setBounds(594, 167, 262, 55); 
        VOLUME_UP_BTN.addActionListener(e -> {
        	EXERCISE_DIFFICULTY_UI exercise = new EXERCISE_DIFFICULTY_UI();
        	exercise.setVisible(true);
        	dispose();
        });
        
        
        JLabel INFO = imageSetter("info-main.png"); 
        INFO.setBounds(30, 137, 493, 353);
           
        JButton INSTRUCTIONS_BTN = buttonSetter(
        		"instructions-simplified.png",
        		"instructions-simplified-clicked.png",
        		"instructions-simplified.png");
        INSTRUCTIONS_BTN.setBounds(594, 233, 262, 55); 
        INSTRUCTIONS_BTN.addActionListener(e -> {
        	INSTRUCTIONS_UI ins = new INSTRUCTIONS_UI();
        	ins.setVisible(true);
        	dispose();
        });

        JButton CREDITS_BTN = buttonSetter(
        		"credits-simplified.png",
        		"credits-simplified-clicked.png",
        		"credits-simplified.png"); 
        CREDITS_BTN.setBounds(594, 299, 262, 55); 
        CREDITS_BTN.addActionListener(e -> {
        	CREDITS_UI credits = new CREDITS_UI();
        	credits.setVisible(true);
        	dispose();
        });
        
        JButton EXIT_BTN = buttonSetter(
        		"exit-simplified.png",
        		"exit-simplified-clicked.png",
        		"exit-simplified.png"); 
        EXIT_BTN.setBounds(594, 365, 262, 55); 
        EXIT_BTN.addActionListener(e -> {
        	System.exit(0);
        });
             
        JButton LATEST_NEWS_BTN = buttonSetter(
        		"latest-news-main-ui.png",
        		"latest-news-main-ui-pressed.png",
        		"latest-news-main-ui.png"); 
        LATEST_NEWS_BTN.setBounds(794, 21, 120, 71); 
        contentPane.add(LATEST_NEWS_BTN); 
        LATEST_NEWS_BTN.addActionListener(ActionListener -> {
        	EXERCISE_LIBRARY_UI exercise_lib = new EXERCISE_LIBRARY_UI();
        	exercise_lib.setVisible(true);
        	dispose();
        	
        });
        
        JButton ALARM_CLOCK_BTN = buttonSetter(
        		"alarm-clock-main-ui.png",
        		"alarm-clock-main-ui-pressed.png",
        		"alarm-clock-main-ui.png"); 
        ALARM_CLOCK_BTN.setBounds(649, 21, 120, 71); 
        contentPane.add(ALARM_CLOCK_BTN); 
        ALARM_CLOCK_BTN.addActionListener(e -> {
        	ALARM_CLOCK_UI alarmFeatureUI = new ALARM_CLOCK_UI();
        	alarmFeatureUI.setVisible(true);
        	dispose();
        });

        JButton MEAL_PLANNER_BTN = buttonSetter(
        		"meal-planner-main-ui.png",
        		"meal-planner-main-ui-pressed.png",
        		"meal-planner-main-ui.png");
        MEAL_PLANNER_BTN.setBounds(504, 21, 120, 71); 
        contentPane.add(MEAL_PLANNER_BTN); 
        MEAL_PLANNER_BTN.addActionListener(ActionListener -> {
        	MEAL_PLANNER_UI mealPlanner = new MEAL_PLANNER_UI();
        	mealPlanner.setVisible(true);
        	dispose();
        });
            
        JButton BMI_TRACKER_BTN = buttonSetter(
        		"bmi-tracker-main-ui.png",
        		"bmi-tracker-main-ui-pressed.png",
        		"bmi-tracker-main-ui.png"); 
        BMI_TRACKER_BTN.setBounds(359, 21, 120, 71); 
        contentPane.add(BMI_TRACKER_BTN); 
        
        BMI_TRACKER_BTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BMI_FEATURE_UI bmiFeatureUI = new BMI_FEATURE_UI();
                bmiFeatureUI.setVisible(true);
                dispose();
            }
        });
        
        JButton EXERCISE_NOW_BTN = buttonSetter(
        		"exercise-now-main-ui.png",
        		"exercise-now-main-ui-pressed.png",
        		"exercise-now-main-ui.png");
        EXERCISE_NOW_BTN.setBounds(214, 21, 120, 71); 
        contentPane.add(EXERCISE_NOW_BTN); 
        EXERCISE_NOW_BTN.addActionListener(e -> {
        	EXERCISE_DIFFICULTY_UI diff = new EXERCISE_DIFFICULTY_UI();
        	diff.setVisible(true);
        	dispose();
        });
      
        JLabel labelLogo = imageSetter("logo-green.png");
        labelLogo.setBounds(10, 21, 194, 87);

        ImageIcon backgroundImageIcon = new ImageIcon(getClass().getClassLoader().getResource("main-ui-bg-simplified.png"));
        JLabel backgroundImageLabel = new JLabel(backgroundImageIcon);
        backgroundImageLabel.setSize(getSize());
        backgroundImageLabel.setBounds(0, 0, getWidth(), getHeight());
        contentPane.add(backgroundImageLabel, new Integer(Integer.MIN_VALUE));
        ((JPanel) contentPane).setOpaque(false);
    }
    
	public JLabel imageSetter(String imageLocation) {
        ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource(imageLocation));
        JLabel label = new JLabel(imageIcon);
        contentPane.add(label);
        return label;
    }
    
    public JButton buttonSetter(String imageLocation, String enteredIconLocation, String exitedIconLocation) {
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource(imageLocation));
        JButton button = new JButton(icon);
        button.setBorder(null);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setSize(icon.getIconWidth(), icon.getIconHeight());
        button.addMouseListener(getMouseListener(enteredIconLocation, exitedIconLocation));
        contentPane.add(button);
        return button;
    }
    
    private MouseAdapter getMouseListener(String enteredIconLocation, String exitedIconLocation) {
        return new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                ImageIcon enteredIcon = new ImageIcon(getClass().getClassLoader().getResource(enteredIconLocation));
                ((JButton) e.getSource()).setIcon(enteredIcon);
            }

            public void mouseExited(MouseEvent e) {
                ImageIcon exitedIcon = new ImageIcon(getClass().getClassLoader().getResource(exitedIconLocation));
                ((JButton) e.getSource()).setIcon(exitedIcon);
            }
        };
    }
}
