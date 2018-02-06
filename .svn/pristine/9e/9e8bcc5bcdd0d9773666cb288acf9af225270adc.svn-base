import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Class that generates the JFrame for Exercises/recipes
 *
 * @author TeamA
 * @version 1.0
 */
public class ExercisePanel extends JPanel implements Observer, Panel{
    private ExerciseList exerciseList;
    private JPanel frame;
    private JComboBox<String> exerciseSelector = new JComboBox<String>();
    private JButton submitBtn;
    private UserLog userLog;

    private JTextField calories;
    private JTextField minutes;

    /**
     * Constructor for JFrame to add more Exercises/recipes
     */
    public ExercisePanel(ExerciseList ExerciseList, UserLog userLog){
        this.exerciseList = ExerciseList;
        this.userLog = userLog;
        frame = new JPanel();
        this.exerciseList.addObserver(this);
    }

    /**
     * Displays this interface
     */
    public JPanel display(){
        frame.setSize(700, 700);
        frame.setLayout(new GridLayout(0,1));//using no layout managers

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
                String dateStr = "2016-04-20";
                Date date = null;
                try {
                    date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
                }catch(ParseException pe){
                }
                if(userLog.checkForEntry(date)){
                    DailyLogEntry dle = userLog.getLogEntry(date);
                    dle.addExercise(exerciseList.getExercise(selected));
                    displayCalories(0.0);
                    exerciseSelector.setSelectedIndex(0);
                    displayMinutes(0.0);
                }
                else {
                    userLog.createNewDailyLogEntry(date);
                    DailyLogEntry dle = userLog.getLogEntry(date);
                    dle.addExercise(exerciseList.getExercise(selected));
                    displayCalories(0.0);
                    exerciseSelector.setSelectedIndex(0);
                    displayMinutes(0.0);
                }
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
     * Adds all the Exercises into the display frame
     * @param allExercises
     */
    public void addExercises(ArrayList<Exercise> allExercises){
        ArrayList<String> currentExercises = new ArrayList<String>();

        int ExerciseCt = exerciseSelector.getItemCount();
        int ExerciseListLength = allExercises.size();

        //gets all the current Exercises in the box
        for(int i=0; i<ExerciseCt; i++){
            currentExercises.add(exerciseSelector.getItemAt(i));
        }

        for(int i=0; i<ExerciseListLength; i++){
            if(! (currentExercises.contains( allExercises.get(i).getName()) )){
                exerciseSelector.addItem( allExercises.get(i).getName() );
            }
        }
    }

    /**
     * updates all of the frames when there is a change
     * @param observable
     * @param args
     */
    public void update(Observable observable, Object args){

        if( exerciseList != observable ) {
            return ;
        }
        //List of Exercises
        addExercises(exerciseList.getAllExercises());
    }
}