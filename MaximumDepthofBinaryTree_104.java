/*Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Input: root = [3,9,20,null,null,15,7]
Output: 3*/

public class MaximumDepthofBinaryTree_104 {
    public int maxDepth(TreeNode root) { // Method to compute the maximum depth of the binary tree starting from the root.
        if (root == null) return 0; // Base case: if the current node is null, return 0 (an empty tree has depth 0).
        return Math.max(maxDepth(root.left), // Recursively compute the maximum depth of the left subtree.
                maxDepth(root.right)) // Recursively compute the maximum depth of the right subtree.
                + 1; // Add 1 to account for the current node's depth in the tree.
    }
}

/*
Walkthrough Example:
        1
       / \
       2   3
      /
     4
Start at the root node (1):
The left subtree (rooted at 2) has a depth of 2.
The right subtree (rooted at 3) has a depth of 1.
The maximum depth is the larger of the two (2), and adding 1 for the root gives a total depth of 3.*/
