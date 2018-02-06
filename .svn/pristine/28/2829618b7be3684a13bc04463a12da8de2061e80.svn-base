 
/**
 * Class that generates the JFrame for foods/recipes
 *@authors Team A
 *@version 3.0
 */
 
package view ;
 
import controller.FoodCollectionManager;
import controller.LogCollectionManager;
import model.DailyLogEntry;
import model.Food;
import model.FoodCollection;
import model.LogCollection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;
import java.util.Date;

public class LogFoodPanel extends JPanel implements Observer, Panel{
    private FoodCollection foodList;
    private LogCollection userLog;
    private JTabbedPane tabs;
    private FoodCollectionManager foodManager = new FoodCollectionManager(foodList);
    private JComboBox<String> foodSelector = new JComboBox<String>();
    private JComboBox<String> deleteSelector = new JComboBox<String>();
    private JButton submitBtn;

    private JTextField calories;
    private JTextField fat;
    private JTextField carbs;
    private JTextField protein;
    private JTextField servings;

    private JTextField caloriesDel;
    private JTextField fatDel;
    private JTextField carbsDel;
    private JTextField proteinDel;
    private JTextField servingsDel;

    /**
     * Constructor for JFrame to add more foods/recipes
     */
    public LogFoodPanel(FoodCollection foodList, LogCollection userLog){
        this.foodList = foodList;
        this.userLog = userLog;

        tabs = new JTabbedPane();
        this.foodList.addObserver(this);
        this.userLog.addObserver(this);
    }

    /**
     * Displays this interface
     */
    public JPanel display(){
        JPanel frame = new JPanel();
        tabs.add("Add Food", buildFoodPanel());
        tabs.add("Delete Food", buildDeletePanel());
        frame.setLayout(new GridLayout(0,1));//using no layout managers

        frame.setSize(700, 700);
        frame.add(tabs);
        return frame;
    }

