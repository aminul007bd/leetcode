/*Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
Input: root = [1,2,2,3,4,4,3]
Output: true*/

public class SymmetricTree_101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;

        if (n1 == null || n2 == null || n1.val != n2.val) return false;

        return isMirror(n1.left, n2.right) && isMirror(n1.right, n2.left);
    }
}
