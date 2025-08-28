package two_pointers.leetcode;

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {

        if(height==null || height.length < 1)
            return -1;

        int start = 0;
        int end = height.length-1;

        int maxArea = Integer.MIN_VALUE;
        int tmpArea = 0;
        while(start< end) {
            int minHeight = Math.min(height[start],height[end]);
            tmpArea = minHeight * (end-start);
            maxArea = Math.max(maxArea,tmpArea);

            if(height[start]<=height[end])
                start++;
            else
                end--;
        }
        return maxArea;
    }

    public static void main(String s[]) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(ContainerWithMostWater.maxArea(height));

        int[] height1 = {1,1};
        System.out.println(ContainerWithMostWater.maxArea(height1));
    }

}
