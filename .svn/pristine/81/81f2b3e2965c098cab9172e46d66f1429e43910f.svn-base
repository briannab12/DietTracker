import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Class that generates the JFrame for foods/recipes
 *
 * @author TeamA
 * @version 1.0
 */
public class FoodFrame extends JFrame implements Observer, Frame{
    private FoodList foodList;
    private JFrame frame;

    /**
     * Constructor for JFrame to add more foods/recipes
     */
    public FoodFrame(FoodList foodList){
        this.foodList = foodList;
        frame = new JFrame();
        this.foodList.addObserver(this);
        //List of foods
        buildFoodList(foodList.getAllFoods());
    }

    /**
     * Displays this interface
     */
    public void display(){
        frame.setSize(700, 700);
        //making the frame visible
        frame.setVisible(true);
    }

    /**
     * Creates the food object
     */
    public void createFood(){

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
     * Creates the JPanel to add basic foods
     * @return the JPanel to add basic foods
     */
    public JPanel createPanel(){
        JPanel basicFoodPanel = new JPanel();

        return basicFoodPanel;
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
        JTextField jtfFoodName = new JTextField(name);

        return jtfFoodName;
    }

    /**
     * create a button to submit foods
     *
     * @param text  the button text
     * @return JButton
     */
    public JButton createButton(String text){
        JButton submitBtn = new JButton();

        return submitBtn;
    }

    /**
     * Creates a panel for all of the foods
     * @return foodListPane A JPanel that contains a list of all foods and servings field for each
     */
    public void buildFoodList(ArrayList<Food> tempList){
        // Create Panel to display list of foods
        JPanel foodListPane = new JPanel();

        //List of foods
        ArrayList<Food> fList;
        fList = tempList;
        // Creates a textfield for each food object to be displayed
        for( Food foodObj: fList){
            JLabel food = createLabel(foodObj.toString());

            // Add textField to Panel
            foodListPane.add(food);
        } // end of for
        frame.add(foodListPane);
    }

    public JTextField createTextField(){
        return new JTextField();
    }

    public void update(Observable observable, Object args){

        if( foodList != observable ) {
            return ;
        }
        //List of foods
        buildFoodList(foodList.getAllFoods());
    }
}