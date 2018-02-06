import javax.swing.*;
import java.awt.*;

/**
 * Implements and displays all of the JFrames in a tab format
 */
public class Display{

    private FoodPanel fFrame;
    private ExercisePanel eFrame;
    private WeightPanel wFrame;
    private AddFoodPanel afFrame;
    private AddExercisePanel aeFrame;
    private DashboardPanel dFrame;

    JFrame mainFrame;

    /**
     * Creates the main window and implement all the JFrames
     */
    public Display(FoodList foodList, ExerciseList exerciseList, UserLog userLog){
        fFrame = new FoodPanel(foodList, userLog);
        eFrame = new ExercisePanel(exerciseList, userLog);
        wFrame = new WeightPanel(userLog);
        afFrame = new AddFoodPanel(foodList, userLog);
        aeFrame = new AddExercisePanel(exerciseList, userLog);
        dFrame = new DashboardPanel(userLog);
        mainFrame = new JFrame("Diet Manager");
    }

    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }

    public void displayAll(){
        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Home", dFrame.display());
        tabbedPane.addTab("Foods", fFrame.display());
        tabbedPane.addTab("Exercises", eFrame.display());
        tabbedPane.addTab("Weight", wFrame.display());
        tabbedPane.addTab("Add Food", afFrame.display());
        tabbedPane.addTab("Add Exercise", aeFrame.display());

        mainFrame.add(tabbedPane);
        
        mainFrame.setSize(350, 500);
        mainFrame.setVisible(true);
    }
}