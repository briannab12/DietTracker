/*
 * Creates and deletes entries from the food list
 *
 *@authors Team A
 *@version 1
 */
public class FoodList{
   
    // a list of Food objects where the key is a the name of the food
    private HashMap<String,Food> foodList;

    // the name of the CSV file containing all of the Foods
    private String foodCSV;

    /**
    * Constructor
    */
    public FoodList(){

    }

    /**
     * Creates a new Basic Food in the CSV and adds it to the food list
     *
     * @param name       The name of the Food
     * @param carbs      The carbs for the Food
     * @param fats       The fats for the Food
     * @param protein    The protein for the Food
     * @param calories   The calories for the Food
     */
    public void createBasic(String name, double carbs, double fats, double protein, double calories){

    }

    /**
     * Creates a new Recipe in the CSV and adds it to the food list
     *
     * @param name      The name of the recipe
     * @param foodList  The list of Foods in the recipe
     */
    public void createRecipe(String name, ArrayList<Food> foodList){

    }

    /**
     * Load the data from the food CSV file
     */
    public void loadFoodData(){

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

    }

    /**
     * get a food by name
     *
     * @param name the name of the food
     * @return  the Food object
     */
    public Food getFood(String name){

    }
}