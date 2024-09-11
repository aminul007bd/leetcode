import java.util.*;

/* Given an array of strings strs, group the anagrams together. You can return the answer in any order.

Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation: There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
*/
public class GroupAnagrams_49 {
    // Time complexity: O(m∗nlogn)
    public List<List<String>> groupAnagrams0(String[] strs) {
        Map<String, List<String>> ans = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList<>());
            }
            ans.get(key).add(s);
        }

        return new ArrayList<>(ans.values());
    }
    //Time complexity: O(m∗n)
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ans = new HashMap<>();

        for (String s : strs) {
            int[] count = new int[26];

            // Count frequency of each letter in the string
            for (char c : s.toCharArray()) {
                count[c - 'a']++; // 'a' = 97 ascii value
            }

            StringBuilder sb = new StringBuilder();
            for (int num : count) {
                sb.append(num).append("#"); //Convert frequency array to string key, sb becomes "1#0#0#0#1#0#0#0#0#0#0#0#0#0#0#0#0#0#0#1#0#0#0#0#0#0#"
            }
            String key = sb.toString(); // key = "1#0#0#0#1#0#0#0#0#0#0#0#0#0#0#0#0#0#0#1#0#0#0#0#0#0#"
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList<>());
            }
            ans.get(key).add(s); // ans is a Map<String, List<String>> where key is a string representing the unique character frequency pattern.
            // ans.get(key) retrieves the List<String> associated with the key from the map.
            //If the key is already in the map, this list will contain strings that share the same frequency pattern (i.e., anagrams).
        }

        return new ArrayList<>(ans.values());
    }
}
