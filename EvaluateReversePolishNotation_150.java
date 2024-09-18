/*You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

Evaluate the expression. Return an integer that represents the value of the expression.

Note that:

The valid operators are '+', '-', '*', and '/'.
Each operand may be an integer or another expression.
The division between two integers always truncates toward zero.
There will not be any division by zero.
The input represents a valid arithmetic expression in a reverse polish notation.
The answer and all the intermediate calculations can be represented in a 32-bit integer.


Example 1:

Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9*/

import java.util.Stack;

public class EvaluateReversePolishNotation_150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String c : tokens) {
            if (c.equals("+")) {
                stack.push(stack.pop() + stack.pop()); // Pop the top two values, add them, and push the result back onto the stack
            } else if (c.equals("-")) {
                int second = stack.pop(); // Pop the second operand
                int first = stack.pop(); // Pop the first operand
                stack.push(first - second);// Subtract: first - second and push the result back onto the stack
            } else if (c.equals("*")) {
                stack.push(stack.pop() * stack.pop()); // Pop the top two values, multiply them, and push the result back onto the stack
            } else if (c.equals("/")) {
                int second = stack.pop(); // Pop the second operand
                int first = stack.pop(); // Pop the first operand
                stack.push(first / second); // Divide: first / second and push the result back onto the stack
            } else { // If the token is a number
                stack.push(Integer.parseInt(c)); // Parse the number (from string to integer) and push it onto the stack
            }
        }

        return stack.peek(); // The final result will be the only value left in the stack (on the top)
    }
}

/*
Walkthrough Example:
Let's take the input ["2", "1", "+", "3", "*"] as an example. The expression in Reverse Polish Notation (RPN) is equivalent to ((2 + 1) * 3).

Initial State:
Stack: []
Step-by-Step Execution:
Token: "2"

It's a number, so we push 2 onto the stack.
Stack: [2]
Token: "1"

It's a number, so we push 1 onto the stack.
Stack: [2, 1]
Token: "+"

It's an operator. We pop the top two values (1 and 2), add them (2 + 1 = 3), and push the result (3) back onto the stack.
Stack: [3]
Token: "3"

It's a number, so we push 3 onto the stack.
Stack: [3, 3]
Token: "*"

It's an operator. We pop the top two values (3 and 3), multiply them (3 * 3 = 9), and push the result (9) back onto the stack.
Stack: [9]
Final State:
The stack now contains a single value: 9, which is the result of the expression.
        Return:
Return value: 9
Thus, the result of evaluating the RPN expression ["2", "1", "+", "3", "*"] is 9.*/
