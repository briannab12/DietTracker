/**
 * Stores the data about the user for a single day. It stores their calorie limit, weight, and the list of Foods
 */
import java.util.*;

public class DailyLogEntry{

   // the date this log is for
   private Date date;

   // the list of foods
   private ArrayList<Food> foodList;

   // the list of exercises
   private ArrayList<Exercise> exerciseList;

   // the users weight for this day
   private double weight;

   // the user's calorie limit for the day
   private double calorieLimit;

   public static final double DEFAULT_WEIGHT = 150.0;

   public static final double DEFAULT_CALORIE_LIMIT = 2000.0;

   /**
    * The constructor sets the date and default values
    *
    * @param date   the date this log is for
    */
   public DailyLogEntry(Date date) {
      this.date = date;
      this.foodList = new ArrayList<Food>();
      this.exerciseList = new ArrayList<Exercise>();
      this.weight = DEFAULT_WEIGHT;
      this.calorieLimit = DEFAULT_CALORIE_LIMIT;
   }

   /**
    * Adds a food to the foodList
    *
    * @param food   The food to be added to the foodlist
    */
   public void addFood(Food food){
      foodList.add(food);

   }

   /**
    * Adds a food to the foodList
    *
    * @param exercise   The food to be added to the foodlist
    */
   public void addExercise(Exercise exercise){
      exerciseList.add(exercise);
   }

   /**
    * Sets the calorie limit for the day
    *
    * @param _calorieLimit   The limit to be set
    */
   public void setCalorieLimit(double _calorieLimit){
      calorieLimit = _calorieLimit;
   }

   /**
    * Sets the weight for the day
    *
    * @param _weight   The weight to be set
    */
   public void setWeight(double _weight){
      weight = _weight;
   }

    /**
     * Return the list of food consumed for this day
     *
     * @return list of food consumed for that day
     */
   public ArrayList<Food> getFood(){
       return this.foodList;
   }

    /**
     * Return the calorie limit for this day
     *
     * @return calorie limit for that day
     */
   public double getCalorieLimit(){
       return this.calorieLimit;
   }

    /**
     * Return the weight for this day
     *
     * @return calorie limit for that day
     */
   public double getWeight(){
       return this.weight;
   }

    /**
     * Return the date this log is for
     *
     * @return the date this log is for
     */
   public Date getDate(){
       return this.date;
   }

    /**
     * Return the year this log is for
     *
     * @return the year this log is for
     */
    /*public int getYear(){
        String[] parts = date.split("-");
        return Integer.parseInt(parts[0]);
    }*/

    /**
     * Return the month this log is for
     *
     * @return the month this log is for
     */
    /*public int getMonth(){
        String[] parts = date.split("-");
        return Integer.parseInt(parts[1]);
    }*/

    /**
     * Return the day this log is for
     *
     * @return the day this log is for
     */
    /*public int getDay(){
        String[] parts = date.split("-");
        return Integer.parseInt(parts[2]);
    }*/
}