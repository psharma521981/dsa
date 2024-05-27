package cyclic_sort;

//Validae the input
//intuition is that each array index having same value as index
public class Find_the_Missing_Number {
    public static int findMissingNumber(int[] nums) {
        // TODO: Write your code here
        if(nums==null)
          return -1;

        int left = 0;

        while(left<nums.length) {

            if(nums[left] < nums.length && nums[left] != nums[nums[left]]) {
                swap(nums, left,nums[left]);
            } else {
                left++;
            }
        }

        left = 0;

        while(left<nums.length) {
            if(left!=nums[left])
                return left;

            left++;
        }

        return -1;
    }

    private static void swap(int[] nums, int a,int b) {

            int tmp = nums[a];
            nums[a] = nums[b];
            nums[b] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(Find_the_Missing_Number.findMissingNumber(new int[] { 4, 0, 3, 1 }));
        System.out.println(Find_the_Missing_Number.findMissingNumber(
                new int[] { 8, 3, 5, 2, 4, 6, 0, 1 }));
    }
}
