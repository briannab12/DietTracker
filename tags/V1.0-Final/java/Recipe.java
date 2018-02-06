/**
 * This is the Food Interface which is the Component for the Basic Food and Recipe Classes.
 * Include methods that allows the retrieval of information.
 * @author Fu from Team A
 * @version 1.0
 */

import java.util.ArrayList;

public class Recipe implements Food{

    private String name;
    private double fats;
    private double carbs;
    private double protein;
    private double calories;
    private double servings;
    private ArrayList<Food> ingredients;
	
	/**
     * Recipe constructor
     *
     * @param _name The recipe name
	 * @param _ingredients The basic foods the recipe contains
     */
	public Recipe(String _name, ArrayList<Food> _ingredients){
		name = _name;
		ingredients = _ingredients;
		calculateNutrition();
	}

	private void calculateNutrition(){
        Double carbs = 0.0;
        for(Food food : ingredients){
            carbs += food.getCarbs() * food.getServings();
        }
        this.carbs = carbs;

        Double fats = 0.0;
        for(Food food : ingredients){
            fats += food.getFat() * food.getServings();
        }
        this.fats = fats;

        Double protein = 0.0;
        for(Food food : ingredients){
            protein += food.getProtein() * food.getServings();
        }
        this.protein = protein;

        Double calories = 0.0;
        for(Food food : ingredients){
            calories += food.getCalories() * food.getServings();
        }
        this.calories = calories;
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
     * Returns the list of Food/ingredients in Recipe
     *
     * @return the list of ingredients
     */
    public ArrayList<Food> getIngredients(){
		return ingredients;
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
     *
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

    /**
     * Sets the list of Food/ingredients found in the recipe
     *
     * @param _ingredients   the list of Foods that make up the recipe
     */
    public void setIngredients(ArrayList<Food> _ingredients){
		ingredients = _ingredients;
    }

    /**
     * sets the recipe to a string to send to other classes
     *
     * @return String
     */
    public String toString(){
        return String.format("Name: " +  name + " Calories: " + calories + " Fat: " + fats + " Carbs: " + carbs + " Proteins: " + protein + "%n");
    }
}
