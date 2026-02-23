package leetcode.two_pointers;

public class TrappingRainWater_42 {
    public int trap(int[] height) {

        if(height == null) {
            return -1;
        }

        int[] left = new int[height.length];
        int[] right = new int[height.length];

        int leftMax = height[0];
        int rightMax = height[height.length-1];
        int lastIdx = height.length -1;

        for(int i=0;i<height.length;i++) {
            leftMax = Math.max(leftMax,height[i]);
            left[i] = leftMax;
            rightMax = Math.max(rightMax,height[lastIdx-i]);
            right[lastIdx-i] = rightMax;
        }

        int sumOfWater = 0;

        for(int i=0;i<height.length;i++) {
            int h = Math.min(left[i],right[i]) * 1 - height[i];
            sumOfWater+=h;
        }

        return   sumOfWater;
    }
}
