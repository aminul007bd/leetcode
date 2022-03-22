public class ReorderList_143 {
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public void reorderList(ListNode head) {
      if(head == null) return;

      // find the middle of the linked list (problem 876)
      ListNode slow = head, fast = head.next;
      while (fast != null && fast.next != null) {
          slow = slow.next;
          fast = fast.next.next;
      }

     // reverse the linked list( problem 206)
      ListNode prev = null, curr = slow, temp;
      while (curr != null) {
          temp = curr.next;
          curr.next = prev;
          prev = curr;
          curr = temp;
      }
      // merge two sorted liked list (problem 21)
      ListNode first = head, second = prev;
      while (second.next != null) {
          temp = first.next;
          first.next = second;
          first = temp;

          temp = second.next;
          second.next = first;
          second = temp;
      }
  }
}
