/**
 * Manages the ExerciseLog by checking for, creating, and adding entries
 *@authors Team A
 *@version 3.0
 */
 
 package controller ;

import model.ExerciseCollection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExerciseCollectionManager implements ActionListener{

    private ExerciseCollection exerciseList;

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
    public ExerciseCollectionManager(ExerciseCollection exerciseList){
        this.exerciseList = exerciseList;
    }

    /**
     * Checks if the exercise exists, if not creates a new Basic Exercise
     *
     * @param name       The name of the Exercise
     * @param calories   The calories for the Exercise
     */
    public void createExercise(String name, double calories)
    {
        if(!exerciseList.exerciseExsists(name)){
            exerciseList.createNewExercise(name, calories);
        }

    }
}