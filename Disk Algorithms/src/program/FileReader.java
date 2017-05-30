/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author batuhan
 */
public class FileReader {

    File sourceFile;

    public FileReader(File sourceFile) {
        this.sourceFile = sourceFile;

    }

    public ArrayDeque<Integer> readTrackMovements() {
        ArrayDeque<Integer> trackMovements = new ArrayDeque<>();
        try {
            Scanner input = new Scanner(sourceFile);
            while (input.hasNext()) {
                int next = Integer.parseInt(input.next());
                trackMovements.add(next);
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Track file not found");
        }
        return trackMovements;
    }

}
