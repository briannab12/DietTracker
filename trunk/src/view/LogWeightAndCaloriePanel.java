 /**
 * Creates the frame panel frontend for the weight interface.
 *@authors Team A
 *@version 3.0
 */
 
 package view ;

import controller.LogCollectionManager;
import model.ExerciseCollection;
import model.LogCollection;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogWeightAndCaloriePanel extends JPanel implements Observer, Panel{
    // attributes
    private JPanel panel;
    private JButton jbSet;
    private JButton jbCal;
    private JLabel jlPounds;
    private JTextField jtfWeight;
    private JTextField jtfCalorie;

    private LogCollection userLog;
    private ExerciseCollection exerciseList;
    LogCollectionManager ulm;


    /**
     * The Weight GUI constructor
     */
    public LogWeightAndCaloriePanel(LogCollection userLog, ExerciseCollection exerciseList)    {
        panel = new JPanel();
        this.userLog = userLog;
        this.exerciseList = exerciseList;
        ulm = new LogCollectionManager(userLog);
    }

    /**
     * Display the Jpanel for the Weight GUI
     * @return  a JPanel object
     */
    public JPanel display() {

        panel.setSize(700, 700);
        panel.setLayout(new FlowLayout());//using no layout managers

        JPanel jpane = createPanel();
        jpane.setLayout(new GridLayout(2,0));

        JPanel pane = createPanel();
        //creates the Exercise selector and the servings selector labels
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        JPanel labelPane = createPanel();
        labelPane.setLayout(new GridLayout(0, 2));
        labelPane.add(createLabel("Enter Your Weight"));
        jtfWeight = createTextField("0");
        labelPane.add(jtfWeight);
        pane.add(labelPane);
        jbSet = createButton("Set Your Weight");
        pane.add(jbSet);
        jpane.add(pane);
        panel.add(jpane);

        JPanel titlePane = createPanel();
        titlePane.setLayout(new GridLayout(1,0));
        titlePane.add(createLabel("Weight Over Time Graph"));
        panel.add(titlePane);

        panel.add( new WeightBarGraphCanvas(userLog));

        //creates the Exercise selector and the servings selector labels
        JPanel pane2 = createPanel();
        pane2.setLayout(new FlowLayout(FlowLayout.CENTER));
        JPanel jpane2 = createPanel();
        jpane2.setLayout(new GridLayout(2,0));
        pane2.setLayout(new FlowLayout(FlowLayout.CENTER));
        JPanel caloriePane = createPanel();
        caloriePane.setLayout(new GridLayout(0,2));
        caloriePane.add(createLabel("Enter your Calorie Limit"));
        jtfCalorie = createTextField("0");
        caloriePane.add(jtfCalorie);
        pane2.add(caloriePane);
        jbCal = createButton("Set Your Calorie Limit");
        pane2.add(jbCal);
        jpane2.add(pane2);

        panel.add(jpane2);

        jbSet.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                double weight;
                if(validateNumericString(jtfWeight.getText())){
                    String weightStr = jtfWeight.getText();
                    weight = Double.parseDouble(weightStr);
                    ulm.addWeight(weight);
                }
                else{
                    JOptionPane.showMessageDialog(new JFrame(), "Inputted text is not a number", "Non-Numeric Input", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                JOptionPane msgPane = new JOptionPane("You have set your weight to "+ jtfWeight.getText()+"lbs");
                JDialog msg = msgPane.createDialog(null, "Weight Set");
                msg.setLocationRelativeTo(panel);
                msg.setVisible(true);

            }
        });

        jbCal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double calorie;
                if(validateNumericString(jtfCalorie.getText())){
                    String calorieStr = jtfCalorie.getText();
                    calorie = Double.parseDouble(calorieStr);
                    ulm.setCalorieLimit(calorie);
                }
                else
                {
                    JOptionPane.showMessageDialog(new JFrame(),"Inputted text is not a number","Non-Numeric Input",JOptionPane.ERROR_MESSAGE);
                    return;
                }

                JOptionPane msgPane = new JOptionPane("Daily calorie limit set to "+ jtfCalorie.getText());
                JDialog msg = msgPane.createDialog(null, "Calorie Limit Set");
                msg.setLocationRelativeTo(panel);
                msg.setVisible(true);

            }
        });

        return panel;
    } // End of Display

    /**
     * Creates a Frame to display the graph of user's weight
     * @return JFrame showing graph
     */
    public JFrame weightGraph(){
        return new JFrame();
    }

    /**
     * create a JTextFeild
     *
     * @param text the text for the label
     * @return a JTextFeild object
     */
    public JTextField createTextField(String text) {
        return new JTextField(text);
    }

    /**
     * Create a button
     * @param  name
     * @return a button
     */
    public JButton createButton(String name) {
        return new JButton(name);
    }

    /**
     * Creates a label
     * @param name
     * @return a label
     */
    public JLabel createLabel(String name){
        return new JLabel(name);
    }

    /**
     * Creates a panel to use for weight
     * @return a JPanel
     */
    public JPanel createPanel() {
        return new JPanel();
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

    public void update(Observable observable, Object args){

    }

}// end of WeightFrame
