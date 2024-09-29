/*
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list.
If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]

*/

public class ReverseNodesink_Group_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1)
            return head; // Base case: if the list is empty, has one node, or no reversal needed (k == 1), return head.

        ListNode dummyhead = new ListNode(-1);     // Create a dummy node to ease the handling of the head of the list.
        ListNode begin; // Pointer to the node before the current k-group.
        dummyhead.next = head; // Connect dummyhead to the original head of the list.
        begin = dummyhead; // Initialize 'begin' to dummyhead.
        int i = 0; // Counter to keep track of the current node position in the list.

        while (head != null) { // Traverse the list.
            i++; // Increment counter for each node visited.
            if (i % k == 0) { // If we've reached the end of a k-group:
                begin = reverse(begin, head.next); // Reverse the k-group between 'begin' and 'head.next' and update 'begin' to the last node in the reversed group.
                head = begin.next; // Move 'head' to the next node after the reversed group.
            } else {
                head = head.next; // Otherwise, move 'head' forward.
            }
        }
        return dummyhead.next; // Return the new head of the reversed list.
    }

    public ListNode reverse(ListNode begin, ListNode end) {
        ListNode curr = begin.next; // Current node starts at the first node in the k-group (after 'begin').
        ListNode next, first; // 'next' will store the next node during traversal, 'first' is the original first node of the group.
        ListNode prev = begin; // 'prev' is initialized to 'begin', the node before the group.
        first = curr; // Store the first node of the group to reconnect later.

        while (curr != end) { // Traverse and reverse nodes in the group until 'curr' reaches 'end'.
            next = curr.next; // Temporarily store the next node.
            curr.next = prev; // Reverse the pointer of the current node.
            prev = curr; // Move 'prev' to the current node.
            curr = next; // Move 'curr' to the next node in the original sequence.
        }

        begin.next = prev; // Connect the node before the group to the new head of the reversed group.
        first.next = curr; // Connect the old first node (now the last) to 'curr' (the node after the reversed group).
        return first;   // Return the last node of the reversed group (now the new 'begin' for the next group).
    }
}


/*Walkthrough Example
Let's walk through an example using the list 1 -> 2 -> 3 -> 4 -> 5 -> 6 with k = 3. We want to reverse every 3 nodes in the list.

Initial Setup:

Input list: 1 -> 2 -> 3 -> 4 -> 5 -> 6
dummyhead is created with a value of -1 and points to the head: dummyhead -> 1 -> 2 -> 3 -> 4 -> 5 -> 6.
begin points to dummyhead, and i = 0.
First Loop Iteration (i = 1, 2, 3):

head moves from 1 to 3 as the loop increments i on each step.
When i % k == 0 (i.e., i = 3), the first k-group 1 -> 2 -> 3 is ready to be reversed.
        Call reverse(begin, head.next) to reverse the group 1 -> 2 -> 3.
Reversing Group 1 -> 2 -> 3:
curr starts at 1, prev is dummyhead, and first = 1.
Reverse 1 -> 2, making it dummyhead -> 1 <- 2 (still points to 3).
Reverse 2 -> 3, now it is dummyhead -> 1 <- 2 <- 3.
Connect dummyhead -> 3 -> 2 -> 1 -> 4 -> 5 -> 6.
Return 1 as the new begin, and head now points to 4.
Second Loop Iteration (i = 4, 5, 6):

head moves from 4 to 6.
When i % k == 0 (i.e., i = 6), the next k-group 4 -> 5 -> 6 is ready to be reversed.
        Call reverse(begin, head.next) to reverse the group 4 -> 5 -> 6.
Reversing Group 4 -> 5 -> 6:
curr starts at 4, prev is 1, and first = 4.
Reverse 4 -> 5, making it 1 -> 4 <- 5 (still points to 6).
Reverse 5 -> 6, now it is 1 -> 4 <- 5 <- 6.
Connect 1 -> 6 -> 5 -> 4.
Return 4 as the new begin, and head becomes null.
Final Output:

The loop exits as head is now null, and the function returns dummyhead.next.
        The final reversed list is 3 -> 2 -> 1 -> 6 -> 5 -> 4.*/
