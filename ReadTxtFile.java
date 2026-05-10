/*
 * Sara Sunny
 * Lab 3 - Problem 1 - Class File
 */
package sunny_lab3_prob1;

/**
 *
 * @author slbru
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;

public class ReadTxtFile {

    int row, column;
    String array[][];
    
    File f = new File("DataFile.txt");
    
    public ReadTxtFile(){
        row = 1;
        column = 0;
    }
    public void ReadFile(){ //determines # of rows and columns
    
        try(Scanner in = new Scanner(f)) {                                  
            column = in.nextLine().split("\t").length; //determines number of columns
       
            int counter = 1; 
        
            while (in.hasNext()){   //determines number of rows
                in.next();
                if (counter == column) {
                    counter = 1;
                    row++;              
                }
                else {
                    counter++;
                }
            }
        }    
        catch (Exception e){
            e.printStackTrace();    
        }
        
        try(Scanner in = new Scanner(f)) {      //reads file into array
            array = new String[row][column];
            for (int i=0; i<row; i++){
                for (int j=0; j< column; j++){
                    if(in.hasNext()){
                        array[i][j] = in.next();
                    }
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void DisplayArray(){             //display array to check
       for(int i=0; i<row; i++){            
           for (int j=0; j< column; j++){
               System.out.printf("%.1f,\t ", array[i][j]);
           }
           System.out.println();
       }
   }
    
    public void ReWriteFile(){              //rewrites file into a csv with commas between values
        try(Scanner in = new Scanner(f)) {
            try(FileWriter f2= new FileWriter ("DataFile.csv")){
                for(int i=0; i < row; i++){
                    for (int j=0; j < column; j++){
                        f2.write(array[i][j] + ", ");   
                    }  
                    f2.write("\n");           
                }
            } 
        }
        catch (Exception e){
            e.printStackTrace();
        }
    } 
}
