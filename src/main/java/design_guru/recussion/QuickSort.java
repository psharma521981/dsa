package recussion;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuickSort {
    public void sort(int[] array) {
       quickSort(array,0,array.length -1);
    }
    public List<Integer> sort(List<Integer> array) {
        int[] arr = array.stream().mapToInt(i->i).toArray();
        quickSort(arr,0,arr.length-1);

        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }

    private void quickSort(int[] array, int i, int j) {
        if(i<j) {
            int pivot = partition(array, i, j);
            quickSort(array, i, pivot-1);
            quickSort(array, pivot+1, j);
        }
    }

    private Integer partition (int[] array,int low, int high) {

        int pivot = array[high];
        int i = low;
        int partitionIndex = low;

        while(i<high) {
            if(array[i] <= pivot) {
                int tmp = array[partitionIndex];
                array[partitionIndex] = array[i];
                array[i] = tmp;
                partitionIndex++;
            }
            i++;
        }
        int tmp = array[partitionIndex];
        array[partitionIndex] = array[high];
        array[high] = tmp;

        return partitionIndex;
    }
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();

        // Example inputs
        int[][] examples = {
               {4, 2, 6, 8, 3},
                {10, 5, 3, 7, 2, 8, 6},
                {1, 2, 3, 4, 5}
        };

        for (int i = 0; i < examples.length; i++) {
            int[] array = examples[i];
            quickSort.sort(array);
            System.out.println("Sorted Array #" + (i + 1) + ": " + Arrays.toString(array));
        }
    }
}
