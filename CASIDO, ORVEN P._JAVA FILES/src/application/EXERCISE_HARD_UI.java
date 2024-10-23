package application;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.Timer;
import java.util.ArrayList;
import java.util.List;

public class EXERCISE_HARD_UI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel TIMER_LBL;
    private JLabel GIF_LBL;
    private Timer timer;
    private int timeRemaining = 90;
    private boolean isPaused = false;
    private List<String> exercises;
    private int currentExerciseIndex = 0;
    private JDialog restDialog = null; // Keep track of the rest dialog

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
					LANDING_SIMPLIFIED_UI landingSimplified = new LANDING_SIMPLIFIED_UI();
					landingSimplified.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public EXERCISE_HARD_UI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 960, 540);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setTitle("Health and Fitness Companion");
        setResizable(false);

        ImageIcon mainIcon = new ImageIcon(getClass().getClassLoader().getResource("iconLogoPoster.png"));
        setIconImage(mainIcon.getImage());

        TIMER_LBL = new JLabel("90");
        TIMER_LBL.setFont(new Font("Century Gothic", Font.BOLD, 99));
        TIMER_LBL.setHorizontalAlignment(SwingConstants.CENTER);
        TIMER_LBL.setBounds(689, 110, 206, 124);
        TIMER_LBL.setForeground(Color.decode("#0B9F4F")); // Set text color
        contentPane.add(TIMER_LBL);

        JLabel TITLE_LBL = imageSetter("hard-level.png");
        TITLE_LBL.setBounds(72, 15, 791, 84);

        GIF_LBL = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("AIR-CRUNCH-ANIMATION.gif")));
        GIF_LBL.setBounds(52, 117, 600, 338);
        contentPane.add(GIF_LBL);

        JButton MENU_BTN = buttonSetter(
        		"main-menu-exercise.png",
        		"main-menu-exercise-clicked.png",
        		"main-menu-exercise.png");
        MENU_BTN.setBounds(782, 419, 130, 41);
        MENU_BTN.addActionListener(e -> {
            // Stop the timer and dispose of any open dialogs
            if (timer != null) {
                timer.stop();
            }
            if (restDialog != null) {
                restDialog.dispose();
            }
			LANDING_SIMPLIFIED_UI landingSimplified = new LANDING_SIMPLIFIED_UI();
			landingSimplified.setVisible(true);
            dispose();
        });

        JButton NEXT_BTN = buttonSetter(
        		"next-exercise.png",
        		"next-exercise-clicked.png",
        		"next-exercise.png");
        NEXT_BTN.setBounds(782, 377, 130, 41);

        JButton RESTART_BTN = buttonSetter(
        		"restart-exercise.png",
        		"restart-exercise-clicked.png",
        		"restart-exercise.png");
        RESTART_BTN.setBounds(782, 336, 130, 41);

        JButton PAUSE_BTN = buttonSetter(
        		"pause-exercise.png",
        		"pause-exercise-clicked.png",
        		"pause-exercise.png");
        PAUSE_BTN.setBounds(782, 294, 130, 41);

        ImageIcon backgroundImageIcon = new ImageIcon(getClass().getClassLoader().getResource("LIBRARY-PICS.png"));
        JLabel backgroundImageLabel = new JLabel(backgroundImageIcon);
        backgroundImageLabel.setBounds(0, 0, 960, 540);
        contentPane.add(backgroundImageLabel);

        setContentPane(contentPane);

        // Initialize the list of exercises
        exercises = new ArrayList<>();
        exercises.add("CALF-RAISE-ANIMATION.gif");
        exercises.add("JUMPING-JACK-ANIMATION.gif");
        exercises.add("PLANK-ANIMATION.gif");
        exercises.add("PUSH-UP-ANIMATION.gif");
        exercises.add("SIT-OUTS-ANIMATION.gif");
        exercises.add("SIT-UP-ANIMATION.gif");
        exercises.add("SQUATS-ANIMATION.gif");
        exercises.add("WALKING-LUNGE-ANIMATION.gif");

        // Initialize and start the timer
        initializeTimer();

        // Add action listener for PAUSE_BTN
        PAUSE_BTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                toggleTimer();
            }
        });

        // Add action listener for RESTART_BTN
        RESTART_BTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                restartTimer();
            }
        });

        // Add action listener for NEXT_BTN
        NEXT_BTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nextExercise();
            }
        });
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

    private void initializeTimer() {
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (timeRemaining > 0) {
                    timeRemaining--;
                    TIMER_LBL.setText(String.valueOf(timeRemaining));
                } else {
                    timer.stop();
                    showRestDialog();
                }
            }
        });
        timer.start();
    }

    private void toggleTimer() {
        if (isPaused) {
            timer.start();
            isPaused = false;
        } else {
            timer.stop();
            isPaused = true;
        }
    }

    private void restartTimer() {
        timer.stop();
        timeRemaining = 90;
        TIMER_LBL.setText(String.valueOf(timeRemaining));
        timer.start();
        isPaused = false;
    }

    private void nextExercise() {
        currentExerciseIndex++; // Increment first
        if (currentExerciseIndex < exercises.size()) {
            String exerciseGifPath = exercises.get(currentExerciseIndex);
            GIF_LBL.setIcon(new ImageIcon(getClass().getClassLoader().getResource(exerciseGifPath)));
            restartTimer();
        } else {
            JOptionPane.showMessageDialog(contentPane, "Well done!");

            // Stop the timer and dispose of any open dialogs
            if (timer != null) {
                timer.stop();
            }
            if (restDialog != null) {
                restDialog.dispose();
            }

            // Navigate to main menu
            LANDING_SIMPLIFIED_UI landingSimplified = new LANDING_SIMPLIFIED_UI();
            landingSimplified.setVisible(true);
            dispose();
        }
    }

    private void showRestDialog() {
        final int restTime = 10; // Rest time in seconds
        restDialog = new JDialog(this, "Congratulations!", true);
        restDialog.getContentPane().setLayout(null);
        restDialog.setSize(423, 200);
        restDialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

        JLabel messageLabel = new JLabel("Well Done! Take a rest for the next " + restTime + " seconds");
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        messageLabel.setBounds(50, 30, 300, 30);
        restDialog.getContentPane().add(messageLabel);

        JButton okButton = new JButton("Skip");
        okButton.setBounds(150, 100, 100, 30);
        restDialog.getContentPane().add(okButton);

        // Create a timer for the dialog
        Timer dialogTimer = new Timer(1000, new ActionListener() {
            int timeLeft = restTime;

            @Override
            public void actionPerformed(ActionEvent e) {
                timeLeft--;
                messageLabel.setText("Well Done! Take a rest for the next " + timeLeft + " seconds");
                if (timeLeft <= 0) {
                    restDialog.dispose();
                    nextExercise();
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        dialogTimer.start();

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restDialog.dispose();
                nextExercise();
                dialogTimer.stop();
            }
        });

        restDialog.setLocationRelativeTo(contentPane);
        restDialog.setVisible(true);
    }
}



