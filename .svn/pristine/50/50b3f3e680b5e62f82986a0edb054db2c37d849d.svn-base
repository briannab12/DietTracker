import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.*;
import java.util.*;
import java.util.Date;

/**
 * Class that generates the JFrame for foods/recipes
 *
 * @author TeamA
 * @version 1.0
 */
public class FoodPanel extends JPanel implements Observer, Panel{
    private FoodList foodList;
    private UserLog userLog;
    private JPanel frame;
    private FoodListManager foodManager = new FoodListManager(foodList);
    private JComboBox<String> foodSelector = new JComboBox<String>();
    private JButton submitBtn;

    private JTextField calories;
    private JTextField fat;
    private JTextField carbs;
    private JTextField protein;
    private JTextField servings;

    /**
     * Constructor for JFrame to add more foods/recipes
     */
    public FoodPanel(FoodList foodList, UserLog userLog){
        this.foodList = foodList;
        this.userLog = userLog;
        frame = new JPanel();
        this.foodList.addObserver(this);
    }

    /**
     * Displays this interface
     */
    public JPanel display(){
        frame.setSize(700, 700);
        frame.setLayout(new GridLayout(0,1));//using no layout managers

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
                String dateStr = "2016-04-20";
                Date date = null;
                try {
                    date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
                }catch(ParseException pe){
                }
                if(userLog.checkForEntry(date)){
                    DailyLogEntry dle = userLog.getLogEntry(date);
                    dle.addFood(foodList.getFood(selected));
                    userLog.logFood(foodList.getFood(selected), date);
                    displayCalories(0.0);
                    displayFat(0.0);
                    displayCarbs(0.0);
                    displayProtein(0.0);
                    displayServings(1.0);
                    foodSelector.setSelectedIndex(0);
                }
                else {
                    userLog.createNewDailyLogEntry(date);
                    DailyLogEntry dle = userLog.getLogEntry(date);
                    dle.addFood(foodList.getFood(selected));
                    userLog.logFood(foodList.getFood(selected), date);
                    displayCalories(0.0);
                    displayFat(0.0);
                    displayCarbs(0.0);
                    displayProtein(0.0);
                    displayServings(1.0);
                    foodSelector.setSelectedIndex(0);
                }
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
     * Adds all the foods into the display frame
     * @param allFoods
     */
    public void addFoods(ArrayList<Food> allFoods){
        ArrayList<String> currentFoods = new ArrayList<String>();

        int foodCt = foodSelector.getItemCount();
        int foodListLength = allFoods.size();

        //gets all the current foods in the box
        for(int i=0; i<foodCt; i++){
            currentFoods.add(foodSelector.getItemAt(i));
        }

        for(int i=0; i<foodListLength; i++){
            if(! (currentFoods.contains( allFoods.get(i).getName()) )){
                foodSelector.addItem( allFoods.get(i).getName() );
            }
        }
    }

    /**
     * updates all of the frames when there is a change
     * @param observable
     * @param args
     */
    public void update(Observable observable, Object args){

        if( foodList != observable ) {
            return ;
        }
        //List of foods
        addFoods(foodList.getAllFoods());
    }
}