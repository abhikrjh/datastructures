package blind75;

/*
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:
Input: n = 2
Output: 2

Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps


Example 2:
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

*/

public class ClimbingStairs {

    private static int climbStairs(int n) {

        // base condition , for first two staircase n=1 and n=2
        if (n == 1) return 1;
        if (n == 2) return 2;

        // ways(n) = ways(n-1) + ways(n-2) // fibonacci series

        // to reach step 3

        int oneStepsBefore = 2; // ways to reach step 2
        int twoStepsBefore = 1; // ways to reach step 1

        int allWays = 0;

        for (int i = 3; i <= n; i++) {

            allWays = oneStepsBefore + twoStepsBefore;

            twoStepsBefore = oneStepsBefore;

            oneStepsBefore = allWays;
        }

        return allWays;
    }

    public static void main(String[] args) {

        int steps = 4;

        int allWays = climbStairs(steps);

        System.out.println(allWays);
    }
}
