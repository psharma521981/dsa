package src.blind75.two_pointers;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0; // To store the maximum area found

        if(height==null || height.length < 1)
            return -1;

        int left = 0;
        int right = height.length - 1;
        while(left < right) {
            int minHeight = Math.min(height[left],height[right]);

            maxArea = Math.max(maxArea, minHeight * (right-left));

            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
    public static void main(String[] args) {
        ContainerWithMostWater sol = new ContainerWithMostWater();
        System.out.println(sol.maxArea(new int[]{1,3,2,4,5})); // 9
        System.out.println(sol.maxArea(new int[]{5,2,4,2,6,3})); // 20
        System.out.println(sol.maxArea(new int[]{2,3,4,5,18,17,6})); // 17
    }
}
