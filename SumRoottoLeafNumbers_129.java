/*You are given the root of a binary tree containing digits from 0 to 9 only.

Each root-to-leaf path in the tree represents a number.

For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

A leaf node is a node with no children.

Input: root = [1,2,3]
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.*/

public class SumRoottoLeafNumbers_129 {

    public int sumNumbers(TreeNode root) { // This is the main function that kicks off the depth-first search (DFS) to calculate the sum of root-to-leaf numbers.
        return dfs(root, 0);  // Start DFS with the root node and an initial sum of 0.
    }

    private int dfs(TreeNode node, int num) { // This is a helper function to perform DFS and calculate the sum of numbers formed by root-to-leaf paths.
        if (node == null) { // If the current node is null (base case), return 0 since there's no valid path here.
            return 0;
        }
        num = num * 10 + node.val; // Update the current number by shifting the previous value by one decimal place and adding the current node's value.

        if (node.left == null && node.right == null) { // If the node is a leaf (i.e., it has no children), return the number formed from root to this leaf.
            return num;
        }

        return dfs(node.left, num) + dfs(node.right, num); // Recursively calculate the sum for the left and right subtrees and return their sum.
    }
}

/*
We need to calculate the sum of the numbers formed by root-to-leaf paths. The numbers from root to leaf are 12 (from path 1 -> 2) and 13 (from path 1 -> 3).

Step-by-Step Walkthrough:
Initial Call:

The function sumNumbers(root) is called, where root is the node with value 1.
This leads to calling the helper function dfs(root, 0), where root = 1 and num = 0.
First DFS Call (Node 1):

The current node is 1, and num = 0.
The updated num is calculated as num * 10 + 1 = 0 * 10 + 1 = 1.
Since node 1 is not a leaf, we move to the left child by calling dfs(2, 1).
Second DFS Call (Node 2):

The current node is 2, and num = 1.
The updated num is calculated as num * 10 + 2 = 1 * 10 + 2 = 12.
Since node 2 is a leaf, we return 12.
Back to Node 1:

Now, after calculating the left subtree, we move to the right child by calling dfs(3, 1).
Third DFS Call (Node 3):

The current node is 3, and num = 1.
The updated num is calculated as num * 10 + 3 = 1 * 10 + 3 = 13.
Since node 3 is a leaf, we return 13.
Final Calculation:

After processing both the left and right children of node 1, we sum the results: 12 + 13 = 25.
Thus, the total sum of root-to-leaf numbers is 25.*/
