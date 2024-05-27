package two_pointers.leetcode;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length < 1)
            return -1;

        int index = 0;

        for(int i =0 ;i< nums.length;i++) {
            if(nums[i] != val)
                nums[index++] = nums[i];
        }

        return index;
    }
}
