/*Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.
Input: root = [4,2,6,1,3]
Output: 1*/

public class MinimumAbsoluteDifferenceinBST_530 {
    TreeNode prev = null; // Declare a global variable to track the previous node in the in-order traversal.
    int ans = Integer.MAX_VALUE; // Initialize the global variable 'ans' to store the minimum difference between two nodes.

    public int getMinimumDifference(TreeNode root) {  // Function to initiate the in-order traversal and return the result.
        inorder(root);  // Call the in-order traversal function on the root node.
        return ans;  // Return the minimum difference after traversal is complete.
    }

    private void inorder(TreeNode root) { // Define an in-order traversal function.
        if (root == null) return; // Base case: if the root is null, return.
        inorder(root.left);  // Traverse the left subtree first (in-order traversal).

        if (prev != null)  // If the previous node is not null (meaning it's not the first node being processed),
            ans = Math.min(ans, root.val - prev.val);  // Calculate the difference between the current node's value and the previous node's value, and update the minimum difference.

        prev = root;  // Update 'prev' to the current node.

        inorder(root.right);  // Traverse the right subtree.
    }
}
