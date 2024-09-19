public class BackspaceStringCompare_844 {

    public static boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int skipS = 0, skipT = 0;
        // while there maybe chars in s and t
        while (i >= 0 || j >= 0) {
            // find position of new possible char in build (s)
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else break;
            }
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else break;
            }
            // If two actual characters are different
            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) {
                return false;
            }
            // if expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0)) return false;
            i--;
            j--;
        }
        return true;
    }
}
