import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
(i.e., from left to right, then right to left for the next level and alternate between).

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]*/

public class BinaryTreeZigzagLevelOrderTraversal_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>(); // Initialize the result list where each sublist will store node values from a particular level.
        travel(root, ans, 0); // Start the recursive traversal from the root node at level 0.
        return ans;                                   // After traversal, return the result list.
    }

    private void travel(TreeNode root, List<List<Integer>> ans, int level) {
        if (root == null)
            return; // Base case: if the current node is null, return (end recursion for this path).

        if (ans.size() == level) // If the current level doesn't exist in 'ans' yet:
        {
            List<Integer> newLevel = new LinkedList<>(); // Create a new list for the current level.
            ans.add(newLevel); // Add this new level list to 'ans'.
        }

        List<Integer> collection = ans.get(level); // Retrieve the list corresponding to the current level.

        if (level % 2 == 0) // If the current level is even:
            collection.add(root.val); // Add the current node's value to the end of the list.
        else    // If the current level is odd:
            collection.add(0, root.val); // Add the current node's value to the start of the list (reverse order for zigzag effect).

        travel(root.left, ans, level + 1); // Recursively traverse the left subtree, increasing the level.
        travel(root.right, ans, level + 1);// Recursively traverse the right subtree, increasing the level.
    }
}

/*
Walkthrough Example:
Let's say we have the following binary tree:
         1
        / \
       2   3
      / \   \
     4   5   6

We want to perform a zigzag level-order traversal, so the output should be:

    [ [1],          // Level 0 (left to right)
    [3, 2],       // Level 1 (right to left)
    [4, 5, 6]     // Level 2 (left to right)
    ]

Step-by-Step Execution:
Initial Call:

zigzagLevelOrder(root) is called with the root of the tree (node with value 1).
First Level (root level):

travel(1, sol, 0) is called.
Since sol.size() <= 0, a new list for level 0 is created and added to sol.
Node 1 is added to the level 0 list (as it is an even level, it is added to the end).
Now, the sol looks like: [[1]].
Recursively call travel for the left child (node 2) and right child (node 3) at level 1.
Second Level (level 1):

travel(2, sol, 1) is called for the left child.

Since sol.size() <= 1, a new list for level 1 is created and added to sol.

Node 2 is added to the level 1 list (as it is an odd level, it is added to the front).

Now, the sol looks like: [[1], [2]].

Recursively call travel for its children (nodes 4 and 5) at level 2.

Next, travel(3, sol, 1) is called for the right child.

        Node 3 is added to the level 1 list (since it is odd, it is also added to the front).

Now, the sol looks like: [[1], [3, 2]].

Recursively call travel for the right child (node 6) at level 2.

Third Level (level 2):

travel(4, sol, 2) is called.

Since sol.size() <= 2, a new list for level 2 is created.

Node 4 is added to the level 2 list (even level, added to the end).

Now, the sol looks like: [[1], [3, 2], [4]].

travel(5, sol, 2) is called for the right child of node 2.

Node 5 is added to the level 2 list.

        Now, the sol looks like: [[1], [3, 2], [4, 5]].

travel(6, sol, 2) is called for the right child of node 3.

Node 6 is added to the level 2 list.

        Now, the sol looks like: [[1], [3, 2], [4, 5, 6]].

End of Recursion:

Since there are no more children to process, the recursion terminates and the sol list is returned as the final output.*/
