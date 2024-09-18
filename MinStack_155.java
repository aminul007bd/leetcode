/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.



Example 1:
Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]
*/


import java.util.Stack;

public class MinStack_155 {
    private int min;
    private Stack<Integer> stack;

    // Constructor for the MinStack
    public MinStack_155() {
        min = Integer.MAX_VALUE; // Initialize min to the maximum possible value
        stack = new Stack<>(); // Initialize the stack
    }


    public void push(int val) {
        // only push the old minimum value when the current
        // minimum value changes after pushing the new value x
        if (val <= min) {
            stack.push(min); // Store the previous minimum value on the stack.
            min = val; // Update the current minimum to the new value.
        }
        stack.push(val);
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value,
        // pop twice and change the current minimum value to the last minimum value.
        if (stack.pop() == min) min = stack.pop();
    }

    public int top() {
        return stack.peek(); // Return the top value of the stack.
    }

    public int getMin() {
        return min;
    }
}


/*
Example Walkthrough:
Let's walk through the following sequence of operations:

Initial state:

min = Integer.MAX_VALUE
stack = []
Push 5:

x = 5, which is less than min (Integer.MAX_VALUE).
Store the old min (Integer.MAX_VALUE) in the stack.
Update min = 5.
Push 5 onto the stack.
        Stack: [Integer.MAX_VALUE, 5]
min = 5

Push 3:

x = 3, which is less than min (5).
Store the old min (5) in the stack.
Update min = 3.
Push 3 onto the stack.
        Stack: [Integer.MAX_VALUE, 5, 5, 3]
min = 3

Get Minimum:

getMin() returns 3 since it's the current minimum.
Push 7:

x = 7, which is greater than min (3).
Simply push 7 onto the stack.
        Stack: [Integer.MAX_VALUE, 5, 5, 3, 7]
min = 3

Pop:

Pop the top value (7).
Since 7 is not equal to min, no change to min.
Stack: [Integer.MAX_VALUE, 5, 5, 3]
min = 3

Pop:

Pop the top value (3).
Since 3 is equal to min, pop again to retrieve the old min (5).
Stack: [Integer.MAX_VALUE, 5]
min = 5

Get Minimum:
getMin() returns 5 since the minimum has been restored after popping 3.

This code maintains the minimum element in constant time (O(1)) while still allowing for normal stack operations.*/
