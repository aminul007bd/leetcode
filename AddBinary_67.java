/*
    Given two binary strings a and b, return their sum as a binary string.

    Example 1:

    Input: a = "11", b = "1"
    Output: "100"
*/


public class AddBinary_67 {
    public String addBinary(String a, String b) // This method takes two binary strings 'a' and 'b' as input and returns their sum as a binary string.
    {
        StringBuilder sb = new StringBuilder(); // A StringBuilder is used to efficiently build the resulting binary string by appending characters.

        int carry = 0; // 'carry' will store the carryover during the addition of two binary digits (0 or 1), similar to decimal addition.

        int i = a.length() - 1; // 'i' is initialized to point to the last character of string 'a', starting from the rightmost bit (least significant bit).

        int j = b.length() - 1; // 'j' is initialized to point to the last character of string 'b', starting from the rightmost bit.

        while (i >= 0 || j >= 0 || carry == 1) // The loop runs as long as there are bits left in either string or there’s a carry (carry == 1).
        {
            if (i >= 0) // If there are still bits left in string 'a' (i >= 0):
                carry += a.charAt(i--) - '0'; // Add the value of the bit at position 'i' in 'a' to 'carry'. Subtract '0' to convert the char ('0' or '1') to its integer value (0 or 1). Decrement 'i' after this.

            if (j >= 0) // If there are still bits left in string 'b' (j >= 0):
                carry += b.charAt(j--) - '0'; // Add the value of the bit at position 'j' in 'b' to 'carry'. Subtract '0' to convert the char to an integer. Decrement 'j' after this.

            sb.append(carry % 2); // Append the result of 'carry % 2' (either 0 or 1) to the StringBuilder. This gives the current bit in the binary sum.

            carry /= 2; // Update 'carry' to store the carryover for the next bit. If 'carry' was 2 (both bits were 1), it becomes 1 for the next addition. If it's 1 or 0, no carryover remains.
        }

        return sb.reverse().toString(); // Reverse the StringBuilder, since the bits were added from least significant to most significant, and convert it to a string to return the final result.
    }
}
/*
Explanation with an Example:
Let’s say a = "1010" and b = "1011".

Initial setup:

i = 3, j = 3 (pointing to the last digits of a and b).
carry = 0.
First iteration:

Add the last bit of a (0) and b (1) with the carry (0).
carry = 0 + 1 = 1.
Append carry % 2 = 1 to sb → sb = "1".
carry = 1 / 2 = 0.
Second iteration:

Add the next bits: a[2] = 1 and b[2] = 1 with the carry (0).
carry = 1 + 1 = 2.
Append carry % 2 = 0 to sb → sb = "10".
carry = 2 / 2 = 1.
Third iteration:

Add the next bits: a[1] = 0 and b[1] = 0 with the carry (1).
carry = 0 + 0 + 1 = 1.
Append carry % 2 = 1 to sb → sb = "101".
carry = 1 / 2 = 0.
Fourth iteration:

Add the next bits: a[0] = 1 and b[0] = 1 with the carry (0).
carry = 1 + 1 = 2.
Append carry % 2 = 0 to sb → sb = "1010".
carry = 2 / 2 = 1.
Fifth iteration (no bits left, but carry is 1):

Append carry % 2 = 1 to sb → sb = "10101".
carry = 1 / 2 = 0.
Result: Reverse sb = "10101" and return the final result: "10101".
*/
