import java.util.ArrayList;
import java.util.List;

/*Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]*/
public class BinaryTreeLevelOrderTraversal_102 {

    // Main method to perform level-order traversal
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();  // Result list to hold all levels
        traverseLevel(root, 0, ans);  // Start traversal from root and level 0
        return ans;  // Return the final result
    }

    // Helper method to recursively traverse the tree in level-order
    private void traverseLevel(TreeNode root, int level, List<List<Integer>> ans) {
        if (root == null) {
            return;  // Base case: if node is null, return (nothing to add)
        }

        // If we're at a new level that hasn't been added to the list yet
        if (ans.size() == level) {
            ans.add(new ArrayList<>());  // Create a new list for this level
        }

        ans.get(level).add(root.val);  // Add the current node value to its corresponding level list

        // Recur for left and right subtrees, increasing the level by 1
        traverseLevel(root.left, level + 1, ans);  // Traverse the left subtree
        traverseLevel(root.right, level + 1, ans); // Traverse the right subtree
    }

}
