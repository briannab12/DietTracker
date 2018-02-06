/**
 * An interface for all of the GUI JFrame classes
 *@authors Team A
 *@version 3.0
 */
 
 package view;
 
import javax.swing.*;

interface Panel{

    /**
     * create and display the GUI elements
     */
    public JPanel display();

    /**
     * create a JPanel
     *
     * @return a JPanel
     */
    public JPanel createPanel();

    /**
     * create a JLabel with the specified text
     *
     * @param text  the text for the label
     * @return  a JLabel object
     */
    public JLabel createLabel(String text);

    /**
     * create a JTextFeild
     *
     * @param text the text for the label
     * @return a JTextFeild object
     */
    public JTextField createTextField(String text);

    /**
     * create a JButton
     * @param text  the text for the button
     * @return  a JButton
     */
    public JButton createButton(String text);
}