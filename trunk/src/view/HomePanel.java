/**
 * Class that generates the landing page for all users.
 *
 * @author Team A
 * @version 3.0
 */
 
 package view;
 
 import controller.LogCollectionManager;
 import model.DailyLogEntry;
 import model.Exercise;
 import model.Food;
 import model.LogCollection;

 import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class HomePanel extends JPanel implements Observer, Panel{

    private JPanel frame;
    private JComboBox<String> dateSelector = new JComboBox<>();
    private LogCollection userLog;
    private LogCollectionManager logManager;
    private JTextArea foodArea = null;
    private JTextArea foodCalArea = null;
    private JTextArea exArea = null;
    private JTextArea exCalArea = null;
    private JTextArea foodProteins = null;
    private JTextArea foodCarbs = null;
    private JTextArea foodFats = null;
    private JTextArea foodServings = null;
    private JTextArea netConsumedCal = null;
    private JTextArea exMin = null;
    private JPanel daysWork = null;
    private JLabel netCaloriesConsumed;
    private JLabel calorieLimit;
    private JLabel caloriesDay;
    private JLabel caloriesBurn;
    private JLabel weightlabel;

    private JPanel datePane = createPanel();

    /**
     * Constructor for the Landing Page
     * create all of the necessary display options
     *
     */
    public HomePanel(LogCollection userLog){
        frame = new JPanel();
        this.userLog = userLog;
        userLog.addObserver(this);
        logManager = new LogCollectionManager(this.userLog);
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
        //JTextArea servingArea = new JTextArea();
        //DEBUG date needs to be linked to selected date on gui
        Date currentDay = userLog.getDateObj();
        if(userLog.checkForEntry(currentDay)){
            ArrayList<Food> dayFood = logManager.getFoodOnDay(currentDay);
            foodArea.setText("Food: \n");
            for(Food foodItem : dayFood){
                foodArea.append( foodItem.getName() +"\n");
            }
        }
        else{
            foodArea.setText("Food: \n");
        }

        return foodArea;
    }

    /**
     * Method to list all of the exercise from the exercise log
     *
     */
    public JTextArea listExercises(){
        JTextArea exerciseArea = new JTextArea();
        //DEBUG date needs to be linked to selected date on gui
        Date currentDay = userLog.getDateObj();

        if(userLog.checkForEntry(currentDay)){
            ArrayList<Exercise> dayExercise = logManager.getExerciseOnDay(currentDay);
            exerciseArea.setText("Exercise:\n");
            for(Exercise exercise : dayExercise){
                exerciseArea.append( exercise.getName() +"\n");
            }
        }
        else{
            exerciseArea.setText("Exercise:\n");
        }

        return exerciseArea;

    }

    /**
     * Method to display all of the calories eaten vs the calorie limit
     */
    public JTextArea displayCalories(){
        JTextArea jtacalories = new JTextArea();
        Date currentDay = userLog.getDateObj();
        if(userLog.checkForEntry(currentDay)){
            ArrayList<Food> dayFood = logManager.getFoodOnDay(currentDay);
            jtacalories.setText("Calories: \n");
            for(Food foodItem : dayFood){
                jtacalories.append(String.valueOf(foodItem.getCalories() *foodItem.getServings()) + "\n");
            }
        }
        else{
            jtacalories.setText("Calories: \n");
        }

        return jtacalories;

    }
    /**
     * Method to display all of the calories eaten vs the calorie limit
     */
    public JTextArea displayBurnedCalories(){
        JTextArea jtaCalories = new JTextArea();
        Date currentDay = userLog.getDateObj();
        if(userLog.checkForEntry(currentDay)){
            ArrayList<Exercise> dayExercise = logManager.getExerciseOnDay(currentDay);
            jtaCalories.setText("Calories Burned: \n");
            for(Exercise exercise : dayExercise){
                exercise.setCaloriesBurned(userLog.getCurrentWeight());
                jtaCalories.append(String.valueOf(exercise.getCaloriesBurned()) + "\n");
            }
        }
        else{
            jtaCalories.setText("Calories Burned: \n");
        }

        return jtaCalories;

    }
    /**
     * Method to display all of the calories eaten vs the calorie limit
     */
    public JTextArea displayTimeExercised(){
        JTextArea jtaCalories = new JTextArea();
        Date currentDay = userLog.getDateObj();
        if(userLog.checkForEntry(currentDay)){
            ArrayList<Exercise> dayExercise = logManager.getExerciseOnDay(currentDay);
            jtaCalories.setText("Time (min): \n");
            for(Exercise exercise : dayExercise){
                jtaCalories.append(String.valueOf(exercise.getTime()) + "\n");
            }
        }
        else{
            jtaCalories.setText("Time (min): \n");
        }

        return jtaCalories;

    }
    /**
     * Method to display all of the protein eaten
     */
    public JTextArea getFoodProteins(){
        JTextArea jtaprotien = new JTextArea();
        Date currentDay = userLog.getDateObj();
        if(userLog.checkForEntry(currentDay)){
            ArrayList<Food> dayFood = logManager.getFoodOnDay(currentDay);
            jtaprotien.setText("Protein: \n");
            for(Food foodItem : dayFood){
                jtaprotien.append(String.valueOf(foodItem.getProtein()*foodItem.getServings()) + "\n");
            }
        }
        else{
            jtaprotien.setText("Protein: \n");
        }

        return jtaprotien;

    }

    /**
     * Method to display all of the carbs eaten
     */
    public JTextArea getFoodCarbs(){
        JTextArea jtacarbs = new JTextArea();
        Date currentDay = userLog.getDateObj();
        if(userLog.checkForEntry(currentDay)){
            ArrayList<Food> dayFood = logManager.getFoodOnDay(currentDay);
            jtacarbs.setText("Carbs: \n");
            for(Food foodItem : dayFood){
                jtacarbs.append(String.valueOf(foodItem.getCarbs() * foodItem.getServings()) + "\n");
            }
        }
        else{
            jtacarbs.setText("Carbs: \n");
        }

        return jtacarbs;

    }

    /**
     * Method to display all of the fats eaten
     */
    public JTextArea getFoodServings(){
        JTextArea jtafat = new JTextArea();
        Date currentDay = userLog.getDateObj();
        if(userLog.checkForEntry(currentDay)){
            ArrayList<Food> dayFood = logManager.getFoodOnDay(currentDay);
            jtafat.setText("Servings: \n");
            for(Food foodItem : dayFood){
                jtafat.append(String.valueOf(foodItem.getServings() + "\n"));
            }
        }
        else{
            jtafat.setText("Servings: \n");
        }

        return jtafat;

    }

    /**
     * Method to display all of the fats eaten
     */
    public JTextArea getFoodFat(){
        JTextArea jtaservings = new JTextArea();
        Date currentDay = userLog.getDateObj();
        if(userLog.checkForEntry(currentDay)){
            ArrayList<Food> dayFood = logManager.getFoodOnDay(currentDay);
            jtaservings.setText("Fats: \n");
            for(Food foodItem : dayFood){
                jtaservings.append(String.valueOf(foodItem.getFat() + "\n"));
            }
        }
        else{
            jtaservings.setText("No servings found");
        }

        return jtaservings;

    }

    public Double calNetCalories(Date currentDay)
    {
        double net;
        double burnedCalories = 0;
        ArrayList<Exercise> dayExercise = logManager.getExerciseOnDay(currentDay);
        for(Exercise exercise : dayExercise){
            exercise.setCaloriesBurned(userLog.getCurrentWeight());
            burnedCalories += exercise.getCaloriesBurned();
        }
        net = logManager.getCaloriesOnDay(currentDay) - burnedCalories;
        return net;
    }

    public JLabel getNetCalories(Date currentDay)
    {
        String netCal = String.valueOf(calNetCalories(currentDay));
        JLabel netLabel= new JLabel(netCal);
        if(overUnderCalories(currentDay)){
            netLabel.setForeground(Color.RED);
        }
        else
        {
            netLabel.setForeground(Color.GREEN);
        }

        return netLabel;

    }


    /**
     * Method to calculate. all of the calories consumed
     */
    public JTextArea getNetConsumed(){
        JTextArea jtaCC = new JTextArea();

        return jtaCC;

    }



    public JPanel daysTotal()
    {

        JPanel mainPane = new JPanel();
        mainPane.setLayout(new GridLayout(2,0));
        Date currentDay = userLog.getDateObj();
        mainPane.add(new Label("Your Overall Day: "));
        if(userLog.checkForEntry(currentDay))
        {
            JPanel daysWorkPane = new JPanel();
            daysWorkPane.setLayout(new GridLayout(0,2));
            daysWorkPane.add(new JLabel("Net Calories: "));
            netCaloriesConsumed = getNetCalories(currentDay);
            daysWorkPane.add(netCaloriesConsumed);
            daysWorkPane.add(new JLabel("Your Calorie Limit: "));
            calorieLimit = new JLabel(String.valueOf(logManager.getCalorieLimit()));
            daysWorkPane.add(calorieLimit);
            daysWorkPane.add(new JLabel("\nTotal Calories Consumed: "));
            caloriesDay = new JLabel(String.valueOf(logManager.getCaloriesOnDay(currentDay)));
            daysWorkPane.add(caloriesDay);
            daysWorkPane.add(new JLabel("\nTotal Calories Burned: "));
            double burnedCalories = 0;
            ArrayList<Exercise> dayExercise = logManager.getExerciseOnDay(currentDay);
            for(Exercise exercise : dayExercise){
                exercise.setCaloriesBurned(userLog.getCurrentWeight());
                burnedCalories += exercise.getCaloriesBurned();
            }
            caloriesBurn = new JLabel( String.valueOf(burnedCalories));
            daysWorkPane.add(caloriesBurn);
            daysWorkPane.add(new JLabel("\nYour Weight: "));
            weightlabel = new JLabel(String.valueOf(logManager.getWeight()));
            daysWorkPane.add(weightlabel);

            mainPane.add(daysWorkPane);
        }
        else{
            mainPane.add( new Label("No data found"));
        }

        return mainPane;
    }

    /**
     * Method to check if user is over or under their calorie limit
     *
     */
    public boolean overUnderCalories(Date currentDay){
        if(calNetCalories(currentDay)> logManager.getCalorieLimit())
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    /**
     * create and display the GUI elements
     */
    public JPanel display(){

        frame.setLayout(new FlowLayout());//using no layout managers
        datePane.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton prevBtn = createButton("Previous Day");
        datePane.add(prevBtn);
        datePane.add(createDateSelector());
        JButton nextBtn = createButton("Next Day");
        datePane.add(nextBtn);
        frame.add(datePane, FlowLayout.LEFT);

        prevBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userLog.prevDay();
            }
        });

        nextBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userLog.nextDay();
            }
        });

        JPanel mainPane = createPanel();
        mainPane.setLayout(new GridLayout(0,7));
        foodArea = listFood();
        foodCalArea = displayCalories();
        exArea = listExercises();
        foodProteins = getFoodProteins();
        foodCarbs = getFoodCarbs();
        foodFats = getFoodFat();
        foodServings = getFoodServings();
        netConsumedCal = getNetConsumed();
        exCalArea = displayBurnedCalories();
        exMin = displayTimeExercised();
        daysWork = daysTotal();
        mainPane.add(foodArea);
        mainPane.add(foodCalArea);
        mainPane.add(foodFats);
        mainPane.add(foodCarbs);
        mainPane.add(foodProteins);
        mainPane.add(foodServings);
        mainPane.add(netConsumedCal);
        mainPane.add(exArea);
        mainPane.add(exCalArea);
        mainPane.add(exMin);
        frame.add(mainPane);

        JPanel overallDay = new JPanel();
        overallDay.add(daysWork);
        frame.add(overallDay);

        JPanel titlePane = createPanel();
        titlePane.setLayout(new GridLayout(1,0));
        titlePane.add(createLabel("Fats Carbs Protein Graph"));
        frame.add(titlePane);

        JPanel graphPane = createPanel();
        graphPane.setLayout(new GridLayout(1,0));
        graphPane.add( new NutritionBarGraphCanvas(userLog));
        frame.add(graphPane);

        return frame;
    }

    public void updateDisplay(){

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
        return new JLabel(text);
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
        return new JButton(text);
    }

    /**
     *
     *
     * @return a JComboBox with all the log dates
     */
    public JComboBox createDateSelector()
    {
        dateSelector = new JComboBox<String>();

        HashMap<Date,DailyLogEntry> dailyLogs = userLog.getDailyLogs();
        ArrayList<DailyLogEntry> allLogs = new ArrayList<>(dailyLogs.values()); ;
        Collections.sort(allLogs);
        Collections.reverse(allLogs);

        //dateSelector.addItem("--Select a Date--");
        for(DailyLogEntry logs: allLogs )
        {
            dateSelector.addItem(logs.getDateString());
        }
        for(int i=0; i<dateSelector.getItemCount(); i++){
            if(dateSelector.getItemAt(i).equals(userLog.getDateString())){
                dateSelector.setSelectedIndex(i);
            }
        }

        dateSelector.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String selected = (String) dateSelector.getSelectedItem();
                try {
                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(selected);
                    logManager.setDate(date);

                } catch (ParseException e1) {
                    e1.printStackTrace();
                }

            }


        });

        return dateSelector;
    }

    public void rebuildDatePane(){
        frame.remove(datePane);
        datePane = createPanel();
        datePane.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton prevBtn = createButton("Previous Day");
        datePane.add(prevBtn);
        datePane.add(createDateSelector());
        JButton nextBtn = createButton("Next Day");
        datePane.add(nextBtn);
        frame.add(datePane, FlowLayout.LEFT);

        prevBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userLog.prevDay();
            }
        });

        nextBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userLog.nextDay();
            }
        });

        frame.revalidate();
        frame.repaint();
    }

    public void updateLists(){
        //gets current day
        Date currentDay = userLog.getDateObj();

        //clears all the lists
        foodArea.replaceRange("", 0, foodArea.getText().length());
        foodCalArea.replaceRange("", 0, foodCalArea.getText().length());
        exArea.replaceRange("", 0, exArea.getText().length());
        exCalArea.replaceRange("", 0, exCalArea.getText().length());
        foodCarbs.replaceRange("", 0, foodCarbs.getText().length());
        foodFats.replaceRange("",0,foodFats.getText().length());
        foodProteins.replaceRange("",0,foodProteins.getText().length());
        foodServings.replaceRange("",0,foodServings.getText().length());
        exMin.replaceRange("",0,exMin.getText().length());

        //Updates food list
        if(userLog.checkForEntry(currentDay)){
            ArrayList<Food> dayFood = logManager.getFoodOnDay(currentDay);
            foodArea.append("Food: \n");
            for(Food food : dayFood){
                foodArea.append(String.valueOf(food.getName()) + "\n");
            }
        }
        else{
            foodArea.append("No foods found");
        }

        //updates calories list
        if(userLog.checkForEntry(currentDay)){
            ArrayList<Food> dayFood = logManager.getFoodOnDay(currentDay);
            foodCalArea.append("Calories: \n");
            for(Food foodItem : dayFood){
                foodCalArea.append(String.valueOf(Math.floor(foodItem.getCalories()*foodItem.getServings() * 10) / 10) + "\n");
            }
        }
        else{
            foodCalArea.append("No calories found");
        }

        //updates proteins list
        if(userLog.checkForEntry(currentDay)){
            ArrayList<Food> dayFood = logManager.getFoodOnDay(currentDay);
            foodProteins.append("Protein: \n");
            for(Food foodItem : dayFood){
                foodProteins.append(String.valueOf(Math.floor(foodItem.getProtein()*foodItem.getServings() * 10) / 10) + "\n");
            }
        }
        else{
            foodProteins.append("No proteins found");
        }

        //updates fats list
        if(userLog.checkForEntry(currentDay)){
            ArrayList<Food> dayFood = logManager.getFoodOnDay(currentDay);
            foodFats.append("Fat: \n");
            for(Food foodItem : dayFood){
                foodFats.append(String.valueOf( Math.floor(foodItem.getFat()*foodItem.getServings() * 10) / 10) + "\n");
            }
        }
        else{
            foodFats.append("No fat found");
        }

        //updates carbs list
        if(userLog.checkForEntry(currentDay)){
            ArrayList<Food> dayFood = logManager.getFoodOnDay(currentDay);
            foodCarbs.append("Carbs: \n");
            for(Food foodItem : dayFood){
                foodCarbs.append(String.valueOf(Math.floor(foodItem.getCarbs()*foodItem.getServings() * 10) / 10) + "\n");
            }
        }
        else{
            foodCarbs.append("No carbs found");
        }

        //updates servings list
        if(userLog.checkForEntry(currentDay)){
            ArrayList<Food> dayFood = logManager.getFoodOnDay(currentDay);
            foodServings.append("Servings: \n");
            for(Food foodItem : dayFood){
                foodServings.append(String.valueOf(foodItem.getServings()) + "\n");
            }
        }
        else{
            foodServings.append("No servings found");
        }


        //updates exercise list
        if(userLog.checkForEntry(currentDay)){
            ArrayList<Exercise> dayExercise = logManager.getExerciseOnDay(currentDay);
            exArea.append("Exercise:\n");
            for(Exercise exercise : dayExercise){
                exArea.append( exercise.getName() +"\n");
            }
        }
        else{
            exArea.append("No exercises found");
        }


        //updates calories burnt list
        if(userLog.checkForEntry(currentDay)){
            ArrayList<Exercise> dayExercise = logManager.getExerciseOnDay(currentDay);
            exCalArea.append("Calories: \n");
            for(Exercise exercise : dayExercise){
                exercise.setCaloriesBurned(userLog.getCurrentWeight());
                exCalArea.append(String.valueOf(exercise.getCaloriesBurned()) + "\n");
            }
        }
        else{
            exCalArea.append("No calories found");
        }

        //updates exercise time list
        if(userLog.checkForEntry(currentDay)){
            ArrayList<Exercise> dayExercise = logManager.getExerciseOnDay(currentDay);
            exMin.append("Time (min): \n");
            for(Exercise exercise : dayExercise){
                exMin.append(String.valueOf(exercise.getTime()) + "\n");
            }
        }
        else{
            exMin.append("No times found");
        }

        //updating calorie/weight display
        double burnedCalories = 0;
        ArrayList<Exercise> dayExercise = logManager.getExerciseOnDay(currentDay);
        for(Exercise exercise : dayExercise){
            exercise.setCaloriesBurned(userLog.getCurrentWeight());
            burnedCalories += exercise.getCaloriesBurned();
        }
        netCaloriesConsumed.setText(getNetCalories(currentDay).getText());
        netCaloriesConsumed.setForeground(getNetCalories(currentDay).getForeground());
        caloriesDay.setText(logManager.getCaloriesOnDay(currentDay).toString());
        calorieLimit.setText(String.valueOf(logManager.getCalorieLimit()));
        caloriesBurn.setText(String.valueOf(burnedCalories));
        weightlabel.setText(String.valueOf(logManager.getWeight()));

    }

    public void update(Observable observable, Object args){
        rebuildDatePane();
        updateLists();
    }
}