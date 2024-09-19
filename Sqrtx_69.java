/*Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
The returned integer should be non-negative as well.
You must not use any built-in exponent function or operator.

For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
Example 1:
Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.*/

public class Sqrtx_69 {
    public int mySqrt(int x) {
        if (x == 0) {// Check if the input is 0; the square root of 0 is 0
            return 0;
        }
        int first = 1, last = x; // Initialize the search range: 'first' starts at 1, 'last' starts at x
        while (first <= last) {// Perform binary search within the range [first, last]
            int mid = first + (last - first) / 2; // Calculate the midpoint to avoid overflow: (first + last) / 2
            if (mid == x / mid) { // If mid * mid equals x, mid is the square root
                return mid;
            } else if (mid > x / mid) {// If mid * mid is greater than x, search the left half
                last = mid - 1;
            } else {
                first = mid + 1; // If mid * mid is less than x, search the right half
            }
        }

        return last; // If no exact square root is found, return the largest integer less than the square root
    }

}

/*
Walkthrough Example
Let's walk through an example where x = 8:

Initialization:

first = 1, last = 8: The search range is from 1 to 8.
First Loop Iteration:

mid = first + (last - first) / 2 = 1 + (8 - 1) / 2 = 4: The midpoint is 4.
Check if 4 * 4 == 8: This is false (16 > 8).
Since 4 > 8 / 4, update last = mid - 1 = 4 - 1 = 3: Narrow the search range to [1, 3].
Second Loop Iteration:

mid = 1 + (3 - 1) / 2 = 2: The midpoint is 2.
Check if 2 * 2 == 8: This is false (4 < 8).
Since 2 < 8 / 2, update first = mid + 1 = 2 + 1 = 3: Narrow the search range to [3, 3].
Third Loop Iteration:

mid = 3 + (3 - 3) / 2 = 3: The midpoint is 3.
Check if 3 * 3 == 8: This is false (9 > 8).
Since 3 > 8 / 3, update last = mid - 1 = 3 - 1 = 2: Narrow the search range to [3, 2].
Exit Loop:

The loop condition while (first <= last) is now false because first = 3 and last = 2.
Return the Result:

Return last = 2: The largest integer whose square is less than or equal to 8 is 2, which is the floor value of the square root of 8.*/
