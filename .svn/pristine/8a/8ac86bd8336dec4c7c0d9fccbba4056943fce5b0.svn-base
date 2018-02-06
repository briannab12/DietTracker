import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * Class that generates the landing page
 *
 * @author Team A
 * @version 1.0
 */

public class DashboardPanel extends JPanel implements Observer, Panel{

    private JPanel frame;
    private UserLog userLog;

    /**
     * Constructor for the Landing Page
     * create all of the necessary display options
     *
     */
    public DashboardPanel(UserLog userLog){
        frame = new JPanel();
        this.userLog = userLog;
    }

    /**
     * create a JTextField
     *
     * @param name the text for the label
     * @return a JTextFeild object
     */
    public JTextField createTextField( String name){
        JTextField jtfFoodName = new JTextField(name, 10);

        return jtfFoodName;
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
     * Method to set the date so that the user can interact with the log
     * on a specific date
     *
     * @param date object the date that the user wants to interact with
     */
    public void setDate(Date date)
    {

    }

    /**
     * Method to delete a food from the user log
     */
    public void delete(){

    }

    /**
     * Method to list all of the food from the user log
     *
     */
    public JTextArea listFood(){
        JTextArea foodArea = new JTextArea();
        //DEBUG date needs to be linked to selected date on gui
        String dateStr = "2016-04-20";
        Date currentDay = null;
        try {
            currentDay = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
        }catch(ParseException pe){

        }
        if(userLog.checkForEntry(currentDay)){
            DailyLogEntry dle = userLog.getLogEntry(currentDay);
            ArrayList<Food> dayFood = dle.getFood();
            foodArea.setText("Food:\n");
            for(Food foodItem : dayFood){
                foodArea.append( foodItem.getName() +"\n");
            }
        }
        else{
            foodArea.setText("No foods found");
        }

        return foodArea;
    }

    /**
     * Method to display all of the calories eaten vs the calorie limit
     */
    public JTextArea displayCalories(){
        JTextArea jtacalories = new JTextArea();
        String dateStr = "2016-04-20";
        Date currentDay = null;
        try {
            currentDay = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
        }catch(ParseException pe){

        }
        if(userLog.checkForEntry(currentDay)){
            DailyLogEntry dle = userLog.getLogEntry(currentDay);
            ArrayList<Food> dayFood = dle.getFood();
            jtacalories.setText("Calories: \n");
            for(Food foodItem : dayFood){
                jtacalories.append(String.valueOf(foodItem.getCalories()) + "\n");
            }
        }
        else{
            jtacalories.setText("No calories found");
        }

        return jtacalories;

    }

    /**
     * Method to set the calorie limit
     *
     * @param calories
     */
    public void setCalorieLimit(int calories){

    }

    /**
     * Method to submit the calorie limit to be used in the rest of the app
     *
     */
    public void submitCalorieLimit(){

    }

    /**
     * Method to display how far over or under the user is for thier calorie limit
     *
     */
    public void overUnderCalories(){

    }

    /**
     * create and display the GUI elements
     */
    public JPanel display(){
        frame.setLayout(new FlowLayout());//using no layout managers
        frame.add(listFood());
        frame.add(displayCalories());
        frame.setVisible(true);//making the frame visible
        return frame;
    }

    /**
     * create a JPanel
     *
     * @return a JPanel
     */
    public JPanel createPanel(){
        return new JPanel();
    }

    /**
     * create a JLabel with the specified text
     *
     * @param text  the text for the label
     * @return  a JLabel object
     */
    public JLabel createLabel(String text){
        return new JLabel();
    }

    /**
     * create a JTextFeild
     *
     * @return a JTextFeild object
     */
    public JTextField createTextField(){
        return new JTextField();
    }

    /**
     * create a JButton
     * @param text  the text for the button
     * @return  a JButton
     */
    public JButton createButton(String text){
        return new JButton();
    }

    public void update(Observable observable, Object args){

    }
}