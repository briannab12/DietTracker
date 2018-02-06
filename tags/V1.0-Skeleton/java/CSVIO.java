/*
 * IO class for reading/writing CSV files
 *@authors Team A
 *@version 1
 */

public class CSVIO implements IOInterface{

   /**
    * Constructor
    */
   public CSVIO(){
   
   }

   /**
    * Reads in data from a CSV file
    *
    * @param file the file that data is being read from
    * @return an ArrayList of Strings where each line is a new item in the array
    */
   public ArrayList<String> read(String file){

   };

   /**
    * Writes data to a CSV file
    *
    * @param File the file that data is being written to
    * @param toWrite the string to be written to the file
    */
   public void write(String file, String toWrite){

   };

   /**
    * Deletes data from a CSV file
    *
    * @param file the file that data is being deleted from
    * @param toWrite the string to be written to the file
    */
   public void delete(String file, String toWrite){

   };

}