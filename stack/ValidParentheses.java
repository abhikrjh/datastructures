package stack;
/*

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

*/

import java.util.Stack;

public class ValidParentheses {

    private static boolean validParenthesis(String s) {

        if (null == s || s.isEmpty()) {
            return false;
        }

        char[] arr = s.toCharArray();

        Stack<Character> stack = new Stack<>();

        // Input stack = ([])
        for (char c : arr) {

            // push all the open bracket
            if (c == '(' || c == '{' || c == '[') {

                stack.push(c);
            } else {

                if (stack.empty()) { // If closing bracket is without opening bracket
                    return false;
                }

                // Handle closing bracket

                switch (c) {

                    case ')' -> {
                        if (stack.pop() != '(') {
                            return false;
                        }
                        break;
                    }
                    case '}' -> {
                        if (stack.pop() != '{') {
                            return false;
                        }
                        break;
                    }

                    case ']' -> {
                        if (stack.pop() != '[') {
                            return false;
                        }
                        break;
                    }
                    default -> {

                    }
                }

            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {


//        String s = "()";

//        String s = "()[]{}";
//
//        String s = "(]";
//
//        String s = "([])";

        String s = "({[";

        System.out.println(validParenthesis(s));
    }
}
