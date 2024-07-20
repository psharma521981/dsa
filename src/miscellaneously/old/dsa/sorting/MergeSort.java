package src.miscellaneously.old.dsa.sorting;

public class MergeSort {

    public static void main(String[] args) {
        int[] a = new int[] { 5, 3, 7, 3, 2, 9, 4, 1 }; ///
        int length = a.length;
        mergeSort(a, 0, length - 1);

        for (int i = 0; i < length; i++) {
            System.out.print(a[i] + "\t");
        }

    }

    private static void mergeSort(int[] a, int left, int right) {
        // divide array into sub arrays
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(a, left, mid);
            mergeSort(a, mid + 1, right);
            merge(a, left, mid, right);
        }
    }

    private static void merge(int[] a, int left, int mid, int right) {

        // Size of left subarray
        int i = mid - left + 1;
        int j = right - mid;

        int[] leftArray = new int[i];
        int[] rightArray = new int[j];

        for (int l = 0; l < i; l++) {
            leftArray[l] = a[left + l];
        }

        for (int r = 0; r < j; r++) {
            rightArray[r] = a[mid + 1 + r];
        }
        int l = 0;
        int r = 0;
        int k = left;

        while (l < i && r < j) {

            if (leftArray[l] <= rightArray[r]) {
                a[k++] = leftArray[l++];
            } else {
                a[k++] = rightArray[r++];
            }
        }

        while (l < i) {
            a[k++] = leftArray[l++];
        }
        while (r < j) {
            a[k++] = rightArray[r++];
        }
    }

}
