package recussion;

public class CheckPrime {
    public static boolean isPrime(int number) {
        // TODO: Write your code here
        int start = 2;

        return checkPrime(start,number);
    }

    private static boolean checkPrime(int start, int number) {
        if(start>=number || number==1)
            return true;

        if (number % start == 0)
            return false;

        return checkPrime(++start,number);

    }

    public static void main(String[] args) {
        // Example inputs
        int[] examples = {7, 12, 23};

        for (int example : examples) {
            boolean isPrime = isPrime(example);
            System.out.println(example + " is prime: " + isPrime);
        }
    }

}
