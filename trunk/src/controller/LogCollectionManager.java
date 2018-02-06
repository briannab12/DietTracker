/**
 * Handles the logic of saving, updating, and deleting data from the user log when the user clicks buttons on the GUI.
 * All data is changed for the data set by the user which is defaulted to the current day.
 *
 * Add action listner to button in a different class
 * https://stackoverflow.com/questions/4985507/action-listener-in-another-class-java
 *
 * https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/uiswing/examples/events/BeeperProject/src/events/Beeper.java
 *@authors Team A
 *@version 3.0
 */
 
 package controller ;

import model.*;

import java.util.*;
import java.awt.event.*;

public class LogCollectionManager implements ActionListener{

    // the object for storing and updating data about the user
    private LogCollection userLog;
    private FoodCollection foodList;


    /**
     * Defulat constructor
     * Initializes the UserLog
     */
    public LogCollectionManager(LogCollection userLog)
    {
        // create a new UserLog object
        this.userLog = userLog;
    }

    /**
    * Defulat constructor
    * Initializes the UserLog
    */
    public LogCollectionManager(LogCollection userLog, FoodCollection foodList)
    {
        // create a new UserLog object
        this.userLog = userLog;
        this.foodList = foodList;
    }

    public void createNewDailyLog(Date date){
        userLog.createNewDailyLogEntry(date);
    }

    /**
    * Get the date the user has selected to log data
    *
    * @return The date the user has selected to log data
    */
    public String getDate()
    {
        return "";
    }

    /**
     * Get the date the user has selected to log data
     *
     * @param date    The date the user has selected to log data
     */
    public void setDate(Date date)
    {
        userLog.setDate(date);
    }

    public void prevDay()
    {
        userLog.prevDay();
    }

    public void nextDay()
    {
        userLog.nextDay();
    }

    /**
     * Get the user's weight. The weight is:
     * 1. that explicitly given for the date, if any, otherwise
     * 2. that given for the most recent earlier date in the log, if any, otherwise
     * 3. 150.0
     *
     * @return  The user's weight
     */
    public double getWeight()
    {
        return userLog.getWeight();
    }

    /**
     * Set the users weight
     * @param weight    The user's weight
     */
    public void setWeight(double weight)
    {
        // set the users weight in UserLog
    }

    /**
     * Get the user's calorie limit. The calorie limit is:
     * 1. that explicitly given for the date, if any, otherwise
     * 2. that given for the most recent earlier date in the log, if any, otherwise
     * 3. 2000.0
     *
     * @return  The user's calorie limit
     */
    public double getCalorieLimit()
    {
        return userLog.getCurrentCalorieLimit();
    }

    /**
     * Set the user's calorie limit
     *
     * @param calorieIntake
     */
    public void setCalorieLimit(double calorieIntake)
    {
        userLog.setCalorieLimit(calorieIntake);
        userLog.logCalories(calorieIntake);
    }


    /**
     * Calculate and return the percent fat of food intake for a day
     * @return  the percent fat of food intake for a day
     */
    public double getPercentFat()
    {
        return 0;
    }

    /**
     * Calculate and return the percent carbs of food intake for a day
     * @return  the percent carbs of food intake for a day
     */
    public double getPercentCarb()
    {
        return 0;
    }

    /**
     * Calculate and return the percent protein of food intake for a day
     * @return  the percent protein of food intake for a day
     */
    public double getPercentProtein()
    {
        return 0;
    }

    /**
     * Get the list of Food the user logged on a specified day
     *
     * @param date  The date to get the log data for
     * @return  The list of Food objects the user logged
     */
    public ArrayList<Food> getFoodOnDay(Date date)
    {
        if(userLog.checkForEntry(date)){
            DailyLogEntry dle = userLog.getLogEntry(userLog.getDateObj());
            return dle.getFood();
        }
        return null;

    }

    /**
     * Get the list of Food the user logged on a specified day
     *
     * @param date  The date to get the log data for
     * @return  The list of Food objects the user logged
     */
    public ArrayList<Exercise> getExerciseOnDay(Date date)
    {
        if(userLog.checkForEntry(date)){
            DailyLogEntry dle = userLog.getLogEntry(userLog.getDateObj());
            return dle.getExercise();
        }
        return null;

    }

    /**
     * Get the calorie count for the user on a specified day.
     * @param date  The date to get the calorie count for
     * @return  The calorie count
     */
    public Double getCaloriesOnDay(Date date)
    {
        return userLog.getCaloriesOnDay(date);
    }

    /**
     * get the calories burned for the day
     * @param date the date the data is for
     * @return the calories burned
     */
    public double getCaloriesBurned(Date date){
        return userLog.getCaloriesBurned(date);
    }

    /**
     * Get the fats for the user on a specified day.
     * @param date  The date to get the fats for
     * @return  The fats
     */
    public Double getFatsOnDay(Date date)
    {
        return userLog.getFatsOnDay(date);
    }

    /**
     * Get the carbs for the user on a specified day.
     * @param date  The date to get the carbs for
     * @return  The carbs
     */
    public Double getCarbsOnDay(Date date)
    {
        return userLog.getCarbsOnDay(date);
    }

    /**
     * Get the Protein for the user on a specified day.
     * @param date  The date to get the Protein for
     * @return  The Protein
     */
    public Double getProteinOnDay(Date date)
    {
        return userLog.getProteinOnDay(date);
    }

    public void addFood(String foodName, double servings){

        Date date = null;
        date = userLog.getDateObj();
        if(userLog.checkForEntry(date)){
        }
        else {
            userLog.createNewDailyLogEntry(date);
        }
        userLog.logFood(foodList.getFood(foodName), servings, date);
    }

    public void deleteFood(String foodName, double servings){

        Date date = null;
        date = userLog.getDateObj();
        if(!userLog.checkForEntry(date)){
            userLog.createNewDailyLogEntry(date);
        }
        userLog.deleteFood(foodList.getFood(foodName), servings, date);
    }

    public void addExercise(String exName, double minutes){

        Date date = null;
        date = userLog.getDateObj();
        if(userLog.checkForEntry(date)){
        }
        else {
            userLog.createNewDailyLogEntry(date);
        }
        userLog.logExercise(exName, minutes, date);
    }

    public void deleteExercise(String exName, double min){

        Date date = null;
        date = userLog.getDateObj();
        if(!userLog.checkForEntry(date)){
            userLog.createNewDailyLogEntry(date);
        }
        userLog.deleteExercise(exName, min, date);
    }

    public void addWeight(double weight){
        Date date = userLog.getDateObj();
        if(!userLog.checkForEntry(date)){
            userLog.createNewDailyLogEntry(date);
        }
        userLog.logWeight(weight, date);
    }

    public void logFood(String food, int serving)
    {

    }

    /**
     * Delete a specific food from the log
     */
    public void deleteFood(String date, String name, int servings)
    {
    }

    /**
     * returns true if the user has exceeded their set daily calorie limit
     *
     * @return  true if the user has exceeded their set daily calorie limit
     */
    public boolean hasExceededCalorieLimit()
    {
        return false;
    }


    public HashMap<Date, DailyLogEntry> getDailyLogs() {
       return userLog.getDailyLogs();
    }

    /**
     * The action performed when the user clicks a button on the display
     *
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        //cmd
    }

}//ends UserLogManager