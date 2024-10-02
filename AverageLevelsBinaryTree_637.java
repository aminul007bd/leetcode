import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


//Input: root = [3,9,20,15,7]
//Output: [3.00000,14.50000,11.00000]
// BFS approach

public class AverageLevelsBinaryTree_637 {
    public List<Double> averageOfLevels(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>(List.of(root)); // Initialize a queue to facilitate level-order traversal. Start with the root node.
        List<Double> ans = new ArrayList<>(); // Initialize a list to store the average values for each level.

        while (!q.isEmpty()) { // While there are still nodes to process in the queue.
            double qlen = q.size(), row = 0; // Store the number of nodes at the current level (size of the queue).

            for (int i = 0; i < qlen; i++) { // Loop through all nodes at the current level.
                TreeNode curr = q.poll(); // Dequeue the first node in the queue.
                row += curr.val; // Add the value of the current node to the running sum for this level.
                if (curr.left != null)
                    q.offer(curr.left); // If the current node has a left child, enqueue it for the next level.
                if (curr.right != null)
                    q.offer(curr.right); // If the current node has a right child, enqueue it for the next level.
            }
            ans.add(row / qlen); // After processing all nodes at this level, calculate the average and add it to the answer list.
        }

        return ans; // Return the list of averages for each level.
    }
}

/*
Walkthrough Example:
Let’s walk through the code with the following binary tree:

         3
        / \
       9  20
       /   \
      15   7

Level 0:
The root node (3) is added to the queue.
The queue contains: [3].
qlen = 1, because there is 1 node at this level.
row = 0.
The node 3 is dequeued, and its value is added to row, so row = 3.
The left child (9) and right child (20) of node 3 are enqueued.
The queue now contains: [9, 20].
The average for this level is 3 / 1 = 3.0, so ans = [3.0].

Level 1:
The queue contains: [9, 20].
qlen = 2, because there are 2 nodes at this level.
row = 0.
The node 9 is dequeued, and its value is added to row, so row = 9.
The node 20 is dequeued, and its value is added to row, so row = 29.
The left child (15) and right child (7) of node 20 are enqueued.
The queue now contains: [15, 7].
The average for this level is 29 / 2 = 14.5, so ans = [3.0, 14.5].
Level 2:

The queue contains: [15, 7].
qlen = 2, because there are 2 nodes at this level.
        row = 0.
The node 15 is dequeued, and its value is added to row, so row = 15.
The node 7 is dequeued, and its value is added to row, so row = 22.
The queue is now empty.
The average for this level is 22 / 2 = 11.0, so ans = [3.0, 14.5, 11.0].
Final Output:

The tree traversal is complete, and the list of averages for each level is [3.0, 14.5, 11.0].
Time Complexity:
O(n), where n is the total number of nodes in the tree. Each node is visited exactly once.
Space Complexity:
O(m), where m is the maximum number of nodes at any level (which is the maximum width of the tree).
This space is required for the queue used in level-order traversal.*/
