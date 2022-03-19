public class PalindromicSubstrings_647 {
    // Dynamic programming way to solve
    public int countSubstrings(String s) {
        if(s.length() == 0) return 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int res = 0;

        // Base case 1: length = 1 --> true;
        for(int i = 0; i< n; i++) {
            dp[i][i] = true;
            res++;
        }

        // Base case 2: length = 2 --> char[i] == char[i+1]
        for(int i = 0; i < n - 1; i ++) {
            dp[i][i + 1] = s.charAt(i) == s.charAt(i+1);
            if(dp[i][i+1]) res++;
        }

        // General case: length > 2 --> char[s] == char[e]&& dp[i+1][j-1] is true
        for(int len = 3; len <= n; len++) {
            for(int i = 0, j = i + len - 1; j< n; i++, j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i+1][j-1];
                if(dp[i][j]) res++;
            }
        }

        return res;
    }

    // Second way space complexity O(1)
    public int countSubstrings2(String s) {
        int n = s.length(), res = 0;
        if(n <= 0) return 0;
        char[] ch = s.toCharArray();
        for(int i = 0; i< n; i++) {
            // Odd and even lengths (center for the odd --> i, i)
            // Center for the even --> i, i+1
            res += isPalindrome(i, i, ch);
            res += isPalindrome(i, i + 1, ch);
        }
        return res;
    }

    private int isPalindrome(int start, int end, char[] ch) {
            int count = 0;
            while (start >= 0 && end < ch.length && ch[start++] == ch[end++]) {
                count++;
            }
            return count;
    }
}