    public JPanel buildFoodPanel(){
        JPanel frame = createPanel();
        JPanel pane = createPanel();
        //creates the food selector and the servings selector labels
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        JPanel labelPane = createPanel();
        labelPane.setLayout(new GridLayout(0, 2));
        labelPane.add(createLabel("Select Food"));
        labelPane.add(createLabel("Servings"));
        labelPane.add(createFoodSelector());
        servings = createTextField("1");
        labelPane.add(servings);
        pane.add(labelPane);
        frame.add(pane);

        pane = createPanel();
        //creates the label and text field for calories
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane.add(createLabel("Calories (per Serving): "));
        calories = createUneditableTextField("0");
        pane.add(calories);
        frame.add(pane);

        pane = createPanel();
        //creates the label and text field for fat
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane.add(createLabel("Fat (per Serving): "));
        fat = createUneditableTextField("0");
        pane.add(fat);
        frame.add(pane);

        pane = createPanel();
        //creates the label and text field for carbs
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane.add(createLabel("Carbs (per Serving): "));
        carbs = createUneditableTextField("0");
        pane.add(carbs);
        frame.add(pane);

        pane = createPanel();
        //creates the label and text field for proteins
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane.add(createLabel("Proteins (per Serving): "));
        protein = createUneditableTextField("0");
        pane.add(protein);
        frame.add(pane);

        pane = createPanel();
        //creates the label and text field for proteins
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        submitBtn = createButton("Add Food to Log");
        pane.add(submitBtn);
        frame.add(pane);

        foodSelector.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                JComboBox<String> comboBox = (JComboBox<String>) ie.getSource();
                String selected = (String) comboBox.getSelectedItem();
                if (selected.equals("--Select Food--")) {
                    displayCalories(0.0);
                    displayFat(0.0);
                    displayCarbs(0.0);
                    displayProtein(0.0);
                } else {
                    displayCalories(foodList.getFood(selected).getCalories());
                    displayFat(foodList.getFood(selected).getFat());
                    displayCarbs(foodList.getFood(selected).getCarbs());
                    displayProtein(foodList.getFood(selected).getProtein());
                }
            }
        });

        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String selected = (String) foodSelector.getSelectedItem();
                double servingsNum = -1;
                if(validateNumericString(servings.getText()))
                {
                    String servStr = servings.getText();
                    servingsNum = Double.parseDouble(servStr);

                    LogCollectionManager ulm = new LogCollectionManager(userLog, foodList);
                    ulm.addFood(selected, servingsNum);
                }
                else{
                    JOptionPane.showMessageDialog(new JFrame(), "Inputted text is not a number", "Non-Numeric Input", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                JOptionPane msgPane = new JOptionPane("You have added "+ selected+ " to the Food Log");
                JDialog msg = msgPane.createDialog((JFrame)null, "Food Added");
                msg.setLocationRelativeTo(frame);
                msg.setVisible(true);

                displayCalories(0.0);
                displayFat(0.0);
                displayCarbs(0.0);
                displayProtein(0.0);
                displayServings(1.0);
                foodSelector.setSelectedIndex(0);
            }
        });

        return frame;
    }

    public JPanel buildDeletePanel(){
        JPanel frame = createPanel();
        JPanel pane = createPanel();
        //creates the food selector and the servings selector labels
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        JPanel labelPane = createPanel();
        labelPane.setLayout(new GridLayout(0, 2));
        labelPane.add(createLabel("Select Food"));
        labelPane.add(createLabel("Servings"));
        labelPane.add(createDeleteSelector());
        servingsDel = createUneditableTextField("1");
        labelPane.add(servingsDel);
        pane.add(labelPane);
        frame.add(pane);

        pane = createPanel();
        //creates the label and text field for calories
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane.add(createLabel("Calories (per Serving): "));
        caloriesDel = createUneditableTextField("0");
        pane.add(caloriesDel);
        frame.add(pane);

        pane = createPanel();
        //creates the label and text field for fat
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane.add(createLabel("Fat (per Serving): "));
        fatDel = createUneditableTextField("0");
        pane.add(fatDel);
        frame.add(pane);

        pane = createPanel();
        //creates the label and text field for carbs
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane.add(createLabel("Carbs (per Serving): "));
        carbsDel = createUneditableTextField("0");
        pane.add(carbsDel);
        frame.add(pane);

        pane = createPanel();
        //creates the label and text field for proteins
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane.add(createLabel("Proteins (per Serving): "));
        proteinDel = createUneditableTextField("0");
        pane.add(proteinDel);
        frame.add(pane);

        pane = createPanel();
        //creates the label and text field for proteins
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        submitBtn = createButton("Delete Food from Log");
        pane.add(submitBtn);
        frame.add(pane);

        deleteSelector.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                String picked = (String) deleteSelector.getSelectedItem();
                String[] pickedSplit = picked.split(":");
                String selected = pickedSplit[0];
                if (selected.equals("--Select Food--")) {
                    displayServingsDel(0.0);
                    displayCaloriesDel(0.0);
                    displayFatDel(0.0);
                    displayCarbsDel(0.0);
                    displayProteinDel(0.0);

                } else {
                    double serv = Double.parseDouble(pickedSplit[1]);
                    Date currentDay = userLog.getDateObj();
                    if(userLog.checkForEntry(currentDay)){
                        DailyLogEntry dle = userLog.getLogEntry(currentDay);
                        ArrayList<Food> dayFood = dle.getFood();
                        for(Food foodItem : dayFood){
                            if(foodItem.getName().equals(foodList.getFood(selected).getName())){
                                displayServingsDel(serv);
                            }
                        }
                    }
                    displayCaloriesDel(foodList.getFood(selected).getCalories());
                    displayFatDel(foodList.getFood(selected).getFat());
                    displayCarbsDel(foodList.getFood(selected).getCarbs());
                    displayProteinDel(foodList.getFood(selected).getProtein());
                }
            }
        });

        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String picked = (String) deleteSelector.getSelectedItem();
                String[] pickedSplit = picked.split(":");
                String selected = pickedSplit[0];
                if(selected.equals("--Select Food--"))
                {

                }
                else {
                    double serv = Double.parseDouble(pickedSplit[1]);
                    if (validateNumericString(servings.getText())) {

                        LogCollectionManager ulm = new LogCollectionManager(userLog, foodList);
                        ulm.deleteFood(selected, serv);
                    } else {
                        JOptionPane.showMessageDialog(new JFrame(), "Inputted text is not a number", "Non-Numeric Input", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                JOptionPane msgPane = new JOptionPane("You have removed "+ selected+ " from your Food Log");
                JDialog msg = msgPane.createDialog((JFrame)null, "Food Removed");
                msg.setLocationRelativeTo(frame);
                msg.setVisible(true);

                displayCaloriesDel(0.0);
                displayFatDel(0.0);
                displayCarbsDel(0.0);
                displayProteinDel(0.0);
                displayServingsDel(1.0);
                deleteSelector.setSelectedIndex(0);
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
     * display fat
     * @param fat
     */
    public void displayFat(double fat) {
        this.fat.setText(""+fat);
    }

    /**
     * display carbs
     * @param carbs
     */
    public void displayCarbs(double carbs){
        this.carbs.setText(""+carbs);
    }

    /**
     * display Protein
     * @param protein
     */
    public void displayProtein(double protein){
        this.protein.setText(""+protein);
    }

    /**
     * display Servings
     * @param serving
     */
    public void displayServings(double serving){
        this.servings.setText(""+serving);
    }

    /**
     * display the calories
     * @param calories
     */
    public void displayCaloriesDel(double calories){
        this.caloriesDel.setText(""+calories);
    }

    /**
     * display fat
     * @param fat
     */
    public void displayFatDel(double fat) {
        this.fatDel.setText(""+fat);
    }

    /**
     * display carbs
     * @param carbs
     */
    public void displayCarbsDel(double carbs){
        this.carbsDel.setText(""+carbs);
    }

    /**
     * display Protein
     * @param protein
     */
    public void displayProteinDel(double protein){
        this.proteinDel.setText(""+protein);
    }

    /**
     * display Servings
     * @param serving
     */
    public void displayServingsDel(double serving){
        this.servingsDel.setText(""+serving);
    }

    /**
     * create a JComboBox with the all foods and recipes
     *
     * @return  a JComboBox object
     */
    public JComboBox createFoodSelector(){
        ArrayList<Food> allFoods= foodList.getAllFoods();
        foodSelector.addItem("--Select Food--");
        for(Food food : allFoods){
            foodSelector.addItem(food.getName());
        }
        return foodSelector;
    }

    /**
     * create a JComboBox with the all foods and recipes on the selected date
     *
     * @return  a JComboBox object
     */
    public JComboBox createDeleteSelector() {
        LogCollectionManager ulm = new LogCollectionManager(userLog, foodList);
        ArrayList<Food> loggedFoods = ulm.getFoodOnDay(userLog.getDateObj());

        deleteSelector.addItem("--Select Food--");
        if (!loggedFoods.isEmpty()){
            for (Food food : loggedFoods) {
                deleteSelector.addItem(food.getName()+":"+food.getServings());
            }
        }
        return deleteSelector;
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
     * create a button to submit foods
     *
     * @param text  the button text
     * @return JButton
     */
    public JButton createButton(String text){
        JButton submitBtn = new JButton(text);

        return submitBtn;
    }

    /**
     * Updates the food selector for deletions and addition
     * @param allFoods
     */
    public void updateFoodSelector(ArrayList<Food> allFoods){
        int ct = foodSelector.getItemCount();
        foodSelector.addItem("--Select Food--");
        foodSelector.setSelectedIndex(ct);

        for(int i =0; i<ct; i++) {
            foodSelector.removeItemAt(0);
        }

        if (!allFoods.isEmpty()){
            for (Food food : allFoods) {
                foodSelector.addItem(food.getName());
            }
        }
    }

    /**
     * Updates the delete selector for each day when any changes are made
     */
    public void updateDeleteSelector(){
        int ct = deleteSelector.getItemCount();
        deleteSelector.addItem("--Select Food--");
        deleteSelector.setSelectedIndex(ct);

        for(int i=0; i<ct; i++) {
            deleteSelector.removeItemAt(0);
        }

        LogCollectionManager ulm = new LogCollectionManager(userLog, foodList);
        ArrayList<Food> loggedFood = ulm.getFoodOnDay(userLog.getDateObj());
        try
        {
            if (!loggedFood.isEmpty()){
                for (Food food : loggedFood) {
                    deleteSelector.addItem(food.getName()+":"+food.getServings());
                }
            }
        }
        catch(NullPointerException npe){
            int count = deleteSelector.getItemCount();
            for(int i = 1; i<count; i++) {
                deleteSelector.removeItemAt(1);
            }
        }
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


    /**
     * updates all of the frames when there is a change
     * @param observable
     * @param args
     */
    public void update(Observable observable, Object args){
        //List of foods
        if(observable == foodList) {
            updateFoodSelector(foodList.getAllFoods());
        }
        if(observable == userLog){
            updateDeleteSelector();
            updateFoodSelector(foodList.getAllFoods());
        }
    }
}