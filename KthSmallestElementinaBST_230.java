/*Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed)
of all the values of the nodes in the tree.

Input: root = [3,1,4,null,2], k = 1
Output: 1*/

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementinaBST_230 {
    List<Integer> ans = new ArrayList<>();  // Create a list to store the elements of the BST in sorted order.

    public int kthSmallest(TreeNode root, int k) {
        inorder(root);  // Call the in-order traversal method to fill the 'ans' list with sorted values.
        return ans.get(k - 1);  // Return the Kth smallest element (k-1 because list indices start at 0).
    }

    private void inorder(TreeNode root) {  // Define the in-order traversal method.
        if (root == null) return;  // Base case: if the current node is null, return.

        inorder(root.left);  // Recursively traverse the left subtree.

        ans.add(root.val);  // Add the current node's value to the 'ans' list.

        inorder(root.right);  // Recursively traverse the right subtree.
    }
}

/*
Walkthrough Example
Let's consider the following Binary Search Tree (BST):

         5
        / \
       3   7
      / \   \
     2   4   8
Suppose we want to find the 2nd smallest element (k = 2).

Steps
Initial Setup:

The ans list is initially empty: ans = [].
Call to kthSmallest:

The method kthSmallest(root, 2) is called, where root is the root node (5).
In-order Traversal (This is the key part where the BST is traversed in sorted order):

Starting with the root node (5):

Call inorder(5).
Move to the left subtree: inorder(3).
For node 3:

Move to the left subtree: inorder(2).
For node 2:

Left subtree is null, so return.
Add 2 to ans: ans = [2].
Move to the right subtree: null, so return.
Back to node 3:

Add 3 to ans: ans = [2, 3].
Move to the right subtree: inorder(4).
For node 4:

Left subtree is null, so return.
Add 4 to ans: ans = [2, 3, 4].
Move to the right subtree: null, so return.
Back to node 5:

Add 5 to ans: ans = [2, 3, 4, 5].
Move to the right subtree: inorder(7).
For node 7:

Move to the left subtree: null, so return.
Add 7 to ans: ans = [2, 3, 4, 5, 7].
Move to the right subtree: inorder(8).
For node 8:

Left subtree is null, so return.
Add 8 to ans: ans = [2, 3, 4, 5, 7, 8].
Move to the right subtree: null, so return.
Completion of In-order Traversal:

The in-order traversal is complete, and the ans list is now sorted: ans = [2, 3, 4, 5, 7, 8].
Return the Result:

The method kthSmallest retrieves the 2nd smallest element using ans.get(2 - 1), which is ans.get(1) = 3.
Output
The output of the kthSmallest function for this tree with k = 2 will be:*/
