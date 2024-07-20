package src.miscellaneously.old.others;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//TODO
// Function to right custom sort 
//increasing order of frequency & decreasing order of value for same frequency 
public class CustomSort {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[] input = new int[] { -1, 1, -6, 4, 5, -6, 1, 4, 1 };

        customSort(input);
        // Print the array


    }

    private static void customSort(int[] input) {

        // Input validation

        if (input == null)
            return;

        // Count the frequency
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int i : input) {
            frequencyMap.put(i, frequencyMap.getOrDefault(i, 0) + 1);
        }

        // Iterate over the frequency and add into the queue
        PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                return p1.frequency - p2.frequency;
            }
        });
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            queue.offer(new Pair(entry.getKey(), entry.getValue()));
        }

        // Itereate over the qeueue and compare the frequency
        PriorityQueue<Integer> decreasingOrderQueue = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer p1, Integer p2) {
                return p1 - p2;
            }
        });

        int[] output = new int[input.length];
        int index = 0;
        while (!queue.isEmpty()) {

            Pair pair = queue.poll();
            // Poll till next frequency encountered
            for (int i = 1; i < pair.frequency; i++) {
                decreasingOrderQueue.add(pair.number);
                output[index++] = pair.number;
            }

        }
        for (int i : output) {
            System.out.print(i + ",");
        }
    }
}

class Pair {

    int number;
    int frequency;

    Pair(int number, int frequency) {
        this.number = number;
        this.frequency = frequency;
    }
}
