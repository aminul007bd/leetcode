public class RemoveLinkedListElements_203 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode next = removeElements(head.next, val);
        if (head.val == val) return next;
        head.next = next;
        return head;
    }
}
