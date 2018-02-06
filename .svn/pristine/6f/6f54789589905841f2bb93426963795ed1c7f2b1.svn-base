import java.io.*;
import java.util.*;

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
    * @return an ArrayList<String[]> where each arraylist item is a food item with info split in []
    */
   public ArrayList<String[]> read(String file){
      ArrayList<String[]> items = new ArrayList<String[]>();

      File csvFile = new File(file);
      BufferedReader br = null;
      String line = "";
      String cvsSplitBy = ",";

      try{
         br = new BufferedReader(new FileReader(csvFile));
         while((line = br.readLine()) != null) {
            String[] item = line.split(",");
            items.add(item);
         }
      }
      catch(FileNotFoundException fnfe){
         fnfe.printStackTrace();
      }
      catch(Exception e) {
         e.printStackTrace();
      }
      return items;
   };

   /**
    * Writes data to a CSV file
    *
    * @param file the file that data is being written to
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