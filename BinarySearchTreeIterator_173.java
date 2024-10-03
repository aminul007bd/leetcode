/*Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):
Input
["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
        [[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
Output
[null, 3, 7, true, 9, true, 15, true, 20, false]
*/

import java.util.Stack;

// Left Subtree --> Root Node ---> Right Subtree (in order traversal)
public class BinarySearchTreeIterator_173 {
    Stack<TreeNode> stack;  // A stack to store nodes as we traverse the tree.

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();  // Initialize the stack.
        updateStack(root);  // Push all the leftmost nodes from the root onto the stack.
    }

    public int next() {
        TreeNode toRemove = stack.pop();  // Get the next node in in-order by popping the top of the stack.
        updateStack(toRemove.right);  // If the popped node has a right child, push its left subtree onto the stack.
        return toRemove.val;  // Return the value of the node.
    }

    public boolean hasNext() {
        return !stack.isEmpty();  // Check if there are more nodes to visit by seeing if the stack is empty.
    }

    public void updateStack(TreeNode node) {
        while (node != null) {
            stack.add(node);  // Add the current node to the stack.
            node = node.left;  // Move to the left child, pushing all left children onto the stack.
        }
    }
}
/*
Example Walkthrough:
Consider this BST:
Copy code
         7
        / \
       3  15
          / \
         9  20

When you initialize BSTIterator with the root (7), the stack is updated by updateStack(), pushing the nodes 7 and 3 onto the stack:
Stack: [7, 3]
Calling next():
The top of the stack (3) is popped and returned.
The stack becomes:
Stack: [7]

Since 3 has no right child, no more nodes are added to the stack.
Output: 3
Calling next() again:
The top of the stack (7) is popped and returned.
The stack is empty now:

Stack: []
Since 7 has a right child (15), the updateStack() method is called, and 15 and 9 are pushed onto the stack (because we traverse the left children of 15):

Stack: [15, 9]
Output: 7
Calling next() again:

The top of the stack (9) is popped and returned.
The stack now contains:

Stack: [15]
Since 9 has no right child, no more nodes are added.
Output: 9
Calling next() again:

The top of the stack (15) is popped and returned.
The stack is now empty:

Stack: []
Since 15 has a right child (20), the updateStack() method is called, and 20 is added to the stack:

Stack: [20]
Output: 15
Calling next() one last time:

The top of the stack (20) is popped and returned.
The stack is now empty:

Stack: []
Output: 20
hasNext() now returns false because the stack is empty.*/
