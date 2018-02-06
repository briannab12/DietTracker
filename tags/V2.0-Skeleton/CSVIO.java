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
         System.err.println("FileNotFoundException reading file in");
         fnfe.printStackTrace();
      }
      catch(Exception e) {
         System.err.println("Exception reading file in");
         e.printStackTrace();
      }
      return items;
   };

   /**
    * Writes data to a CSV file
    *
    * @param file the file that data is being written to
    * @param toWrite the ArrayList of String[]s to be written to the file
    */
   public void write(String file, ArrayList<String[]> toWrite){
      File csvFile = new File(file);
      PrintWriter pw = null;

      for(String[] line : toWrite){
         String lineToWrite = "";
         for(String item : line){
            lineToWrite+=item+",";
         }
         lineToWrite+="\n";
         try{
            FileWriter fw = new FileWriter(csvFile);
            BufferedWriter bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            pw.write(lineToWrite);
         }
         catch(FileNotFoundException fnfe){
            System.err.println("FileNotFoundException writing to file");
            fnfe.printStackTrace();
         }
         catch(Exception e) {
            System.err.println("Exception writing to file");
            e.printStackTrace();
         }
      }
      pw.close();
   };

   /**
    * Writes data to a CSV file
    *
    * @param file the file that data is being written to
    * @param toWrite the String[] to be appended to the file
    */
   public void appendToFile(String file, String[] toWrite){
      File csvFile = new File(file);
      PrintWriter pw = null;

      String lineToWrite = "";
      int i = 0;
      for(String item : toWrite){
         if(i == 0){
            lineToWrite+=item;
            i++;
         } else {
            lineToWrite += "," + item;
         }
      }
      lineToWrite+="\n";
      try{
         FileWriter fw = new FileWriter(csvFile, true);
         BufferedWriter bw = new BufferedWriter(fw);
         pw = new PrintWriter(bw);

         pw.write(lineToWrite);
      }
      catch(FileNotFoundException fnfe){
         System.err.println("FileNotFoundException writing to file");
         fnfe.printStackTrace();
      }
      catch(Exception e) {
         System.err.println("Exception writing to file");
         e.printStackTrace();
      }

      pw.close();
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