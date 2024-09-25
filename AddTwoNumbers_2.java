/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order,
and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
*/

public class AddTwoNumbers_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0); // Step 1: Create a dummy node to serve as the starting point of the resulting linked list.
        ListNode tail = dummyHead; // Step 2: Initialize a pointer 'tail' to build the new list, starting from the dummy node.
        int carry = 0; // Step 3: Initialize a variable 'carry' to handle cases where the sum of two digits exceeds 9.

        while (l1 != null || l2 != null || carry != 0) { // Step 4: Loop until all digits from l1, l2, and carry are processed.

            int digit1 = (l1 != null) ? l1.val : 0; // Extract the digit from l1 or 0 if l1 has been fully processed.
            int digit2 = (l2 != null) ? l2.val : 0; // Extract the digit from l2 or 0 if l2 has been fully processed.
            int sum = digit1 + digit2 + carry; // Step 5: Calculate the sum of the two digits and the carry.


            int digit = sum % 10; // Calculate the digit to be added to the new list (remainder when divided by 10).
            carry = sum / 10; // Update the carry (integer division by 10).


            ListNode newNode = new ListNode(digit); // Step 6: Create a new node with the calculated digit and attach it to the result list.
            tail.next = newNode;
            tail = tail.next; // Move the 'tail' pointer to the newly added node.

            l1 = (l1 != null) ? l1.next : null; // Step 7: Move to the next nodes in l1 and l2 if available.
            l2 = (l2 != null) ? l2.next : null;
        }

        ListNode result = dummyHead.next; // Step 8: Set the starting node of the result list (ignoring the dummy head).
        dummyHead.next = null; // Clear the dummy head to avoid any accidental usage.

        return result; // Step 9: Return the result linked list.
    }

}

/*
Walkthrough Example
Consider the following two linked lists:

l1: 2 → 4 → 3 (represents the number 342)
l2: 5 → 6 → 4 (represents the number 465)

Initial State:
dummyHead points to a new node with value 0.
tail points to dummyHead.
carry is initialized to 0.

First Iteration:
digit1 is 2 (from l1).
digit2 is 5 (from l2).
sum = 2 + 5 + 0 = 7.
digit = 7 % 10 = 7, carry = 7 / 10 = 0.
Create a new node with value 7 and attach it to tail.
Move tail to this new node.
Move to the next nodes in l1 and l2.

Second Iteration:
digit1 is 4 (from l1).
digit2 is 6 (from l2).
sum = 4 + 6 + 0 = 10.
digit = 10 % 10 = 0, carry = 10 / 10 = 1.
Create a new node with value 0 and attach it to tail.
Move tail to this new node.
Move to the next nodes in l1 and l2.

Third Iteration:
digit1 is 3 (from l1).
digit2 is 4 (from l2).
sum = 3 + 4 + 1 = 8.
digit = 8 % 10 = 8, carry = 8 / 10 = 0.
Create a new node with value 8 and attach it to tail.
Move tail to this new node.
Move to the next nodes in l1 and l2 (both are now null).

Final State:
Since carry is 0 and both l1 and l2 are null, exit the loop.
The resulting linked list is 7 → 0 → 8, which represents the number 807 (342 + 465).

Return:
Return the linked list starting from dummyHead.next, which gives 7 → 0 → 8.*/
