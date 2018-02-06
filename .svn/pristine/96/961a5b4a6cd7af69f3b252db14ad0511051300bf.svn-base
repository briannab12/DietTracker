 /**
 * Class that generates the JFrame for Exercises/recipes
 *@authors Team A
 *@version 3.0
 */
 
 package view ;
 
 import controller.LogCollectionManager;
 import model.DailyLogEntry;
 import model.Exercise;
 import model.ExerciseCollection;
 import model.LogCollection;

 import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;


public class LogExercisePanel extends JPanel implements Observer, Panel{
    private ExerciseCollection exerciseList;
    private JPanel frame;
    private JTabbedPane tabs;
    private JComboBox<String> exerciseSelector = new JComboBox<String>();
    private JComboBox<String> deleteSelector = new JComboBox<String>();
    private JButton submitBtn;
    private LogCollection userLog;

    private JTextField calories;
    private JTextField minutes;
    private JTextField caloriesDel;
    private JTextField minutesDel;

    LogCollectionManager ulm;

    /**
     * Constructor for JFrame to add more Exercises/recipes
     */
    public LogExercisePanel(ExerciseCollection ExerciseList, LogCollection userLog){
        this.exerciseList = ExerciseList;
        this.userLog = userLog;
        frame = new JPanel();
        tabs = new JTabbedPane();
        this.userLog.addObserver(this);
        this.exerciseList.addObserver(this);
        ulm = new LogCollectionManager(userLog);
    }

    /**
     * Displays this interface
     */
    public JPanel display() {
        JPanel frame = new JPanel();
        tabs.add("Add Exercise", buildExercisePanel());
        tabs.add("Delete Exercise", buildDeletePanel());
        frame.setLayout(new GridLayout(0, 1));//using no layout managers

        frame.setSize(700, 700);
        frame.add(tabs);
        return frame;
    }

