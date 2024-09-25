import java.util.List;

public class ReverseLinkedListII_92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) { // If the list is empty or `left` and `right` are the same, there's nothing to reverse, so return the original list.
            return head;
        }
        ListNode dummy = new ListNode(0); // A dummy node is created and linked to the head. This helps in handling edge cases, especially if the head node is part of the reversal.
        dummy.next = head;

        ListNode prev = dummy; // Move `prev` to the node just before the `left` position. This sets up the position where the reversal will start.
        // Example: If `left = 2`, after this loop, `prev` will point to the node with value `1`.
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        ListNode cur = prev.next; // `cur` is set to the first node that will be reversed.
        // Example: `cur` will point to the node with value `2`.
        for (int i = 0; i < right - left; i++) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }
        // This loop reverses the nodes between `left` and `right`.
        // - `temp` is the node that is to be moved to the front of the reversed sublist.
        // - `cur.next = temp.next` skips over `temp`.
        // - `temp.next = prev.next` inserts `temp` at the front of the reversed sublist.
        // - `prev.next = temp` completes the insertion of `temp` at the front.
        // Example: For `left = 2` and `right = 4`, the iterations will produce:
        // - First iteration: List becomes `1 → 3 → 2 → 4 → 5`
        // - Second iteration: List becomes `1 → 4 → 3 → 2 → 5`

        return dummy.next;
        // The function returns the new head of the list, which starts from `dummy.next`.
        // Since `dummy.next` was never altered, it still correctly points to the first node of the modified list.
    }

}

/*Step-by-Step Walkthrough:
Initial Setup:

List: 0(dummy) → 1 → 2 → 3 → 4 → 5
left = 2, right = 4: We want to reverse the nodes from position 2 to 4.
Nodes to Reverse: 2 → 3 → 4
Step 1 - Move prev:

Before Moving:
prev points to 0 (dummy node).
After Moving:
prev now points to 1.
List: 0(dummy) → 1(prev) → 2(cur) → 3 → 4 → 5
Step 2 - First Iteration:

Before Iteration:
cur points to 2, temp points to 3.
Action:
Move 3 to the front of the reversed sublist.
After Iteration:
List: 0(dummy) → 1 → 3 → 2(cur) → 4 → 5
prev.next now points to 3, and cur still points to 2.
Step 3 - Second Iteration:

Before Iteration:
cur still points to 2, temp now points to 4.
Action:
Move 4 to the front of the reversed sublist.
After Iteration:
List: 0(dummy) → 1 → 4 → 3 → 2(cur) → 5
prev.next now points to 4, and cur still points to 2.
Final Result:

List: 1 → 4 → 3 → 2 → 5
The portion of the list between left and right has been reversed.
This textual visualization should help you understand how the list evolves through each step.*/






























