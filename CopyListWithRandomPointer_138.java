/*
A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.

Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node.
Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state.
None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.

Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
*/


import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithRandomPointer_138 {
    // space complexity O(n)
    public Node copyRandomList(Node head) {
        if (head == null) return null; // Step 1: Handle the edge case where the input list is empty.
        Map<Node, Node> map = new HashMap<Node, Node>(); // Step 2: Create a HashMap to store the mapping from original nodes to their copies.
        Node node = head;
        while (node != null) {// Step 3: First loop - copy all the nodes and store them in the map.
            map.put(node, new Node(node.val)); // Create a copy of each node with the same label (but without setting next or random pointers yet).
            node = node.next; // Move to the next node in the original list.
        }

        node = head; // Step 4: Second loop - assign next and random pointers for the copied nodes.
        while (node != null) {
            map.get(node).next = map.get(node.next); // Set the 'next' pointer of the copied node.
            map.get(node).random = map.get(node.random); // Set the 'random' pointer of the copied node.
            node = node.next; // Move to the next node in the original list.
        }

        return map.get(head); // Step 5: Return the head of the copied linked list.
    }

    // space complexity O(1)
    public Node copyRandomList1(Node head) {
        if (head == null) return null; // Step 1: Handle the case where the input list is empty.
        Node curr = head; // Step 2: Interweave the original list with the copied nodes.
        while (curr != null) {
            Node new_node = new Node(curr.val, curr.next); // Create a new node that is a copy of the current node.
            curr.next = new_node; // Insert the new node right after the current node.
            curr = new_node.next; // Move to the next node in the original list.
        }
        // Step 3: Assign random pointers to the copied nodes.
        curr = head; //  reset the curr pointer back to the start of the original linked list so that we can perform a second traversal
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next; // Set the random pointer of the new node.
            }
            curr = curr.next != null ? curr.next.next : null; // Move to the next original node (skip the copied node).
        }

        // Step 4: Separate the copied list from the original list.
        Node old_head = head;
        Node new_head = head.next;
        Node curr_old = old_head;
        Node curr_new = new_head;

        while (curr_old != null) {
            curr_old.next = curr_old.next.next; // Restore the original list.
            curr_new.next = curr_new.next != null ? curr_new.next.next : null; // Link the copied nodes together.
            curr_old = curr_old.next; // Move to the next nodes in both lists.
            curr_new = curr_new.next;
        }

        return new_head; // Step 5: Return the head of the copied list.
    }
}

/*
Step 1: Initial Setup
Code: Node curr = head;
Explanation: We start by setting curr to point to the head of the original list.
Image: A single linked list with nodes labeled 1 → 2 → 3, with curr pointing to the first node.

Step 2: Interleaving Copied Nodes
Code: Node new_node = new Node(curr.val, curr.next);
Explanation: For each node in the list, create a new node with the same value and insert it right after the current node.
Image: Each node has a new copy inserted right after it, so the list looks like 1 → 1' → 2 → 2' → 3 → 3', where 1', 2', 3' are the copied nodes.
curr moves through the list during this process.

Step 3: Resetting curr to Head
Code: curr = head;
Explanation: Reset curr back to the head of the list to start a new traversal.
Image: Show curr pointing back to the first original node (1) in the now interleaved list.

Step 4: Setting Random Pointers for Copied Nodes
Code: if (curr.random != null) { curr.next.random = curr.random.next; }
Explanation: For each original node, set the random pointer of the copied node to the copy of the node that the original node’s random pointer points to.
Image: Highlight how the random pointers for the copied nodes are set correctly. For example, if 1.random → 3, then 1'.random → 3'.

Step 5: Separating the Copied List
Code: Node old_head = head; Node new_head = head.next;
Explanation: We prepare to separate the two lists by defining pointers to traverse the original and copied lists.
Image: Two pointers, curr_old and curr_new, are shown to traverse the original and copied lists, respectively.

Step 6: Final Separation
Code: curr_old.next = curr_old.next.next; curr_new.next = curr_new.next != null ? curr_new.next.next : null;
Explanation: We unlink the copied nodes from the original nodes, resulting in two independent lists.
Image: Show the final state where the original list (1 → 2 → 3) is separated from the copied list (1' → 2' → 3').
*/
