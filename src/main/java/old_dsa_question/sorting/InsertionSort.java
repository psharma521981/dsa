package src.miscellaneously.old.dsa.sorting;

public class InsertionSort {

    public static void main(String[] args) {
        int[] a = new int[] { 5, 3, 7, 3, 2, 9, 4, 1 };
        int length = a.length;
        inserttionSort(a, length);

        for (int i = 0; i < length; i++) {
            System.out.print(a[i] + "\t");
        }

    }

    private static void inserttionSort(int[] a, int n) {

        int start = 0;
        for (int i = 1; i < n; i++) {
            int j = i;
           
            while (j > start) {
                if (a[j] < a[j - 1]) {
                    int tmp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = tmp;
                }
                j--;

            }
            
            

        }

    }

}
