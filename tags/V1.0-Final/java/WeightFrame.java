import javax.swing.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class WeightFrame extends JFrame implements Observer,Frame  {
    // attributes
    private JFrame frame;
    private JButton jbSet;
    private JLabel jlPounds;
    private JTextField jtfWeight;

    /**
     * Display the Jpanel for the Weight GUI
     */
    public void display() {
        frame.setLayout(null);
        frame.setVisible(true);
    } // End of Display

    /**
     * The Weight GUI constructor
     */
    public WeightFrame(UserLog userLog)    {
        frame = new JFrame();
    }

    /**
     * Creates a Frame to display the graph of user's weight
     * @return JFrame showing graph
     */
    public JFrame weightGraph(){
        return new JFrame();
    }

    /**
     * create a JTextFeild
     *
     * @param text the text for the label
     * @return a JTextFeild object
     */
    public JTextField createTextField(String text) {
        return new JTextField(text);
    }

    /**
     * Create a button
     * @param  name
     * @return a button
     */
    public JButton createButton(String name) {
        return new JButton();
    }

    /**
     * Creates a label
     * @param name
     * @return a label
     */
    public JLabel createLabel(String name){
        return new JLabel();
    }

    /**
     * Creates a panel to use for weight
     * @return a JPanel
     */
    public JPanel createPanel() {
        return new JPanel();
    }

    public void update(Observable observable, Object args){

    }
}// end of WeightFrame
