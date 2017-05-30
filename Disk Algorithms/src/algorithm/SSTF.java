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
public class SSTF extends Algorithm {

    @Override
    public void solveProblem(ArrayDeque<Integer> requestQueue, int startPoint) {
        int size = requestQueue.size();
        int number = startPoint;
        for (int i = 0; i < size; i++) {
         int neighbour = findClosestNeighbour(number, requestQueue);
         this.totalDistanceTravelled += Math.abs(number - neighbour);
         this.proccessedRequests.add(neighbour);
         number = neighbour;
         requestQueue.remove(neighbour);
        }
        this.averageSeekLength = (double) totalDistanceTravelled / size;
    }
    
    
    private int findClosestNeighbour(int number , ArrayDeque<Integer> list){
        int currentMinDistance = Math.abs(number - list.getFirst());
        int curMinIndex = 0;
        ArrayList<Integer> copyList = new ArrayList<>(list);
        for (int i = 0; i < copyList.size(); i++) {
            if(currentMinDistance > Math.abs(number - copyList.get(i))){
              currentMinDistance = Math.abs(number - copyList.get(i));
              curMinIndex  = i;
            }
        }
        return copyList.get(curMinIndex);
    }

}
