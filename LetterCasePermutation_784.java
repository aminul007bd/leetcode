import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation_784 {

    //Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.
    //Return a list of all possible strings we could create. Return the output in any order.
    //Input: s = "a1b2"
    //Output: ["a1b2","a1B2","A1b2","A1B2"]
        List<String> ans = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        ans.add(s);
        dfs(s.toCharArray(), 0);
        return ans;
    }

    public void dfs(char[] s, int index) {
        for(int i = index; i< s.length; i++) {
            if(Character.isAlphabetic(s[i])) {
                char temp = s[i];
                s[i] = Character.isLowerCase(s[i]) ? Character.toUpperCase(s[i])
                        : Character.toLowerCase(s[i]);
                ans.add(new String(s));
                dfs(s, i+1);
                s[i] = temp;
            }
        }
    }
}
