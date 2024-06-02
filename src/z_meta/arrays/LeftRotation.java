package meta.arrays;

import java.util.List;

public class LeftRotation {
    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        reverseArray(arr,0,arr.size()-1);
        reverseArray(arr,d-1,0);
        reverseArray(arr,0,d-1);
        return arr;
    }

    public static void reverseArray(List<Integer> arr,int left,int right) {

        int tmp;
        while(left<right) {
            tmp = arr.get(left);
            arr.set(left,arr.get(right));
            arr.set(right,tmp);
            left++;
            right--;
        }

    }

}
