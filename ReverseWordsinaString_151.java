public class ReverseWordsinaString_151 {
    /*Given an input string s, reverse the order of the words.
    A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
    Return a string of the words in reverse order concatenated by a single space.
    Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

    Example 1:
    Input: s = "the sky is blue"
    Output: "blue is sky the"*/

    //*Example Walkthrough:

    /*Input: " The quick brown fox "
    Trim and Split:
    Input string: " The quick brown fox "
    After trim(): "The quick brown fox"
    After split("\\s+"): ["The", "quick", "brown", "fox"]
    Reverse Words:

    Start with an empty StringBuilder.
    Iterate from the end of the array to the beginning:
    Append "fox " (result: "fox ").
    Append "brown " (result: "fox brown ").
    Append "quick " (result: "fox brown quick ").
    Append "The" (result: "fox brown quick The").
    Final Result:

    Return the string from StringBuilder: "fox brown quick The"
    */
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+"); // Trim the input string to remove leading and trailing spaces and split into words.
        StringBuilder reversedWords = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {// Iterate through the words in reverse order
            reversedWords.append(words[i]);// Append the current word and a space to the StringBuilder
            if(i != 0) {
                reversedWords.append(" ");// add a single space between words
            }
        }
        return reversedWords.toString(); // Convert StringBuilder to String and return the result
    }

}
