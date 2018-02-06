/*
 * Manages the FoodLog by checking for, creating, and adding entries
 *@authors Team A
 *@version 1
 */
public class FoodListManager{

   /**
   * Constructor
   */
   public FoodListManager(){

   }

   /**
   * Checks if the food exists, if not creates a new Basic Food
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
   * Checks if the food exists, if not creates a new Recipe
   *
   * @param name       The name of the recipe
   * @param foodList   The list of Foods that make up the recipe
   */
   public void createRecipe(String name, ArrayList<Food> foodList){

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