package recussion;

public class Greatest_Common_Divisor {
    public static int calculateGCD(int A, int B) {
        // TODO: Write your code here

        if(A < B) {
            return GCD(A,B,A);
        } else {
            return GCD(A,B,B);
        }
    }
    public static int GCD(int A,int B, int target) {

        if(A % target ==0 && B % target==0)
            return target;
        else{
            return GCD(A,B,target--);
        }
    }
    public static void main(String[] args) {
        // Example inputs
        int[][] examples = {{12, 18}, {25, 15}, {40, 60}};

        for (int[] example : examples) {
            int A = example[0];
            int B = example[1];
            int gcd = calculateGCD(A, B);
            System.out.println("GCD of " + A + " and " + B + " is: " + gcd);
        }
    }
}
