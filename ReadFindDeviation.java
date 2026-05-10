/*
 * Sara Sunny
 * Lab 3 - Problem 2 - Class File
 */
package sunny_lab3_prob2;

/**
 *
 * @author slbru
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;

public class ReadFindDeviation {

    int row = 0, column = 0;
    Double[][] array;
    //Double[][] array2;

    public ReadFindDeviation() {
        column = 0;
        row = 1;
    }

    File f = new File("DataFile.txt");

    public void Read() {

        try ( Scanner in = new Scanner(f)) {
            column = in.nextLine().split("\t").length; //determines number of columns

            int counter = 1;

            while (in.hasNext()) {                       //determines number of rows
                in.next();
                if (counter == column) {
                    counter = 1;
                    row++;
                } else {
                    counter++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try ( Scanner in = new Scanner(f)) {      //reads file into array
            array = new Double[row][column];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    if (in.hasNext()) {
                        array[i][j] = in.nextDouble();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Deviation() {                 // Finding the Standard Deviation
        Double array2[][] = new Double[2][column];
        int colCounter = 0;
        Double colTotal;
        Double devTotal;

        for (int i = 0; i < column; i++) {
            colTotal = 0.0;
            for (int j = 0; j < row; j++) {
                colTotal += array[j][i];
            }
            double mean = colTotal / row;
            array2[0][i] = mean;        //stores mean
        }
        for (int i = 0; i < column; i++) {
            devTotal = 0.0;
            for (int j = 0; j < row; j++) {
                devTotal += Math.pow((array[j][i] - array2[0][i]), 2);
            }
            double deviation = Math.sqrt(devTotal / row);
            array2[1][i] = deviation;   //stores deviation 
        }
        try(FileWriter f2 = new FileWriter("DataFile.csv")) {      //Rewriting file to end in csv format
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < column; j++) {
                    f2.write(array2[i][j] + ", ");
                }
                f2.write("\n");
            }
        }
        catch (Exception e){
               e.printStackTrace();
               }
    }
}
