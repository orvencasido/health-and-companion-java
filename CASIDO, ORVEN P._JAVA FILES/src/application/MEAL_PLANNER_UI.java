package application;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MEAL_PLANNER_UI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel BUTTON_PANNEL;
    private JScrollPane scrollPane;
    private JLabel BREAKFAST_LBL;
    private JLabel LUNCH_LBL;
    private JLabel DINNER_LBL;
    private DefaultListModel<String> recipeListModel;
    private JToggleButton MONDAY_BTN;
    private JToggleButton TUESDAY_BTN;
    private JToggleButton WEDNESDAY_BTN;
    private JToggleButton THURSDAY_BTN;
    private JToggleButton FRIDAY_BTN;
    private JToggleButton SATURDAY_BTN;
    private JToggleButton SUNDAY_BTN;
    
    private String mondayBreakfast = "";
    private String mondayLunch = "";
    private String mondayDinner = "";
    private String tuesdayBreakfast = "";
    private String tuesdayLunch = "";
    private String tuesdayDinner = "";
    private String wednesdayBreakfast = "";
    private String wednesdayLunch = "";
    private String wednesdayDinner = "";
    private String thursdayBreakfast = "";
    private String thursdayLunch = "";
    private String thursdayDinner = "";
    private String fridayBreakfast = "";
    private String fridayLunch = "";
    private String fridayDinner = "";
    private String saturdayBreakfast = "";
    private String saturdayLunch = "";
    private String saturdayDinner = "";
    private String sundayBreakfast = "";
    private String sundayLunch = "";
    private String sundayDinner = "";
    
    private Map<String, String[]> mealPlans = new HashMap<>();

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
    public MEAL_PLANNER_UI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 960, 540);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("Health and Fitness Companion");
        setResizable(false);

        ImageIcon mainIcon = new ImageIcon(getClass().getClassLoader().getResource("iconLogoPoster.png"));
        setIconImage(mainIcon.getImage());
        
        JLabel COOKING_TODAY_LBL = imageSetter("what-are-we-cooking.png");
        COOKING_TODAY_LBL.setBounds(32, 32, 345, 40);
        
        JLabel PERSONALIZED_LBL = imageSetter("personalized-meal-plan.png");
        PERSONALIZED_LBL.setBounds(32, 210, 345, 40);
        
        JLabel RECIPES_LBL = imageSetter("recipes-to-cook.png");
        RECIPES_LBL.setBounds(718, 22, 159, 40);
        
        recipeListModel = new DefaultListModel<>(); // Initialize the model
        JList<String> recipeList = new JList<>(recipeListModel); // Create JList with model
        recipeList.setBackground(Color.decode("#eaffef")); // Set background color of JList
        JScrollPane recipeScrollPane = new JScrollPane(recipeList); // Put JList in JScrollPane
        recipeScrollPane.setBounds(718, 90, 200, 300);
        recipeScrollPane.setBorder(null); // Remove border from JScrollPane
        recipeScrollPane.setBackground(Color.decode("#eaffef")); // Set background color of JScrollPane
        contentPane.add(recipeScrollPane);
        
        String ADDMEAL_ICON_BTN = "add-meal.png";
        String ADDMEAL_ICON_ENTERED = "add-meal-clicked.png";
        JButton ADDMEAL_BTN = buttonSetter(ADDMEAL_ICON_BTN, ADDMEAL_ICON_ENTERED, ADDMEAL_ICON_BTN);
        ADDMEAL_BTN.setBounds(514, 24, 150, 40);
        
        String ADDPLANL_ICON_BTN = "add-plan.png";
        String ADDPLANL_ICON_ENTERED = "add-plan-clicked.png";
        JButton ADDPLAN_BTN = buttonSetter(ADDPLANL_ICON_BTN, ADDPLANL_ICON_ENTERED, ADDPLANL_ICON_BTN);
        ADDPLAN_BTN.setBounds(514, 200, 150, 40);
        
        String BACK_ICON_BTN = "back-exercises.png";
        String BACK_ICON_ENTERED = "back-exercises-clicked.png";
        JButton BACK_BTN = buttonSetter(BACK_ICON_BTN, BACK_ICON_ENTERED, BACK_ICON_BTN);
        BACK_BTN.setBounds(780, 450, 133, 40);
        BACK_BTN.addActionListener(ActionListener -> {
			LANDING_SIMPLIFIED_UI landingSimplified = new LANDING_SIMPLIFIED_UI();
			landingSimplified.setVisible(true);
        	dispose();
        });
        
        String PLUS_ICON_BTN = "plus.png";
        String PLUS_ICON_ENTERED = "plus-clicked.png";
        JButton ADDRECIPE_BTN = buttonSetter(PLUS_ICON_BTN, PLUS_ICON_ENTERED, PLUS_ICON_BTN);
        ADDRECIPE_BTN.setBounds(887, 32, 40, 23);
        ADDRECIPE_BTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display input dialog to get recipe name
                String recipeName = JOptionPane.showInputDialog(MEAL_PLANNER_UI.this, "Enter Recipe Name:");
                if (recipeName != null && !recipeName.isEmpty()) {
                    // Add the recipe to the list model
                    recipeListModel.addElement(recipeName);
                }
            }
        });
        
        String MONDAY_ICON_BTN = "monday.png";
        String MONDAY_ICON_ENTERED = "monday-clicked.png";
        MONDAY_BTN = buttonSetterToggle(MONDAY_ICON_ENTERED, MONDAY_ICON_BTN, MONDAY_ICON_ENTERED, MONDAY_ICON_BTN);
        MONDAY_BTN.setBounds(70, 275, 121, 23);
        
        String TUESDAY_ICON_BTN = "tuesday.png";
        String TUESDAY_ICON_ENTERED = "tuesday-clicked.png";
        TUESDAY_BTN = buttonSetterToggle(TUESDAY_ICON_ENTERED, TUESDAY_ICON_BTN, TUESDAY_ICON_ENTERED, TUESDAY_ICON_BTN);
        TUESDAY_BTN.setBounds(210, 275, 121, 23);
        
        String WEDNESDAY_ICON_BTN = "wednesday.png";
        String WEDNESDAY_ICON_ENTERED = "wednesday-clicked.png";
        WEDNESDAY_BTN = buttonSetterToggle(WEDNESDAY_ICON_ENTERED, WEDNESDAY_ICON_BTN, WEDNESDAY_ICON_ENTERED, WEDNESDAY_ICON_BTN);
        WEDNESDAY_BTN.setBounds(350, 275, 121, 23);
        
        String THURSDAY_ICON_BTN = "thursday.png";
        String THURSDAY_ICON_ENTERED = "thursday-clicked.png";
        THURSDAY_BTN = buttonSetterToggle(THURSDAY_ICON_ENTERED, THURSDAY_ICON_BTN, THURSDAY_ICON_ENTERED, THURSDAY_ICON_BTN);
        THURSDAY_BTN.setBounds(490, 275, 121, 23);
        
        String FRIDAY_ICON_BTN = "friday.png";
        String FRIDAY_ICON_ENTERED = "friday-clicked.png";
        FRIDAY_BTN = buttonSetterToggle(FRIDAY_ICON_ENTERED, FRIDAY_ICON_BTN, FRIDAY_ICON_ENTERED, FRIDAY_ICON_BTN);
        FRIDAY_BTN.setBounds(150, 307, 121, 23);
        
        String SATURDAY_ICON_BTN = "saturday.png";
        String SATURDAY_ICON_ENTERED = "saturday-clicked.png";
        SATURDAY_BTN = buttonSetterToggle(SATURDAY_ICON_ENTERED, SATURDAY_ICON_BTN, SATURDAY_ICON_ENTERED, SATURDAY_ICON_BTN);
        SATURDAY_BTN.setBounds(290, 307, 121, 23);
        
        String SUNDAY_ICON_BTN = "sunday.png";
        String SUNDAY_ICON_ENTERED = "sunday-clicked.png";
        SUNDAY_BTN = buttonSetterToggle(SUNDAY_ICON_ENTERED, SUNDAY_ICON_BTN, SUNDAY_ICON_ENTERED, SUNDAY_ICON_BTN);
        SUNDAY_BTN.setBounds(430, 307, 121, 23);
        
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(MONDAY_BTN);
        buttonGroup.add(TUESDAY_BTN);
        buttonGroup.add(WEDNESDAY_BTN);
        buttonGroup.add(THURSDAY_BTN);
        buttonGroup.add(FRIDAY_BTN);
        buttonGroup.add(SATURDAY_BTN);
        buttonGroup.add(SUNDAY_BTN);
        
        BREAKFAST_LBL = new JLabel("");
        BREAKFAST_LBL.setFont(new Font("Century Gothic", Font.PLAIN, 12));
        BREAKFAST_LBL.setHorizontalAlignment(SwingConstants.CENTER);
        BREAKFAST_LBL.setBounds(70, 419, 159, 59);
        contentPane.add(BREAKFAST_LBL);
        
        LUNCH_LBL = new JLabel("");
        LUNCH_LBL.setFont(new Font("Century Gothic", Font.PLAIN, 12));
        LUNCH_LBL.setHorizontalAlignment(SwingConstants.CENTER);
        LUNCH_LBL.setBounds(261, 419, 159, 59);
        contentPane.add(LUNCH_LBL);
        
        DINNER_LBL = new JLabel("");
        DINNER_LBL.setFont(new Font("Century Gothic", Font.PLAIN, 12));
        DINNER_LBL.setHorizontalAlignment(SwingConstants.CENTER);
        DINNER_LBL.setBounds(452, 419, 159, 59);
        contentPane.add(DINNER_LBL);

        BUTTON_PANNEL = new JPanel();
        BUTTON_PANNEL.setOpaque(false); // Make the panel transparent
        BUTTON_PANNEL.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        scrollPane = new JScrollPane(BUTTON_PANNEL);
        scrollPane.setOpaque(false); // Make the scroll pane transparent
        scrollPane.getViewport().setOpaque(false); // Make the viewport transparent
        scrollPane.setBorder(null); // Remove the border
        scrollPane.setBounds(30, 78, 634, 100);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        contentPane.add(scrollPane);
        
        JLabel BREAKFAST_TXT_LBL = imageSetter("for-breakfast.png");
        BREAKFAST_TXT_LBL.setBounds(70, 366, 159, 42);
        
        JLabel LUNCH_TXT_LBL = imageSetter("for-lunch.png");
        LUNCH_TXT_LBL.setBounds(261, 366, 159, 42);
        
        JLabel DINNER_TXT_LBL = imageSetter("for-dinner.png");
        DINNER_TXT_LBL.setBounds(452, 365, 159, 42);
        
        ADDMEAL_BTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display input dialogs to get food name, ingredients, and notes
                JTextField foodNameField = new JTextField();
                JTextArea ingredientsArea = new JTextArea();
                JTextField notesField = new JTextField();

                JPanel panel = new JPanel(new GridLayout(0, 1));
                panel.add(new JLabel("Food Name:"));
                panel.add(foodNameField);
                panel.add(new JLabel("Ingredients:"));
                panel.add(new JScrollPane(ingredientsArea)); // Use JScrollPane for multi-line input
                panel.add(new JLabel("Notes:"));
                panel.add(notesField);

                int result = JOptionPane.showConfirmDialog(MEAL_PLANNER_UI.this, panel, "Enter Food Details",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    // Get input values
                    String foodName = foodNameField.getText();
                    String ingredients = ingredientsArea.getText();
                    String notes = notesField.getText();
                    
                    // Load the default image icon
                    String defaultImagePath = "add-ulam.png";
                    ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource(defaultImagePath));
                    // Resize the icon to 90x70 pixels
                    Image image = icon.getImage().getScaledInstance(90, 70, Image.SCALE_SMOOTH);
                    icon = new ImageIcon(image);

                    // Create a new button with food name and icon
                    JButton newButton = new JButton(foodName);
                    newButton.setPreferredSize(new Dimension(90, 70));
                    newButton.setContentAreaFilled(false); // Make button transparent
                    newButton.setBorderPainted(false); // Remove border
                    if (icon != null) {
                        newButton.setIcon(icon); // Set the icon
                    }

                    newButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // Display food details and delete option in a message dialog when the button is clicked
                            String message = "Food Name: " + foodName + "\n\nIngredients: \n" + ingredients + "\n\nNotes: " + notes;
                            int option = JOptionPane.showConfirmDialog(MEAL_PLANNER_UI.this, message + "\n\nDo you want to delete this meal?", "Meal Details", JOptionPane.YES_NO_OPTION);

                            if (option == JOptionPane.YES_OPTION) {
                                // Remove the button from BUTTON_PANNEL
                                BUTTON_PANNEL.remove(newButton);
                                BUTTON_PANNEL.revalidate();
                                BUTTON_PANNEL.repaint();
                            }
                        }
                    });

                    // Add the new button to BUTTON_PANNEL
                    BUTTON_PANNEL.add(newButton);
                    BUTTON_PANNEL.revalidate();
                    BUTTON_PANNEL.repaint();
                }
            }
        });
        
        ADDPLAN_BTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
                String selectedDay = (String) JOptionPane.showInputDialog(MEAL_PLANNER_UI.this,
                        "Select the day of the plan:", "Day Selection",
                        JOptionPane.QUESTION_MESSAGE, null, daysOfWeek, daysOfWeek[0]);

                if (selectedDay != null && !selectedDay.isEmpty()) {
                    JTextField breakfastField = new JTextField();
                    JTextField lunchField = new JTextField();
                    JTextField dinnerField = new JTextField();

                    JPanel panel = new JPanel(new GridLayout(0, 1));
                    panel.add(new JLabel("Breakfast:"));
                    panel.add(breakfastField);
                    panel.add(new JLabel("Lunch:"));
                    panel.add(lunchField);
                    panel.add(new JLabel("Dinner:"));
                    panel.add(dinnerField);

                    int result = JOptionPane.showConfirmDialog(MEAL_PLANNER_UI.this, panel,
                            "Enter Meals for " + selectedDay, JOptionPane.OK_CANCEL_OPTION);

                    if (result == JOptionPane.OK_OPTION) {
                        String breakfast = breakfastField.getText();
                        String lunch = lunchField.getText();
                        String dinner = dinnerField.getText();

                        // Store meal plan for Monday
                        if (selectedDay.equals("Monday")) {
                            mondayBreakfast = breakfast;
                            mondayLunch = lunch;
                            mondayDinner = dinner;
                        } else if (selectedDay.equals("Tuesday")) {
                            tuesdayBreakfast = breakfast;
                            tuesdayLunch = lunch;
                            tuesdayDinner = dinner;
                        } else if (selectedDay.equals("Wednesday")) {
                            wednesdayBreakfast = breakfast;
                            wednesdayLunch = lunch;
                            wednesdayDinner = dinner;
                        } else if (selectedDay.equals("Thursday")) {
                            thursdayBreakfast = breakfast;
                            thursdayLunch = lunch;
                            thursdayDinner = dinner;
                        } else if (selectedDay.equals("Friday")) {
                            fridayBreakfast = breakfast;
                            fridayLunch = lunch;
                            fridayDinner = dinner;
                        } else if (selectedDay.equals("Saturday")) {
                            saturdayBreakfast = breakfast;
                            saturdayLunch = lunch;
                            saturdayDinner = dinner;
                        } else if (selectedDay.equals("Sunday")) {
                            sundayBreakfast = breakfast;
                            sundayLunch = lunch;
                            sundayDinner = dinner;
                        }
                    }
                }
            }
        });

        MONDAY_BTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (MONDAY_BTN.isSelected()) {
                    BREAKFAST_LBL.setText(mondayBreakfast);
                    LUNCH_LBL.setText(mondayLunch);
                    DINNER_LBL.setText(mondayDinner);
                }
            }
        });
        

        TUESDAY_BTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (TUESDAY_BTN.isSelected()) {
                    BREAKFAST_LBL.setText(tuesdayBreakfast);
                    LUNCH_LBL.setText(tuesdayLunch);
                    DINNER_LBL.setText(tuesdayDinner);
                }
            }
        });
        
        WEDNESDAY_BTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (WEDNESDAY_BTN.isSelected()) {
                    BREAKFAST_LBL.setText(wednesdayBreakfast);
                    LUNCH_LBL.setText(wednesdayLunch);
                    DINNER_LBL.setText(wednesdayDinner);
                }
            }
        });
        
        THURSDAY_BTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (THURSDAY_BTN.isSelected()) {
                    BREAKFAST_LBL.setText(thursdayBreakfast);
                    LUNCH_LBL.setText(thursdayLunch);
                    DINNER_LBL.setText(thursdayDinner);
                }
            }
        });
        
        FRIDAY_BTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (FRIDAY_BTN.isSelected()) {
                    BREAKFAST_LBL.setText(fridayBreakfast);
                    LUNCH_LBL.setText(fridayLunch);
                    DINNER_LBL.setText(fridayDinner);
                }
            }
        });
        
        SATURDAY_BTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (SATURDAY_BTN.isSelected()) {
                    BREAKFAST_LBL.setText(saturdayBreakfast);
                    LUNCH_LBL.setText(saturdayLunch);
                    DINNER_LBL.setText(saturdayDinner);
                }
            }
        });
        
        SUNDAY_BTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (SUNDAY_BTN.isSelected()) {
                    BREAKFAST_LBL.setText(sundayBreakfast);
                    LUNCH_LBL.setText(sundayLunch);
                    DINNER_LBL.setText(sundayDinner);
                }
            }
        });

        ImageIcon backgroundImageIcon = new ImageIcon(getClass().getClassLoader().getResource("MEAL-PLANNER-BG.png"));
        JLabel backgroundImageLabel = new JLabel(backgroundImageIcon);
        backgroundImageLabel.setBounds(0, 0, 960, 540);
        contentPane.add(backgroundImageLabel);
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
	
    public JToggleButton buttonSetterToggle(String imageLocation, String enteredIconLocation, String exitedIconLocation, String toggledIconLocation) {
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource(imageLocation));
        JToggleButton button = new JToggleButton(icon);
        button.setBorder(null);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setSize(icon.getIconWidth(), icon.getIconHeight());

        // Set the default icon
        button.setIcon(new ImageIcon(getClass().getClassLoader().getResource(imageLocation)));

        // Create an ItemListener to listen for state changes in the toggle button
        button.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    // Button is toggled
                    button.setIcon(new ImageIcon(getClass().getClassLoader().getResource(toggledIconLocation)));
                } else {
                    // Button is untoggled
                    button.setIcon(new ImageIcon(getClass().getClassLoader().getResource(imageLocation)));
                }
            }
        });

        // Add mouse listener for hover effect
        button.addMouseListener(getMouseListenerToggle(enteredIconLocation, exitedIconLocation, toggledIconLocation));

        contentPane.add(button);
        return button;
    }

    private MouseAdapter getMouseListenerToggle(String enteredIconLocation, String exitedIconLocation, String toggledIconLocation) {
        return new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                JToggleButton button = (JToggleButton) e.getSource();
                if (button.isSelected()) {
                    ImageIcon enteredIcon = new ImageIcon(getClass().getClassLoader().getResource(toggledIconLocation));
                    button.setIcon(enteredIcon);
                } else {
                    ImageIcon enteredIcon = new ImageIcon(getClass().getClassLoader().getResource(enteredIconLocation));
                    button.setIcon(enteredIcon);
                }
            }

            public void mouseExited(MouseEvent e) {
                JToggleButton button = (JToggleButton) e.getSource();
                if (button.isSelected()) {
                    ImageIcon exitedIcon = new ImageIcon(getClass().getClassLoader().getResource(toggledIconLocation));
                    button.setIcon(exitedIcon);
                } else {
                    ImageIcon exitedIcon = new ImageIcon(getClass().getClassLoader().getResource(exitedIconLocation));
                    button.setIcon(exitedIcon);
                }
            }
        };
    }
}
