package src.miscellaneously.old.dsa.sorting;

public class QuickSort {

    public static void main(String[] args) {
        int[] a = new int[] { 5, 3, 7, 3, 2, 9, 4, 1, 15, 7, 100, 3, 99 };
        int length = a.length;
        quickSort(a, 0, length - 1);

        for (int i = 0; i < length; i++) {
            System.out.print(a[i] + "\t");
        }

    }

    private static void quickSort(int[] a, int left, int right) {

        if (left < right) {

            int partiion = pivotal(a, left, right);
            quickSort(a, left, partiion - 1);
            quickSort(a, partiion + 1, right);
        }

    }

    private static int pivotal(int[] a, int left, int right) {

        int pivotal = a[right];
        int i = left;
        int j = right;

        while (i < j) {

            while (a[i] <= pivotal && i < j)
                i++;
            while (a[j] >= pivotal && i < j)
                j--;
            
            swap(a, i, j);
                
        }
       swap(a,right,j);

        return j;
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}
