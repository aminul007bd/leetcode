/* Given two strings s and t, determine if they are isomorphic.
Two strings s and t are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving the order of characters.
No two characters may map to the same character, but a character may map to itself.

Example 1:
Input: s = "egg", t = "add"
Output: true
Explanation: The strings s and t can be made identical by:
Mapping 'e' to 'a'.
Mapping 'g' to 'd'.
*/
/*
Example:
Consider s = "egg" and t = "add":

The mapping of s to t should be consistent for the strings to be isomorphic.
        Let's walk through it:

Step 1:
i = 0: The current characters are e (from s) and a (from t).
mapS['e'] = 0 (it has not appeared yet, so default is 0).
mapT['a'] = 0 (it has not appeared yet, so default is 0).
Since both are 0, no problem. The current characters can map to each other. We update:
mapS['e'] = 1 (the current index + 1).
mapT['a'] = 1.
Step 2:
i = 1: The current characters are g (from s) and d (from t).
mapS['g'] = 0 (it has not appeared yet, so default is 0).
mapT['d'] = 0 (it has not appeared yet, so default is 0).
Again, both are equal, so the mapping is still consistent. Update:
mapS['g'] = 2.
mapT['d'] = 2.
Step 3:
i = 2: The current characters are g (from s) and d (from t) again.
        mapS['g'] = 2 (last seen at position 2).
mapT['d'] = 2 (last seen at position 2).
Since both are equal, the mapping is still consistent.
In this case, the function will return true, because the characters in both strings map consistently.*/

public class IsomorphicStrings_205 {
    public boolean isIsomorphic(String s, String t) {
        int[] mapS = new int[128];
        int[] mapT = new int[128]; // Size 200 is used to accommodate all possible ASCII values (more than needed here)

        if (s.length() != t.length())  return false;
        for (int i = 0; i < s.length(); i++) {
            if (mapS[s.charAt(i)] != mapT[t.charAt(i)]) // If the current characters in s and t were last seen at different positions,
                return false; // the mapping is inconsistent, so return false
            mapS[s.charAt(i)] = i + 1;
            mapT[t.charAt(i)] = i + 1;
            // Record the latest position (i+1) of the characters in both strings
            // Adding 1 to ensure default 0 values are not confused with actual indices
        }
        return true; // If the loop completes without finding an inconsistency, the strings are isomorphic
    }

}
