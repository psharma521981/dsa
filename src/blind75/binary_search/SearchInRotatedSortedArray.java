package src.blind75.binary_search;

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
