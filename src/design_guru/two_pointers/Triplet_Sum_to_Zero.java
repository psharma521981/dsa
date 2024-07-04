package two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triplet_Sum_to_Zero {

    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();
        // TODO: Write your code here

        if(arr==null || arr.length<3)
            return triplets;

        Arrays.sort(arr);

        for(int i=0;i<arr.length-2;i++) {
            if(arr[i]!=arr[i+1])
            searchPair(arr,i,triplets);
        }
        return triplets;
    }

    private static void searchPair(int[] arr, int i, List<List<Integer>> triplets) {

        int start = i+1;
        int end = arr.length - 1;

        while(start<end) {
            int sum = arr[i]+arr[start]+arr[end];
            if( sum == 0) {
                triplets.add(Arrays.asList(arr[i],arr[start],arr[end]));
                start++;
                end--;

                while (start<end && arr[start] == arr[start+1])
                    start++;
                while(start<end && arr[end] == arr[end-1])
                    end--;
            } else if(sum < 0) {
                start++;
            } else {
                end--;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Triplet_Sum_to_Zero.searchTriplets(
                new int[] { -3, 0, 1, 2, -1, 1, -2 }));
        System.out.println(Triplet_Sum_to_Zero.searchTriplets(new int[] { -5, 2, -1, -2, 3 }));
    }
}
