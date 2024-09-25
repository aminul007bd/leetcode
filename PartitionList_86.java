/*
Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.
Example:
Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]
*/

public class PartitionList_86 {
    public ListNode partition(ListNode head, int x) {
        ListNode before = new ListNode(0); // Create a dummy node 'before' to start the list of nodes < x
        ListNode after = new ListNode(0);// Create a dummy node 'after' to start the list of nodes >= x
        ListNode before_curr = before; // Pointer to build the 'before' list
        ListNode after_curr = after; // Pointer to build the 'after' list

        while (head != null) {// Traverse the original list until the end
            if (head.val < x) { // If the current node's value is less than x,
                before_curr.next = head; // append it to the 'before' list.
                before_curr = before_curr.next;// Move the 'before' pointer forward.
            } else { // If the current node's value is greater than or equal to x,
                after_curr.next = head; // append it to the 'after' list.
                after_curr = after_curr.next; // Move the 'after' pointer forward.
            }
            head = head.next; // Move to the next node in the original list.
        }

        after_curr.next = null; // Terminate the 'after' list to prevent cycles.
        before_curr.next = after.next; // Connect the 'before' list with the 'after' list.

        return before.next; // Return the head of the 'before' list, which is the new partitioned list.
    }
}
/*
Walkthrough Example
Let's use the example list: 1 -> 4 -> 3 -> 2 -> 5 -> 2 with x = 3.

Initial Setup:
before and after are dummy nodes that start at 0.
before_curr and after_curr point to these dummy nodes.

Iteration 1: (head points to 1)
1 < 3, so 1 is added to the before list.
before_curr now points to 1.

Iteration 2: (head points to 4)
4 >= 3, so 4 is added to the after list.
after_curr now points to 4.

Iteration 3: (head points to 3)
3 >= 3, so 3 is added to the after list.
after_curr now points to 3.

Iteration 4: (head points to 2)
2 < 3, so 2 is added to the before list.
before_curr now points to 2.

Iteration 5: (head points to 5)
5 >= 3, so 5 is added to the after list.
after_curr now points to 5.

Iteration 6: (head points to 2)
2 < 3, so 2 is added to the before list.
before_curr now points to the second 2.

After Loop:
The loop ends, and head is null.
after_curr.next = null ensures the after list ends properly.
before_curr.next = after.next connects the last node in the before list to the first node in the after list.

Result:
The combined list is 1 -> 2 -> 2 -> 4 -> 3 -> 5.
The method returns before.next, which points to the new head of the partitioned list.
Final Partitioned List
For the input list 1 -> 4 -> 3 -> 2 -> 5 -> 2 and x = 3, the partitioned list will be 1 -> 2 -> 2 -> 4 -> 3 -> 5.
All nodes with values less than 3 are placed before the nodes with values greater than or equal to 3.*/
