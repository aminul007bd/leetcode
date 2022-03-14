import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class wordBreak_139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreakRe(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }

    private boolean wordBreakRe(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if(start == s.length()) return true;

        if(memo[start] != null) {
            return memo[start];
        }
        for(int end = start + 1; end <= s.length(); end++){
            if(wordDict.contains(s.substring(start, end))
                && wordBreakRe(s, wordDict, end, memo)
            ) {
                return memo[start] = true;
            }
        }

        return memo[start] = false;
    }

    // with dynamic programming solutions
    public boolean wordBreakDp(String s, List<String> wordDict) {
        Set<String> wordDirectSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 0; i<= s.length(); i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j] && wordDirectSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}


















