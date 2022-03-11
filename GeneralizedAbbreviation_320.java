import java.util.ArrayList;
import java.util.List;

// ******* need to understand the problem and solution
public class GeneralizedAbbreviation_320 {
    // Input: word = "word"
    //Output: ["4","3d","2r1","2rd","1o2","1o1d","1or1","1ord","w3","w2d","w1r1","w1rd","wo2","wo1d","wor1","word"]

    public List<String> generateAbbreviations(String word) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), word, 0, 0);
        return ans;
    }

    // i is the current position
    // k is the count of the consecutive abbreviated characters
    private void backtrack(List<String> ans, StringBuilder builder, String word, int i, int k) {
        int len = builder.length(); // keep the length of the builder
        if(i == word.length()) {
            if(k != 0) builder.append(k); // append the last k if non zero
            ans.add(builder.toString());
        } else {
            // the branch that word.charAt(i) is abbreviated
            backtrack(ans, builder, word, i + 1, k + 1);
            if(k != 0) builder.append(k);
            builder.append(word.charAt(i));
            backtrack(ans, builder, word, i + 1, 0);
        }
        builder.setLength(len);
    }
}
