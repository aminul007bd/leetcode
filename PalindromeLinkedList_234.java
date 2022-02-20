public class PalindromeLinkedList_234 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode firstHalfHead = head;
        ListNode secondHalfHead = reverse(slow.next);

        while (secondHalfHead != null && firstHalfHead != null) {
            if(firstHalfHead.val != secondHalfHead.val) return false;
            secondHalfHead = secondHalfHead.next;
            firstHalfHead = firstHalfHead.next;
        }
        return true;
    }

    public static ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return  newHead;
    }
}
