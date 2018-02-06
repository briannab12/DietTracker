/**
 * This is the Food Interface which is the Component for the Basic Food and Recipe Classes.
 * Include methods that allows the retrieval of information.
 *@authors Team A
 *@version 3.0
 */
 
  package model ;

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
        servings = 1;
        calculateNutrition();
    }

    /**
     * Recipe constructor
     *
     * @param _name The recipe name
     * @param _ingredients The basic foods the recipe contains
     * @param _servings The number of servings
     */
    public Recipe(String _name, ArrayList<Food> _ingredients, double _servings){
        name = _name;
        ingredients = _ingredients;
        servings = _servings;
        calculateNutrition();
    }

	private void calculateNutrition(){
        this.carbs = Math.floor(calcCarbs(this) * 10) / 10;
        this.fats = Math.floor(calcFats(this) * 10) / 10;
        this.protein = Math.floor(calcProtein(this) * 10) / 10;
        this.calories = Math.floor(calcCalories(this) * 10) / 10;
    }


    /**
     * Helper methpd to calculate food nutritional info
     *
     * @param food the food object
     * @return the grams of nutritional data
     */
    private double calcCarbs(Food food){
        Double recipeCarbs = 0.0;

        if(food instanceof BasicFood){
            recipeCarbs += food.getCarbs() * food.getServings();
        } else if(food instanceof Recipe){
            Recipe recipe = (Recipe) food;
            for (Food aFood : recipe.getIngredients()) {
                if(aFood instanceof Recipe){
                    recipeCarbs += calcCarbs(aFood) * aFood.getServings();
                }
                if(aFood instanceof BasicFood){
                    recipeCarbs += calcCarbs(aFood);
                }
            }
        }

        return recipeCarbs;
    }

    /**
     * Helper methpd to calculate food nutritional info
     *
     * @param food the food object
     * @return the grams of nutritional data
     */
    private double calcFats(Food food) {
        Double recipeFats = 0.0;

        if (food instanceof BasicFood) {
            recipeFats += food.getFat() * food.getServings();
        } else if (food instanceof Recipe) {
            Recipe recipe = (Recipe) food;
            for (Food aFood : recipe.getIngredients()) {
                if(aFood instanceof Recipe){
                    recipeFats += calcFats(aFood) * aFood.getServings();
                }
                if(aFood instanceof BasicFood){
                    recipeFats += calcFats(aFood);
                }
            }
        }

        return recipeFats;
    }

    /**
     * Helper methpd to calculate food nutritional info
     *
     * @param food the food object
     * @return the grams of nutritional data
     */
    private double calcProtein(Food food){
        Double recipeProtein = 0.0;

        if (food instanceof BasicFood) {
            recipeProtein += food.getProtein() * food.getServings();
        } else if (food instanceof Recipe) {
            Recipe recipe = (Recipe) food;
            for (Food aFood : recipe.getIngredients()) {
                if(aFood instanceof Recipe){
                    recipeProtein += calcProtein(aFood) * aFood.getServings();
                }
                if(aFood instanceof BasicFood){
                    recipeProtein += calcProtein(aFood);
                }
            }
        }

        return recipeProtein;
    }

    /**
     * Helper methpd to calculate food nutritional info
     *
     * @param food the food object
     * @return the grams of nutritional data
     */
    private double calcCalories(Food food){
        Double recipeCalories = 0.0;

        if (food instanceof BasicFood) {
            recipeCalories += food.getCalories() * food.getServings();
        } else if (food instanceof Recipe) {
            Recipe recipe = (Recipe) food;
            for (Food aFood : recipe.getIngredients()) {
                if(aFood instanceof Recipe){
                    recipeCalories += calcCalories(aFood) * aFood.getServings();
                }
                if(aFood instanceof BasicFood){
                    recipeCalories += calcCalories(aFood) * aFood.getServings();
                }
            }
        }

        return recipeCalories;
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
     * Set the number of servings
     *
     * @param _servings  the number of servings
     */
    public void setIngredientServings(Food food, double _servings){
        try {
            System.out.println(getName() + "setting ingrediants " + food.getName() + _servings);
            int index = getIngredientByName(food.getName());
            ingredients.get(index).setServings(_servings);
        }catch(NullPointerException npe){

        }
    }

    /**
     * Sets the list of Food/ingredients found in the recipe
     *
     * @param _ingredients   the list of Foods that make up the recipe
     */
    public void setIngredients(ArrayList<Food> _ingredients){
		ingredients = _ingredients;
    }

    public int getIngredientByName(String name){
        for(Food ingredient : ingredients){
            if(ingredient.getName().equals(name)){
                return ingredients.indexOf(ingredient);
            }
        }
        return -1;
    }

    /**
     * sets the recipe to a string to send to other classes
     *
     * @return String
     */
    public String toString(){
        return String.format("Name: " +  name + " Calories: " + calories + " Fat: " + fats + " Carbs: " + carbs + " Proteins: " + protein + "%n");
    }

    public Food clone(Food obj, double servings){
        ArrayList<Food> ingredientsCopy = new ArrayList<>();
        if(obj instanceof BasicFood) {
            // it is a BasicFood
            BasicFood bCopy = (BasicFood) obj.clone(obj, obj.getServings());
            ingredientsCopy.add(bCopy);
        }
        else if(obj instanceof Recipe){
            // copy all of the ingredients and make a new list
            Recipe recipe = (Recipe) obj;
            for(Food aFood: recipe.getIngredients()){
                // it is a Recipe
                Food fCopy = aFood.clone(aFood, aFood.getServings());
                ingredientsCopy.add(fCopy);
            }
        }

        Recipe recipeCopy = new Recipe(obj.getName(), ingredientsCopy, servings);
        return recipeCopy;
    }
}
