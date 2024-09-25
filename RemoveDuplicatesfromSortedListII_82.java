/*
Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
Return the linked list sorted as well.
Example:
Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]
*/

public class RemoveDuplicatesfromSortedListII_82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;  // Edge case: If the list is empty, return null

        ListNode dummy = new ListNode(0);  // Dummy node to handle cases where head has duplicates
        dummy.next = head; // dummy -> 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5
        ListNode prev = dummy;  // Pointer to the last node that is guaranteed to be distinct

        while (head != null) {
            // If we have found the beginning of duplicates sublist
            // skip all the nodes in this duplicate sublist
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next; // Move the head pointer to the end of duplicates sublist
                }
                prev.next = head.next; // Skip all duplicates
            } else {
                prev = prev.next; // Otherwise, move the prev pointer
            }
            head = head.next; // Move forward
        }

        return dummy.next;  // Return the head of the modified list
    }
}

/*Applying the Example
For the list 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5:

First Iteration: head is 1, not a duplicate. Move prev and head forward.
List: dummy -> 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5

Second Iteration: head is 2, not a duplicate. Move prev and head forward.
List: dummy -> 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5

Third Iteration: head is 3, which is a duplicate (next node is also 3). Skip all 3s.
After skipping, prev.next is updated to 4.
List: dummy -> 1 -> 2 -> 4 -> 4 -> 5

Fourth Iteration: head is 4, which is a duplicate (next node is also 4). Skip all 4s.
After skipping, prev.next is updated to 5.
List: dummy -> 1 -> 2 -> 5

Fifth Iteration: head is 5, not a duplicate. Move prev and head forward.
List: dummy -> 1 -> 2 -> 5
At the end of the loop, the modified list is 1 -> 2 -> 5, which is returned as the result.

Final Result
The function returns the linked list 1 -> 2 -> 5, which contains only the distinct elements from the original list.*/
