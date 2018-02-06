/*
 * Manages the FoodLog by checking for, creating, and adding entries
 *@authors Team A
 *@version 1
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;

public class FoodListManager implements ActionListener{

   private FoodList foodList;

   /**
    * ActionListener for FoodFrame GUI
    *
    */
   @Override
   public void actionPerformed(ActionEvent e) {

   }

   /**
   * Constructor
   */
   public FoodListManager(FoodList foodList){
      this.foodList = foodList;
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
   public void createBasic(String name, double calories, double fats, double carbs, double protein){
        foodList.createNewBasic(name, calories, fats, carbs, protein);
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
    * get a food by name
    *
    * @param name the name of the food
    * @return  the Food object
    */
   public Food getFood(String name){
       return new BasicFood("name", 0, 0, 0, 0, 0);
   }
}