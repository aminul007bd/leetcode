/*
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is
the inorder traversal of the same tree, construct and return the binary tree.

Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
*/

import java.util.HashMap;
import java.util.Map;

/*Preorder (Root -> Left -> Right): [3, 9, 20, 15, 7]
Inorder (Left -> Root -> Right): [9, 3, 15, 20, 7]*/

public class ConstructBinaryTreefromPreorderandInorderTraversal_105 {

    private int preorderIndex; // Tracks the current index in the preorder traversal array.
    private Map<Integer, Integer> mapping; // Maps each value in the inorder array to its index for quick lookups.

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        mapping = new HashMap<>(); // Initialize the map to store value-to-index mappings of inorder array.
        for (int i = 0; i < inorder.length; i++) {
            mapping.put(inorder[i], i); // Fill the map with elements of inorder array and their corresponding indices.
        }

        preorderIndex = 0;  // Start at the first element of the preorder array.
        return build(preorder, 0, inorder.length - 1);  // Call the recursive function to build the tree, with the full inorder array bounds.
    }

    private TreeNode build(int[] preorder, int start, int end) {
        if (start > end) return null;  // Base case: If there are no elements to process, return null (no subtree here).

        //rootVal = preorder[0], which is 3.
        int rootVal = preorder[preorderIndex++]; // Pick the current element from preorder as the root node and increment the index.
        TreeNode root = new TreeNode(rootVal);  // Create the root node with the value from preorder array.
        int mid = mapping.get(rootVal); // Find the index of this root value in the inorder array using the map.

        root.left = build(preorder, start, mid - 1);  // Recursively build the left subtree using elements before the root in the inorder array.
        root.right = build(preorder, mid + 1, end);  // Recursively build the right subtree using elements after the root in the inorder array.

        return root; // Return the constructed subtree rooted at `root`.
    }
}
