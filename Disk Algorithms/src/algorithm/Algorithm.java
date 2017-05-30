/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 *
 * @author batuhan
 */
public abstract class Algorithm {
    
    int totalDistanceTravelled;
    double averageSeekLength;
    ArrayList<Integer> proccessedRequests;

    public Algorithm() {
        this.totalDistanceTravelled = 0;
        this.averageSeekLength = 0;
        this.proccessedRequests = new ArrayList<>();
    }
    
    public abstract void solveProblem(ArrayDeque<Integer> requestQueue , int startPoint);

    public int getTotalDistanceTravelled() {
        return totalDistanceTravelled;
    }

    public double getAverageSeekLength() {
        return averageSeekLength;
    }

    public ArrayList<Integer> getProccessedRequests() {
        return proccessedRequests;
    }
    
    
}
