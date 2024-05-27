package cyclic_sort;

public class Cyclic_Sort {
    public static int[] sort(int[] nums) {
        // TODO: Write your code here

        if(nums==null)
            return nums;

       int left = 0;
       while(left<nums.length) {

           if(nums[left]==left+1) {
               left++;
               continue;
           }
           swap(nums,left,nums[left]-1);
       }
        return nums;
    }

    private static void swap(int[] nums, int a,int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b]= tmp;

    }

    public static void main(String[] args) {
        int[] arr = new int[] { 3, 1, 5, 4, 2 };
        Cyclic_Sort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[] { 2, 6, 4, 3, 1, 5 };
        Cyclic_Sort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[] { 1, 5, 6, 4, 3, 2 };
        Cyclic_Sort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }
}
