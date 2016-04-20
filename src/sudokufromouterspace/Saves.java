/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokufromouterspace;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jeanaguilar
 */
public class Saves {

//Easy txt files for saving    
    File easySave1 = new File("/Users/jeanaguilar/NetBeansProjects/SudokuFromOuterSpace/SavesEasy/Save1.txt");
    File easySave2 = new File("/Users/jeanaguilar/NetBeansProjects/SudokuFromOuterSpace/SavesEasy/Save2.txt");
    File easySave3 = new File("/Users/jeanaguilar/NetBeansProjects/SudokuFromOuterSpace/SavesEasy/Save3.txt");
    File easySave4 = new File("/Users/jeanaguilar/NetBeansProjects/SudokuFromOuterSpace/SavesEasy/Save4.txt");

//Medium txt files for saving
    File mediumSave1 = new File("/Users/jeanaguilar/NetBeansProjects/SudokuFromOuterSpace/SavesMed/Save1.txt");
    File mediumSave2 = new File("/Users/jeanaguilar/NetBeansProjects/SudokuFromOuterSpace/SavesMed/Save2.txt");
    File mediumSave3 = new File("/Users/jeanaguilar/NetBeansProjects/SudokuFromOuterSpace/SavesMed/Save3.txt");
    File mediumSave4 = new File("/Users/jeanaguilar/NetBeansProjects/SudokuFromOuterSpace/SavesMed/Save4.txt");

//Hard txt files for saving
    File hardSave1 = new File("/Users/jeanaguilar/NetBeansProjects/SudokuFromOuterSpace/SavesHard/Save1.txt");
    File hardSave2 = new File("/Users/jeanaguilar/NetBeansProjects/SudokuFromOuterSpace/SavesHard/Save2.txt");
    File hardSave3 = new File("/Users/jeanaguilar/NetBeansProjects/SudokuFromOuterSpace/SavesHard/Save3.txt");
    File hardSave4 = new File("/Users/jeanaguilar/NetBeansProjects/SudokuFromOuterSpace/SavesHard/Save4.txt");

    public void Save(File saveSlot, int[][] saveMatrix) {

        try {

            PrintWriter writer = new PrintWriter(saveSlot);
            Files.deleteIfExists(saveSlot.toPath());

            PrintStream output = new PrintStream(saveSlot);

            for (int r = 0; r < saveMatrix.length; r++) {

                for (int c = 0; c < saveMatrix[r].length; c++) {
                    String save = "";
                    save += "" + saveMatrix[r][c];
                    output.println(save);
                }

            }
            JOptionPane.showMessageDialog(null, "Juego guardado correctamente");
        } catch (FileNotFoundException j) {
            j.printStackTrace();
            System.out.println("No existe tal archivo.");
        } catch (IOException ex) {
            Logger.getLogger(Saves.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


   

   
