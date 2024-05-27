package recussion;

import java.util.Arrays;

public class MergeSort {
    public static int[] mergeSort(int[] arr) {

        mergeSortHelper(arr,arr.length);

        return arr;
    }

    private static void mergeSortHelper(int[] arr, int len) {
        if(len < 2)
            return;

        int mid = len /2;

        int[] left = new int[mid];
        int[] right = new int[len-mid];

        int i;
        for(i=0;i<mid;i++)
            left[i] = arr[i];
        for(;i<len;i++)
            right[i-mid] = arr[i];

        mergeSortHelper(left,mid);
        mergeSortHelper(right,len-mid);
        merge(arr,left,right,mid,len-mid);
    }

    private static void merge(int[] arr,int[] left, int[] right, int leftLen, int rightLen) {

        int i=0,j=0,k=0;

        while(i<leftLen && j<rightLen) {
            if(left[i] <= right[j])
                arr[k++] = left[i++];
            else
                arr[k++] = right[j++];
        }

        while(i<leftLen)
            arr[k++] = left[i++];
        while(j<rightLen)
            arr[k++] = right[j++];
    }


    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 3, 1, 6};

        System.out.println("Input Array:");
        System.out.println(Arrays.toString(arr));

        mergeSort(arr);

        System.out.println("Sorted Array:");
        System.out.println(Arrays.toString(arr));
    }
}
