package application;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.event.ActionEvent;

public class EXERCISE_LIBRARY_UI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
	public EXERCISE_LIBRARY_UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
        setTitle("Health and Fitness Companion");
        setResizable(false);

        ImageIcon mainIcon = new ImageIcon(getClass().getClassLoader().getResource("iconLogoPoster.png"));
        setIconImage(mainIcon.getImage());
        
        JLabel EXERCISE_LABEL = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("exercises-library.png")));
        EXERCISE_LABEL.setBounds(127, 11, 710, 40);
        contentPane.add(EXERCISE_LABEL);
        
        JButton BACK_BTN = new JButton();
        BACK_BTN = buttonSetter("back-exercises.png",
				"back-exercises-clicked.png",
				"back-exercises.png");
        BACK_BTN.setBounds(780, 450, 133, 40);
        BACK_BTN.addActionListener(ActionLister -> {
        	LANDING_SIMPLIFIED_UI frame = new LANDING_SIMPLIFIED_UI();
            frame.setVisible(true);
        	dispose();
        });
        
        JButton PUSHUP_BTN = new JButton();
        PUSHUP_BTN = buttonSetter("push-up-icon.png",
        						"push-up-icon-clicked.png",
        						"push-up-icon.png");
        PUSHUP_BTN.setBounds(131, 67, 156, 97);
        PUSHUP_BTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ExerciseWindow exer = new ExerciseWindow( 
                    "PUSH-UP.gif", 
                    "push-up-text.png");
            }
        });
        
        JButton SITUP_BTN = new JButton();
        SITUP_BTN = buttonSetter("sit-up-icon.png",
				"sit-up-icon-clicked.png",
				"sit-up-icon.png");
        SITUP_BTN.setBounds(403, 67, 156, 97);
        SITUP_BTN.addActionListener(ActionListener -> {
        	ExerciseWindow exer = new ExerciseWindow(
        			"SIT-UP.gif",
        			"sit-up-text.png");
        });
        
        JButton BODYSQUAT_BTN = new JButton();
        BODYSQUAT_BTN = buttonSetter("squats-icon.png",
				"squats-icon-clicked.png",
				"squats-icon.png");
        BODYSQUAT_BTN.setBounds(678, 67, 156, 97);
        BODYSQUAT_BTN.addActionListener(ActionListener -> {
        	ExerciseWindow exer = new ExerciseWindow(
        			"AIR-SQUAT.gif",
        			"body-squats-text.png");
        });
        
        JButton WALKINGLUNGE_BTN = new JButton(); 
        WALKINGLUNGE_BTN = buttonSetter("walking-lunge-icon.png",
				"walking-lunge-icon-clicked.png",
				"walking-lunge-icon.png");
        WALKINGLUNGE_BTN.setBounds(131, 197, 156, 97);
        WALKINGLUNGE_BTN.addActionListener(ActionListener -> {
        	ExerciseWindow exer = new ExerciseWindow(
        			"WALKING-LUNGES.gif",
        			"walking-lunge-text.png");
        });
        
        JButton PLANK_BTN = new JButton();
        PLANK_BTN = buttonSetter("plank-icon.png",
				"plank-icon-clicked.png",
				"plank-icon.png");
        PLANK_BTN.setBounds(403, 197, 156, 97);
        PLANK_BTN.addActionListener(ActionListener -> {
        	ExerciseWindow exer = new ExerciseWindow(
        			"FOREARM-PLANK.gif",
        			"plank-text.png");
        });
        
        JButton JUMPING_JACK_BTN = new JButton();
        JUMPING_JACK_BTN = buttonSetter("jumping-jack-icon.png",
				"jumping-jack-icon-clicked.png",
				"jumping-jack-icon.png");
        JUMPING_JACK_BTN.setBounds(678, 198, 156, 97);
        JUMPING_JACK_BTN.addActionListener(ActionListener -> {
        	ExerciseWindow exer = new ExerciseWindow(
        			"JUMPING-JACKS.gif",
        			"jumping-jack-text.png");
        });
        
        JButton BIKECRUNCH_BTN = new JButton();
        BIKECRUNCH_BTN = buttonSetter("bike-crunch-icon.png",
				"bike-crunch-icon-clicked.png",
				"bike-crunch-icon.png");
        BIKECRUNCH_BTN.setBounds(131, 330, 156, 97);
        BIKECRUNCH_BTN.addActionListener(ActionListener -> {
        	ExerciseWindow exer = new ExerciseWindow(
        			"BICYCLE-CRUNCH.gif",
        			"bike-crunch-text.png");
        });
        
        JButton WALLSIT_BTN = new JButton();
        WALLSIT_BTN = buttonSetter("wall-sit-icon.png",
				"wall-sit-icon-clicked.png",
				"wall-sit-icon.png");
        WALLSIT_BTN.setBounds(403, 331, 156, 97);
        WALLSIT_BTN.addActionListener(ActionListener -> {
        	ExerciseWindow exer = new ExerciseWindow(
        			"WALL-SIT.gif",
        			"wallsit-text.png");
        });
        
        JButton CALFRAISE_BTN = new JButton("standing calf raise");
        CALFRAISE_BTN = buttonSetter("calfraise-icon.png",
				"calfraise-icon-clicked.png",
				"calfraise-icon.png");
        CALFRAISE_BTN.setBounds(678, 331, 156, 97);
        CALFRAISE_BTN.addActionListener(ActionListener -> {
        	ExerciseWindow exer = new ExerciseWindow(
        			"STANDING-CALF-RAISE.gif",
        			"calfraise-text.png");
        });
        
        ImageIcon backgroundImageIcon = new ImageIcon(getClass().getClassLoader().getResource("LIBRARY-PICS.png"));
        JLabel backgroundImageLabel = new JLabel(backgroundImageIcon);
        backgroundImageLabel.setBounds(0, 0, 960, 540);
        contentPane.add(backgroundImageLabel);
        
		setContentPane(contentPane);
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

class ExerciseWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public ExerciseWindow(String gifPath, String description) {
        setTitle("Exercise Library");
        setBounds(100, 100, 960, 540);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        
        EXERCISE_LIBRARY_UI lib = new EXERCISE_LIBRARY_UI();
        JButton btnNewButton = new JButton("back");
        btnNewButton = lib.buttonSetter("back-exercises.png", 
        								"back-exercises-clicked.png", 
        								"back-exercises.png");
        btnNewButton.setBounds(780, 450, 133, 40);
        contentPane.add(btnNewButton);
        btnNewButton.addActionListener(ActionListener -> {
            lib.setVisible(true);
            dispose();
        });
        
        JLabel lblNewLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("exercise_label.png")));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(178, 11, 550, 40);
        contentPane.add(lblNewLabel);
        
        JLabel gifLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(gifPath)));
        gifLabel.setBounds(40, 71, 600, 338);
        gifLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(gifLabel);
        
        JLabel descriptionLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(description)));
        descriptionLabel.setBounds(656, 71, 235, 338);
        descriptionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(descriptionLabel);
        
        ImageIcon backgroundImageIcon = new ImageIcon(getClass().getClassLoader().getResource("LIBRARY-PICS.png"));
        JLabel backgroundImageLabel = new JLabel(backgroundImageIcon);
        backgroundImageLabel.setBounds(0, 0, 960, 540);
        contentPane.add(backgroundImageLabel);

        setContentPane(contentPane);
	}
}