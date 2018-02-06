import java.swing.*;
import java.util.*;

/**
 * Class that generates the JFrame for foods/recipes
 *
 * @author TeamA
 * @version 1.0
 */
public class FoodFrame extends JFrame implements Observer{
    FoodListManager foodManager;

    /**
     * Constructor for JFrame to add more foods/recipes
     */
    public FoodFrame(FoodListManager _foodManager){
        foodManager = _foodManager;
    }

    /**
     * Displays this interface
     */
    public void display(){

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
     * @return basicFoodPanel The panel to add basic foods
     */
    public JPanel basicFoodPanel(){
        JPanel basicFoodPanel = new JPanel();

        return basicFoodPanel;
    }

    /**
     * Creates a jLabel
     * @return jlLabel A jLabel
     */
    public JLabel createLabel(){
        JLabel jlLabel = new JLabel();

        return jlLabel;
    }

    /**
     * Creates a text field for naming recipes/foods
     * @return jtfFoodName Text Field for naming foods
     */
    public JTextField textField(){
        JTextField jtfFoodName = new JTextField();

        return jtfFoodName;
    }

    /**
     * Creates a button to submit foods
     * @return submitBtn A submit
     */
    public JButton submitButton(){
        JButton submitBtn = new JButton();

        return submitBtn;
    }

    /**
     * Creates a panel for all of the foods
     * @return foodListPane A JPanel that contains a list of all foods and servings field for each
     */
    public JPanel buildFoodList(){
        JPanel foodListPane = new JPanel();

        ArrayList<String> foodList;
        foodList = foodManager.getAllFoods();
        JList basicFoods = new JList( foodList.toArray() );



        return foodListPane;
    }


}