/*
You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.

Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
*/
public class MergeTwoSortedLists_21 {
    // Time complexity O(n)
    // Space complexity O(1)
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(-1); // Step 1: Create a dummy node 'preHead' to act as the starting point of the merged list.
        ListNode prev = dummyHead; // Step 2: Initialize a pointer 'prev' that will be used to build the merged list.

        while (list1 != null && list2 != null) { // Step 3: Loop until one of the lists (l1 or l2) is fully traversed.

            if (list1.val < list2.val) { // Step 4: Compare the current values of l1 and l2.
                prev.next = list1; // If l1's value is smaller, attach l1 to the merged list.
                list1 = list1.next; // Move l1 to the next node.
            } else {
                prev.next = list2; // If l2's value is smaller or equal, attach l2 to the merged list.
                list2 = list2.next; // Move l2 to the next node.
            }
            prev = prev.next; // Move the 'prev' pointer to the newly added node.
        }
        // If one list is exhausted, attach the remaining elements of the other list.
        prev.next = list1 == null ? list2 : list1; // Step 5: Attach the remaining nodes of l1 or l2 to the merged list.

        return dummyHead.next; // Step 6: Return the merged list starting from the node after 'preHead'.
    }

}

/*Walkthrough Example
Consider the following two sorted linked lists:

l1: 1 → 3 → 5
l2: 2 → 4 → 6
Initial State:

preHead points to a new node with value -1.
prev points to preHead.
First Iteration:

Compare l1.val (1) with l2.val (2).
Since 1 < 2, attach l1 (node with value 1) to the merged list.
Move l1 to the next node (3).
Move prev to the node with value 1.
Second Iteration:

Compare l1.val (3) with l2.val (2).
Since 3 > 2, attach l2 (node with value 2) to the merged list.
Move l2 to the next node (4).
Move prev to the node with value 2.
Third Iteration:

Compare l1.val (3) with l2.val (4).
Since 3 < 4, attach l1 (node with value 3) to the merged list.
Move l1 to the next node (5).
Move prev to the node with value 3.
Fourth Iteration:

Compare l1.val (5) with l2.val (4).
Since 5 > 4, attach l2 (node with value 4) to the merged list.
Move l2 to the next node (6).
Move prev to the node with value 4.
Fifth Iteration:

Compare l1.val (5) with l2.val (6).
Since 5 < 6, attach l1 (node with value 5) to the merged list.
Move l1 to null (end of list).
Move prev to the node with value 5.
End of Loop:

l1 is now null, so attach the remaining l2 (node with value 6) to the merged list.
Final State:

The merged linked list is: 1 → 2 → 3 → 4 → 5 → 6.
Return:

Return the merged list starting from preHead.next, which gives 1 → 2 → 3 → 4 → 5 → 6.*/
