/*Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Input: root = [1,2,3,4,5,null,7]
Output: [1,#,2,3,#,4,5,7,#]
Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node,
just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.*/

public class PopulatingNextRightPointersinEachNodeII_117 {
    public Node connect(Node root) {
        if (root == null || (root.left == null && root.right == null)) { // Base case: If the root is null or is a leaf node (no children), return the root as is.
            return root;
        }
        if (root.left != null && root.right != null) { // If both left and right children exist, connect them.
            root.left.next = root.right; // Connect left child to right child
            root.right.next = getNextHasChildrenNode(root); // Connect right child to next available child in other branches
        }
        if (root.left == null) { // If only the right child exists, connect it to the next available node.
            root.right.next = getNextHasChildrenNode(root); // Connect right child to the next node in the level
        }
        if (root.right == null) { // If only the left child exists, connect it to the next available node.
            root.left.next = getNextHasChildrenNode(root); // Connect left child to the next node in the level
        }
        // Recursively process the right subtree first, then the left subtree.
        root.right = connect(root.right);
        root.left = connect(root.left);

        return root; // Return the modified root node
    }

    public Node getNextHasChildrenNode(Node root) {
        // Traverse the linked 'next' nodes at the same level to find the next node that has children.
        while (root.next != null) {
            if (root.next.left != null) {
                return root.next.left; // Return the left child of the next node if it exists
            }
            if (root.next.right != null) {
                return root.next.right; // Return the right child of the next node if the left child doesn't exist
            }
            root = root.next; // Move to the next node in the same level
        }

        return null; // If no next node has children, return null
    }

}

/* Example Walkthrough:

Step 1:
Start with root = 1.
Connect 2 (left) to 3 (right). Now 2.next = 3.
Call getNextHasChildrenNode(root) for 3, but since there is no node after 3, 3.next = null.

Step 2:
Recurse into the right child 3. It has only a right child (7), so 7.next = null.
Recurse into the left child 2. Connect 4.next = 5 (left to right). Then, connect 5.next = 7 by calling getNextHasChildrenNode(root).

Final Connections:
At level 1: 1 -> null
At level 2: 2 -> 3 -> null
At level 3: 4 -> 5 -> 7 -> null

Time Complexity: O(n)
Each node is visited exactly once to connect its children, ensuring linear time complexity.
Space Complexity: O(1) (excluding recursion stack)

No additional data structures are used to store nodes or pointers, so the space complexity is constant, though recursion adds to the call stack.
This solution efficiently connects the next pointers in O(n) time complexity using recursion.*/
