public class LongestRepeatingCharacterReplacement_424 {
    public int characterReplacement(String s, int k) {
        int length = s.length();
        if(length == 0) return 0;
        int[] charToMap = new int[26];
        int i = 0, j = 0, maxCount = 0;
        while (i < length) {
            // Increase the count of the alphabet encountered at i
            int count = ++charToMap[s.charAt(i)- 'a'];

            if( count > maxCount) {
                maxCount = count;
            } else {
                k--;
            }

            // shorten the window by increasing j
            // also reduce the count of alphabet at j
            if (k < 0) {
                --charToMap[s.charAt(j) - 'a'];
                k++;
                j++;
            }
            i++;
        }
        return i - j;


    }


}
