package two_pointers;

import java.util.Arrays;

public class Triplet_Sum_Close_to_Target {
    public static int searchTriplet(int[] arr, int targetSum) {
        if(arr==null || arr.length < 3)
            return 0;
        Arrays.sort(arr);

       int minimumDifference = Integer.MAX_VALUE;
       int sumCloseToTarget =  Integer.MAX_VALUE;
        //{ -3, -1, 1, 2 }
        for(int i=0;i<arr.length-2;i++) {
            int start = i+1;
            int end = arr.length - 1;

            while(start < end) {
                int tripletSum = arr[i] + arr[start] + arr[end];
                if(Math.abs(targetSum - tripletSum) <= Math.abs(minimumDifference) && tripletSum < Math.abs(sumCloseToTarget)) {
                    minimumDifference = Math.abs(targetSum - tripletSum);
                    sumCloseToTarget = tripletSum;
                }
               if(tripletSum==targetSum)
                   return tripletSum;
               if(tripletSum < targetSum)
                   start++;
               else
                   end--;
            }

        }

        return sumCloseToTarget;
    }
    public static void main(String[] args) {

        System.out.println(
                Triplet_Sum_Close_to_Target.searchTriplet(new int[] { -3, -1, 1, 2 }, 1));

        System.out.println(
                Triplet_Sum_Close_to_Target.searchTriplet(new int[] { -1, 0, 2, 3 }, 2));

        System.out.println(
                Triplet_Sum_Close_to_Target.searchTriplet(new int[] { 1, 0, 1, 1 }, 100));
        System.out.println(
                Triplet_Sum_Close_to_Target.searchTriplet(new int[] { 0, 0, 1, 1, 2, 6 }, 5));
    }
}
