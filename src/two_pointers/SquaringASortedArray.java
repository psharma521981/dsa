package two_pointers;

public class SquaringASortedArray {
    public static int[] makeSquares(int[] arr) {
        int n = arr.length;
        int[] squares = new int[n];
        // TODO: Write your code here
        int right = n-1;
        int left = 0;
        int index = 0;
        int leftSquare = 0;
        int rightSquare = 0;
        for (int i=0;i<n;i++) {
            leftSquare = arr[left] * arr[left];
            rightSquare = arr[right] * arr[right];
            if(leftSquare>=rightSquare) {
                squares[n-1-i] = leftSquare;
                left++;
            } else {
                squares[n-1-i] = rightSquare;
                right--;
            }
        }
        return squares;
    }
    /* Alternative solution
     for (int i=0;i<n;i++) {
      leftSquare = arr[left] * arr[left];
      rightSquare = arr[right] * arr[right];
        if(leftSquare>=rightSquare) {
          squares[n-1-i] = leftSquare;
          left++;
        } else {
            squares[n-1-i] = rightSquare;
            right--;
        }
        }
        return squares;
     */
    public static void main(String[] args) {
        int[] result = SquaringASortedArray.makeSquares(new int[] { -2, -1, 0, 2, 3 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();

        result = SquaringASortedArray.makeSquares(new int[] { -3, -1, 0, 1, 2 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();
    }
}
