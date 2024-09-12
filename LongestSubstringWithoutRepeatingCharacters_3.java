/*Given a string s, find the length of the longest substring
without repeating characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.*/

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters_3 {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLength = 0;
        HashSet<Character> charSet = new HashSet<>(); //A HashSet is used to store the unique characters in the current window.

        for (int right = 0; right < s.length(); right++) {
            while (charSet.contains(s.charAt(right))) { //Shrink the window when encountering a duplicate character
                charSet.remove(s.charAt(left)); // Remove the character at the left pointer from the set, effectively shrinking the window.
                left++;
            }

            charSet.add(s.charAt(right)); // Add the current character to the set (this happens after the duplicate is removed, so now the window contains only unique characters).
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
