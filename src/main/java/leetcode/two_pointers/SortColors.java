package leetcode.two_pointers;

public class SortColors {
    public void sortColors(int[] nums) {

        if(nums == null)
            return;

        int tmp;
        for(int i=0;i<nums.length;i++) {
            for(int j=i+1;j<nums.length;j++) {
                if(nums[i] > nums[j]) {
                    tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }
    //3 Pointers approach
    public void sortColorsThreePointers(int[] nums) {

        if(nums == null)
            return;

        int tmp;
        int i = 0;
        int j = 0;
        int k = nums.length - 1;

        while(j <= k) {

            if(nums[j] == 0) {
                tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j++;
                i++;
            } else if (nums[j] == 2) {
                tmp = nums[k];
                nums[k] = nums[j];
                nums[j] = tmp;
                k--;
            } else {
                j++;
            }
        }
    }
}
