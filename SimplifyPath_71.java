/*You are given an absolute path for a Unix-style file system, which always begins with a slash '/'.
Your task is to transform this absolute path into its simplified canonical path.

Example 1:

Input: path = "/home/"

Output: "/home"

Explanation:

The trailing slash should be removed.*/

import java.util.Stack;

public class SimplifyPath_71 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>(); // create a stack to keep track of directories
        String[] directories = path.split("/"); // split the path by slash '/'
        for (String dir : directories) { // iterate over the directories
            if (dir.equals(".") || dir.isEmpty()) { // ignore the current directory '.' and empty directories
                continue;
            } else if (dir.equals("..")) { // go one level up for double period '..'
                if (!stack.isEmpty()) { // if stack is not empty, pop the top element
                    stack.pop();
                }
            } else { // for any other directory, push it to the stack
                stack.push(dir);
            }
        }
        return "/" + String.join("/", stack); // join the directories in the stack with slash '/' and add a slash at the beginning
    }
}
