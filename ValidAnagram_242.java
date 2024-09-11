import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true
*/
public class ValidAnagram_242 {
    public boolean isAnagramOLongN(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return Arrays.equals(sChars, tChars);
    }

    // O(n) with hashMap
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> count = new HashMap<>();

        for (char x : s.toCharArray()) {
            count.put(x, count.getOrDefault(x, 0) + 1); // Count the frequency of characters in string s
        }

        for (char x : t.toCharArray()) {
            count.put(x, count.getOrDefault(x, 0) - 1); // Decrement the frequency of characters in string t
        }

        // Check if any character has non-zero frequency
        for (int val : count.values()) {
            if (val != 0) {
                return false;
            }
        }
        return true;
    }
}