    public JPanel buildExercisePanel(){
        JPanel frame = createPanel();
        JPanel pane = createPanel();
        //creates the Exercise selector and the servings selector labels
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        JPanel labelPane = createPanel();
        labelPane.setLayout(new GridLayout(0, 2));
        labelPane.add(createLabel("Select Exercise"));
        labelPane.add(createLabel("Minutes"));
        labelPane.add(createexerciseSelector());
        minutes = createTextField("0");
        labelPane.add(minutes);
        pane.add(labelPane);
        frame.add(pane);

        pane = createPanel();
        //creates the label and text field for calories
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane.add(createLabel("Calories (1hr for 100lbs): "));
        calories = createUneditableTextField("0");
        pane.add(calories);
        frame.add(pane);

        pane = createPanel();
        //creates the label and text field for proteins
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        submitBtn = createButton("Add Exercise to Log");
        pane.add(submitBtn);
        frame.add(pane);

        exerciseSelector.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                JComboBox<String> comboBox = (JComboBox<String>) ie.getSource();
                String selected = (String) comboBox.getSelectedItem();
                if (selected.equals("--Select Exercise--")) {
                    displayCalories(0.0);
                } else {
                    displayCalories(exerciseList.getExercise(selected).getCalories());
                }
            }
        });

        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String selected = (String) exerciseSelector.getSelectedItem();
                double min = -1;
                if(validateNumericString(minutes.getText())) {
                    String minStr = minutes.getText();
                    min = Double.parseDouble(minStr);
                    ulm.addExercise(selected, min);
                } else{
                    JOptionPane.showMessageDialog(new JFrame(), "Inputted text is not a number", "Non-Numeric Input", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                // create new log and exericse

                JOptionPane msgPane = new JOptionPane("You have added "+ selected+ " to your Exercise Log.");
                JDialog msg = msgPane.createDialog((JFrame)null, "Exercise Added");
                msg.setLocationRelativeTo(frame);
                msg.setVisible(true);

                displayCalories(0.0);
                displayMinutes(0.0);

                exerciseSelector.setSelectedIndex(0);
            }
        });

        return frame;
    }

    public JPanel buildDeletePanel(){
        JPanel frame = createPanel();
        JPanel pane = createPanel();
        //creates the Exercise selector and the servings selector labels
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        JPanel labelPane = createPanel();
        labelPane.setLayout(new GridLayout(0, 2));
        labelPane.add(createLabel("Select Exercise"));
        labelPane.add(createLabel("Minutes"));
        labelPane.add(createDeleteSelector());
        minutesDel = createUneditableTextField("0");
        labelPane.add(minutesDel);
        pane.add(labelPane);
        frame.add(pane);

        pane = createPanel();
        //creates the label and text field for calories
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane.add(createLabel("Calories (1hr for 100lbs): "));
        caloriesDel = createUneditableTextField("0");
        pane.add(caloriesDel);
        frame.add(pane);

        pane = createPanel();
        //creates the label and text field for proteins
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        submitBtn = createButton("Delete Exercise");
        pane.add(submitBtn);
        frame.add(pane);

        deleteSelector.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                JComboBox<String> comboBox = (JComboBox<String>) ie.getSource();
                String picked = (String) comboBox.getSelectedItem();
                String[] pickedSplit = picked.split(":");
                String selected = pickedSplit[0];
                if (selected.equals("--Select Exercise--")) {
                    displayMinutesDel(0.0);
                    displayCaloriesDel(0.0);

                } else {
                    double mins = Double.parseDouble(pickedSplit[1]);
                    Date currentDay = userLog.getDateObj();
                    if(userLog.checkForEntry(currentDay)){
                        DailyLogEntry dle = userLog.getLogEntry(currentDay);
                        ArrayList<Exercise> dayExercise = dle.getExercise();
                        for(Exercise exerciseItem : dayExercise){
                            if(exerciseItem.getName().equals(exerciseList.getExercise(selected).getName())){
                                displayMinutesDel(mins);
                            }
                        }
                    }
                    displayCaloriesDel(exerciseList.getExercise(selected).getCalories());
                }
            }
        });

        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String picked = (String) deleteSelector.getSelectedItem();
                String[] pickedSplit = picked.split(":");
                String selected = pickedSplit[0];
                if(selected.equals("--Select Exercise--"))
                {

                }
                else {
                    double mins = Double.parseDouble(pickedSplit[1]);
                    if (validateNumericString(minutesDel.getText())) {
                        String timeStr = minutesDel.getText();
                        Double min = Double.parseDouble(timeStr);
                        ulm.deleteExercise(selected, mins);
                    } else {
                        JOptionPane.showMessageDialog(new JFrame(), "Inputted text is not a number", "Non-Numeric Input", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                JOptionPane msgPane = new JOptionPane("You have removed "+ selected+ " from your Exercise Log");
                JDialog msg = msgPane.createDialog((JFrame)null, "Exercise Removed");
                msg.setLocationRelativeTo(frame);
                msg.setVisible(true);

                displayCaloriesDel(0.0);
                displayMinutesDel(0.0);
                deleteSelector.setSelectedIndex(0);
            }
        });

        return frame;
    }

    /**
     * display the calories
     * @param calories
     */
    public void displayCalories(double calories){
        this.calories.setText(""+calories);
    }

    /**
     * display the minutes
     * @param minutes
     */
    public void displayMinutes(double minutes){
        this.minutes.setText(""+minutes);
    }

    /**
     * display the calories
     * @param calories
     */
    public void displayCaloriesDel(double calories){
        this.caloriesDel.setText(""+calories);
    }

    /**
     * display the minutes
     * @param minutes
     */
    public void displayMinutesDel(double minutes){
        this.minutesDel.setText(""+minutes);
    }

    /**
     * create a JLabel with the specified text
     *
     * @return  a JLabel object
     */
    public JComboBox createexerciseSelector(){
        ArrayList<Exercise> allExercises= exerciseList.getAllExercises();
        exerciseSelector.addItem("--Select Exercise--");
        for(Exercise Exercise : allExercises){
            exerciseSelector.addItem(Exercise.getName());
        }
        return exerciseSelector;
    }

    /**
     * create a JComboBox with the all exercises on the selected date
     *
     * @return  a JComboBox object
     */
    public JComboBox createDeleteSelector() {
        ArrayList<Exercise> loggedExercises = ulm.getExerciseOnDay(userLog.getDateObj());

        deleteSelector.addItem("--Select Exercise--");
        if (!loggedExercises.isEmpty()){
            for (Exercise exercise : loggedExercises) {
                deleteSelector.addItem(exercise.getName()+":"+exercise.getTime());
            }
        }
        return deleteSelector;
    }

    /**
     * Creates the Exercise object
     */
    public void createExercise(){

    }

    /**
     * Creates the JPanel to add recipes
     * @return recipePane The panel to add recipes
     */
    public JPanel recipePanel(){
        JPanel recipePane = new JPanel();

        return recipePane;
    }

    /**
     * Creates the JPanel to add basic Exercises
     * @return the JPanel to add basic Exercises
     */
    public JPanel createPanel(){
        JPanel basicExercisePanel = new JPanel();

        return basicExercisePanel;
    }

    /**
     * create a JLabel with the specified text
     *
     * @param text  the text for the label
     * @return  a JLabel object
     */
    public JLabel createLabel(String text){
        JLabel jlLabel = new JLabel(text);
        jlLabel.setFont(new Font(jlLabel.getFont().getName(), Font.PLAIN, 16));
        return jlLabel;
    }

    /**
     * create a JTextFeild
     *
     * @param name the text for the label
     * @return a JTextFeild object
     */
    public JTextField createTextField( String name){
        JTextField jtfExerciseName = new JTextField(name, 10);

        return jtfExerciseName;
    }

    /**
     * create an uneditable JTextField
     *
     * @param text the text for the label
     * @return a JTextFeild object
     */
    public JTextField createUneditableTextField(String text){
        JTextField textField = new JTextField(text, 10);
        textField.setEditable(false);
        return textField;
    }

    /**
     * create a button to submit Exercises
     *
     * @param text  the button text
     * @return JButton
     */
    public JButton createButton(String text){
        JButton button = new JButton(text);

        return button;
    }

    /**
     * Updates the food selector for deletions and addition
     * @param allExercises
     */
    public void updateExerciseSelector(ArrayList<Exercise> allExercises){
        int ct = exerciseSelector.getItemCount();
        exerciseSelector.addItem("--Select Exercise--");
        exerciseSelector.setSelectedIndex(ct);

        for(int i =0; i<ct; i++) {
            exerciseSelector.removeItemAt(0);
        }

        if (!allExercises.isEmpty()){
            for (Exercise ex : allExercises) {
                exerciseSelector.addItem(ex.getName());
            }
        }
    }

    /**
     * Updates the delete selector for each day when any changes are made
     */
    public void updateDeleteSelector(){

        int ct = deleteSelector.getItemCount();
        deleteSelector.addItem("--Select Exercise--");
        deleteSelector.setSelectedIndex(ct);

        for(int i=0; i<ct; i++) {
            deleteSelector.removeItemAt(0);
        }
        ArrayList<Exercise> loggedExercises = ulm.getExerciseOnDay(userLog.getDateObj());
        try{
            if (!loggedExercises.isEmpty()){
                for (Exercise ex : loggedExercises) {
                    deleteSelector.addItem(ex.getName()+":"+ex.getTime());
                }
            }
        }
        catch(NullPointerException npe){
            int count = deleteSelector.getItemCount();
            for(int i = 1; i<count; i++) {
                deleteSelector.removeItemAt(1);
            }
        }

    }

    /**
     * validates that the user inputted string is a numeric
     * @param str string to check for numerics
     * @return true if numeric, false if non-numeric
     */
    public boolean validateNumericString(String str) {
        for (char c : str.toCharArray()) {
            //if character is a decimal point
            if(c == '.'){
                return true;
            }
            //if the character isnt a digit
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }

    /**
     * updates all of the frames when there is a change
     * @param observable
     * @param args
     */
    public void update(Observable observable, Object args){
        //List of exercise
        if(observable == exerciseList) {
            updateExerciseSelector(exerciseList.getAllExercises());
        }
        if(observable == userLog){
            updateDeleteSelector();
            updateExerciseSelector(exerciseList.getAllExercises());
        }
    }
}