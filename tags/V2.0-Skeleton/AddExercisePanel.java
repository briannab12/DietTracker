import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;

import static java.awt.FlowLayout.CENTER;

/**
 * Class that generates  for exercises/recipes
 *
 * @author TeamA
 * @version 1.0
 */
public class AddExercisePanel extends JPanel implements Observer, Panel{
    private ExerciseList exerciseList;
    private UserLog userLog;
    private JPanel frame;
    private JButton submitBtn;
    private ArrayList<JComboBox<String>> exerciseSelectors = new ArrayList<JComboBox<String>>();
    private JTextField calories;
    private JTextField exerciseName;

    /**
     * Constructor for JPanel to add more exercises/recipes
     */
    public AddExercisePanel(ExerciseList exerciseList, UserLog userLog){
        this.exerciseList = exerciseList;
        this.userLog = userLog;
        frame = new JPanel();
    }

    /**
     * Displays this interface
     */
    public JPanel display(){

        frame.setSize(700, 700);
        frame.setLayout(new GridLayout(0,1));//using no layout managers

        //Panel to create exercise
        JPanel pane = createPanel();
        //creates the text field for entering exercise name
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane.add(createLabel("Exercise Name: "));
        exerciseName = createTextField("New Exercise");
        pane.add(exerciseName);
        frame.add(pane);

        pane = createPanel();
        //creates the label and text field for calories
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane.add(createLabel("Calories (1hr for 100lbs): "));
        calories = createTextField("0");
        pane.add(calories);
        frame.add(pane);

        //submit panel
        pane = createPanel();
        //creates the exercise submit button
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        submitBtn = createButton("Create Exercise");
        pane.add(submitBtn);
        frame.add(pane);

        for(JComboBox<String> selector : exerciseSelectors){
            selector.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent ie) {
                    JComboBox<String> comboBox = (JComboBox<String>) ie.getSource();
                    String selected = (String) comboBox.getSelectedItem();
                    if (selected.equals("--Select Exercise--")) {

                    } else {
                        exerciseList.getExercise(selected);
                    }
                }
            });
        }

        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ExerciseListManager exerciseManager = new ExerciseListManager(exerciseList);
                double cals = Double.parseDouble(calories.getText());
                exerciseManager.createExercise(exerciseName.getText(), cals);
            }
        });

        return frame;
    }

    /**
     * create a JComboBox with the all exercises
     *
     * @return  a JComboBox object
     */
    public JComboBox createExerciseSelector(){
        JComboBox<String> exerciseSelector = new JComboBox<String>();
        ArrayList<Exercise> allExercises= exerciseList.getAllExercises();
        exerciseSelector.addItem("--Select Exercise--");
        for(Exercise exercise : allExercises){
            exerciseSelector.addItem(exercise.getName());
        }
        exerciseSelectors.add(exerciseSelector);
        return exerciseSelector;
    }

    /**
     * create a JLabel with the specified text
     *
     * @param text  the text for the label
     * @return  a JLabel object
     */
    public JLabel createLabel(String text){
        JLabel jlLabel = new JLabel(text);

        return jlLabel;
    }

    /**
     * create a JPanel
     *
     * @return a JPanel
     */
    public JPanel createPanel(){
        JPanel jPane = new JPanel();

        return jPane;
    }

    /**
     * create a JTextField
     *
     * @param text the text for the label
     * @return a JTextFeild object
     */
    public JTextField createTextField(String text){
        JTextField textField = new JTextField(text, 10);

        return textField;
    }

    /**
     * create a JButton
     * @param text  the text for the button
     * @return  a JButton
     */
    public JButton createButton(String text){
        JButton button = new JButton(text);

        return button;
    }

    public JTextField createTextField(){
        return new JTextField();
    }

    public void update(Observable observable, Object args){

    }
}