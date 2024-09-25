/*
Given two strings s and t of lengths m and n respectively, return the minimum window substring
of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
The testcases will be generated such that the answer is unique.

Example 1:
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
*/

public class MinimumWindowSubstring_76 {
    public String minWindow(String s, String t) {
        // Initialize a frequency map to count occurrences of characters in 't'
        int[] map = new int[128]; // ASCII character set size
        for (char c : t.toCharArray()) {
            map[c]++; // Increment the count for each character in 't'
        }

        // Initialize variables
        int counter = t.length(); // Number of characters in 't' to match
        int begin = 0; // Start index of the current window
        int end = 0; // End index of the current window
        int d = Integer.MAX_VALUE; // Length of the smallest window found
        int head = 0; // Start index of the smallest window

        // Slide the window across string 's'
        while (end < s.length()) {
            if (map[s.charAt(end++)]-- > 0) { // If the character at 'end' is part of 't', decrement its count in the map
                counter--; // Decrease counter if character is needed
            }
            while (counter == 0) { // When all characters are matched
                if (end - begin < d) { // Update the smallest window if the current window is smaller
                    head = begin;
                    d = end - head;
                }
                if (map[s.charAt(begin++)]++ == 0) { // Move the start index of the window to the right
                    counter++; // Increase counter if character was needed and now it's no longer in the window
                }
            }
        }

        return d == Integer.MAX_VALUE ? "" : s.substring(head, head + d);// If no valid window was found, return an empty string
    }

}

/*
Walkthrough Example
Let’s walk through an example with s = "ADOBECODEBANC" and t = "ABC".

        Initialize Variables:

map: Frequency array for characters in t (ASCII size 128).
counter: Number of characters left to match (initialized to t.length(), which is 3).
begin, end, d, head: Indices and values to manage the window.
Frequency Map Initialization:

        For t = "ABC", map will be: {65: 1, 66: 1, 67: 1} (where 65 = 'A', 66 = 'B', 67 = 'C').
Slide Window Across s:

First Iteration:

end = 0, s.charAt(0) = 'A'
map[65]-- (decrement count for 'A')
counter-- (decrease counter to 2)
end = 1
Second Iteration:

end = 1, s.charAt(1) = 'D'
map[68] (no change, 'D' not in t)
end = 2
Continue Iterating Until counter == 0:

Find Window:

begin = 4, end = 7, window "CODEBANC":
map[65], map[66], map[67] (all zeroes)
Update d to end - begin which is 7 - 4 = 3
head set to 4
Move begin Right:

begin = 5, s.charAt(5) = 'O'
map[79]++ (no change, 'O' not in t)
Continue until counter is no longer zero.
        Result:

After iterating through s, the smallest window "BANC" (from index 9 to 12) is found.
d is 4, and head is 9.
Return Result:

The smallest window substring is s.substring(head, head + d) which is "BANC".*/
