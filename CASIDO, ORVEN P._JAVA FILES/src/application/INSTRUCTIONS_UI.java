package application;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class INSTRUCTIONS_UI extends JFrame {

	private static final long serialVersionUID = 1L;
	private static JPanel contentPane;

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
	public INSTRUCTIONS_UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
        setTitle("Health and Fitness Companion");
        setResizable(false);

        ImageIcon mainIcon = new ImageIcon(getClass().getClassLoader().getResource("iconLogoPoster.png"));
        setIconImage(mainIcon.getImage());
		
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
        
        JButton FEATURE_1_BTN = new JButton();
        FEATURE_1_BTN = buttonSetter("exercise-instruction.png",
				"exercise-instruction-clicked.png",
				"exercise-instruction.png");
	    FEATURE_1_BTN.setBounds(363, 159, 216, 40);
	    FEATURE_1_BTN.addActionListener(ActionLister -> {
	    	showImage("feature1-instruction.png");
	    	dispose();
        });
	    
        JButton FEATURE_2_BTN = new JButton();
        FEATURE_2_BTN = buttonSetter("bmi-instruction.png",
				"bmi-instruction-clicked.png",
				"bmi-instruction.png");
	    FEATURE_2_BTN.setBounds(364, 214, 216, 40);
	    FEATURE_2_BTN.addActionListener(ActionLister -> {
	    	showImage("feature2-instruction.png");
	    	dispose();
        });
	    
        JButton FEATURE_3_BTN = new JButton();
        FEATURE_3_BTN = buttonSetter("meal-instruction.png",
				"meal-instruction-clicked.png",
				"meal-instruction.png");
	    FEATURE_3_BTN.setBounds(365, 269, 216, 40);
	    FEATURE_3_BTN.addActionListener(ActionLister -> {
	    	showImage("feature3-instruction.png");
	    	dispose();
        });
	    
        JButton FEATURE_4_BTN = new JButton();
        FEATURE_4_BTN = buttonSetter("alarm-instruction.png",
				"alarm-instruction-clicked.png",
				"alarm-instruction.png");
	    FEATURE_4_BTN.setBounds(365, 324, 216, 40);
	    FEATURE_4_BTN.addActionListener(ActionLister -> {
	    	showImage("feature4-instruction.png");
	    	dispose();
        });
	    
        JButton FEATURE_5_BTN = new JButton();
        FEATURE_5_BTN = buttonSetter("library-instruction.png",
				"library-instruction-clicked.png",
				"library-instruction.png");
	    FEATURE_5_BTN.setBounds(365, 379, 216, 40);
	    FEATURE_5_BTN.addActionListener(ActionLister -> {
	    	showImage("feature5-instruction.png");
	    	dispose();
        });

        ImageIcon backgroundImageIcon = new ImageIcon(getClass().getClassLoader().getResource("instructions-new-bg.png"));
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
	
    private void showImage(String imagePath) {
        JFrame imageFrame = new JFrame();
        imageFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        imageFrame.setBounds(100, 100, 960, 540);
        imageFrame.setTitle("Health and Fitness Companion");
        imageFrame.setLayout(null);  // Use null layout to manually set bounds
        
        ImageIcon mainIcon = new ImageIcon(getClass().getClassLoader().getResource("iconLogoPoster.png"));
        imageFrame.setIconImage(mainIcon.getImage());
        
        // Create and add BACK_BTN
        JButton BACK_BTN = new JButton();
        BACK_BTN = buttonSetter("back-exercises.png",
				"back-exercises-clicked.png",
				"back-exercises.png");
        BACK_BTN.setBounds(780, 450, 133, 40);
        BACK_BTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                INSTRUCTIONS_UI ins = new INSTRUCTIONS_UI();
                ins.setVisible(true);
                imageFrame.dispose();
            }
        });
        imageFrame.add(BACK_BTN);

        ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource(imagePath));
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(0, 0, 960, 540); 
        imageFrame.add(imageLabel);

        imageFrame.setVisible(true);
    }
}
