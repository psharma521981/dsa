package recussion;

public class Factorial {

    public static int calculateFactorial(int number) {
        // TODO: Write your code here
        if(number < 0)
            return number;
        if(number == 0)
            return 1;

        return number * calculateFactorial(number - 1);
    }

    public static void main(String[] args) {
        // Example inputs
        int[] examples = {5, 7, 1};

        for (int number : examples) {
            int factorial = calculateFactorial(number);
            System.out.println("Factorial of " + number + ": " + factorial);
        }
    }
}
