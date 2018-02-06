/**
 * This creates the exercise objects
 *@authors Team A
 *@version 3.0
 */
 
 package model ;
 
 import javax.swing.*;
import java.util.*;

 
public class ExerciseCollection extends Observable{
    // a list of Exercise objects where the key is a the name of the exercise
    private HashMap<String,Exercise> exerciseList = new HashMap<>();

    private String name;
    private IOInterface csv;
    private String exCSV;

    /**
     * Default constructor
     * takes in no params and sets all variables to empty
     */
    public ExerciseCollection(String fileName){
        csv = new CSVIO();
        exCSV = fileName;
        loadExerciseData();
    }

    /**
     * Creates an exercise object
     * @param exName The name of the exercise
     * @param exCalories The calories burnt for a 100lb person in 1hr
     */
    public void createExercise(String exName, double exCalories){
        Exercise exercise = new Exercise(exName, exCalories);
        exerciseList.put(exName, exercise);
    }

    /**
     * Creates a new exercise in the CSV and adds it to the exercise list
     *
     * @param name       The name of the Exercise
     * @param calories   The calories for the Exercise
     */
    public void createNewExercise(String name, double calories){
        Exercise exercise = new Exercise(name, calories);
        exerciseList.put(name, exercise);

        setChanged();
        notifyObservers();

        String[] toWrite = {"e","",""};
        toWrite[1] = name;
        toWrite[2] = ""+calories;
        csv.appendToFile(exCSV, toWrite);
    }


    /**
     * Load the data from the exercise CSV file and create exercise objects
     */
    public void loadExerciseData(){
        ArrayList<String[]> exStrings = csv.read(exCSV);

        //Get each exercise from the arraylist and create exercise objects
        for(String[] exString : exStrings) {
            // makes sure the item is an exercise
            if(exString[0].equals("e")){
                createExercise( exString[1], Double.parseDouble(exString[2]) );
            }
        }

        setChanged();
        notifyObservers();
    }

    /**
     * get the list of all the Exercises
     * @return   the list of all the Exercises
     */
    public ArrayList<Exercise> getAllExercises(){
        Collection<Exercise> values = exerciseList.values();
        ArrayList<Exercise> listOfExercises = new ArrayList<Exercise>(values);
        return listOfExercises;
    }

    /**
     * get a exercise by name
     *
     * @param name the name of the Exercise
     * @return  the Exercise object
     */
    public Exercise getExercise(String name){
        return exerciseList.get(name);
    }

    /**
     *  Checks if an Exercise already exists
     * @param name
     * @return
     */
    public boolean exerciseExsists(String name){
        if (exerciseList.containsKey(name)){
            return true;
        }
        else
        {
            return false;
        }
    }


}
