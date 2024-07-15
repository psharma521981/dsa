package recussion;

import java.util.HashMap;

public class FibonnaciWithMemoization {

        // Create a map for memoization
        static HashMap<Integer, Integer> cache = new HashMap<>();

        static int fibonacci(int n) {
            // If value is in cache, return it
            if (cache.containsKey(n)) {
                return cache.get(n);
            }

            int result;

            // Set base cases
            if (n == 0) {
                result = 0;
            }
            else if (n == 1) {
                result = 1;
            }
            else {
                // Compute the Fibonacci number recursively
                result = fibonacci(n - 1) + fibonacci(n - 2);
            }

            // Store the result in cache before returning
            cache.put(n, result);
            return result;
        }

        public static void main(String[] args) {
            int n = 10;
            System.out.println("Fibonacci number of " + n + " is " + fibonacci(n));
        }
}
