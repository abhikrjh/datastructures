package recursion;

/*
Ques - No of steps to reduce a numbe to zero
Given an integer num, return the number of steps to reduce it to zero.

In one step, if the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.



Example 1:

Input: num = 14
Output: 6
Explanation:
Step 1) 14 is even; divide by 2 and obtain 7.
Step 2) 7 is odd; subtract 1 and obtain 6.
Step 3) 6 is even; divide by 2 and obtain 3.
Step 4) 3 is odd; subtract 1 and obtain 2.
Step 5) 2 is even; divide by 2 and obtain 1.
Step 6) 1 is odd; subtract 1 and obtain 0.
*/

public class LeetCode1342 {

    static int numberOfSteps(int num){
        return helper(num, 0);
    }

    static int helper(int num, int steps) {

        if(num == 0){
            return steps;
        }

        if(num % 2 == 0){
            return helper(num/2, steps+1);
        }

        return helper(num-1, steps+1);
    }

    // Need to find defect in the below approach

//    static int totalStep = 0;
//
//    static int numberOfSteps(int n) {
//
//        if (n == 0)
//            return totalStep;
//
//        if (n % 2 != 0) {
//
//            n = n - 1;
//        } else {
//
//            n = n / 2;
//        }
//
//        totalStep += 1;
//
//        return numberOfSteps(n);
//    }


    public static void main(String[] args) {

        int n = 14;
        int steps = numberOfSteps(n);

        System.out.println(steps);
    }
}
