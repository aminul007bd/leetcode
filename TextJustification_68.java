/*Example 1:
Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
Output: [
        "This    is    an",
        "example  of text",
        "justification.  "
] */

import java.util.ArrayList;
import java.util.List;

public class TextJustification_68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>(); // To store the final justified lines of text
        List<String> cur = new ArrayList<>(); // To store words for the current line
        int num_of_letters = 0; // To track the number of letters in the current line (without spaces)

        for (String word : words) { // Iterate through each word in the input list
            if (word.length() + cur.size() + num_of_letters > maxWidth) { // Check if adding the current word exceeds maxWidth
                for (int i = 0; i < maxWidth - num_of_letters; i++) { // Distribute spaces evenly between words until line reaches maxWidth
                    cur.set(i % (cur.size() - 1 > 0 ? cur.size() - 1 : 1),
                            cur.get(i % (cur.size() - 1 > 0 ? cur.size() - 1 : 1)) + " "); // Add one space at a time to words, distributing extra spaces evenly

                }

                StringBuilder sb = new StringBuilder(); // StringBuilder to construct the justified line
                for (String s : cur) sb.append(s); // Append each word from cur to the StringBuilder
                res.add(sb.toString());// Add the fully justified line to the result list
                cur.clear();// Clear the current line's words for the next line
                num_of_letters = 0;// Reset letter count for the new line
            }
            cur.add(word);// Add the current word to the current line
            num_of_letters += word.length();// Update the total number of letters in the current line
        }

        StringBuilder lastLine = createLastLine(maxWidth, cur);
        res.add(lastLine.toString()); // Add the last line to the result list

        return res;// Return the final list of fully justified lines
    }

    private static StringBuilder createLastLine(int maxWidth, List<String> cur) {
        StringBuilder lastLine = new StringBuilder(); // StringBuilder to construct the last line (which is left-aligned)

        for (int i = 0; i < cur.size(); i++) { // Add each word in the current line to lastLine
            lastLine.append(cur.get(i));
            if (i != cur.size() - 1) // checks whether the current element in the list (cur[i]) is not the last element in the list.
                lastLine.append(" "); // Add a single space between words, but not after the last word
        }

        while (lastLine.length() < maxWidth)
            lastLine.append(" "); // Append extra spaces to the last line to make its length equal to maxWidth
        return lastLine;
    }

}
/*
Step-by-Step Walkthrough:
First Iteration (word = "This"):

cur = ["This"], num_of_letters = 4 (4 letters in "This").
Second Iteration (word = "is"):

cur = ["This", "is"], num_of_letters = 6 (4 from "This" + 2 from "is").
Third Iteration (word = "an"):

cur = ["This", "is", "an"], num_of_letters = 8 (6 + 2 from "an").
Fourth Iteration (word = "example"):

Trying to add "example" exceeds maxWidth (7 letters + 8 letters + 2 spaces > 16).
Justify the current line "This is an":
Extra spaces: 8 spaces (to distribute among words).
Result: "This is an".
res = ["This is an"].
Add "example" to a new line:

cur = ["example"], num_of_letters = 7.
Fifth Iteration (word = "of"):

cur = ["example", "of"], num_of_letters = 9 (7 + 2).
Sixth Iteration (word = "text"):

cur = ["example", "of", "text"], num_of_letters = 13 (9 + 4).
Seventh Iteration (word = "justification."):

Trying to add "justification." exceeds maxWidth (14 letters + 13 letters + 2 spaces > 16).
Justify the current line "example of text":
Result: "example of text" (spaces already well-distributed).
res = ["This is an", "example of text"].
Last line (word = "justification."):

The last line is left-aligned.
        lastLine = "justification. " (spaces added to the end to match maxWidth).
Final Result:

res = ["This is an", "example of text", "justification. "].*/
