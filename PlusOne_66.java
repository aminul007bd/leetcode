/*
You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer.
The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.

Example 1:
Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
*/

public class PlusOne_66 {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) { // Loop through the digits array from the last element to the first
            if (digits[i] + 1 != 10) { // Check if adding 1 to the current digit doesn't result in 10 (no carry-over)
                digits[i] += 1; // If true, increment the current digit by 1
                return digits; // Return the modified array, as no further carry-over is needed
            }
            digits[i] = 0; // If adding 1 results in 10, set the current digit to 0 (handle carry-over)
        }

        int[] newDigits = new int[digits.length + 1]; // If all digits were 9, create a new array with an extra digit
        newDigits[0] = 1; // Set the first element of the new array to 1 (handle the final carry-over)

        return newDigits; // Return the new array, which correctly represents the incremented number
    }
}

/*Full Example Walkthrough:
Input: digits = [1, 2, 9]

Step 1: Start the loop with i = 2. digits[2] + 1 = 9 + 1 = 10, so the loop sets digits[2] to 0.

Step 2: Next iteration with i = 1. digits[1] + 1 = 2 + 1 = 3, which is not 10, so it increments digits[1] to 3 and returns the array [1, 3, 0].

Input: digits = [9, 9, 9]

Step 1: Start the loop with i = 2. digits[2] + 1 = 9 + 1 = 10, so set digits[2] to 0.

Step 2: Next iteration with i = 1. digits[1] + 1 = 9 + 1 = 10, so set digits[1] to 0.

Step 3: Next iteration with i = 0. digits[0] + 1 = 9 + 1 = 10, so set digits[0] to 0.

Step 4: The loop ends without returning. A new array newDigits = [1, 0, 0, 0] is created and returned.*/
