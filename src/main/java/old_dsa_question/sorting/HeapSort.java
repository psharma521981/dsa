package src.miscellaneously.old.dsa.sorting;

public class HeapSort {

    public static void main(String[] args) {
        int[] a = new int[] { 5, 3, 7, 3, 2, 9, 4, 1, 15, 20, 16, 22 };
        int length = a.length;
        buildHeap(a);
        heapSort(a, length - 1);

        for (int i = 0; i < length; i++) {
            System.out.print(a[i] + "\t");
        }

    }

    private static void heapSort(int[] a, int last) {


        for (int i = last; i >= 0; i--) {
            swap(a, i, 0);
            heapify(a, i - 1, 0);
        }

    }

    private static void heapify(int[] a, int n, int i) {

        int leftChild = i * 2;
        int rightChild = i * 2 + 1;
        int largest = i;

        if (leftChild <= n && a[leftChild] > a[largest])
            largest = leftChild;

        if (rightChild <= n && a[rightChild] > a[largest])
            largest = rightChild;



        if (i != largest) {
            swap(a, i, largest);

            heapify(a, n, largest);
        }

    }

    private static void buildHeap(int[] a) {

        int length = a.length - 1;

        for (int i = length / 2; i >= 0; i--) {
            heapify(a, length, i);
        }

    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;

    }

}
