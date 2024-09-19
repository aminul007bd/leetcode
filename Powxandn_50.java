/*
Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
*/

public class Powxandn_50 {
    public double myPow(double x, int n) {
        return binaryExp(x, (long) n); // Convert the integer n to a long type to handle potential overflow
    }

    private double binaryExp(double x, long n) {
        if (n == 0) { // Base case: if n is 0, return 1 (x^0 is always 1)
            return 1;
        }
        if (n < 0) { // If n is negative, compute the positive power and take its reciprocal
            return 1.0 / binaryExp(x, -n);
        }
        if (n % 2 == 1) { // If n is odd, use the formula x^n = x * (x^2)^((n-1)/2)
            return x * binaryExp(x * x, (n - 1) / 2);
        } else {
            return binaryExp(x * x, n / 2); // If n is even, use the formula x^n = (x^2)^(n/2)
        }
    }
}

/*
Approach
This code uses Exponentiation by Squaring to efficiently compute the power of a number. The key steps are:

Base Case: When n is 0, return 1 because any number raised to the power of 0 is 1.
Negative Exponent: If n is negative, convert it to positive, compute the power for the positive exponent, and then take the reciprocal.
Odd and Even Exponents:
Odd Exponent: If n is odd, reduce the problem by expressing x^n as x * (x^2)^((n-1)/2). This reduces the exponent by 1 and changes the problem to a smaller even exponent.
Even Exponent: If n is even, express x^n as (x^2)^(n/2). This reduces the exponent by dividing it by 2 and squares the base.
Walkthrough Example
Let's compute myPow(2.0, 10):

Initial Call:

binaryExp(2.0, 10)
First Level of Recursion:

n = 10 (even), so use binaryExp(x * x, n / 2) = binaryExp(4.0, 5)
Second Level of Recursion:

n = 5 (odd), so use x * binaryExp(x * x, (n - 1) / 2) = 4.0 * binaryExp(16.0, 2)
Third Level of Recursion:

n = 2 (even), so use binaryExp(x * x, n / 2) = binaryExp(256.0, 1)
Fourth Level of Recursion:

n = 1 (odd), so use x * binaryExp(x * x, (n - 1) / 2) = 256.0 * binaryExp(65536.0, 0)
Base Case:

n = 0, so return 1.0
Combine Results:

binaryExp(65536.0, 0) returns 1.0
binaryExp(256.0, 1) returns 256.0 * 1.0 = 256.0
binaryExp(16.0, 2) returns 256.0
binaryExp(4.0, 5) returns 4.0 * 256.0 = 1024.0
binaryExp(2.0, 10) returns 1024.0
*/
