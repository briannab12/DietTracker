/**
 * Inializes the GUI, FoodManager and UserLogManager
 */
public class User{
   private static FoodList foodList;
   private static UserLog userLog;
   private static Display display;
   private static FoodListManager foodListManager;
   private static UserLogManager userLogManager;
   private static String foodFileName = "recipefoods.csv";

   /**
    * Initialize the display, food manager and user log manager
    */
   public User(){
      // Display needs to know about FoodList and UserLog so it can call FoodList.addObserver(this)
      foodList = new FoodList(foodFileName);
      userLog = new UserLog("fileName");
      display = new Display(foodList, userLog);
      foodListManager = new FoodListManager(foodList);
      userLogManager = new UserLogManager(userLog);
   }
   
   /**
    * Creates a new User
    */
   public static void main(String [] args){
      User user = new User();
      display.displayAll();
   }
}