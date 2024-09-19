import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageLevelsBinaryTree_637 {

    //Input: root = [3,9,20,15,7]
    //Output: [3.00000,14.50000,11.00000]
    // BFS approach

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return result;
        queue.add(root);
        while (!queue.isEmpty()) {
            double level_sum = 0, count = 0;
            Queue<TreeNode> temp = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode curr_node = queue.remove();
                level_sum += curr_node.val;
                count++;
                if (curr_node.left != null) temp.add(curr_node.left);
                if (curr_node.right != null) temp.add(curr_node.right);
            }
            queue = temp;
            result.add(level_sum * 1.0 / count);
        }
        return result;
    }
}
