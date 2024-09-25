/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.
Example:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
*/

public class RemoveNthNodeFromEndofList_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head; // Initialize two pointers, 'fast' and 'slow', both pointing to the head of the list.

        for (int i = 0; i < n; i++) fast = fast.next; // Move the 'fast' pointer n steps ahead in the list.

        if (fast == null)
            return head.next;// If 'fast' is null after moving n steps, it means the node to remove is the head.
        // Return the next node as the new head.
        while (fast.next != null) { // Move both 'fast' and 'slow' pointers until 'fast' reaches the last node.
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next; // 'slow' now points to the node just before the one that needs to be removed. Skip the target node by adjusting 'slow.next'.

        return head; // Return the original head of the list.
    }
}

/*
Walkthrough Example
Let's walk through an example to see how this code works. Consider the list: 1 -> 2 -> 3 -> 4 -> 5, and n = 2.
The goal is to remove the 2nd node from the end of the list (which is 4).

Initial Setup:
fast and slow both point to the head of the list: 1 -> 2 -> 3 -> 4 -> 5.
Move fast Forward by n Steps:

The for loop moves fast forward by n steps (n = 2).
After the first iteration, fast points to 2 -> 3 -> 4 -> 5.
After the second iteration, fast points to 3 -> 4 -> 5.
Now, fast is 2 steps ahead of slow.
Check if fast is Null:

The code checks if fast is null. If it were null, it would mean that the list has exactly n nodes, and the head needs to be removed.
In this case, fast is not null, so the code proceeds to the next step.
Move Both fast and slow Until fast Reaches the Last Node:

The while loop moves both fast and slow pointers one step at a time until fast.next is null.
After the first iteration:
fast points to 4 -> 5.
slow points to 2 -> 3 -> 4 -> 5.
After the second iteration:
fast points to 5.
slow points to 3 -> 4 -> 5.
Now, fast points to the last node, and slow points to the node just before the one that needs to be removed.
Remove the nth Node from the End:

slow.next = slow.next.next skips the 4, effectively removing it from the list. Now, slow.next points to 5.
Return the Resulting List:

The method returns the head of the modified list, which is still 1 -> 2 -> 3 -> 5.
Final Result
For the input list 1 -> 2 -> 3 -> 4 -> 5 and n = 2, the method returns 1 -> 2 -> 3 -> 5, where the 2nd node from the end (4) has been removed.*/
