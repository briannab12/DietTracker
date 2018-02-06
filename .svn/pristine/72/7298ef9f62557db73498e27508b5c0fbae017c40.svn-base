/**
 * Stores the data about the user for a single day. It stores their calorie limit, weight, and the list of Foods
 *@authors Team A
 *@version 3
 */
 
 package model ;
 
import java.util.*;

public class DailyLogEntry implements Comparable<DailyLogEntry>{

   // the date this log is for
   private Date date;

   // the list of foods
   private ArrayList<Food> foodList;

   // the list of exercises
   private ArrayList<Exercise> exerciseList;

   // the users weight for this day
   private double weight;

   //if the weight has been specified or not
   private boolean weightSet = false;

   // the user's calorie limit for the day
   private double calorieLimit;

   private double totalFats;

   private double totalCarbs;

   private double totalProtein;

    private double totalCalories;

    private double caloriesBurned = 0;

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
      calculateNutrition();
      calculateCaloriesBurned();
   }


    /**
     * get the total calories burned for the day
     * @return the total calories burned for the day
     */
    public double getCaloriesBurned(){
        return caloriesBurned;
    }

    /**
     * calculate the total calories burned for the day
     */
   public void calculateCaloriesBurned(){
       double totalCalories = 0.0;
       for(Exercise e:exerciseList){
           e.setCaloriesBurned(weight);
           totalCalories += e.getCaloriesBurned();
       }
       caloriesBurned =  Math.floor(totalCalories * 10) / 10;
   }

   /**
    * Adds a food to the foodList
    *
    * @param food   The food to be added to the foodlist
    */
   public void addFood(Food food, double serv){
      foodList.add(food);
      foodList.get(foodList.indexOf(food)).setServings(serv);
      calculateNutrition();
      calculateCaloriesBurned();
   }

    /**
     * calculate the nutritional information for the day
     */
   public void calculateNutrition(){
       double carbs = 0.0;
       double fats = 0.0;
       double protein = 0.0;
       double calories = 0.0;

       for(Food f: foodList){
           carbs += f.getCarbs() * f.getServings();
           fats += f.getFat() * f.getServings();
           protein += f.getProtein() * f.getServings();
           calories += f.getCalories() * f.getServings();
       }

       this.totalCarbs = Math.floor(carbs * 10) / 10;
       this.totalFats =  Math.floor(fats * 10) / 10;
       this.totalProtein =  Math.floor(protein * 10) / 10;
       this.totalCalories =  Math.floor(calories * 10) / 10;
   }

   /**
    * Deletes a food from the foodList
    *
    * @param food   The food to be deletes from the foodlist
    */
   public void deleteFood(Food food, double serv){
       int delIndex = -1;
      for(Food toDel : foodList) {
          if(toDel.getName().equals(food.getName()) && toDel.getServings() == serv){
              delIndex = foodList.indexOf(toDel);
          }
      }
      if(delIndex > -1){
          foodList.remove(delIndex);
      }
       calculateNutrition();
       calculateCaloriesBurned();
   }

    /**
     * Deletes a exercise from the exerciseList
     *
     * @param ex   The exercise to be deletes from the exerciselist
     */
    public void deleteExercise(Exercise ex, double min){
        int delIndex = -1;
        for(Exercise toDel : exerciseList) {
            if(toDel.getName().equals(ex.getName()) && toDel.getTime() == min){
                delIndex = exerciseList.indexOf(toDel);
            }
        }
        if(delIndex > -1){
            exerciseList.remove(delIndex);
        }
        calculateCaloriesBurned();
    }

   /**
    * Adds a food to the foodList
    *
    * @param exercise   The food to be added to the foodlist
    */
   public void addExercise(Exercise exercise,double minutes){
       Exercise newExercise = exercise.clone(exercise);
       newExercise.setTime(minutes);
       newExercise.setCaloriesBurned(this.weight);
       exerciseList.add(newExercise);
       calculateCaloriesBurned();
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
       calculateCaloriesBurned();
       weightSet = true;
   }

    /**
     * Return if the weight has been set for this day
     *
     * @return if the weight has been set or not
     */
    public boolean weightSet(){
        return weightSet;
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
    * Return the list of exercises for this day
    *
    * @return list of exercises for that day
    */
   public ArrayList<Exercise> getExercise(){
      return this.exerciseList;
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
    * Return the date this log is for
    *
    * @return the date this log is for
    */
   public String getDateString(){
      return (this.date.getYear()+1900) + "-" + (this.date.getMonth()+1) + "-" + this.date.getDate();
   }

    /**
     * Get the total calories for the day
     * @return total calories for the day
     */
    public double getTotalCalories() {
        return totalCalories;
    }

    /**
     * Get the total fats for the day
     * @return total fats for the day
     */
    public double getTotalFats() {
        return totalFats;
    }

    /**
     * Get the total carbs for the day
     * @return total carbs for the day
     */
    public double getTotalCarbs() {
        return totalCarbs;
    }

    /**
     * Get the total protein for the day
     * @return total protein for the day
     */
    public double getTotalProtein() {
        return totalProtein;
    }

    public int compareTo(DailyLogEntry o)
    {
       return getDate().compareTo(o.getDate());
    }
}