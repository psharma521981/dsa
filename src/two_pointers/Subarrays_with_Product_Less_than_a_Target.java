package two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subarrays_with_Product_Less_than_a_Target {
    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // TODO: Write your code here

        if(arr==null)
            return result;

       int start = 0;
       int end = arr.length;
       int product = 1;
       while(start<end) {
           List<Integer> location = new ArrayList<>();
           result.add(location);
           product = arr[start];
           while(product<target) {
               location = new ArrayList<>();
               product+=arr[++start];
               location.add(start);

           }
           result.add(location);

       }
    return result;

    }
    public static void main(String[] args) {
        System.out.println(findSubarrays(new int[] { 2, 5, 3, 10 }, 30));
        System.out.println(findSubarrays(new int[] { 8, 2, 6, 5 }, 50));
    }
}
