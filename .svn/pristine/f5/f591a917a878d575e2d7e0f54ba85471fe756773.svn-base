/**
 * Handles the logic of saving, updating, and deleting data from the user log when the user clicks buttons on the GUI.
 * All data is changed for the data set by the user which is defaulted to the current day.
 *
 * Add action listner to button in a different class
 * https://stackoverflow.com/questions/4985507/action-listener-in-another-class-java
 *
 * https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/uiswing/examples/events/BeeperProject/src/events/Beeper.java
 */

import java.util.*;
import java.awt.event.*;

public class UserLogManager implements ActionListener{

    // the object for storing and updating data about the user
    private UserLog userLog;

    /**
    * Defulat constructor
    * Initializes the UserLog
    */
    public UserLogManager(UserLog userLog)
    {
        // create a new UserLog object
        this.userLog = userLog;
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
        return 0;
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
        return 0;
    }

    /**
     * Set the user's calorie limit
     *
     * @param calorieIntake
     */
    public void setCalorieLimit(double calorieIntake)
    {
        // set the calorie limit in UserLog
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
        return new ArrayList<Food>();
    }

    /**
     * Get the calorie count for the user on a specified day.
     * Gets the list of logged Food for the user on a specific day
     * @param date  The date to get the calorie count for
     * @return  The calorie count
     */
    public String getCaloriesOnDay(String date)
    {
        return "";
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

    /**
     * The action performed when the user clicks a button on the display
     *
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        //cmd
    }

}//ends UserLogManager