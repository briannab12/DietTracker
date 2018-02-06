/**
 * This creates the exercise objects
 *
 * @author Team A
 */
public class Exercise {
    private String name;
    private double calories;
    private double time;

    /**
     * Default constructor
     * takes in no params and sets all variables to empty
     */
    public Exercise(){
        name = "";
        calories = 0;
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
     * get the time
     * @return time
     */
    public double getTime(){
        return time;
    }

}

