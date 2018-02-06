 /**
 * Implements and displays all of the JFrames in a tab format by calling other panels.
 *@authors Team A
 *@version 3.0
 */
 
 package view ;
 
import model.ExerciseCollection;
import model.FoodCollection;
import model.LogCollection;

import javax.swing.*;
import java.awt.*;

public class MainDisplay {

    private LogFoodPanel fFrame;
    private LogExercisePanel eFrame;
    private LogWeightAndCaloriePanel wFrame;
    private CreateFoodPanel afFrame;
    private CreateExercisePanel aeFrame;
    private HomePanel dFrame;

    JFrame mainFrame;

    /**
     * Creates the main window and implement all the JFrames
     */
    public MainDisplay(FoodCollection foodList, ExerciseCollection exerciseList, LogCollection userLog){
        fFrame = new LogFoodPanel(foodList, userLog);
        eFrame = new LogExercisePanel(exerciseList, userLog);
        wFrame = new LogWeightAndCaloriePanel(userLog, exerciseList);
        afFrame = new CreateFoodPanel(foodList, userLog);
        aeFrame = new CreateExercisePanel(exerciseList, userLog);
        dFrame = new HomePanel(userLog);
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
        tabbedPane.addTab("Log Foods", fFrame.display());
        tabbedPane.addTab("Log Exercises", eFrame.display());
        tabbedPane.addTab("Log Weight & Calories", wFrame.display());
        tabbedPane.addTab("Create Food", afFrame.display());
        tabbedPane.addTab("Create Exercise", aeFrame.display());

        mainFrame.add(tabbedPane);
        
        mainFrame.setSize(1050, 800);
        mainFrame.setVisible(true);
    }
}