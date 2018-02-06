import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;

import static java.awt.FlowLayout.CENTER;

/**
 * Class that generates  for foods/recipes
 *
 * @author TeamA
 * @version 1.0
 */
public class AddFoodPanel extends JPanel implements Observer, Panel{
    private FoodList foodList;
    private UserLog userLog;
    private JPanel frame;
    private JButton submitBtn;
    private JButton addIngredientBtn;
    private JButton submitRecipeBtn;
    private ArrayList<JComboBox<String>> foodSelectors = new ArrayList<JComboBox<String>>();
    private JTextField calories;
    private JTextField fat;
    private JTextField carbs;
    private JTextField protein;
    private JTextField foodName;
    private JTextField recipeName;

    /**
     * Constructor for JPanel to add more foods/recipes
     */
    public AddFoodPanel(FoodList foodList, UserLog userLog){
        this.foodList = foodList;
        this.userLog = userLog;
        frame = new JPanel();
    }

    /**
     * Displays this interface
     */
    public JPanel display(){

        frame.setSize(700, 700);
        frame.setLayout(new GridLayout(0,1));//using no layout managers

        //Panel to add basic food
        JPanel foodPane = createPanel();
        JPanel pane = createPanel();
        //creates the text field for entering foodname
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane.add(createLabel("Food Name: "));
        foodName = createTextField("New Food");
        pane.add(foodName);
        foodPane.add(pane);

        pane = createPanel();
        //creates the label and text field for calories
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane.add(createLabel("Calories (per Serving): "));
        calories = createTextField("0");
        pane.add(calories);
        foodPane.add(pane);

        pane = createPanel();
        //creates the label and text field for fat
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane.add(createLabel("Fat (per Serving): "));
        fat = createTextField("0");
        pane.add(fat);
        foodPane.add(pane);

        pane = createPanel();
        //creates the label and text field for carbs
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane.add(createLabel("Carbs (per Serving): "));
        carbs = createTextField("0");
        pane.add(carbs);
        foodPane.add(pane);

        pane = createPanel();
        //creates the label and text field for proteins
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane.add(createLabel("Proteins (per Serving): "));
        protein = createTextField("0");
        pane.add(protein);
        foodPane.add(pane);

        pane = createPanel();
        //creates the food submit button
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        submitBtn = createButton("Create Food");
        pane.add(submitBtn);
        foodPane.add(pane);

        //Panel to add recipe
        JPanel recipePane = createPanel();
        recipePane.setLayout(new GridLayout(0,1));

        //ingredients panel
        JPanel ingrediantPane = createPanel();
        pane = createPanel();
        //creates the text field for entering the recipe name
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane.add(createLabel("Recipe Name: "));
        recipeName = createTextField("New Food");
        pane.add(recipeName);
        ingrediantPane.add(pane);

        pane = createPanel();
        //creates the food selector
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane.add(createLabel("Ingredient 1"));
        pane.add(createFoodSelector());
        addIngredientBtn = createButton("Add Ingredient");
        pane.add(addIngredientBtn);
        ingrediantPane.add(pane);

        //submit panel
        JPanel submitPane = createPanel();
        pane = createPanel();
        //creates the recipe submit button
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        submitRecipeBtn = createButton("Create Recipe");
        pane.add(submitRecipeBtn);
        submitPane.add(pane);

        recipePane.add(ingrediantPane);
        recipePane.add(submitPane);

        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Create Food", foodPane);
        tabbedPane.addTab("Create Recipe", recipePane);
        frame.add(tabbedPane);

        /*for(JComboBox<String> selector : foodSelectors){
            selector.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent ie) {
                    JComboBox<String> comboBox = (JComboBox<String>) ie.getSource();
                    String selected = (String) comboBox.getSelectedItem();
                    if (selected.equals("--Select Food--")) {

                    } else {
                        foodList.getFood(selected);
                        addNextSelector(ingrediantPane);
                    }
                }
            });
        }
        */
        addIngredientBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNextSelector(ingrediantPane);
            }
        });

        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                FoodListManager foodManager = new FoodListManager(foodList);
                double cals = Double.parseDouble(calories.getText());
                double fats = Double.parseDouble(fat.getText());
                double carb = Double.parseDouble(carbs.getText());
                double prot = Double.parseDouble(protein.getText());
                foodManager.createBasic(foodName.getText(), cals, fats, carb, prot);
            }
        });

        return frame;
    }

    int ingrediantCt = 1;
    public void addNextSelector(JPanel ingrediantPane){
        JPanel pane = createPanel();
        //creates the food selector
        ingrediantCt++;
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane.add(createLabel("Ingrediant "+ingrediantCt));
        pane.add(createFoodSelector());
        ingrediantPane.add(pane);
    }

    /**
     * create a JComboBox with the all foods and recipes
     *
     * @return  a JComboBox object
     */
    public JComboBox createFoodSelector(){
        JComboBox<String> foodSelector = new JComboBox<String>();
        ArrayList<Food> allFoods= foodList.getAllFoods();
        foodSelector.addItem("--Select Food--");
        for(Food food : allFoods){
            foodSelector.addItem(food.getName());
        }
        foodSelectors.add(foodSelector);
        return foodSelector;
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