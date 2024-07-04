package recussion;

public class PerfectSquare {
    public static boolean isPerfectSquare(int num) {
        if(num <= 1)
            return false;

        return checkPefectSuare(num,num/2);

    }

    private static boolean checkPefectSuare(int num, int i) {
        if(i<=1)
            return false;

        if(num == (i*i))
            return true;

        return checkPefectSuare(num,--i);
    }
    public static void main(String[] args) {
        int[] examples = {16, 14, 9};

        for (int num : examples) {
            boolean isPerfect = isPerfectSquare(num);
            System.out.println(num + " is a perfect square: " + isPerfect);
        }
    }
}
