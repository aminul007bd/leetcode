/*
Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.



        Example 1:

Input: n = 19
Output: true
*/

public class HappyNumber_202 {
   /* Complete Example
    Let's walk through an example with n = 19 to clarify the whole process:

    Initial values:

    n = 19
    slow = getNextNumber(19) = 82
    fast = getNextNumber(getNextNumber(19)) = getNextNumber(82) = 68
    First iteration:

    slow = 82
    fast = 68
    slow != fast, so continue the loop.
    Update slow and fast:

    slow = getNextNumber(82) = 68
    fast = getNextNumber(getNextNumber(68)) = getNextNumber(100) = 1
    Second iteration:

    slow = 68
    fast = 1
    fast == 1, so return true (19 is a happy number).
    */
    //Floyd's Cycle Detection Algorithm

    public boolean isHappy(int n) {
        int slow = getNextNumber(n);
        int fast = getNextNumber(getNextNumber(n)); //fast is set to the next number of the next number of n, meaning it moves twice as fast as slow.

        while (slow != fast) {
            if (fast == 1) return true;
            slow = getNextNumber(slow);
            fast = getNextNumber(getNextNumber(fast));
        }

        return slow == 1;
    }

    //Calculates the next number in the sequence by summing the squares of digits.
// this function will run for each digit for 19 the loop will run 2 times
    private int getNextNumber(int n) {
        int output = 0;

        while (n > 0) {
            int digit = n % 10; // get the last digit(9 from 19)
            output += digit * digit;
            n = n / 10;
        }

        return output;
    }
}
