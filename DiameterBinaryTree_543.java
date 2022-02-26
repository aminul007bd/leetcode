public class DiameterBinaryTree_543 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    private int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        longestPath(root);
        return diameter;
    }

    private int longestPath(TreeNode node) {
        if(node == null) return 0;
        // recursively find the longest path
        // both left and right child
        int leftPath = longestPath(node.left);
        int rightPath = longestPath(node.right);

        //update diameter if leftPath plus right path is larger
        diameter = Math.max(diameter, leftPath + rightPath);

        // return the longest
        // add 1 for its parent
        return Math.max(leftPath, rightPath) + 1;
    }

}
