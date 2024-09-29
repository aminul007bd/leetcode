/*Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree,
construct and return the binary tree.

Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]*/

import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/*PostOrder ( Left -> Right--> Root): [3, 9, 20, 15, 7]
Inorder (Left -> Root -> Right): [9, 3, 15, 20, 7]*/
public class ConstructBinaryTreefromInorderandPostorderTraversal_106 {

    private int postorderIndex;
    private Map<Integer, Integer> mapping;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        mapping = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            mapping.put(inorder[i], i);
        }

        postorderIndex = postorder.length - 1;  // Start from the last index of postorder
        return build(postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int start, int end) {
        // Base case: if the current range is invalid
        if (start > end) return null;

        // Get the current root value from the postorder array
        int rootVal = postorder[postorderIndex--];
        TreeNode root = new TreeNode(rootVal);

        // Find the index of the root in the inorder array
        int mid = mapping.get(rootVal);

        // Recursively build the right and left subtrees
        root.right = build(postorder, mid + 1, end);  // Build right subtree first
        root.left = build(postorder, start, mid - 1);  // Then build left subtree

        return root;
    }
}
