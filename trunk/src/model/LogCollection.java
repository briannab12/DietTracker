/**
 * Maintains the data for the user's log data
 *@authors Team A
 *@version 3.0
 */
 
  package model ;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

//setchanged -- note for Caitlyn
//notityobservers -- note for Caitlyn

public class LogCollection extends Observable{
    //the object holding the list of all available foods
    private FoodCollection foodList;

    //the object holding the list of all available exercises
    private ExerciseCollection exerciseList;

    // a list of DailyLog objects where the key is a date
    private HashMap<Date,DailyLogEntry> dailyLogs = new HashMap<>();

    // the date the user is logging data
    private Date date = new Date();

    // the name of the CSV file containing all of the user's log data
    private String userLogCSV;
    private IOInterface csv;

    private Calendar cal = Calendar.getInstance();
    //Constants
    public static final double DEFAULT_WEIGHT = 150.0;
    public static final double DEFAULT_CALORIES = 2000.0;

    /**
     * The default constructor
     * Load the log data from the CSV, set the default date, weight, and calorie limit values
     * Initialize the Food manager
     */
    public LogCollection(String fileName, FoodCollection _foodList, ExerciseCollection _exerciseList)
    {
        userLogCSV = fileName;
        csv = new CSVIO();
        foodList = _foodList;
        exerciseList = _exerciseList;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date today = dateFormat.parse(dateFormat.format(date));
            setDate(today);
        }catch(ParseException pe){

        }
        loadLogData();
    }

    /**
     * Return the date this log is for
     *
     * @return the date this log is for
     */
    public String getDateString(){
        return (this.cal.getTime().getYear()+1900) + "-" + (this.cal.getTime().getMonth()+1) + "-" + this.cal.getTime().getDate();
    }

    public Date getDateObj(){
        return cal.getTime();
    }

    /**
     * Set the date the user is logging data for
     * @param date the date the user is logging data for
     */
    public void setDate(Date date){

        cal.setTime(date);
        if (checkForEntry(date) == true)
        {
            DailyLogEntry dle = getLogEntry(date);
        }
        else {
            createNewDailyLogEntry(date);
        }
        setChanged();
        notifyObservers();

    }

    private boolean next = true;

    public void prevDay(){
        cal.add(Calendar.DATE,-1 );
        if (checkForEntry(getDateObj()) == true)
        {
            DailyLogEntry dle = getLogEntry(getDateObj());
        }
        else {
            createNewDailyLogEntry(getDateObj());
        }
        next=false;
        setChanged();
        notifyObservers();
    }

    public void nextDay(){
        cal.add(Calendar.DATE,1 );
        if (checkForEntry(getDateObj()) == true)
        {
            DailyLogEntry dle = getLogEntry(getDateObj());
        }
        else {
            createNewDailyLogEntry(getDateObj());
        }
        next = true;
        setChanged();
        notifyObservers();
    }

    public boolean nextOrPrev(){
        return next;
    }


    /**
     * get the weight for the user for the the currently selected date
     *
     * @return  the user's weight
     */
    public double getWeight()
    {
        if(checkForEntry(getDateObj()) && getLogEntry(getDateObj()).weightSet()){
            return getLogEntry(getDateObj()).getWeight();
        }else{
            return getMostRecentWeight();
        }
    }


    private boolean weightNotFound = false;
    /**
     * get the weight for the user for the the most recent date to the selected date
     *
     * @return  the user's weight
     */
    public double getMostRecentWeight()
    {
        Calendar checkCal = Calendar.getInstance();
        checkCal.setTime(getDateObj());
        double weight = -1;

        //if its before the oldest logged weight, set weight to default
        if( getDateObj().before(getOldestWeightDate())){
            weight=DEFAULT_WEIGHT;
        }
        else{
            do {
                if ((checkCal.getTime().getYear()) > (cal.getTime().getYear())) {
                    weight = getCurrentWeight();
                }
                if (checkForEntry(checkCal.getTime())) {
                    if (getLogEntry(checkCal.getTime()).weightSet()) {
                        weight = getLogEntry(checkCal.getTime()).getWeight();
                    }
                }
                checkCal.add(Calendar.DATE, -1);
            }
            while (weight == -1);
        }

        return weight;
    }

    public Date getOldestWeightDate(){
        ArrayList<DailyLogEntry> dle = new ArrayList<>(dailyLogs.values());

        Collections.sort(dle);
        if(dle.size() > 0) {
            return dle.get(0).getDate();
        }
        return null;
    }

    public double getOldestWeight(){
        ArrayList<DailyLogEntry> dle = new ArrayList<>(dailyLogs.values());

        Collections.sort(dle);
        if(dle.size() > 0) {
            return dle.get(0).getWeight();
        }
        else {
            return DEFAULT_WEIGHT;
        }
    }

    /**
     * get the weight for the user for the the currently selected date
     *
     * @return  the user's weight
     */
    public double getCurrentWeight()
    {
        ArrayList<DailyLogEntry> dle = new ArrayList<>(dailyLogs.values());

        Collections.sort(dle);
        Collections.reverse(dle);
        if(dle.size() > 0) {
            return dle.get(0).getWeight();
        }
        else {
            return DEFAULT_WEIGHT;
        }
    }

    /**
     * set the user's weight for the date selected
     * @param weight
     */
    public void setWeight(double weight) {
        if(!checkForEntry(date)){
            createNewDailyLogEntry(date);
        }
        DailyLogEntry dle = dailyLogs.get(date);
        dle.setWeight(weight);

        setChanged();
        notifyObservers();
    }

    /**
     * get the user's calorie limit for the date selected
     * @return the user's calorie limit
     */
    public double getCurrentCalorieLimit() {
        ArrayList<DailyLogEntry> dle = new ArrayList<>(dailyLogs.values());

        Collections.sort(dle);
        Collections.reverse(dle);
        if(dle.size() > 0) {
            return dle.get(0).getCalorieLimit();
        }
        else {
            return DEFAULT_CALORIES;
        }
    }

    /**
     * get the user's calorie limit for the date selected
     * @return the user's calorie limit
     */
    public double getPreviousCalorieLimit() {
        ArrayList<DailyLogEntry> dle = new ArrayList<>(dailyLogs.values());

        Collections.sort(dle);
        Collections.reverse(dle);
        if(dle.size() > 1) {
            return dle.get(1).getCalorieLimit();
        }
        else {
            return DEFAULT_CALORIES;
        }
    }

    /**
     * get the user's calorie limit for the date selected
     * @return the user's calorie limit
     */
    public double getPreviousWeight() {
        ArrayList<DailyLogEntry> dle = new ArrayList<>(dailyLogs.values());

        Collections.sort(dle);
        Collections.reverse(dle);
        if(dle.size() > 1) {
            return dle.get(1).getWeight();
        }
        else {
            return DEFAULT_WEIGHT;
        }
    }

    /**
     * set the user's calorie limit for the date selected
     *
     * @param calorieLimit  the user's calorie limit
     */
    public void setCalorieLimit(double calorieLimit)
    {
        if(!checkForEntry(date)){
            createNewDailyLogEntry(date);
        }
        DailyLogEntry dle = dailyLogs.get(date);
        dle.setCalorieLimit(calorieLimit);

        setChanged();
        notifyObservers();
    }

    public void createNewDailyLogEntry(Date date){
        DailyLogEntry dle = new DailyLogEntry(date);
        dailyLogs.put(date, dle);

        setChanged();
        notifyObservers();
    }

    /**
     * load all of the data from the CSV file and store it as DailyLogEntry objects in the HashMap where the key is the
     * date of the log as yyyy-MM-dd
     */
    private void loadLogData(){
        ArrayList<String[]> logStrings = csv.read(userLogCSV);

        //Get each day's log from the arraylist create DailyLogEntry objects
        Date logDay = null;
        for(String[] dailyArray : logStrings) {
            if(!(dailyArray[0].isEmpty()))
            {
                String dateStr = dailyArray[0] + "-" + dailyArray[1] + "-" + dailyArray[2];
                try {
                    logDay = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
                } catch (ParseException pe) {

                }
                DailyLogEntry entry = null;
                //if the log entry already exists
                if (dailyLogs.containsKey(logDay)) {
                    entry = dailyLogs.get(logDay);
                    //creates the log entry if it doesn't exist
                } else {
                    dailyLogs.put(logDay, new DailyLogEntry(logDay));
                    entry = dailyLogs.get(logDay);
                }

                //checks if the entry is a food, weight, or calories
                if (dailyArray[3].equals("f")) {
                    //gets the food, clones it and set servings
                    Food food = foodList.getFood(dailyArray[4]);
                    Food foodToAdd = food.clone(food, Double.parseDouble(dailyArray[5]));
                    entry.addFood(foodToAdd, Double.parseDouble(dailyArray[5]));
                } else if (dailyArray[3].equals("e")) {
                    //gets the exercise clones it and set minutes
                    Exercise exercise = exerciseList.getExercise(dailyArray[4]);
                    Exercise exerciseToAdd = exercise.clone(exercise);
                    entry.addExercise(exerciseToAdd, Double.parseDouble(dailyArray[5]));
                } else if (dailyArray[3].equals("w")) {
                    //sets the weight for the day
                    entry.setWeight(Double.parseDouble(dailyArray[4]));
                } else if (dailyArray[3].equals("c")) {
                    //sets the calorie limit for the day
                    entry.setCalorieLimit(Double.parseDouble(dailyArray[4]));
                }

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
        setChanged();
        notifyObservers();
    }

    /**
     * add a Food and the numbers of servings to the log
     */
    public void logFood(Food food, double servings, Date date)
    {
        //add the food to the daily log entry for the date
        DailyLogEntry dle = getLogEntry(date);
        Food foodToAdd = food.clone(food, servings);
        dle.addFood(foodToAdd, servings);

        //adds zeros if the day/month is less than 10
        String monthStr = "";
        String dayStr = "";
        if( (date.getMonth()+1) < 10){
            monthStr = "0"+(date.getMonth()+1);
        }
        else{
            monthStr = ""+(date.getMonth()+1);
        }

        if( (date.getDate()) < 10){
            dayStr = "0"+(date.getDate());
        }
        else{
            dayStr = ""+(date.getDate());
        }


        // get the Food object from Food manager, set the servings on the Food object and store it
        String[] toWrite = {"","","","f","",""};
        toWrite[0] = ""+(date.getYear()+1900);
        toWrite[1] = monthStr;
        toWrite[2] = dayStr;
        toWrite[4] = food.getName();
        toWrite[5] = ""+servings;
        csv.appendToFile(userLogCSV, toWrite);

        setChanged();
        notifyObservers();
    }

    /**
     * delete the Food and its info in the log
     */
    public void deleteFood(Food food, double servings, Date date)
    {
        //add the food to the daily log entry for the date
        DailyLogEntry dle = getLogEntry(date);
        dle.deleteFood(food, servings);

        //adds zeros if the day/month is less than 10
        String monthStr = "";
        String dayStr = "";
        if( (date.getMonth()+1) < 10){
            monthStr = "0"+(date.getMonth()+1);
        }
        else{
            monthStr = ""+(date.getMonth()+1);
        }

        if( (date.getDate()) < 10){
            dayStr = "0"+(date.getDate());
        }
        else{
            dayStr = ""+(date.getDate());
        }

        // get the Food object from Food manager, set the servings on the Food object and store it
        String[] toWrite = {"","","","f","",""};
        toWrite[0] = ""+(date.getYear()+1900);
        toWrite[1] = monthStr;
        toWrite[2] = dayStr;
        toWrite[4] = food.getName();
        toWrite[5] = ""+servings;
        csv.delete(userLogCSV, toWrite);

        setChanged();
        notifyObservers();
    }

    /**
     * delete the Food and its info in the log
     */
    public void deleteExercise(String exName, double min, Date date)
    {
        //add the food to the daily log entry for the date
        DailyLogEntry dle = getLogEntry(date);
        dle.deleteExercise(exerciseList.getExercise(exName), min);

        //adds zeros if the day/month is less than 10
        String monthStr = "";
        String dayStr = "";
        if( (date.getMonth()+1) < 10){
            monthStr = "0"+(date.getMonth()+1);
        }
        else{
            monthStr = ""+(date.getMonth()+1);
        }

        if( (date.getDate()) < 10){
            dayStr = "0"+(date.getDate());
        }
        else{
            dayStr = ""+(date.getDate());
        }

        // get the Ex object from exercise manager, set the servings on the Food object and store it
        String[] toWrite = {"","","","e","",""};
        toWrite[0] = ""+(date.getYear()+1900);
        toWrite[1] = monthStr;
        toWrite[2] = dayStr;
        toWrite[4] = exName;
        toWrite[5] = ""+min;
        csv.delete(userLogCSV, toWrite);

        setChanged();
        notifyObservers();
    }


    /**
     * add a weight to the log
     */
    public void logWeight(double weight, Date date)
    {
        //add the food to the daily log entry for the date
        DailyLogEntry dle = getLogEntry(date);
        dle.setWeight(weight);

        //adds zeros if the day/month is less than 10
        String monthStr = "";
        String dayStr = "";
        if( (date.getMonth()+1) < 10){
            monthStr = "0"+(date.getMonth()+1);
        }
        else{
            monthStr = ""+(date.getMonth()+1);
        }

        if( (date.getDate()) < 10){
            dayStr = "0"+(date.getDate());
        }
        else{
            dayStr = ""+(date.getDate());
        }

        // get the Food object from Food manager, set the servings on the Food object and store it
        String[] toWrite = {"","","","w",""};
        toWrite[0] = ""+(date.getYear()+1900);
        toWrite[1] = monthStr;
        toWrite[2] = dayStr;
        toWrite[4] = ""+weight;
        csv.appendToFile(userLogCSV, toWrite);

        setChanged();
        notifyObservers();
    }

    public void logCalories(double calories){

        //adds zeros if the day/month is less than 10
        String monthStr = "";
        String dayStr = "";
        if( (date.getMonth()+1) < 10){
            monthStr = "0"+(date.getMonth()+1);
        }
        else{
            monthStr = ""+(date.getMonth()+1);
        }

        if( (date.getDate()) < 10){
            dayStr = "0"+(date.getDate());
        }
        else{
            dayStr = ""+(date.getDate());
        }


        // get the Food object from Food manager, set the servings on the Food object and store it
        String[] toWrite = {"","","","c",""};
        toWrite[0] = ""+(date.getYear()+1900);
        toWrite[1] = monthStr;
        toWrite[2] = dayStr;
        toWrite[4] = ""+calories;
        csv.appendToFile(userLogCSV, toWrite);

        setChanged();
        notifyObservers();
    }

    /**
     * add a Exercise and the number of minutes to the log
     */
    public void logExercise(String exerciseName, double min, Date date)
    {
        //add the exercise to the daily log entry for the date
        DailyLogEntry dle = getLogEntry(date);
        dle.addExercise(exerciseList.getExercise(exerciseName), min);

        //adds zeros if the day/month is less than 10
        String monthStr = "";
        String dayStr = "";
        if( (date.getMonth()+1) < 10){
            monthStr = "0"+(date.getMonth()+1);
        }
        else{
            monthStr = ""+(date.getMonth()+1);
        }

        if( (date.getDate()) < 10){
            dayStr = "0"+(date.getDate());
        }
        else{
            dayStr = ""+(date.getDate());
        }

        // get the Exercise object from Exercise manager, set the minutes on the Exercise object and store it
        String[] toWrite = {"","","","e","",""};
        toWrite[0] = ""+(date.getYear()+1900);
        toWrite[1] = monthStr;
        toWrite[2] = dayStr;
        toWrite[4] = exerciseName;
        toWrite[5] = ""+min;
        csv.appendToFile(userLogCSV, toWrite);

        setChanged();
        notifyObservers();
    }

    public double getCaloriesBurned(Date date){
        getLogEntry(date).calculateCaloriesBurned();
        getLogEntry(date).setWeight(getWeight());
        return getLogEntry(date).getCaloriesBurned();
    }

    /**
     * Get the calorie count for the user on a specified day.
     * @param date  The date to get the calorie count for
     * @return  The calorie count
     */
    public Double getCaloriesOnDay(Date date)
    {
        if(checkForEntry(date)) {
            return getLogEntry(date).getTotalCalories();
        }
        return 0.0;
    }

    /**
     * Get the fats for the user on a specified day.
     * @param date  The date to get the fats for
     * @return  The fats
     */
    public Double getFatsOnDay(Date date)
    {
        if(checkForEntry(date)) {
            return getLogEntry(date).getTotalFats();
        }
        return 0.0;
    }

    /**
     * Get the carbs for the user on a specified day.
     * @param date  The date to get the carbs for
     * @return  The carbs
     */
    public Double getCarbsOnDay(Date date)
    {
        if(checkForEntry(date)) {
            return getLogEntry(date).getTotalCarbs();
        }
        return 0.0;
    }

    /**
     * Get the Protein for the user on a specified day.
     * @param date  The date to get the Protein for
     * @return  The Protein
     */
    public Double getProteinOnDay(Date date)
    {
        if(checkForEntry(date)) {
            return getLogEntry(date).getTotalProtein();
        }
        return 0.0;
    }

}//end of userLog