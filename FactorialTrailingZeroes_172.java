/*
Given an integer n, return the number of trailing zeroes in n!.
Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.

Example:
Input: n = 5
Output: 1
Explanation: 5! = 120, one trailing zero.
*/


public class FactorialTrailingZeroes_172 {
    public int trailingZeroes(int n) {
        int count = 0; // Initialize a counter 'c' to keep track of the number of trailing zeroes
        while (n > 4) { // Continue dividing n by 5 until n is less than or equal to 4
            count += (n / 5); // Add the result of n divided by 5 to the counter 'c'
            n /= 5; // Update n by dividing it by 5
        }

        return count; // Return the total count of trailing zeroes
    }
}

/*
Walkthrough Example:
Let's walk through an example where n = 25:

Initialization:
c = 0: This is where we will store the count of trailing zeroes.
n = 25: This is the input value.

First Loop Iteration:
c += (n / 5) = 25 / 5 = 5: Add 5 to c because there are 5 multiples of 5 in 25!.
n /= 5 = 25 / 5 = 5: Update n to 5.

Second Loop Iteration:
c += (n / 5) = 5 / 5 = 1: Add 1 to c because there is 1 multiple of 25 in 25!.
n /= 5 = 5 / 5 = 1: Update n to 1.

Exit Loop:
The loop condition while (n > 4) is now false because n is 1.
Return the Result:

return c = 6: The final value of c is 6, which means 25! has 6 trailing zeroes.

25! equals 15,511,210,043,330,985,984,000,000.*/
