import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

Example 1:
Input: s = "()"
Output: true
        */
public class ValidParentheses_20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put(')', '('); // key, value
        mapping.put('}', '{');
        mapping.put(']', '[');

        for (char c : s.toCharArray()) {
            if (mapping.containsValue(c)) { //If c is an opening bracket ((, {, [), push it onto the stack.
                stack.push(c);
            } else if (mapping.containsKey(c)) { //If c is a closing bracket (), }, ]), we perform additional checks.
                if (stack.isEmpty() || mapping.get(c) != stack.pop()) { //  If the stack is empty when encountering a closing bracket, it means there is no corresponding opening bracket, so return false.
                    return false; // If the top of the stack doesn't match the expected opening bracket for c, return false.
                }
            }
        }

        return stack.isEmpty(); //After processing all characters, return true if the stack is empty
    }
}
