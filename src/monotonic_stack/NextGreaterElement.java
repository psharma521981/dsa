package monotonic_stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {
    //Input validation for null && size
    //Iterate over target array and put elements into stack such that stack peak is not less then element
    //if it is then pop that element and stored into hash map. It shows that who ask you to pop out from stack
    //Hash map represent the mapping that, which greater element eliminates the element
    //iterate over the source array and get the next greater element from hash map or get default.
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        if(nums1==null || nums2==null || nums1.length < 1 || nums2.length < 1)
            return null;

        Stack<Integer> greaterStack =new Stack<>();
        Map<Integer,Integer> greaterMap = new HashMap<>();

        for(int i=0;i<nums2.length;i++) {

                while(!greaterStack.empty() && greaterStack.peek() < nums2[i])
                    greaterMap.put(greaterStack.pop(), nums2[i]);

                greaterStack.push(nums2[i]);
            }

        for(int i =0;i< nums1.length;i++) {
            int nextElement =  greaterMap.getOrDefault(nums1[i], -1);
            nums1[i] = nextElement;
        }

        return nums1;


    }
    public static void main(String[] args) {
        NextGreaterElement solution = new NextGreaterElement();
        int[] nums1 = {4,2,6};
        int[] nums2 = {6,2,4,5,3,7};
        int[] output = solution.nextGreaterElement(nums1, nums2);
        for (int num : output)
            System.out.print(num + " ");
        System.out.println();
    }
}
