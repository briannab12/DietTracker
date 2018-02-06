/**
 * Implements and displays all of the JFrames in a tab format
 */
public class Display{

    private FoodFrame fFrame;
    private WeightFrame wFrame;
    private AddFoodFrame afFrame;
    private DashboardFrame dFrame;

    /**
     * Creates the main window and implement all the JFrames
     */
    public Display(FoodList foodList, UserLog userLog){
        fFrame = new FoodFrame(foodList);
        wFrame = new WeightFrame(userLog);
        afFrame = new AddFoodFrame(foodList, userLog);
        dFrame = new DashboardFrame(userLog);
    }

    public void displayAll(){
        // Display all the panels
        fFrame.display();
        //wFrame.display();
        //afFrame.display();
        //dFrame.display();
    }
}