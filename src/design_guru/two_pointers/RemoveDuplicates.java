package two_pointers;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
    public static int remove(int[] arr) {
        if(arr==null || arr.length==1)
            return 1;

        int first = 0;
        int second = 1;
        Set<Integer> uniqueNum = new HashSet<>();
        while(first<arr.length && second<arr.length) {

            if(uniqueNum.contains(arr[first])) {
                while(arr[first]!=arr[second]) {
                    second++;
                }
                int temp = arr[first];
                arr[first] = arr[second];
            } else {
                uniqueNum.add(arr[first]);
            }
            first++;
        }
        return uniqueNum.size();
    }
    /* Alternate solution
    int nextNonDuplicate = 1; // index of the next non-duplicate element
    for (int i = 0; i < arr.length; i++) {
      if (arr[nextNonDuplicate - 1] != arr[i]) {
        arr[nextNonDuplicate] = arr[i];
        nextNonDuplicate++;
      }
    }

    return nextNonDuplicate;
     */
    public static void main(String[] args) {
        int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
        System.out.println(RemoveDuplicates.remove(arr));

        arr = new int[] { 2, 2, 2, 11 };
        System.out.println(RemoveDuplicates.remove(arr));
    }
}
