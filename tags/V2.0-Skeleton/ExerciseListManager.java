/*
 * Manages the ExerciseLog by checking for, creating, and adding entries
 *@authors Team A
 *@version 1
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;

public class ExerciseListManager implements ActionListener{

    private ExerciseList exerciseList;

    /**
     * ActionListener for ExerciseFrame GUI
     *
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    /**
     * Constructor
     */
    public ExerciseListManager(ExerciseList exerciseList){
        this.exerciseList = exerciseList;
    }

    /**
     * Checks if the exercise exists, if not creates a new Basic Exercise
     *
     * @param name       The name of the Exercise
     * @param calories   The calories for the Exercise
     */
    public void createExercise(String name, double calories){
        exerciseList.createNewExercise(name, calories);
    }
}