package warmup;

import java.util.HashMap;
import java.util.Map;

public class NumberOfGoodPairs {
    public int numGoodPairs(int[] nums) {
        int pairCount = 0;
        //Input validation
        //Calculate the frequency of each number
        //count the pairs and pairs is -1 from frequency

        if(nums==null || nums.length<=1)
            return pairCount;

        Map<Integer,Integer> pairMap = new HashMap();

        for(int i=0;i<nums.length;i++) {
            if(pairMap.get(nums[i]) != null && pairMap.get(nums[i])>=1) {
                pairMap.put(nums[i],pairMap.get(nums[i])+1);
                pairCount+=pairMap.get(nums[i])-1;
            } else {
                pairMap.put(nums[i],1);
            }
        }

        return pairCount;
    }
    /* Alternative solution
    int pairCount = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int n : nums) {
      map.put(n, map.getOrDefault(n, 0) + 1); // increment the count of 'n' in the map
      // every new occurrence of a number can be paired with every previous occurrence
      // so if a number has already appeared 'p' times, we will have 'p-1' new pairs
      pairCount += map.get(n) - 1;
    }
    return pairCount;
     */
    public static void main(String[] args) {
        NumberOfGoodPairs sol = new NumberOfGoodPairs();

        int[] nums1 = { 1, 2, 3, 1, 1, 3 };
        int result1 = sol.numGoodPairs(nums1);
        System.out.println("Result 1: " + result1 + " (Expected: 4)");

        int[] nums2 = { 1, 1, 1, 1 };
        int result2 = sol.numGoodPairs(nums2);
        System.out.println("Result 2: " + result2 + " (Expected: 6)");

        int[] nums3 = { 1, 2, 3 };
        int result3 = sol.numGoodPairs(nums3);
        System.out.println("Result 3: " + result3 + " (Expected: 0)");
    }
}
