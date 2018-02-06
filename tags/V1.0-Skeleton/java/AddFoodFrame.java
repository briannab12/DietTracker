import java.swing.*;
import java.util.*;

/**
 * Class that generates  for foods/recipes
 *
 * @author TeamA
 * @version 1.0
 */
public class AddFoodFrame extends JFrame implements Observer, Frame{
    UserLogManager userManager;

    /**
     * Constructor for JFrame to add more foods/recipes
     */
    public AddFoodFrame(UserLogManager _userManager){
        userManager = _userManager;
    }

    /**
     * Displays this interface
     */
    public void display(){

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
     * @return a JTextFeild object
     */
    public JTextField textField(){
        JTextField textField = new JTextField();

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
}