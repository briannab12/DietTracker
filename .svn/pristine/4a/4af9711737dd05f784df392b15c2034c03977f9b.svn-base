import java.util.ArrayList;

public class BasicFood implements Food
{

    private String name;
    private double fats;
    private double carbs;
    private double protein;
    private double calories;
    private double servings;

    /**
     * Constructor creates a basic food defaults servings to one is not passed in
     *
     * @param _name
     * @param _calories
     * @param _fats
     * @param _carbs
     * @param _protein
     */
    public BasicFood(String _name,  double _calories, double _fats, double _carbs, double _protein){
        name = _name;
        calories = _calories;
        fats = _fats;
        carbs = _carbs;
        protein = _protein;
        servings =1;
    }

    /**
     * Constructor creates a basic food with a set amount of servings
     *
     * @param _name
     * @param _calories
     * @param _fats
     * @param _carbs
     * @param _protein
     * @param _servings
     */
    public BasicFood(String _name,  double _calories, double _fats, double _carbs, double _protein, double _servings){
        name = _name;
        calories = _calories;
        fats = _fats;
        carbs = _carbs;
        protein = _protein;
        servings = _servings;
    }

    /**
     * Gets the carbohydrates of recipe
     *
     * @return  the grams of carbs in a recipe
     */
    public double getCarbs(){
        return carbs;
    }

    /**
     * Returns the fat of recipe
     *
     * @return the grams of fat in a recipe
     */
    public double getFat(){
        return fats;
    }

    /**
     * Returns the Protein of recipe
     *
     * @return the grams of protein in a recipe
     */
    public double getProtein(){
        return protein;
    }

    /**
     * Returns the calories of recipe
     *
     * @return the number of calories in a recipe
     */
    public double getCalories(){
        return calories;
    }

    /**
     * Returns the name of recipe
     *
     * @return the name of the recipe
     */
    public String getName(){
        return name;
    }

    /**
     * Returns the servings for a recipe
     *
     * @return  get the number of servings
     */
    public double getServings(){
        return servings;
    }

    /**
     * Sets the carbohydrates of recipe
     *
     * @param _carbs the grams of carbs
     */
    public void setCarbs(double _carbs){

        carbs = _carbs;
    }

    /**
     * Sets fats of recipe
     *
     * @param _fat   the grams of fat
     */
    public void setFat(double _fat){
        fats = _fat;
    }

    /**
     * Sets proteins of recipe
     * @param _protein   the grams of protein
     */
    public void setProtein(double _protein){
        protein = _protein;
    }

    /**
     * Sets calories of recipe
     *
     * @param _calories  the number of calories
     */
    public void setCalories(double _calories){
        calories = _calories;
    }

    /**
     * Sets name of recipe
     *
     * @param _name  the name fo the recipe
     */
    public void setName(String _name) {
        name = _name;
    }

    /**
     * Set the number of servings
     *
     * @param _servings  the number of servings
     */
    public void setServings(double _servings){
        servings = _servings;
    }

    public String toString(){
        return String.format("Name: " +  name + " Calories: " + calories + " Fat: " + fats + " Carbs: " + carbs + " Proteins: " + protein + "%n");
    }

    public static Food clone(Food obj, Double servings){
        BasicFood copy = new BasicFood(obj.getName(), obj.getCalories(), obj.getFat(), obj.getCarbs(), obj.getProtein(), servings);
        return copy;
    }

}
