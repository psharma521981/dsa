package neetcode150.two_pointers.prectice;

public class container_with_most_water {
    public int maxArea(int[] heights) {
        if(heights == null || heights.length < 2)
            return -1;

        int start = 0;
        int end = heights.length - 1;

        int maxArea = 0;

        while(start < end) {
           int tmpArea  = Integer.min(heights[start],heights[end]) * (end - start);
            maxArea = Integer.max(maxArea,tmpArea);

            if(heights[start] < heights[end])
             start++;
            else
             end--;


        }
        return maxArea;
    }
}
