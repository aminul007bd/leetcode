public class PalindromeNumber_9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false; // Check if the number is negative; negative numbers are not palindromes
        int reverse = 0; // Initialize 'reverse' to store the reversed number
        int xcopy = x; // Create a copy of 'x' to compare later

        while (x > 0) { // Reverse the digits of 'x'
            reverse = (reverse * 10) + (x % 10); // Add the last digit of 'x' to 'reverse'
            x /= 10; // Remove the last digit from 'x'
        }

        return reverse == xcopy; // Check if the reversed number is equal to the original number
    }
}

/*
Example Walkthrough
Let's take x = 121 as an example.

Initial State:

x = 121
reverse = 0
xcopy = 121
First Iteration of While Loop:

x = 121
Last digit: 121 % 10 = 1
Update reverse: (0 * 10) + 1 = 1
Remove last digit: 121 / 10 = 12
Second Iteration of While Loop:

x = 12
Last digit: 12 % 10 = 2
Update reverse: (1 * 10) + 2 = 12
Remove last digit: 12 / 10 = 1
Third Iteration of While Loop:

x = 1
Last digit: 1 % 10 = 1
Update reverse: (12 * 10) + 1 = 121
Remove last digit: 1 / 10 = 0
End of While Loop:

x = 0
reverse = 121
xcopy = 121
Final Comparison:

reverse == xcopy evaluates to 121 == 121, which is true.*/
