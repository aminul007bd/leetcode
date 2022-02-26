import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthBFS_111 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int minDepth(TreeNode root){
        if(root == null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode curr_node = queue.poll();
                if(curr_node != null && curr_node.left == null && curr_node.right == null) return depth;
                if(curr_node.left != null) queue.add(curr_node.left);
                if(curr_node.right != null) queue.add(curr_node.right);
            }
            depth++;
        }
        return -1;
    }
}
