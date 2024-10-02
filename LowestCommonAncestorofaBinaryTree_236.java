/*
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in
T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
*/

public class LowestCommonAncestorofaBinaryTree_236 {
    // Here we are doing DFS search Algo
    // In the traversal where ever we get the p or q we return it,
    //while returnning for a node from left there can be a null or p or q,
    // if both left and right are not null means one will be p and other will be q
    // if left if null then right can be p or q
    // if right if null then left can be p or q
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //In the traversal where ever we get the p or q we return it , if we reach null then simply return(Base cases)
        if (root == p) return p;
        if (root == q) return q;
        if (root == null) return null;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null)
            return root; //if both left and right are not null means one will be p and other will be q

        if (left == null) { // if left if null then right can be p or q
            return right;
        } else {
            return left;    // right == null ,  if right if null then left can be p or q
        }
    }

    // Brute Force will be:
    // For p do a search from root to p , For q do a search from root to q
    // Keep on storing the nodes in the path, afterwards compare that if any of the path matched from dowards then that will be the ans.
}
