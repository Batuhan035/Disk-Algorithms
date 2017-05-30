/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import java.util.ArrayDeque;

/**
 *
 * @author batuhan
 */
public class FIFO extends Algorithm {

    @Override
    public void solveProblem(ArrayDeque<Integer> requestQueue, int startPoint) {
        int size = requestQueue.size();
        int prev = requestQueue.getFirst();
        for (int i = 0; i < size; i++) {
            int next = requestQueue.poll();
            if (i == 0) {
                this.totalDistanceTravelled += Math.abs(startPoint - next);
            } else {
                this.totalDistanceTravelled += Math.abs(next - prev);

            }
            prev = next;

            this.proccessedRequests.add(next);
        }
        this.averageSeekLength = (double) totalDistanceTravelled / size;
    }

}
