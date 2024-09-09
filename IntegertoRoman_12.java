public class IntegertoRoman_12 {
/*
    Seven different symbols represent Roman numerals with the following values:

    Symbol	Value
    I	1
    V	5
    X	10
    L	50
    C	100
    D	500
    M	1000

    Example 1:
    Input: num = 3749
    Output: "MMMDCCXLIX"

    Explanation:
    3000 = MMM as 1000 (M) + 1000 (M) + 1000 (M)
    700 = DCC as 500 (D) + 100 (C) + 100 (C)
    40 = XL as 10 (X) less of 50 (L)
    9 = IX as 1 (I) less of 10 (X)
    Note: 49 is not 1 (I) less of 50 (L) because the conversion is based on decimal places
*/

    public String intToRoman(int num) {
        int[] n = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] s = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int i =0;
        StringBuilder str = new StringBuilder();
        while (num>0){
            if (num>=n[i]){
                str.append(s[i]);
                num-=n[i];
            } else{
                i++;
            }
        }
        return str.toString();
    }
}

/*
        while (num > 0) {
                if (num >= n[i]) {
                str.append(s[i]);
        num -= n[i];
                } else {
        i++;
                }
                }


        ### 1. **`while (num > 0)`**

        - **Purpose**: This line initiates a loop that continues as long as `num` is greater than `0`.
        - **Reason**: The loop needs to process the number until it has been completely converted into Roman numerals. Once `num` becomes `0`, the conversion is complete and there’s no more processing required.

### 2. **`if (num >= n[i])`**

        - **Purpose**: This line checks if the current value `num` is greater than or equal to the current Roman numeral value `n[i]`.
        - **Reason**: This conditional statement determines if the current Roman numeral value (represented by `n[i]`) can be used in the conversion. If `num` is greater than or equal to `n[i]`, it means that `n[i]` can be used as part of the Roman numeral representation.

        ### 3. **`str.append(s[i]);`**

        - **Purpose**: This line appends the Roman numeral symbol corresponding to `n[i]` (stored in `s[i]`) to the `StringBuilder` object `str`.
        - **Reason**: If the current numeral value `n[i]` is used in the representation, you add its symbol `s[i]` to the result. This step builds the Roman numeral string progressively by adding the appropriate symbols.

### 4. **`num -= n[i];`**

        - **Purpose**: This line subtracts the value of `n[i]` from `num`.
        - **Reason**: Since `n[i]` has been used in the Roman numeral representation, it needs to be subtracted from `num` to reflect the remaining value that still needs to be converted. This ensures that the algorithm processes the next appropriate value for the remaining portion of `num`.

        ### 5. **`else`**

        - **Purpose**: This handles the case where `num` is less than `n[i]`.
        - **Reason**: If `num` is smaller than the current Roman numeral value `n[i]`, it means that `n[i]` cannot be used in the conversion for the current value of `num`. Therefore, you need to check the next smaller value.

        ### 6. **`i++;`**

        - **Purpose**: This increments the index `i` to move to the next smaller Roman numeral value in the `n[]` and `s[]` arrays.
- **Reason**: Since `num` is less than the current value `n[i]`, you move to the next smaller Roman numeral value. The algorithm continues to check smaller values until it finds one that can be used or until it has processed all possible values.

### Summary of the Loop

- The `while` loop iterates until `num` becomes `0`, building the Roman numeral representation step by step.
        - Inside the loop, the `if` condition checks whether the current Roman numeral value can be used. If it can, it adds the corresponding symbol to the result and updates `num`.
        - If the current value cannot be used (because `num` is smaller), it moves to the next smaller Roman numeral value by incrementing `i`.

By continuously choosing the largest possible Roman numeral values that fit into `num`, the algorithm constructs the Roman numeral representation in an efficient manner. The loop ensures that all parts of `num` are accounted for and converted into the correct Roman numeral symbols.*/
