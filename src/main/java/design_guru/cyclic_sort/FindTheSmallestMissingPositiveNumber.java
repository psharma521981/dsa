package design_guru.cyclic_sort;

public class FindTheSmallestMissingPositiveNumber {
    public int findNumber(int[] nums) {

        if(nums == null || nums.length < 1)
            return -1;

        int index = 0;
        int length = nums.length;

        while(index < length) {

            if(nums[index] > 0 && nums[index] <= length && nums[index] != nums[nums[index] - 1])
                swap(nums,index,nums[index] - 1);
            else
                index++;
        }
        index = 0;

        while(index < length) {
            if(nums[index] != index + 1) {
                return index + 1;
            }
            index++;
        }
        return length+1;
    }

    private void swap(int[] nums, int source, int target) {
        int tmp = nums[source];
        nums[source] = nums[target];
        nums[target] = tmp;
    }

    public static void main(String[] args) {
        FindTheSmallestMissingPositiveNumber sol = new FindTheSmallestMissingPositiveNumber();
        System.out.println(
                sol.findNumber(new int[] { -3, 1, 5, 4, 2 }));
        System.out.println(
                sol.findNumber(new int[] { 3, -2, 0, 1, 2 }));
        System.out.println(
                sol.findNumber(new int[] { 3, 2, 5, 1 }));
    }
}
