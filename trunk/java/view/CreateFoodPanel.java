/**
 * Class that generates  for foods/recipes
 *
 * @author TeamA
 * @version 3.0
 */
 
 package view;

import controller.FoodCollectionManager;
import model.Food;
import model.FoodCollection;
import model.LogCollection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


public class CreateFoodPanel extends JPanel implements Observer, Panel{
    private FoodCollection foodList;
    private LogCollection userLog;
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

    FoodCollectionManager foodManager;

    /**
     * Constructor for JPanel to add more foods/recipes
     */
    public CreateFoodPanel(FoodCollection foodList, LogCollection userLog){
        this.foodList = foodList;
        this.userLog = userLog;
        frame = new JPanel();
        foodManager = new FoodCollectionManager(foodList);
    }

    /**
     * Displays this interface
     * @return  a JPanel object
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
        ingrediantPane.add(pane);

        //submit panel
        JPanel submitPane = createPanel();
        pane = createPanel();
        //creates the recipe submit button
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        addIngredientBtn = createButton("Add Ingredient");
        pane.add(addIngredientBtn);
        submitRecipeBtn = createButton("Create Recipe");
        pane.add(submitRecipeBtn);
        submitPane.add(pane);

        recipePane.add(ingrediantPane);
        recipePane.add(submitPane);

        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Create Food", foodPane);
        tabbedPane.addTab("Create Recipe", recipePane);
        frame.add(tabbedPane);
        addIngredientBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNextSelector(ingrediantPane);
            }
        });

        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                double fats = -1.0;
                double carb = -1.0;
                double prot = -1.0;
                double cals = -1.0;

                if(validateNumericString(calories.getText()) && validateNumericString(fat.getText()) && validateNumericString(carbs.getText()) && validateNumericString(protein.getText())){
                    cals = Double.parseDouble(calories.getText());
                    fats = Double.parseDouble(fat.getText());
                    carb = Double.parseDouble(carbs.getText());
                    prot = Double.parseDouble(protein.getText());
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Inputted text is not a number", "Non-Numeric Input", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String foodNameStr = null;

                if(!foodName.getText().equals("New Food")){
                    foodNameStr = foodName.getText();
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Please input a name for the new food", "Invalid Name", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                foodManager.createBasic(foodNameStr, cals, fats, carb, prot);
                JOptionPane msgPane = new JOptionPane("You have added "+foodName.getText()+" With the following \n "+"Calories: "+calories.getText()+" Fat: "+fat.getText()+ " Carbs: "+carbs.getText()+" Protein: "+protein.getText());
                JDialog msg = msgPane.createDialog((JFrame)null, "Message");
                msg.setLocationRelativeTo(frame);
                msg.setVisible(true);

            }
        });

        submitRecipeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Food> recipe = new ArrayList<>();

                if( (recipeName.getText().equals("New Food")) || (recipeName.getText().equals("")) )
                {
                    JOptionPane.showMessageDialog( new JFrame(), "Please input a name for the new recipe", "Invalid Name", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String selected;
                for(JComboBox<String> food: foodSelectors)
                {
                    selected = food.getSelectedItem().toString();
                    if(!selected.equals("Add Ingredient"))
                    {
                        recipe.add(foodManager.getFood(selected));
                    }

                }

                if(recipe.size()<= 1)
                {
                    JOptionPane.showMessageDialog(new JFrame(), "Please submit a valid recipe", "Invalid Recipe",JOptionPane.ERROR_MESSAGE);
                    return;
                }

                foodManager.createRecipe(recipeName.getText(),recipe);

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
        pane.add(createLabel("Ingredient "+ingrediantCt));
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
}