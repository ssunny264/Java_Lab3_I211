/*
 * Sara Sunny
 * Lab 3 - Problem 1 - Main
 */
package sunny_lab3_prob1;

/**
 *
 * @author slbru
 */
public class Sunny_Lab3_Prob1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ReadTxtFile doc = new ReadTxtFile();
        
        doc.ReadFile();
        
        //doc.DisplayArray();
        
        doc.ReWriteFile();
        
        System.out.println();
    }
    
}
