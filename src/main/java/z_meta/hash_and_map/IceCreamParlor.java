package src.z_meta.hash_and_map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IceCreamParlor {
    /*
    Two friends like to pool their money and go to the ice cream parlor. They always choose two distinct flavors and they spend all of their money.
Given a list of prices for the flavors of ice cream, select the two that will cost all of the money they have.
     */
    public static List<Integer> icecreamParlor(int m, List<Integer> arr) {
        //related to two sum problem
        if(arr==null || arr.size() < 2)
            return null;
        Map<Integer,Integer> diffToIndexMap = new HashMap<>();
        List<Integer> outputIndex = new ArrayList<>();
        for(int i=0;i<arr.size();i++) {
            if(diffToIndexMap.get(m-arr.get(i)) !=null)  {
                outputIndex.add(diffToIndexMap.get(m-arr.get(i)));
                outputIndex.add(i+1);

                return outputIndex;
            } else {
                diffToIndexMap.put(arr.get(i),i+1);
            }
        }
        return null;
    }
}
