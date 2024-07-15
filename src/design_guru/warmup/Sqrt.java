package warmup;

public class Sqrt {
    public int mySqrt(int x) {
        //Input validation if num < 2 then no need to check further
        //initialize low and high = num/2
        //start binary search and check for overflow and underflow
        //calculate square is less than num or not. Do binary search accordingly
        if(x<2)
            return x;

        int low=2,high=x/2;

        while(low<=high) {
            int mid = low + (high-low)/2;
            long square = (long) mid * mid;

            if(square < x)
                low = low + 1;
            else if (square > x)
                high = high - 1;
            else
                return mid;
        }

        return high;
    }
    // Check why - int mid = low + (high-low)/2;

    /* Alternative solution
    public int mySqrt(int x) {
    //Input validation
    if(x<2)
     return x;
    int low=2,high=x/2;
    while(low<=high) {
      int mid = low + (high-low)/2;
      long square = (long) mid * mid;
      if(square < x)
       low = low + 1;
      else if (square > x)
         high = high - 1;
      else
         return mid;
    }

    return high;
  }
     */
    public static void main(String[] args) {
        Sqrt solution = new Sqrt();

        int input1 = 4;
        int expectedOutput1 = 2;
        int result1 = solution.mySqrt(input1);
        System.out.println(result1 == expectedOutput1); // Expected output: true

        int input2 = 8;
        int expectedOutput2 = 2;
        int result2 = solution.mySqrt(input2);
        System.out.println(result2 == expectedOutput2); // Expected output: true

        int input4 = 2;
        int expectedOutput4 = 1;
        int result4 = solution.mySqrt(input4);
        System.out.println(result4 == expectedOutput4); // Expected output: true

        int input5 = 3;
        int expectedOutput5 = 1;
        int result5 = solution.mySqrt(input5);
        System.out.println(result5 == expectedOutput5); // Expected output: true

        int input6 = 15;
        int expectedOutput6 = 3;
        int result6 = solution.mySqrt(input6);
        System.out.println(result6 == expectedOutput6); // Expected output: true
    }
}
