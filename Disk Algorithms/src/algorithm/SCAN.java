/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author batuhan
 */
public class SCAN extends Algorithm {

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

    private int findClosestNeighbour(int number, ArrayDeque<Integer> list) {
        ArrayList<Integer> copyList = new ArrayList<>(list);
        ArrayList<Integer> biggerValues = new ArrayList<>();
        
        int next = 0;
        for (int i = 0; i < copyList.size(); i++) {
            if (copyList.get(i) > number) {
                biggerValues.add(copyList.get(i));
            }
        }
        if (biggerValues.size() > 0) {
            next = Collections.min(biggerValues);
        } else {
            next = Collections.max(list);
        }

        return next;
    }

}
