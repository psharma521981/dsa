package design_guru.two_pointers;

public class Dutch_National_Flag_Problem {
    public static int[] sort(int[] arr) {
        // TODO: Write your code here
        if(arr==null)
        return arr;

        int left = 0;
        int right = arr.length-1;
        int tmp = 0;
        int start = 0;

        while(left<right) {

           if(arr[left] > arr[right]) {
               tmp = arr[left];
               arr[left] = arr[right];
               arr[right] = tmp;
               left++;
           } else if(arr[left] == arr[right]) {
               right--;
           } else {
               while(arr[start]<arr[left]) {
                   tmp = arr[left];
                   arr[left] = arr[start];
                   arr[start] = tmp;
                   start++;
               }
               start = 0;
           }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 0, 2, 1, 0 };
        Dutch_National_Flag_Problem.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[] { 2, 2, 0, 1, 2, 0 };
        Dutch_National_Flag_Problem.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
    }
}
