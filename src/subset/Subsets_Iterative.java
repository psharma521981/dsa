package src.subset;

import java.util.ArrayList;
import java.util.List;

public class Subsets_Iterative {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> powerSet = new ArrayList<>();
        //Adding empty Set
        powerSet.add(new ArrayList<>());

        for(int i=0;i<nums.length;i++) {
            int n = powerSet.size();

            for(int j=0;j<n;j++) {
                List<Integer> currentList = new ArrayList<>(powerSet.get(j));
                currentList.add(nums[i]);
                powerSet.add(currentList);
            }
        }
        return powerSet;
    }
}
