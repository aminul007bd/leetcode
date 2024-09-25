/*Given head, the head of a linked list, determine if the linked list has a cycle in it.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
Return true if there is a cycle in the linked list. Otherwise, return false.

Example 1:
Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).*/

public class LinkedListCycle_141 {
    //    Floyd's Cycle Finding Algorithm approach
    public static boolean hasCycle(ListNode head) {
        // Step 1: Initialize two pointers, 'fast' and 'slow', both starting at the head of the list.
        ListNode fast = head; // Fast pointer will move two steps at a time.
        ListNode slow = head; // Slow pointer will move one step at a time.

        // Step 2: Iterate through the list with the fast pointer moving twice as fast as the slow pointer.
        while (fast != null && fast.next != null) {
            fast = fast.next.next; // Move 'fast' pointer two steps ahead.
            slow = slow.next; // Move 'slow' pointer one step ahead.

            if (slow == fast)
                return true; // Step 3: Check if the slow pointer and fast pointer meet at the same node. If they meet, there's a cycle.
        }

        return false; // Step 4: If the loop ends without the pointers meeting, there's no cycle in the list. Return false, indicating no cycle.
    }
}

/*
Walkthrough Example
Consider the following linked list:

Nodes: 1 → 2 → 3 → 4 → 5
Cycle: Node 5 points back to Node 3, creating a cycle.
Initial State:

fast pointer: Node 1 (value 1)
slow pointer: Node 1 (value 1)
First Iteration:

fast pointer moves to Node 3 (value 3) because it moves two steps.
slow pointer moves to Node 2 (value 2) because it moves one step.
        slow != fast, so the loop continues.
Second Iteration:

fast pointer moves to Node 5 (value 5).
slow pointer moves to Node 3 (value 3).
slow != fast, so the loop continues.
Third Iteration:

fast pointer moves to Node 4 (value 4) due to the cycle.
slow pointer moves to Node 4 (value 4).
slow == fast, so the method returns true, indicating a cycle.
If there were no cycle, the fast pointer would eventually reach the end of the list (fast == null), and the method would return false.
*/

