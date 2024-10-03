/*Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left
subtree
of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Input: root = [2,1,3]
Output: true*/


public class ValidateBinarySearchTree_98 {
    public boolean isValidBST(TreeNode root) {  // Method to initiate the BST validation, taking the root of the tree as input.
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);  // Call the helper method 'valid' with the root node and initial min/max values.
    }

    private boolean valid(TreeNode node, long minimum, long maximum) {  // Helper method to check if a tree is a valid BST.
        if (node == null)
            return true;  // Base case: if the current node is null, it is considered valid (an empty tree is a valid BST).

        if (!(node.val > minimum && node.val < maximum))
            return false;  // Check if the current node's value is within the valid range.

        // Recursively check the left and right subtrees with updated min/max values.
        return valid(node.left, minimum, node.val) && valid(node.right, node.val, maximum);
    }
}

/*
Walkthrough Example
Consider the following Binary Search Tree (BST):

markdown
Copy code
                 2
                / \
                1   3
Let's validate if this tree is a valid BST.

Call to isValidBST:

We start by calling isValidBST(root) where root is the node with value 2.
The method calls valid(root, Long.MIN_VALUE, Long.MAX_VALUE) with:
node = 2
minimum = Long.MIN_VALUE (the smallest possible long value)
maximum = Long.MAX_VALUE (the largest possible long value)
First Call to valid(node, minimum, maximum):

Check if node is null: No, it’s 2.
Check if 2 is within the range (Long.MIN_VALUE < 2 < Long.MAX_VALUE): Yes.
        Now, recursively validate the left and right subtrees:
Call valid(node.left, Long.MIN_VALUE, 2) (for the left child).
Call valid(node.right, 2, Long.MAX_VALUE) (for the right child).
Left Subtree Validation (Node with Value 1):

Call: valid(node.left, Long.MIN_VALUE, 2) with node = 1, minimum = Long.MIN_VALUE, and maximum = 2.
Check if node is null: No, it’s 1.
Check if 1 is within the range (Long.MIN_VALUE < 1 < 2): Yes.
Recursively validate the left and right subtrees:
Call valid(node.left, Long.MIN_VALUE, 1) (left child).
Call valid(node.right, 1, 2) (right child).
Left Child of 1 (Null):

Call: valid(node.left, Long.MIN_VALUE, 1) with node = null.
Check if node is null: Yes. Return true.
Right Child of 1 (Null):

Call: valid(node.right, 1, 2) with node = null.
Check if node is null: Yes. Return true.
Return from Left Subtree Validation:

Both left and right subtree validations returned true, so return true for the node with value 1.
Right Subtree Validation (Node with Value 3):

Call: valid(node.right, 2, Long.MAX_VALUE) with node = 3, minimum = 2, and maximum = Long.MAX_VALUE.
        Check if node is null: No, it’s 3.
Check if 3 is within the range (2 < 3 < Long.MAX_VALUE): Yes.
Recursively validate the left and right subtrees:
Call valid(node.left, 2, 3) (left child).
Call valid(node.right, 3, Long.MAX_VALUE) (right child).
Left Child of 3 (Null):

Call: valid(node.left, 2, 3) with node = null.
Check if node is null: Yes. Return true.
Right Child of 3 (Null):

Call: valid(node.right, 3, Long.MAX_VALUE) with node = null.
Check if node is null: Yes. Return true.
Return from Right Subtree Validation:

Both left and right subtree validations returned true, so return true for the node with value 3.
Final Return:
Both left and right subtree validations for the root node (value 2) returned true, so the final result from isValidBST(root) is true.
*/
