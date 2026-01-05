package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {

        if(nums  == null)
            return false;

        Set<Integer> checkDuplicateMap = new HashSet<>();
        for (int i=0;i<nums.length;i++) {
            if(!checkDuplicateMap.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    //HashSet approach also one solution
}
