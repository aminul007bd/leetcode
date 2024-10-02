/* Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.

Input: root = [1,2,5,3,4,null,6]
Output: [1,null,2,null,3,null,4,null,5,null,6] */

public class FlattenBinaryTreetoLinkedList_114 {

    TreeNode head = null;  // Declare a class-level variable `head`, initially set to null. This will help in keeping track of the last processed node during the reverse pre-order traversal.

    public void flatten(TreeNode root) {
        if (root != null)
            revPreOrder(root);  // If the root is not null, start the reverse pre-order traversal from the root.
    }

    // order of line matter
    private void revPreOrder(TreeNode node) {

        if (node.right != null)
            revPreOrder(node.right); // If there is a right child, recursively flatten the right subtree first.

        if (node.left != null)
            revPreOrder(node.left); // If there is a left child, recursively flatten the left subtree next.

        node.left = null; // Set the left child of the current node to null, as we are flattening into a linked list-like structure.

        node.right = head; // Set the right child of the current node to the previous node in the reverse pre-order traversal (stored in `head`).

        head = node; // Move the `head` pointer to the current node. This step effectively shifts the head of the list back.
    }

}

/*
Step-by-Step Walkthrough:
Initial Call:

Call flatten(root), where root = 1.
Since root is not null, call revPreOrder(1).
First Reverse Pre-order Traversal on Node 1:

Call revPreOrder(1).
The right child of 1 is 5, so call revPreOrder(5).
Reverse Pre-order Traversal on Node 5:

Call revPreOrder(5).
The right child of 5 is 6, so call revPreOrder(6).
Reverse Pre-order Traversal on Node 6:

Call revPreOrder(6).
        6 has no right or left child, so set 6.left = null and 6.right = head (null), then update head = 6.
This makes 6 the new head of the flattened list.
Backtrack to Node 5:

Set 5.left = null and 5.right = head (6), then update head = 5.
The flattened structure now looks like this:
rust
Copy code
5 -> 6
Backtrack to Node 1:

Now process the left child of 1, which is 2, so call revPreOrder(2).
Reverse Pre-order Traversal on Node 2:

Call revPreOrder(2).
The right child of 2 is 4, so call revPreOrder(4).
Reverse Pre-order Traversal on Node 4:

Call revPreOrder(4).
        4 has no children, so set 4.left = null and 4.right = head (5), then update head = 4.
The flattened structure now looks like this:
rust
Copy code
4 -> 5 -> 6
Backtrack to Node 2:

Now process the left child of 2, which is 3, so call revPreOrder(3).
Reverse Pre-order Traversal on Node 3:

Call revPreOrder(3).
        3 has no children, so set 3.left = null and 3.right = head (4), then update head = 3.
The flattened structure now looks like this:
rust
Copy code
3 -> 4 -> 5 -> 6
Backtrack to Node 2:

Set 2.left = null and 2.right = head (3), then update head = 2.
The flattened structure now looks like this:
rust
Copy code
2 -> 3 -> 4 -> 5 -> 6
Backtrack to Node 1:

Set 1.left = null and 1.right = head (2), then update head = 1.
The final flattened structure is:
rust
Copy code
1 -> 2 -> 3 -> 4 -> 5 -> 6
Final Flattened Tree (Right Child Only):
rust
Copy code
1 -> 2 -> 3 -> 4 -> 5 -> 6
Time Complexity: O(n)
Every node is visited once during the reverse pre-order traversal, so the time complexity is linear in terms of the number of nodes, n.
Space Complexity: O(h) (due to recursion)
The space complexity is proportional to the height h of the tree due to the recursion stack. In the worst case (skewed tree), it can be O(n).*/
