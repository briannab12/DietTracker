import controller.FoodCollectionManager;
import controller.LogCollectionManager;
import model.ExerciseCollection;
import model.FoodCollection;
import model.LogCollection;
import view.MainDisplay;

/**
 * Inializes the GUI, FoodManager and UserLogManager
 *@authors Team A
 *@version 3.0
 */
public class UserMain {
   private static FoodCollection foodList;
   private static ExerciseCollection exerciseList;
   private static LogCollection userLog;
   private static MainDisplay display;
   private static String foodFileName = "recipefoods.csv";
   private static String exerciseFileName = "exercises.csv";
   private static String userFileName = "log.csv";

   /**
    * Initialize the display, food manager and user log manager
    */
   public UserMain(){
      // Display needs to know about FoodList and UserLog so it can call FoodList.addObserver(this)
      foodList = new FoodCollection(foodFileName);
      exerciseList = new ExerciseCollection(exerciseFileName);
      userLog = new LogCollection(userFileName, foodList, exerciseList);
      display = new MainDisplay(foodList, exerciseList, userLog);
   }
   
   /**
    * Creates a new User
    */
   public static void main(String [] args){
      new UserMain();
      display.displayAll();
   }
}