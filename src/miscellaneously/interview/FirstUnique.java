package src.miscellaneously.interview;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FirstUnique {
    Map<Integer, Integer> frequency = new LinkedHashMap<>();
    List<Integer> listOrder = new LinkedList<>();

    /*
     * 
     * FirstUnique(int[] nums) Initializes the object with the numbers in the queue.
     * int showFirstUnique() returns the value of the first unique integer of the
     * queue, and returns -1 if there is no such integer. void add(int value) insert
     * value to the queue.
     * 
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    FirstUnique(int[] nums) {

        if (nums == null || nums.length < 1)
            throw new RuntimeException();

        for (int i = 0; i < nums.length - 1; i++) {

            frequency.put(nums[i], frequency.getOrDefault(nums[i], 0) + 1);

        }

        shuffleData(frequency);
    }

    int showFirstUnique() {

        if (listOrder.size() > 0) {
            return listOrder.get(0);
        }

        return -1;

    }

    void add(int value) {
        frequency.put(value, frequency.getOrDefault(value, 0) + 1);
        shuffleData(frequency);

    }

    void shuffleData(Map<Integer, Integer> frequency) {
        listOrder = new LinkedList<>();
        for (Integer key : frequency.keySet()) {
            if (frequency.get(key) == 1) {
                listOrder.add(key);
            }

        }
    }

}
