package cyclic_sort;

public class FindTheDuplicateNumber {
    public int findNumber(int[] nums) {

        if(nums == null || nums.length < 1)
            return -1;

        int index =0 ;

        while(index < nums.length) {
            if(nums[index] != index + 1) {
                if(nums[index] != nums[nums[index]]) {
                    swap(nums,index,nums[index]);
                } else {
                    return nums[index];
                }
            } else {
                index++;
            }
        }

        return -1;
    }

    private void swap(int[] nums, int index, int num) {
        int temp = nums[index];
        nums[index] = nums[num];
        nums[num] = temp;

    }

    public static void main(String[] args) {

        FindTheDuplicateNumber sol = new FindTheDuplicateNumber();
        System.out.println(sol.findNumber(new int[] { 1, 4, 4, 3, 2 }));
        System.out.println(sol.findNumber(new int[] { 2, 1, 3, 3, 5, 4 }));
        System.out.println(sol.findNumber(new int[] { 2, 4, 1, 4, 4 }));
    }
}
