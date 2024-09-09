public class FindtheIndexoftheFirstOccurrenceinaString_28 {
    /*Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

    Example 1:

    Input: haystack = "sadbutsad", needle = "sad"
    Output: 0
    Explanation: "sad" occurs at index 0 and 6.
    The first occurrence is at index 0, so we return 0.*/

    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }

        return -1;
    }

/*

### Step-by-Step Explanation

#### 1. **Initial Length Check:**
    if (haystack.length() < needle.length()) {
            return -1;
        }
    - First, the method checks if the length of `haystack` is smaller than the length of `needle`.
    If it is, it’s impossible for `needle` to be a substring of `haystack`, so the function immediately returns `-1`.

#### 2. **Iterating Over `haystack`:**
    for (int i = 0; i <= haystack.length() - needle.length(); i++) {
        - The method uses a loop to check each possible starting position in `haystack` where `needle` could match.
        - The loop runs from index `i = 0` to `haystack.length() - needle.length()` because there's no point in checking starting positions where there are fewer characters left in `haystack` than there are in `needle`.

#### 3. **Substring Comparison:**
        if (haystack.substring(i, i + needle.length()).equals(needle)) {
            return i;
        }
        - Inside the loop, the code checks whether the substring of `haystack` starting at index `i` and of length `needle.length()` is equal to `needle`.
        - `haystack.substring(i, i + needle.length())` extracts a substring from `haystack` starting at index `i` and ending at index `i + needle.length()`.
        - The `equals(needle)` checks whether this substring matches `needle`.
        - If a match is found, the function returns `i`, which is the index of the first occurrence of `needle` in `haystack`.

#### 4. **Return `-1` If No Match Is Found:**
        return -1;
        - If the loop completes and no match is found, the function returns `-1`, indicating that `needle` is not a substring of `haystack`.

### Example

#### Case 1:
       haystack = "hello", needle = "ll"
        - The loop iterates as follows:
        1. `i = 0`: `haystack.substring(0, 2)` is "he", no match.
        2. `i = 1`: `haystack.substring(1, 3)` is "el", no match.
        3. `i = 2`: `haystack.substring(2, 4)` is "ll", which matches `needle`. So, the function returns `2`.

#### Case 2:
        haystack = "hello", needle = "world"
        - The loop will complete without finding a match, so the function returns `-1`.

### Time Complexity
  - **Time Complexity**: O((n - m) * m), where `n` is the length of `haystack` and `m` is the length of `needle`.
  In the worst case, for every possible starting index `i`, the method creates a substring of length `m` and compares it to `needle`.
*/


    }
