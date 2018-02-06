import javax.swing.*;
import java.util.*;

/**
 * Class that generates  for foods/recipes
 *
 * @author TeamA
 * @version 1.0
 */
public class AddFoodFrame extends JFrame implements Observer, Frame{
    private FoodList foodList;
    private UserLog userLog;
    private JFrame frame;

    /**
     * Constructor for JFrame to add more foods/recipes
     */
    public AddFoodFrame(FoodList foodList, UserLog userLog){
        this.foodList = foodList;
        this.userLog = userLog;
        frame = new JFrame();
    }

    /**
     * Displays this interface
     */
    public void display(){
        frame.setLayout(null);//using no layout managers
        frame.setVisible(true);//making the frame visible
    }

    /**
     * Adds the food object to the user log
     */
    public void addFood(){

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
     * create a JTextFeild
     *
     * @param text the text for the label
     * @return a JTextFeild object
     */
    public JTextField createTextField(String text){
        JTextField textField = new JTextField(text);

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