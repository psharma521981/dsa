package blind75.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Sort the array
//skip the duplicate and pick the first item
//check for rest of the 2 items by two left & right pointers and make sure to validate the duplicate elements
//if found the sum ==0 then add to triplet
public class Three_3_Sum {
    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();

        if(arr == null || arr.length < 3)
            return triplets;

        Arrays.sort(arr);

        int last = arr.length - 1;

        for(int i=0;i<arr.length-2;i++) {
            if(i==0 || arr[i]!=arr[i-1])
             searchTriplet(arr,i, i+1, last, triplets);
        }
        return triplets;
    }

    private static void searchTriplet(int[] arr, int i,int start, int last, List<List<Integer>> triplets) {

        while(start < last) {
            int sum = arr[i] + arr[start] + arr[last];
            if(sum==0) {
                List<Integer> triplet = new ArrayList<>();
                triplet.add(arr[i]);
                triplet.add(arr[start]);
                triplet.add(arr[last]);
                triplets.add(triplet);
                start++;
                last--;
                while(start < last && arr[start]==arr[start-1])
                    start++;
                while(start < last && arr[last]==arr[last+1])
                    last--;
            } else if(sum > 0)
                        last--;
                    else
                        start++;
        }
    }
    public static void main(String[] args) {
        System.out.println(Three_3_Sum.searchTriplets(
                new int[] { -3, 0, 1, 2, -1, 1, -2 }));
        System.out.println(Three_3_Sum.searchTriplets(new int[] { -5, 2, -1, -2, 3 }));
        System.out.println(Three_3_Sum.searchTriplets(new int[] {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6}));
    }
}
