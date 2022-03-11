import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsPhoneNumber_17 {
    // Input: digits = "23"
    // 2 = abc
    // 3 == def
    //Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

    List<String> combinations = new ArrayList<>();
    private Map<Character, String> letters = Map.of('2', "abc", '3', "def",
            '4', "ghi", '5', "jkl", '6', "mno", '7', "pqrs",
            '8', "tuv", '9', "wxyz");


    public List<String> letterCombinations(String digits) {
        // if the input is empty, immediately return and empty answer array
        if(digits.length() == 0) return combinations;
        // Initiate backtracking with an empty path and starting index of 0
        backtrack(0, new StringBuilder(), digits);
        return combinations;
    }

    private void backtrack(int index, StringBuilder path, String phoneDigit) {
        // if the path is the same length of hte digit we have to complete combination
        if(path.length() == phoneDigit.length()) {
            combinations.add(path.toString());
            return; // backtrack
        }
        String possibleLetters = letters.get(phoneDigit.charAt(index));
        for (char letter: possibleLetters.toCharArray()) {
            path.append(letter);
            backtrack(index + 1, path, phoneDigit);
            path.deleteCharAt(path.length() - 1);
        }
    }

}
