package two_pointers;

public class PairWithTargetSum {
    public static int[] search(int[] arr, int targetSum) {
        // TODO: Write your code here
        int[] targetIndex = new int[2];
        targetIndex[0] = -1;
        targetIndex[1] = -1;
        if(arr==null)
            return targetIndex;



        int start =0;
        int finish = arr.length -1;

        while(start<finish) {
            if(targetSum<arr[start]+arr[finish]) {
                finish--;
            } else if(targetSum>arr[start]+arr[finish]) {
                start++;
            } else {
                targetIndex[0] = start;
                targetIndex[1] = finish;
                break;
            }

        }
        return targetIndex;
    }
    /* Alternate solution
    int left = 0, right = arr.length - 1;
  while (left < right) {
    int currentSum = arr[left] + arr[right];
    if (currentSum == targetSum)
        return new int[] { left, right }; // found the pair

    if (targetSum > currentSum)
        left++; // we need a pair with a bigger sum
    else
        right--; // we need a pair with a smaller sum
  }
  return new int[] { -1, -1 };
     */
    public static void main(String[] args) {
        int[] result = PairWithTargetSum.search(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = PairWithTargetSum.search(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    }
}
