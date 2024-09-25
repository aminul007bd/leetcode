public class RotateList_61 {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null) return null; // If the list is empty, return null.
        if (head.next == null) return head; // If the list has only one node, return the head as no rotation is needed.

        // close the linked list into the ring
        ListNode old_tail = head; // Initialize old_tail to point to the head.
        int n; // Variable to count the number of nodes in the list.
        for (n = 1; old_tail.next != null; n++) { // Traverse the list to find the last node and count the nodes.
            old_tail = old_tail.next;
        }
        old_tail.next = head; // Connect the last node to the head, forming a circular linked list.

        ListNode new_tail = head;  // Start new_tail at the head.
        for (int i = 0; i < n - k % n - 1; i++) { // Move new_tail to the (n - k % n - 1)th node.
            new_tail = new_tail.next;
        }
        ListNode new_head = new_tail.next; // The new head is the next node after new_tail.

        // break the ring
        new_tail.next = null; // Break the circular linked list to form the rotated list.

        return new_head;  // Return the new head of the rotated list.
    }
}

/*Walkthrough Example
Let's use the list 1 -> 2 -> 3 -> 4 -> 5 and k = 2 to see how the rotation works.
The goal is to rotate the list to the right by 2 positions.

Initial Setup:
Input: 1 -> 2 -> 3 -> 4 -> 5, k = 2.

Base Cases:
The list is not empty (head != null), and it has more than one node (head.next != null), so the code proceeds.

Close the Linked List into a Ring:
old_tail is initialized to head, which points to 1.
The for loop traverses the list to find the last node and counts the number of nodes (n):
After first iteration: old_tail = 2, n = 2.
After second iteration: old_tail = 3, n = 3.
After third iteration: old_tail = 4, n = 4.
After fourth iteration: old_tail = 5, n = 5.
old_tail.next is set to head, creating a circular list: 1 -> 2 -> 3 -> 4 -> 5 -> (back to) 1 -> ....

Find the New Tail and New Head:
new_tail starts at head, which is 1.
The for loop moves new_tail to the (n - k % n - 1)th node:
k % n = 2 % 5 = 2, so n - k % n - 1 = 5 - 2 - 1 = 2.
After first iteration: new_tail = 2.
After second iteration: new_tail = 3.
new_head is set to new_tail.next, which is 4.

Break the Ring:
new_tail.next is set to null, breaking the circular list.
Now, the list is split as 3 -> 4 -> 5 and 1 -> 2.

Return the Rotated List:
The function returns new_head, which points to 4.
The final rotated list is 4 -> 5 -> 1 -> 2 -> 3.

Final Result
For the input list 1 -> 2 -> 3 -> 4 -> 5 and k = 2,
the method returns 4 -> 5 -> 1 -> 2 -> 3, which is the original list rotated to the right by 2 positions.*/
