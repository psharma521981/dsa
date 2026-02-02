package leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class InterSectionOf2Arrays_349 {
    public int[] intersection(int[] nums1, int[] nums2) {


        if(nums1 == null || nums2 == null) {
            return new int[0];
        }

        Set<Integer> unique = new HashSet<>();

        for(int i=0;i<nums1.length;i++) {
            unique.add(nums1[i]);
        }
        Set<Integer> unique2 = new HashSet<>();
        for(int i=0;i<nums2.length;i++) {
            if(unique.contains(nums2[i])) {
                unique2.add(nums2[i]);
            }
        }

        return unique2.stream().mapToInt (i -> i).toArray();


           /* Arrays.sort(nums1);
            Arrays.sort(nums2);

            Set<Integer> unique = new HashSet<>();

            int i = 0;
            int j = 0;

            int len1 = nums1.length;
            int len2 = nums2.length;

            while(i < len1 && j < len2) {

                if(nums1[i] == nums2[j]) {
                    unique.add(nums1[i]);
                    i++;
                    j++;
                } else if(nums1[i] < nums2[j]) {
                    i++;
                } else {
                    j++;
                }
            }

            return unique.stream().mapToInt(k -> k).toArray();*/
    }
}
