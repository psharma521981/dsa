package src.blind75.dp;

public class ClimbingStaircase {
    public int countWays(int n) {

        // base case, we don't need to take any step, so there is only one way
        if(n==0)
            return 1;

        if(n == 1)
            return 1; // we can take one step to reach the end, and that is the only way

        if(n == 2)
            return 2; // we can take one step twice or jump two steps to reach at the top

        if(n < 0)
            return 0;

        return countWays(n-1) +  countWays(n-2) +  countWays(n-3);

    }
    public static void main(String[] args) {
        ClimbingStaircase sc = new ClimbingStaircase();
        System.out.println(sc.countWays(3));
        System.out.println(sc.countWays(4));
        System.out.println(sc.countWays(5));
    }
}
