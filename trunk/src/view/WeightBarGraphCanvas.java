/**
 * Class that generates the bar graph canvas for the weight pane over the most recent 10 days
 *
 * @author TeamA
 * @version 3.0
 */
 
 package view;

import controller.LogCollectionManager;
import model.DailyLogEntry;
import model.LogCollection;

import java.awt.Canvas ;
import java.awt.Color ;
import java.awt.Dimension ;
import java.awt.Graphics ;
import java.awt.Rectangle ;
import java.util.*;

public class WeightBarGraphCanvas extends Canvas implements Observer {

    private LogCollection userLog;
    private final double samples[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } ;
    private LogCollectionManager logManager;

    public WeightBarGraphCanvas(LogCollection userLog) {
        /*
         * Set preferred and minimum sizes.
         */
        this.setPreferredSize(new Dimension(500,400));

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

        // get the weights for each of the days
        HashMap<Date,DailyLogEntry> dailyLogs = logManager.getDailyLogs();
        ArrayList<DailyLogEntry> list = new ArrayList<DailyLogEntry>(dailyLogs.values());
        Collections.sort(list);
        Collections.reverse(list);
        int listCount = 0;
        for(int i = 9; i>=0; i--){
            if (listCount >= list.size()){
                break;
            }
            samples[i] = list.get(listCount).getWeight();
            listCount++;
        }

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
        int barWidth = w / samples.length ;

        g.setColor(Color.DARK_GRAY) ;
        g.setPaintMode() ;

        /*
         * Draw the bar graph, translating the y coordinate so that
         * the bars grow "up".
         */
        for( int i = 0 ; i < samples.length ; i++ ) {
            int height = h * (int)samples[i] / 300 ;
            g.fillRect(i*barWidth, h-height, barWidth, height);
            int num = h-height;
        }
    }
}
