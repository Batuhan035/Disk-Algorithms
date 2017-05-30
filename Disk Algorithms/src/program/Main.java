/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program;

import algorithm.FIFO;
import algorithm.SCAN;
import algorithm.SSTF;
import java.io.File;
import java.util.ArrayDeque;

/**
 *
 * @author batuhan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Read Track Requests
       FileReader reader  = new FileReader(new File("tracks.txt"));
        
       // Put them into a Queue
       ArrayDeque<Integer> headMovements = reader.readTrackMovements();
        
        // Define Start Point
        int startPoint = 100;
        
        // Define Algorithms
        FIFO f = new FIFO();
        SSTF ss = new SSTF();
        SCAN sc = new SCAN();
        
        // Solve with FIFO
        f.solveProblem(new ArrayDeque<Integer>(headMovements),startPoint);
        System.out.println("Name of Algorithm :"+f.getClass().getSimpleName());
        System.out.println("Total Distance :"+f.getTotalDistanceTravelled());
        System.out.printf("Average Seek Time : %.2f\n",f.getAverageSeekLength());
        System.out.println("Schedule Order :"+f.getProccessedRequests());
        
        System.out.println("----------------------------------------------------------------------------------------------------");
        
        // Solve with SSTF
        ss.solveProblem(new ArrayDeque<Integer>(headMovements),startPoint);
        System.out.println("Name of Algorithm :"+ss.getClass().getSimpleName());
        System.out.println("Total Distance :"+ss.getTotalDistanceTravelled());
        System.out.printf("Average Seek Time :%.2f\n",ss.getAverageSeekLength());
        System.out.println("Schedule Order :"+ss.getProccessedRequests());
        
        System.out.println("----------------------------------------------------------------------------------------------------");
       
        // Solve with SCAN
        sc.solveProblem(new ArrayDeque<Integer>(headMovements),startPoint);
        System.out.println("Name of Algorithm :"+sc.getClass().getSimpleName());
        System.out.println("Total Distance :"+sc.getTotalDistanceTravelled());
        System.out.printf("Average Seek Time :%.2f\n",sc.getAverageSeekLength());
        System.out.println("Schedule Order :"+sc.getProccessedRequests());
    }
    
}
