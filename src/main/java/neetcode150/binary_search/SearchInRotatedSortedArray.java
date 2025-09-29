package neetcode150.binary_search;
/*

Given an array of numbers which is sorted in ascending order and also rotated by some arbitrary number, find if a given ‘key’ is present in it.

Write a function to return the index of the ‘key’ in the rotated array. If the ‘key’ is not present, return -1. You can assume that the given array does not have any duplicates.

Example 1:

Input: [10, 15, 1, 3, 8], key = 15
Output: 1
Explanation: '15' is present in the array at index '1'.

 */
public class SearchInRotatedSortedArray {
    public int search(int[] arr, int key) {

        if(arr == null || arr.length < 1)
            return -1;

        int start = 0;
        int end = arr.length - 1;

        while(start <=  end) {

            int mid = (start + end)/2;

            if(arr[mid] == key)
                return mid;

            if(arr[start] <= arr[mid]) {
                if(key >= arr[start] && key < arr[mid]) {
                    end = mid -1;
                } else {
                    start = mid + 1;
                }
            } else {
                if(key > arr[mid] && key <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray sol = new SearchInRotatedSortedArray();
        System.out.println(sol.search(new int[] { 10, 15, 1, 3, 8 }, 15));
        System.out.println(sol.search(
                new int[] { 4, 5, 7, 9, 10, -1, 2 }, 10));
    }
}
