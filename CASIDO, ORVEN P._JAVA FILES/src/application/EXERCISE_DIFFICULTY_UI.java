package application;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class EXERCISE_DIFFICULTY_UI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
	public EXERCISE_DIFFICULTY_UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
        setTitle("Health and Fitness Companion");
        setResizable(false);

        ImageIcon mainIcon = new ImageIcon(getClass().getClassLoader().getResource("iconLogoPoster.png"));
        setIconImage(mainIcon.getImage());
        
        JButton EASY_BTN = buttonSetter(
        		"easy.png",
        		"easy-clicked.png",
        		"easy.png");
        EASY_BTN.setBounds(382, 163, 168, 45);
        EASY_BTN.addActionListener(e -> {
        	EXERCISE_EASY_UI easy = new EXERCISE_EASY_UI();
        	easy.setVisible(true);
        	dispose();
        });
        
        JButton MEDIUM_BTN = buttonSetter(
        		"medium.png",
        		"medium-clicked.png",
        		"medium.png");
        MEDIUM_BTN.setBounds(382, 227, 168, 45);
        MEDIUM_BTN.addActionListener(ActionListener -> {
        	EXERCISE_MEDIUM_UI medium = new EXERCISE_MEDIUM_UI();
        	medium.setVisible(true);
        	dispose();
        });
        
        JButton HARD_BTN = buttonSetter(
        		"hard.png",
        		"hard-clicked.png",
        		"hard.png");
        HARD_BTN.setBounds(382, 290, 168, 45);
        HARD_BTN.addActionListener(ActionListener -> {
        	EXERCISE_HARD_UI hard = new EXERCISE_HARD_UI();
        	hard.setVisible(true);
        	dispose();
        });
        
        JButton BACK_BTN = new JButton();
        BACK_BTN = buttonSetter("back-exercises.png",
				"back-exercises-clicked.png",
				"back-exercises.png");
        BACK_BTN.setBounds(770, 430, 133, 40);
        BACK_BTN.addActionListener(ActionListener -> {
			LANDING_SIMPLIFIED_UI landingSimplified = new LANDING_SIMPLIFIED_UI();
			landingSimplified.setVisible(true);
        	dispose();
        });
        
        JLabel DIFFICULTY_LBL = imageSetter("choose-difficulty.png");
        DIFFICULTY_LBL.setBounds(90, 60, 748, 75);
        
        ImageIcon backgroundImageIcon = new ImageIcon(getClass().getClassLoader().getResource("LIBRARY-PICS.png"));
        JLabel backgroundImageLabel = new JLabel(backgroundImageIcon);
        backgroundImageLabel.setBounds(0, 0, 960, 540);
        contentPane.add(backgroundImageLabel);
        
		setContentPane(contentPane);
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
