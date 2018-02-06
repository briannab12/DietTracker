/**
 * Class that generates  the bar graph canvas for the weight pane
 *
 * @author TeamA
 * @version 3.0
 */
 
 package view ;
 
import controller.LogCollectionManager;
import model.LogCollection;

import java.awt.Canvas ;
import java.awt.Color ;
import java.awt.Dimension ;
import java.awt.Graphics ;
import java.awt.Rectangle ;

import java.util.*;

public class NutritionBarGraphCanvas extends Canvas implements Observer {

    private LogCollection userLog;
    private double fats;
    private double carbs;
    private double protein;
    private int fatsHeight;
    private int carbsHeight;
    private int proteinHeight;
    private LogCollectionManager logManager;

    public NutritionBarGraphCanvas(LogCollection userLog) {
        /*
         * Set preferred and minimum sizes.
         */

        this.setPreferredSize(new Dimension(300,300));

        this.userLog = userLog ;
        userLog.addObserver(this) ;

        this.logManager = new LogCollectionManager(userLog);
        this.update(userLog, userLog);


    }

    /*
     * Update received.
     * Check that this update is one we are interested in.
     * Convert the current temperature in whatever base to a
     * string and change the label.
     */
    public void update(Observable obs, Object o) {

        /*
         * Return on spurious update from unknown observable.
         */
        if( obs != userLog ) {
            return ;
        }

        // get the nutrition for each day

        fats = userLog.getFatsOnDay(userLog.getDateObj());
        carbs = userLog.getCarbsOnDay(userLog.getDateObj());
        protein = userLog.getProteinOnDay(userLog.getDateObj());
        this.repaint();
    }

    /*
     * Paint the canvas with a bar graph of the last few samples.
     * This is called as an indirect consequence of "repaint"
     * which it turn is called in "update".
     */
    public void paint(Graphics g) {
        /*
         * Determine the height and width of the canvas.
         */
        Rectangle bounds = g.getClipBounds() ;
        int w = (int) bounds.getWidth() ;
        int h = (int) bounds.getHeight() ;

        /*
         * Determine the width of each bar in the sample.
         */
        int barWidth = w / 3 ;

        // get the max value
        double maxVal = fats;
        if(carbs > fats){
            maxVal = carbs;
        }
        if (protein > maxVal){
            maxVal = protein;
        }

        /*
         *  fat (red), carbohydrates(green), and protein(blue) from left to right.
         */
        g.setColor(Color.RED) ;
        g.setPaintMode();
        fatsHeight = (int)(h * (fats / maxVal));
        g.fillRect(0*barWidth, h-fatsHeight, barWidth, fatsHeight);

        g.setColor(Color.GREEN) ;
        g.setPaintMode();
        carbsHeight = (int)(h * (carbs / maxVal));
        g.fillRect(1*barWidth, h-carbsHeight, barWidth, carbsHeight);

        g.setColor(Color.BLUE) ;
        g.setPaintMode();
        proteinHeight = (int)(h * (protein / maxVal));
        g.fillRect(2*barWidth, h-proteinHeight, barWidth, proteinHeight);

    }
}
