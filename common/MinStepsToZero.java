package common;
/*
Given an integer N, the task is to count the minimum steps required to reduce the value of N to 0
by performing the following two operations:

Consider integers A and B where N = A * B (A != 1 and B != 1), reduce N to min(A, B)
Decrease the value of N by 1
Examples :


Input: N = 3
Output: 3
Explanation:
Steps involved are 3 -> 2 -> 1 -> 0
Therefore, the minimum steps required is 3.

Input: N = 4
Output: 3
Explanation:
Steps involved are 4->2->1->0.
Therefore, the minimum steps required is 3.
*/

public class MinStepsToZero {
    public static int minSteps(int n) {
        int steps = 0;

        while (n > 0) {
            boolean divided = false;

            // Try to divide by smallest factor
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    n = n / i; // Divide the number
                    divided = true;
                    break;
                }
            }

            // If no factors, just subtract 1
            if (!divided) {
                n--;
            }

            steps++;
        }
        return steps;
    }


    private static int minSteps2Zero(int n) {

        int steps = 0;

        while (n > 0) {

            boolean divided = false;

            for (int i = 2; i < n; i++) {

                if (n % i == 0) {
                    n = n / i;
                    divided = true;
                    break;
                }
            }

            if (!divided) {
                n--;
            }

            steps++;
        }
        return steps;
    }

    public static void main(String[] args) {
//        System.out.println("Input: 3, Output: " + minSteps(3));  // 3

        System.out.println("Input: 4, Output: " + minSteps(4));  // 3
        /*
        System.out.println("Input: 6, Output: " + minSteps(6));  // 4
        System.out.println("Input: 12, Output: " + minSteps(12)); // 5
        System.out.println("Input: 15, Output: " + minSteps(15)); // 5*/
    }
}

