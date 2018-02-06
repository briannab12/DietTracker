/**
 * Maintains the data for the user's log data
 *
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class UserLog extends Observable{
    //the object holding the list of all available foods
    private FoodList foodList;

    // a list of DailyLog objects where the key is a date
    private HashMap<Date,DailyLogEntry> dailyLogs = new HashMap<>();;

    // the date the user is logging data
    private Date date;

    // the name of the CSV file containing all of the user's log data
    private String userLogCSV;
    private IOInterface csv;
    /**
     * The default constructor
     * Load the log data from the CSV, set the default date, weight, and calorie limit values
     * Initialize the Food manager
     */
    public UserLog(String fileName, FoodList _foodList)
    {
        userLogCSV = fileName;
        csv = new CSVIO();
        foodList = _foodList;
        loadLogData();
    }

    /**
     * Get the date the user is logging data for
     *
     * @return  the date the user is logging data for
     */
    public String getDate()
    {
        return ""+ this.date;
    }

    /**
     * Set the date the user is logging data for
     * @param date the date the user is logging data for
     */
    public void setDate(Date date)
    {
        this.date = date;
        if (checkForEntry(date) == true)
        {
            getLogEntry(date);
        }
        else
        {
            createNewDailyLogEntry(date);
        }


    }

    /**
     * get the weight for the user for the date selected
     *
     * @return  the user's weight
     */
    public double getWeight()
    {
        return 0;
    }

    /**
     * set the user's weight for the date selected
     * @param weight
     */
    public void setWeight(double weight)
    {

    }

    /**
     * get the user's calorie limit for the date selected
     * @return the user's calorie limit
     */
    public double getCalorieLimit()
    {
        return 0;
    }

    /**
     * set the user's calorie limit for the date selected
     *
     * @param calorieLimit  the user's calorie limit
     */
    public void setCalorieLimit(double calorieLimit)
    {

    }

    public void createNewDailyLogEntry(Date date){
        DailyLogEntry dle = new DailyLogEntry(date);
        dailyLogs.put(date, dle);
    }

    /**
     * load all of the data from the CSV file and store it as DailyLogEntry objects in the HashMap where the key is the
     * date of the log as yyyy-MM-dd
     */
    private void loadLogData(){
        ArrayList<String[]> logStrings = csv.read(userLogCSV);

        //Get each day's log from the arraylist create DailyLogEntry objects
        for(String[] dailyArray : logStrings) {
            String dateStr = dailyArray[0]+"-"+dailyArray[1]+"-"+dailyArray[2];
            Date logDay = null;
            try {
                logDay = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
            }catch(ParseException pe){

            }
            DailyLogEntry entry = null;
            //if the log entry already exists
            if(dailyLogs.containsKey(logDay)) {
                entry = dailyLogs.get(logDay);
                //creates the log entry if it doesn't exist
            }else{
                dailyLogs.put(logDay, new DailyLogEntry(logDay) );
                entry = dailyLogs.get(logDay);
            }

            //checks if the entry is a food, weight, or calories
            if (dailyArray[3].equals("f")) {
                //gets the food, clones it and set servings
                Food food = foodList.getFood(dailyArray[4]);
                Food foodToAdd = food.clone( food, Double.parseDouble(dailyArray[5]) );
                entry.addFood( foodToAdd );
            } else if (dailyArray[3].equals("w")) {
                //sets the weight for the day
                entry.setWeight( Double.parseDouble(dailyArray[4]) );
            } else if (dailyArray[3].equals("c")) {
                //sets the calorie limit for the day
                entry.setCalorieLimit( Double.parseDouble(dailyArray[4]) );
            }
        }

        setChanged();
        notifyObservers();
    }

    /**
     * @return DailyLogEntrys
     */
    public HashMap<Date, DailyLogEntry> getDailyLogs() {
        return dailyLogs;
    }

    public DailyLogEntry getLogEntry(Date date){
        return dailyLogs.get(date);
    }

    public boolean checkForEntry(Date date){
        try {
            if (dailyLogs.containsKey(date)) {
                return true;
            }
            return false;
        } catch (NullPointerException npe){
            return false;
        }
    }

    /**
     * Save the log data from the HashMap to the CSV file
     */
    private void saveLogData(){

    }

    /**
     * Delete a specific food from the log
     */
    public void deleteFood(Date date, String name, int servings)
    {
    }

    /**
     * add a Food and the numbers of servings to the log
     */
    public void logFood(Food food, Date date)
    {
        // get the Food object from Food manager, set the servings on the Food oject and store it

        String[] toWrite = {"","","","f","",""};
        toWrite[0] = ""+(date.getYear()+1900);
        toWrite[1] = ""+(date.getMonth()+1);
        toWrite[2] = ""+date.getDate();
        toWrite[4] = food.getName();
        toWrite[5] = ""+food.getServings();
        csv.appendToFile(userLogCSV, toWrite);
    }
   
}//end of userLog