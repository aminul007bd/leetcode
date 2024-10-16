/*Write a function that takes the binary representation of a positive integer and returns the number of
set bits
it has (also known as the Hamming weight).
Input: n = 11
Output: 3

Explanation:
The input binary string 1011 has a total of three set bits.*/


public class NumberofOneBits_191 {
    public int hammingWeight(int n) {
        int res = 0; // Initialize a counter 'res' to store the number of '1' bits found.

        for (int i = 0; i < 32; i++) { // Loop through all 32 bits of the integer 'n' since it's a 32-bit number.
            if (((n >> i) & 1) == 1) { // Right shift 'n' by 'i' positions, then use bitwise AND with 1 to isolate the least significant bit (LSB).
                // If the result of (n >> i) & 1 is 1, it means the i-th bit of 'n' is '1'.
                res += 1; // Increment the counter 'res' if the current bit is '1'.
            }
        }

        return res; // After checking all 32 bits, return the total count of '1' bits.
    }
}

/*
Example:
Let's say n = 11. The binary representation of 11 is 00000000000000000000000000001011.

Start with res = 0.
i = 0: n >> 0 = 00000000000000000000000000001011 → (n >> 0) & 1 = 1, so res = 1.
i = 1: n >> 1 = 00000000000000000000000000000101 → (n >> 1) & 1 = 1, so res = 2.
i = 2: n >> 2 = 00000000000000000000000000000010 → (n >> 2) & 1 = 0, so res remains 2.
i = 3: n >> 3 = 00000000000000000000000000000001 → (n >> 3) & 1 = 1, so res = 3.
For the rest of the bits from i = 4 to i = 31, the bits are all 0, so res stays 3.
Thus, the function returns 3, which is the number of '1' bits in the binary representation of 11.*/
