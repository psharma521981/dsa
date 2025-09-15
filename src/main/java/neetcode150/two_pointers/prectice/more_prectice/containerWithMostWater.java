package neetcode150.two_pointers.prectice.more_prectice;

public class containerWithMostWater {
    public int maxArea(int[] heights) {

        if(heights == null)
            return -1;

        int start = 0;
        int end = heights.length - 1;
        int maxArea = 0;
        while(start < end) {
            int tmpArea = 0;

            tmpArea = Math.min(heights[start],heights[end]) * (end - start);
            maxArea = Math.max(maxArea,tmpArea);

            if(heights[start] < heights[end]) {
                start++;
            } else {
                end--;
            }
        }

        return maxArea;
    }
}
