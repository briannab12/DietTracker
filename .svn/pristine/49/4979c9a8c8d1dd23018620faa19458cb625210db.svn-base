/*
 * Creates and deletes entries from the food list
 *
 *@authors Team A
 *@version 1
 */

import java.util.*;

public class FoodList extends Observable{
   
    // a list of Food objects where the key is a the name of the food
    private HashMap<String,Food> foodList = new HashMap<>();

    // the name of the CSV file containing all of the Foods
    private String foodCSV;

    private IOInterface csv;

    /**
     * Constructor
     */
    public FoodList(String fileName){
        csv = new CSVIO();
        foodCSV = fileName;
        loadFoodData();
    }

    /**
     * Creates a new Basic Food in the CSV and adds it to the food list
     *
     * @param name       The name of the Food
     * @param carbs      The carbs for the Food
     * @param fat       The fats for the Food
     * @param protein    The protein for the Food
     * @param calories   The calories for the Food
     */
    public void createBasic(String name, double calories, double fat, double carbs, double protein){
        Food food = new BasicFood(name, calories, fat, carbs, protein);

        foodList.put(name, food);

        setChanged();
        notifyObservers();
    }

    /**
     * Creates a new Basic Food in the CSV and adds it to the food list
     *
     * @param name       The name of the Food
     * @param carbs      The carbs for the Food
     * @param fat       The fats for the Food
     * @param protein    The protein for the Food
     * @param calories   The calories for the Food
     */
    public void createNewBasic(String name, double calories, double fat, double carbs, double protein){
        Food food = new BasicFood(name, calories, fat, carbs, protein);
        foodList.put(name, food);

        setChanged();
        notifyObservers();

        String[] toWrite = {"b","","","","",""};
        toWrite[1] = name;
        toWrite[2] = ""+calories;
        toWrite[3] = ""+fat;
        toWrite[4] = ""+carbs;
        toWrite[5] = ""+protein;
        csv.appendToFile(foodCSV, toWrite);
    }

    /**
     * Creates a new Recipe in the CSV and adds it to the food list
     *
     * @param name      The name of the recipe
     * @param foodsInRecipe  The list of Foods in the recipe
     */
    public void createRecipe(String name, ArrayList<Food> foodsInRecipe){
        Food food = new Recipe(name, foodsInRecipe);
        foodList.put(name, food);
        setChanged();
        notifyObservers();
    }

    /**
     * Load the data from the food CSV file and create Food objects
     */
    public void loadFoodData(){
        ArrayList<String[]> foodStrings = csv.read(foodCSV);

        //Get each basic food from the foods arraylist create food objects
        for(String[] foodArray : foodStrings) {
            // makes sure the item is a basic food
            if(foodArray[0].equals("b")){
                createBasic(foodArray[1], Double.parseDouble(foodArray[2]),Double.parseDouble(foodArray[3]), Double.parseDouble(foodArray[4]), Double.parseDouble(foodArray[5]));
            }
        }

        //Get each recipe from the foods arraylist create food objects
        for(String[] foodArray : foodStrings) {
            // makes sure the item is a recipe
            if (foodArray[0].equals("r")){
                //holds all the foods in a recipe
                ArrayList<Food> recipeFoods = new ArrayList<Food>();
                //for each food in a recipe, create new food obj and set servings
                for (int i = 2; i < foodArray.length; i+=2) {
                    Food food = foodList.get(foodArray[i]);
                    Double servings = Double.parseDouble(foodArray[i+1]);
                    Food foodClone = food.clone(food, servings);
                    recipeFoods.add(foodClone);
                }
                //create a recipe with all of the foods in the recipe
                createRecipe(foodArray[1], recipeFoods);
            }
        }
        setChanged();
        notifyObservers();
    }

    /**
     * Log the data from HashMap to the CSV file
     */
    public void saveFoodData(){

    }

    /**
     * get the list of all the Foods
     * @return   the list of all the foods
     */
    public ArrayList<Food> getAllFoods(){
        Collection<Food> values = foodList.values();
        ArrayList<Food> listOfFood = new ArrayList<Food>(values);
        return listOfFood;
    }

    /**
     * get a food by name
     *
     * @param name the name of the food
     * @return  the Food object
     */
    public Food getFood(String name){
        return foodList.get(name);
    }
}