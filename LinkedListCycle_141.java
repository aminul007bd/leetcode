public class LinkedListCycle_141 {

    //    Definition for singly-linked list
    class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
    }
    //Input: head = [3,2,0,-4], pos = 1
    //Output: true

//    Floyd's Cycle Finding Algorithm approach
    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) return true;
        }
        return false;
    }
    public static void main(String[] args) {
//        ListNode head = [3,2,0,-4];
    }
}
