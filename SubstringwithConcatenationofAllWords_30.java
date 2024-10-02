/*You are given a string s and an array of strings words. All the strings of words are of the same length.

A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.

For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings.
"acdbef" is not a concatenated string because it is not the concatenation of any permutation of words.
Return an array of the starting indices of all the concatenated substrings in s. You can return the answer in any order.

Example 1:
Input: s = "barfoothefoobarman", words = ["foo","bar"]

Output: [0,9]

Explanation:
The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringwithConcatenationofAllWords_30 {
    public List<Integer> findSubstring(String s, String[] words) {
        final Map<String, Integer> counts = new HashMap<>();// Create a HashMap to store the frequency of each word in the 'words' array.
        for (final String word : words) { // Loop through each word in 'words' and count the occurrences of each word.
            counts.put(word, counts.getOrDefault(word, 0) + 1); // {"foo": 1, "bar": 1}
        }
        final List<Integer> indexes = new ArrayList<>(); // Create a list to store the starting indices of the substrings that match the pattern.
        final int n = s.length(), num = words.length, len = words[0].length(); // 'n' is the length of the string 's', 'num' is the number of words, and 'len' is the length of each word.

        for (int i = 0; i < n - num * len + 1; i++) { // Iterate over the string 's' to find the starting index of each potential substring.
            final Map<String, Integer> seen = new HashMap<>(); // Create a HashMap to store the words we have seen in the current substring window.
            int j = 0; // 'j' is used to count how many words we've processed.

            while (j < num) { // This inner loop processes each word-length substring in the current window.
                final String word = s.substring(i + j * len, i + (j + 1) * len); // Extract the next word from the string starting at index 'i + j * len'.

                if (counts.containsKey(word)) { // Check if the word is part of 'words'. If not, break the loop.
                    seen.put(word, seen.getOrDefault(word, 0) + 1); // Count how many times the word has been seen in this window.
                    if (seen.get(word) > counts.getOrDefault(word, 0)) { // If the current word's count exceeds the expected count, stop further processing.
                        break;
                    }
                } else {
                    break; // If the word is not in 'words', break out of the loop.
                }
                j++;
            }
            if (j == num) {
                indexes.add(i);  // If we successfully found all words (i.e., j == num), add the starting index to 'indexes'.
            }
        }

        return indexes; // Return the list of starting indices where the concatenated words were found.
    }

}
