/**
 * This creates the exercise objects
 *@authors Team A
 *@version 3.0
 */
 
package model ;
 
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;


public class Exercise {
    private String name;
    private double calories;
    private double time;
    private double caloriesBurned;

    /**
     * Default constructor
     * takes in no params and sets all variables to empty
     */
    public Exercise(){
        name = "";
        calories = 0.0;
        time = 0.0;
        caloriesBurned = 0.0;
    }

    /**
     * Constructor that takes in all the information for the exercise object
     * @param name
     * @param calories
     */
    public Exercise(String name, double calories){
        this.name = name;
        this.calories = calories;
    }

    /**
     * This will set the name
     * @param name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Sets the calories
     * @param calories
     */
    public void setCalories(double calories){
        this.calories = calories;
    }

    /**
     * Sets the time
     * @param time
     */
    public void setTime(double time){
        this.time = time;
    }

    /**
     * return the name
     * @return name
     */
    public String getName(){
        return name;
    }

    /**
     * get the calories
     * @return calories
     */
    public double getCalories(){
        return calories;
    }

    /**
     * gets the caloris burned of a specific exercise
     */
    public void setCaloriesBurned(double weight){
        caloriesBurned = Math.floor(this.calories*(weight/100.0)*(this.time/60.0) * 10) / 10;
    }

    public double getCaloriesBurned(){
        return caloriesBurned;
    }

    /**
     *
     * @return
     */
    public double getTime(){
        return time;
    }

    /**
     *
     * @param obj
     * @return
     */
    public Exercise clone(Exercise obj){
        Exercise copy = new Exercise(obj.getName(), obj.getCalories());
        return copy;
    }
}

