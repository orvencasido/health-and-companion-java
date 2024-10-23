package application;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Cursor;

public class BMI_FEATURE_UI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField HEIGHT_TEXTFIELD;
    private JTextField WEIGHT_TEXTFIELD;
    private JLabel BMI_COUNTER_LBL;
    private JLabel BMI_LABELER_LBL_1;
    private JTextField HEIGHT_CONVERSION_TEXTFIELD;
    private JTextField WEIGHT_CONVERSION_TEXTFIELD;

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
    public BMI_FEATURE_UI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 960, 540);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(235, 235, 235));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("Health and Fitness Companion");
        setResizable(false);

        ImageIcon mainIcon = new ImageIcon(getClass().getClassLoader().getResource("iconLogoPoster.png"));
        setIconImage(mainIcon.getImage());
        
        JComboBox HEIGHT_COMBOBOX = new JComboBox<>();
        HEIGHT_COMBOBOX.setBounds(144, 63, 80, 22);
        HEIGHT_COMBOBOX.setBorder(BorderFactory.createEmptyBorder());
        // Set background color to white
        HEIGHT_COMBOBOX.setBackground(Color.WHITE);
        contentPane.add(HEIGHT_COMBOBOX);
        // Adding values to the combo box
        HEIGHT_COMBOBOX.addItem("Meters");
        HEIGHT_COMBOBOX.addItem("Feet");
        HEIGHT_COMBOBOX.addItem("Centimeters");
        HEIGHT_COMBOBOX.addItem("Inches");
        
        ImageIcon convertIcon = new ImageIcon(getClass().getClassLoader().getResource("convert-icon.png")); // Load the image for the button
        JButton CONVERSION_CONVERT_BTN = new JButton(convertIcon); // Create the delete button
        CONVERSION_CONVERT_BTN.setBorder(null); // Remove the default border of the button
        CONVERSION_CONVERT_BTN.setOpaque(false); // Remove Background
        CONVERSION_CONVERT_BTN.setContentAreaFilled(false);
        CONVERSION_CONVERT_BTN.setBorderPainted(false);
        CONVERSION_CONVERT_BTN.setSize(convertIcon.getIconWidth(), convertIcon.getIconHeight()); // Set the size of the button to match the size of the icon
        CONVERSION_CONVERT_BTN.setLocation(234, 145); // Set the position of the button
        contentPane.add(CONVERSION_CONVERT_BTN); // Add the button to the content pane
        
        CONVERSION_CONVERT_BTN.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                // Change the opacity of the button icon when clicked
                ImageIcon clickedIcon = new ImageIcon(getClass().getClassLoader().getResource("convert-icon-clicked.png"));
                CONVERSION_CONVERT_BTN.setIcon(clickedIcon);
            }

            public void mouseExited(MouseEvent e) {
                // Reset to normal icon when mouse exits
                CONVERSION_CONVERT_BTN.setIcon(convertIcon);
            }
        });
        
        ImageIcon deleteIcon = new ImageIcon(getClass().getClassLoader().getResource("delete-icon.png")); // Load the image for the button
        JButton DELETE_CONVERT_BTN = new JButton(deleteIcon); // Create the delete button
        DELETE_CONVERT_BTN.setBorder(null); // Remove the default border of the button
        DELETE_CONVERT_BTN.setOpaque(false); // Remove Background
        DELETE_CONVERT_BTN.setContentAreaFilled(false);
        DELETE_CONVERT_BTN.setBorderPainted(false);
        DELETE_CONVERT_BTN.setSize(deleteIcon.getIconWidth(), deleteIcon.getIconHeight()); // Set the size of the button to match the size of the icon
        DELETE_CONVERT_BTN.setLocation(102, 145); // Set the position of the button
        contentPane.add(DELETE_CONVERT_BTN); // Add the button to the content pane
        
        DELETE_CONVERT_BTN.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                // Change the opacity of the button icon when clicked
                ImageIcon clickedIcon = new ImageIcon(getClass().getClassLoader().getResource("delete-icon-clicked.png"));
                DELETE_CONVERT_BTN.setIcon(clickedIcon);
            }

            public void mouseExited(MouseEvent e) {
                // Reset to normal icon when mouse exits
            	DELETE_CONVERT_BTN.setIcon(deleteIcon);
            }
        });
        
        JComboBox WEIGHT_COMBOBOX = new JComboBox<>();
        WEIGHT_COMBOBOX.setBounds(144, 112, 80, 22);
        contentPane.add(WEIGHT_COMBOBOX);
        WEIGHT_COMBOBOX.setBorder(BorderFactory.createEmptyBorder());
        // Set background color to white
        WEIGHT_COMBOBOX.setBackground(Color.WHITE);
        // Adding values to the combo box
        WEIGHT_COMBOBOX.addItem("Kilograms");
        WEIGHT_COMBOBOX.addItem("Pounds");
        WEIGHT_COMBOBOX.addItem("Tons");
        WEIGHT_COMBOBOX.addItem("Grams");
        
        JLabel WEIGHT_CONVERSION_LBL = new JLabel("Weight: ");
        WEIGHT_CONVERSION_LBL.setHorizontalAlignment(SwingConstants.CENTER);
        WEIGHT_CONVERSION_LBL.setFont(new Font("Century Gothic", Font.PLAIN, 13));
        WEIGHT_CONVERSION_LBL.setBounds(27, 99, 105, 40);
        contentPane.add(WEIGHT_CONVERSION_LBL);
        
        JLabel HEIGHT_CONVERSION_LBL = new JLabel("Height:");
        HEIGHT_CONVERSION_LBL.setHorizontalAlignment(SwingConstants.CENTER);
        HEIGHT_CONVERSION_LBL.setFont(new Font("Century Gothic", Font.PLAIN, 13));
        HEIGHT_CONVERSION_LBL.setBounds(26, 54, 105, 40);
        contentPane.add(HEIGHT_CONVERSION_LBL);
        
        // Load the image
        ImageIcon unitConversionIcon = new ImageIcon(getClass().getClassLoader().getResource("unit-conversion.png")); 
        // Create a JLabel with the image icon
        JLabel CONVERSION_LABEL = new JLabel(unitConversionIcon);
        // Set the size of the JLabel to match the size of the image
        CONVERSION_LABEL.setBounds(144, 28, 170, 35);
        // Add the JLabel to the content pane
        contentPane.add(CONVERSION_LABEL);

        HEIGHT_TEXTFIELD = new JTextField();
        HEIGHT_TEXTFIELD.setToolTipText("");
        HEIGHT_TEXTFIELD.setHorizontalAlignment(SwingConstants.CENTER);
        HEIGHT_TEXTFIELD.setFont(new Font("Century Gothic", Font.BOLD, 22));
        HEIGHT_TEXTFIELD.setBounds(163, 274, 135, 36);
        HEIGHT_TEXTFIELD.setBorder(new LineBorder(Color.GRAY, 1));
        HEIGHT_TEXTFIELD.setColumns(10);
        contentPane.add(HEIGHT_TEXTFIELD);

        WEIGHT_TEXTFIELD = new JTextField();
        WEIGHT_TEXTFIELD.setToolTipText("");
        WEIGHT_TEXTFIELD.setHorizontalAlignment(SwingConstants.CENTER);
        WEIGHT_TEXTFIELD.setFont(new Font("Century Gothic", Font.BOLD, 22));
        WEIGHT_TEXTFIELD.setColumns(10);
        WEIGHT_TEXTFIELD.setBounds(163, 356, 135, 36);
        WEIGHT_TEXTFIELD.setBorder(new LineBorder(Color.GRAY, 1));
        contentPane.add(WEIGHT_TEXTFIELD);

        JLabel HEIGHT_LBL = new JLabel("Height (in m)");
        HEIGHT_LBL.setFont(new Font("Century Gothic", Font.PLAIN, 13));
        HEIGHT_LBL.setBounds(188, 311, 94, 22);
        contentPane.add(HEIGHT_LBL);

        JLabel WEIGHT_LBL_1 = new JLabel("Weight (in kg)");
        WEIGHT_LBL_1.setFont(new Font("Century Gothic", Font.PLAIN, 13));
        WEIGHT_LBL_1.setBounds(188, 391, 94, 22);
        contentPane.add(WEIGHT_LBL_1);

        ImageIcon convertBMIIcon = new ImageIcon(getClass().getClassLoader().getResource("convert-bmi-2.png")); // Load the image for the button
        JButton CONVERT_BTN = new JButton(convertBMIIcon); // Create the delete button
        CONVERT_BTN.setBorder(null); // Remove the default border of the button
        CONVERT_BTN.setOpaque(false); // Remove Background
        CONVERT_BTN.setContentAreaFilled(false);
        CONVERT_BTN.setBorderPainted(false);
        CONVERT_BTN.setSize(convertBMIIcon.getIconWidth(), convertBMIIcon.getIconHeight()); // Set the size of the button to match the size of the icon
        CONVERT_BTN.setBounds(56, 418, 377, 38); // Set the position of the button
        contentPane.add(CONVERT_BTN); // Add the button to the content pane
        
        CONVERT_BTN.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                // Change the opacity of the button icon when clicked
                ImageIcon clickedIcon = new ImageIcon(getClass().getClassLoader().getResource("convert-bmi-2-clicked.png"));
                CONVERT_BTN.setIcon(clickedIcon);
            }

            public void mouseExited(MouseEvent e) {
                // Reset to normal icon when mouse exits
            	CONVERT_BTN.setIcon(convertBMIIcon);
            }
        });
      
        // Load the image
        ImageIcon iconBMI = new ImageIcon(getClass().getClassLoader().getResource("bmi-logo.png")); 
        // Create a JLabel with the image icon
        JLabel BMI_LBL = new JLabel(iconBMI);
        // Set the size of the JLabel to match the size of the image
        BMI_LBL.setBounds(553, 42, 264, 43);
        // Add the JLabel to the content pane
        contentPane.add(BMI_LBL);
        
        // Load the image
        ImageIcon iconBMIIs = new ImageIcon(getClass().getClassLoader().getResource("bmi-is.png")); 
        // Create a JLabel with the image icon
        JLabel BMI_LOWER_LBL = new JLabel(iconBMIIs);
        // Set the size of the JLabel to match the size of the image
        BMI_LOWER_LBL.setBounds(635, 94, 94, 22);
        // Add the JLabel to the content pane
        contentPane.add(BMI_LOWER_LBL);

        BMI_COUNTER_LBL = new JLabel("");
        BMI_COUNTER_LBL.setHorizontalAlignment(SwingConstants.CENTER);
        BMI_COUNTER_LBL.setFont(new Font("Century Gothic", Font.BOLD, 45));
        BMI_COUNTER_LBL.setBounds(624, 129, 122, 71);
        contentPane.add(BMI_COUNTER_LBL);

        BMI_LABELER_LBL_1 = new JLabel("");
        BMI_LABELER_LBL_1.setHorizontalAlignment(SwingConstants.CENTER);
        BMI_LABELER_LBL_1.setFont(new Font("Century Gothic", Font.PLAIN, 23));
        BMI_LABELER_LBL_1.setBounds(590, 186, 190, 50);
        contentPane.add(BMI_LABELER_LBL_1);
        
        JLabel ULTIMATE_LABEL_LBL = new JLabel(" ");
        ULTIMATE_LABEL_LBL.setHorizontalAlignment(SwingConstants.RIGHT);
        ULTIMATE_LABEL_LBL.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        ULTIMATE_LABEL_LBL.setBounds(492, 233, 401, 124);
        contentPane.add(ULTIMATE_LABEL_LBL);
       
        ImageIcon clearIcon = new ImageIcon(getClass().getClassLoader().getResource("clear.png")); // Load the image for the button
        JButton CLEAR_BTN = new JButton(clearIcon); // Create the delete button
        CLEAR_BTN.setBorder(null); // Remove the default border of the button
        CLEAR_BTN.setOpaque(false); // Remove Background
        CLEAR_BTN.setContentAreaFilled(false);
        CLEAR_BTN.setBorderPainted(false);
        CLEAR_BTN.setSize(convertBMIIcon.getIconWidth(), convertBMIIcon.getIconHeight()); // Set the size of the button to match the size of the icon
        CLEAR_BTN.setBounds(716, 375, 170, 31);; // Set the position of the button
        contentPane.add(CLEAR_BTN); // Add the button to the content pane
        
        CLEAR_BTN.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                // Change the opacity of the button icon when clicked
                ImageIcon clickedIcon = new ImageIcon(getClass().getClassLoader().getResource("clear-pressed.png"));
                CLEAR_BTN.setIcon(clickedIcon);
            }

            public void mouseExited(MouseEvent e) {
                // Reset to normal icon when mouse exits
            	CLEAR_BTN.setIcon(clearIcon);
            }
        });
        
        ImageIcon backIcon = new ImageIcon(getClass().getClassLoader().getResource("back.png")); // Load the image for the button
        JButton BACK_BTN = new JButton(backIcon); // Create the delete button
        BACK_BTN.setBorder(null); // Remove the default border of the button
        BACK_BTN.setOpaque(false); // Remove Background
        BACK_BTN.setContentAreaFilled(false);
        BACK_BTN.setBorderPainted(false);
        BACK_BTN.setSize(convertBMIIcon.getIconWidth(), convertBMIIcon.getIconHeight()); // Set the size of the button to match the size of the icon
        BACK_BTN.setBounds(716, 415, 170, 31); // Set the position of the button
        contentPane.add(BACK_BTN); // Add the button to the content pane
        
        BACK_BTN.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                // Change the opacity of the button icon when clicked
                ImageIcon clickedIcon = new ImageIcon(getClass().getClassLoader().getResource("back-pressed.png"));
                BACK_BTN.setIcon(clickedIcon);
            }

            public void mouseExited(MouseEvent e) {
                // Reset to normal icon when mouse exits
            	BACK_BTN.setIcon(backIcon);
            }
        });
        
        HEIGHT_CONVERSION_TEXTFIELD = new JTextField();
        HEIGHT_CONVERSION_TEXTFIELD.setHorizontalAlignment(SwingConstants.CENTER);
        HEIGHT_CONVERSION_TEXTFIELD.setBounds(237, 64, 94, 20);
        HEIGHT_CONVERSION_TEXTFIELD.setColumns(10);
        HEIGHT_CONVERSION_TEXTFIELD.setBorder(new LineBorder(Color.gray, 1)); // Adjust color and thickness as needed
        contentPane.add(HEIGHT_CONVERSION_TEXTFIELD);
        
        WEIGHT_CONVERSION_TEXTFIELD = new JTextField();
        WEIGHT_CONVERSION_TEXTFIELD.setHorizontalAlignment(SwingConstants.CENTER);
        WEIGHT_CONVERSION_TEXTFIELD.setColumns(10);
        WEIGHT_CONVERSION_TEXTFIELD.setBounds(237, 112, 94, 20);
        WEIGHT_CONVERSION_TEXTFIELD.setBorder(new LineBorder(Color.gray, 1)); // Adjust color and thickness as needed
        contentPane.add(WEIGHT_CONVERSION_TEXTFIELD);
        
        JLabel CONVERTED_HEIGHT_LBL = new JLabel("");
        CONVERTED_HEIGHT_LBL.setFont(new Font("Century Gothic", Font.PLAIN, 13));
        CONVERTED_HEIGHT_LBL.setBounds(357, 63, 67, 18);
        contentPane.add(CONVERTED_HEIGHT_LBL);
        
        JLabel CONVERTED_WEIGHT_LBL = new JLabel("");
        CONVERTED_WEIGHT_LBL.setFont(new Font("Century Gothic", Font.PLAIN, 13));
        CONVERTED_WEIGHT_LBL.setBounds(357, 113, 67, 18);
        contentPane.add(CONVERTED_WEIGHT_LBL);
        
        // Load the image
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("fill-in.png")); 
        // Create a JLabel with the image icon
        JLabel BMI_IMG_LBL = new JLabel(icon);
        // Set the size of the JLabel to match the size of the image
        BMI_IMG_LBL.setBounds(56, 219, 369, 50);
        // Add the JLabel to the content pane
        contentPane.add(BMI_IMG_LBL);

        CONVERT_BTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get height and weight input
                String heightStr = HEIGHT_TEXTFIELD.getText().trim();
                String weightStr = WEIGHT_TEXTFIELD.getText().trim();

                // Check if height and weight inputs are not empty
                if (!heightStr.isEmpty() && !weightStr.isEmpty()) {
                    try {
                        // Parse height and weight to double
                        double height = Double.parseDouble(heightStr);
                        double weight = Double.parseDouble(weightStr);

                        // Calculate BMI
                        double bmi = calculateBMI(height, weight);

                        // Display BMI
                        BMI_COUNTER_LBL.setText(String.format("%.1f", bmi));

                        // Determine BMI label
                        String bmiLabel = determineBMILabel(bmi);

                        // Display BMI label
                        BMI_LABELER_LBL_1.setText(bmiLabel);
                        
                        // Determine BMI description
                        String bmiDescription = descriptionBMI(bmi);
                        
                        // Display BMI description
                        ULTIMATE_LABEL_LBL.setText(bmiDescription);
                    } catch (NumberFormatException ex) {
                    	HEIGHT_TEXTFIELD.setText(" ");
                    	WEIGHT_TEXTFIELD.setText(" ");
                    }
                } else {
            		HEIGHT_TEXTFIELD.setText(" ");
            		WEIGHT_TEXTFIELD.setText(" ");
            		BMI_COUNTER_LBL.setText(" ");
            		BMI_LABELER_LBL_1.setText(" ");
            		ULTIMATE_LABEL_LBL.setText(" ");
                	JOptionPane.showMessageDialog(contentPane, "Error Input! Retry", "No Input Integer", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        CLEAR_BTN.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		HEIGHT_TEXTFIELD.setText(" ");
        		WEIGHT_TEXTFIELD.setText(" ");
        		BMI_COUNTER_LBL.setText(" ");
        		BMI_LABELER_LBL_1.setText(" ");
        		ULTIMATE_LABEL_LBL.setText(" ");
        		
        	}
        });
        
        CONVERSION_CONVERT_BTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // For HEIGHT
                // Get the selected unit
                String selectedUnit = (String) HEIGHT_COMBOBOX.getSelectedItem();
                // Get the value to convert
                String inputValue = HEIGHT_CONVERSION_TEXTFIELD.getText().trim();

                // Check if the input value is not empty
                if (!inputValue.isEmpty()) {
                    try {
                        double valueToConvert = Double.parseDouble(inputValue);

                        // Convert to meters based on the selected unit
                        double convertedValue = 0.0; // Initialize to a default value
                        if (selectedUnit.equals("Centimeters")) {
                            convertedValue = valueToConvert / 100; // Convert to meters
                        } else if (selectedUnit.equals("Inches")) {
                            convertedValue = valueToConvert / 39.3701; // Convert to meters
                        } else if (selectedUnit.equals("Feet")) {
                            convertedValue = valueToConvert * 0.3048; // Convert to meters
                        } else if (selectedUnit.equals("Meters")) {
                            convertedValue = valueToConvert;
                        }

                        // Display the converted value
                        CONVERTED_HEIGHT_LBL.setText(String.format("%.2f m", convertedValue));
                    } catch (NumberFormatException ex) {
                        // Handle the case where the input value is not a valid number
                        CONVERTED_HEIGHT_LBL.setText("Invalid input");
                    }
                } else {
                    // If the input value is empty, display an appropriate message or clear the label
                    CONVERTED_HEIGHT_LBL.setText("");
                }

                // For WEIGHT
                // Get the selected unit
                String selectedUnitWeight = (String) WEIGHT_COMBOBOX.getSelectedItem();
                // Get the value to convert
                String inputValueWeight = WEIGHT_CONVERSION_TEXTFIELD.getText().trim();

                // Check if the input value is not empty
                if (!inputValueWeight.isEmpty()) {
                    try {
                        double valueToConvertWeight = Double.parseDouble(inputValueWeight);

                        // Convert to meters based on the selected unit
                        double convertedValueWeight = 0.0;
                        if (selectedUnitWeight.equals("Pounds")) {
                            convertedValueWeight = valueToConvertWeight * 0.45359237;
                        } else if (selectedUnitWeight.equals("Tons")) {
                            convertedValueWeight = valueToConvertWeight * 1000;
                        } else if (selectedUnitWeight.equals("Grams")) {
                            convertedValueWeight = valueToConvertWeight / 1000;
                        } else if (selectedUnitWeight.equals("Kilograms")) {
                            convertedValueWeight = valueToConvertWeight;
                        }

                        // Display the converted value
                        CONVERTED_WEIGHT_LBL.setText(String.format("%.2f kg", convertedValueWeight));
                    } catch (NumberFormatException ex) {
                        // Handle the case where the input value is not a valid number
                        CONVERTED_WEIGHT_LBL.setText("Invalid input");
                    }
                } else {
                    // If the input value is empty, display an appropriate message or clear the label
                    CONVERTED_WEIGHT_LBL.setText("");
                }
            }
        });
 
        DELETE_CONVERT_BTN.addActionListener (new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		WEIGHT_CONVERSION_TEXTFIELD.setText(" ");
        		HEIGHT_CONVERSION_TEXTFIELD.setText(" ");
        		CONVERTED_HEIGHT_LBL.setText(" ");
        		CONVERTED_WEIGHT_LBL.setText(" ");
        	}
        });

        BACK_BTN.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				LANDING_SIMPLIFIED_UI landingSimplified = new LANDING_SIMPLIFIED_UI();
				landingSimplified.setVisible(true);
        		dispose();
        	}
        });
        
        // Load the image
        ImageIcon backgroundImageIcon = new ImageIcon(getClass().getClassLoader().getResource("BACKGROUND-BMI-12.png"));

        // Create a JLabel with the image icon
        JLabel backgroundImageLabel = new JLabel(backgroundImageIcon);

        // Set the size of the label to match the size of the JFrame
        backgroundImageLabel.setSize(getSize());

        // Set the bounds of the label to cover the whole content pane
        backgroundImageLabel.setBounds(0, 0, getWidth(), getHeight());

        // Add the JLabel to the content pane (at the back, so it doesn't cover other components)
        contentPane.add(backgroundImageLabel, new Integer(Integer.MIN_VALUE));

        // Make sure the content pane is transparent
        ((JPanel) contentPane).setOpaque(false);
    }

    private double calculateBMI(double height, double weight) {
        return weight / (height * height);
    }

    private String determineBMILabel(double bmi) {
    	String text;
        if (bmi < 18.5) {
        	text = "Underweight";
        	return text;
        } else if(bmi >= 18.5 && bmi <= 24.9) {
        	text = "Normal";
        	return text;
        } else if (bmi >= 25 && bmi <= 29.9) {
        	text = "Overweight";
        	return text;
        } else if (bmi >= 30) {
        	text = "Obese";
        	return text;
        }
        return "";
    }
    
    private String descriptionBMI(double bmi) {
    	return (bmi < 18.5) ? "<html>Individuals with a BMI below the normal range are considered underweight. They may have insufficient body fat, "
    							+ "which can indicate potential health risks such as weakened immune function, nutrient deficiencies, and osteoporosis.</html>"
    				: (bmi <= 24.9) ? "<html>Falling within the healthy BMI range indicates a normal weight. Individuals in this category typically have a "
    									+ "balanced body composition, which is associated with lower risks of chronic diseases and overall good health.</html>"
    				: (bmi <= 29.9) ? "<html>Those with a BMI above the normal range but below the obese range are classified as overweight. Excess weight "
    									+ "can increase the risk of various health conditions, including heart disease, type 2 diabetes, hypertension, and certain cancers.</html>"
    				: "<html>Individuals with a BMI in the obese range have an excessive amount of body fat, which can significantly increase "
    									+ "the risk of developing serious health problems. These may include cardiovascular diseases, stroke, type 2 diabetes. </html>";
    }
}
