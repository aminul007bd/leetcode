/*Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

Input: p = [1,2,3], q = [1,2,3]
Output: true*/


public class SameTree_100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Base case: if both trees are null, they are identical
        if (p == null && q == null) {
            return true;
        }
        // If only one tree is null or the values are different, they are not identical
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        // Recursively check if the left and right subtrees are identical
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}


/*
Step-by-Step Execution:
Root Check:

The method starts by comparing the root nodes of both trees, p and q, which both have the value 1.
Since both nodes are not null and their values are the same (1 == 1), the method proceeds to check the left and right subtrees.
Left Subtree Check:

The method is recursively called on the left children of both nodes, p.left and q.left (both have the value 2).
Again, since neither node is null and their values are the same (2 == 2), the method continues to check the left and right subtrees of these nodes.
Further Left Subtree Check:

Both p.left.left and q.left.left are null (because the node with value 2 does not have children in either tree).
Since both nodes are null, the method returns true for this subtree.
Further Right Subtree Check:

Both p.left.right and q.left.right are null.
Since both are null, the method returns true for this subtree.
Right Subtree Check (Nodes with Value 3):

Now, the method is called on the right children of the root nodes, p.right and q.right (both have the value 3).
Both nodes are not null, and their values are the same (3 == 3), so the method continues to check the left and right subtrees of these nodes.
Further Left Subtree Check:

Both p.right.left and q.right.left are null.
Since both are null, the method returns true for this subtree.
Further Right Subtree Check:

Both p.right.right and q.right.right are null.
Since both are null, the method returns true for this subtree.*/
