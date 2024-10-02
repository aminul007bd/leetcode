/*A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them.
A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.

Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.*/

public class BinaryTreeMaximumPathSum_124 {
    int max = Integer.MIN_VALUE; //initialise a class level max variable

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        sum(root);

        return max;
    }

    public int sum(TreeNode root) {
        if (root == null) return 0; //for leaf node, sum contribution=0

        //if negative, will never contribute to max sum, so ignore
        int lsum = Math.max(sum(root.left), 0);
        int rsum = Math.max(sum(root.right), 0);

        //sum at self node will be sum of all
        int self = root.val + rsum + lsum;
        max = Math.max(max, self);
        //now if we have to go up a node, contribution will come from any one side left or right
        return Math.max(rsum, lsum) + root.val;
    }
}

/*
We will step through the code execution.

                       -10
                       /  \
                       9   20
                       /  \
                       15   7


Step 1: Start at the root (-10)
Call sum(-10)
Initialize lsum = sum(9) and rsum = sum(20)

Step 2: Left Subtree of Root (9)
Call sum(9):
Both left and right children are null, so lsum = 0 and rsum = 0.
self = 9 + 0 + 0 = 9.
Update max = Math.max(-∞, 9) = 9.
Return 9 to the root, as the contribution to the path from this side is 9.

Step 3: Right Subtree of Root (20)
Call sum(20)
Initialize lsum = sum(15) and rsum = sum(7)

Step 4: Left Child of 20 (15)
Call sum(15):
Both left and right children are null, so lsum = 0 and rsum = 0.
self = 15 + 0 + 0 = 15.
Update max = Math.max(9, 15) = 15.
Return 15 to the node 20.

Step 5: Right Child of 20 (7)
Call sum(7):
Both left and right children are null, so lsum = 0 and rsum = 0.
self = 7 + 0 + 0 = 7.
max = Math.max(15, 7) = 15.
Return 7 to the node 20.

Step 6: Calculate at Node 20
Now at node 20, with lsum = 15 and rsum = 7.
self = 20 + 15 + 7 = 42.
Update max = Math.max(15, 42) = 42.
Return 20 + Math.max(15, 7) = 35 to the root (-10).

Step 7: Final Calculation at Root (-10)
Now at the root (-10), with lsum = 9 and rsum = 35.
self = -10 + 9 + 35 = 34.
max = Math.max(42, 34) = 42.*/
