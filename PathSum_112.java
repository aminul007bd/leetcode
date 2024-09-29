public class PathSum_112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) { // If the root is null (empty tree), there can't be any path, so return false.
            return false;
        }

        if (root.left == null && root.right == null) { // If the node is a leaf (no left or right child), check if its value equals the remaining targetSum.
            return targetSum == root.val;
        }

        boolean leftSum = hasPathSum(root.left, targetSum - root.val); // Recursively check the left subtree, subtracting the current node's value from the targetSum.
        boolean rightSum = hasPathSum(root.right, targetSum - root.val); // Recursively check the right subtree, subtracting the current node's value from the targetSum.

        return leftSum || rightSum; // If either the left or right subtree has a valid path that sums to targetSum, return true.
    }
}

/*
Walkthrough Example:

                 5
                / \
               4   8
               /   / \
               11  13  4
              /  \      \
             7    2      1

We are tasked with checking if there’s a path where the sum of node values equals 22.

Step 1: Start with root = 5 and targetSum = 22.
Subtract 5 from 22 → new targetSum = 17.
The node 5 is not a leaf, so we move on to check both subtrees.

Step 2: Move to the left child of 5 (node 4), and targetSum = 17.
Subtract 4 from 17 → new targetSum = 13.
The node 4 is not a leaf, so we move on to check both subtrees.

Step 3: Move to the left child of 4 (node 11), and targetSum = 13.
Subtract 11 from 13 → new targetSum = 2.
The node 11 is not a leaf, so we move on to check both subtrees.

Step 4: Move to the left child of 11 (node 7), and targetSum = 2.
Subtract 7 from 2 → new targetSum = -5.
The node 7 is a leaf, and its value does not match the targetSum, so return false for this path.

Step 5: Backtrack to node 11 and now check its right child (node 2), and targetSum = 2.
Subtract 2 from 2 → new targetSum = 0.
The node 2 is a leaf, and its value matches the targetSum, so return true.

Step 6: Since the left subtree from node 5 has a valid path, return true without checking the right subtree.

Time Complexity: O(n)
Each node is visited exactly once, so the time complexity is linear, where n is the number of nodes.
Space Complexity: O(h) (due to recursion)
The space complexity is proportional to the height h of the tree due to the recursion stack. In the worst case (skewed tree), the space complexity is O(n).
*/
