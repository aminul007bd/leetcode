public class MergeTwoSortedLists_21 {

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

    // Time complexity O(n)
    // Space complexity O(n)
    public ListNode mergeTwoListsR(ListNode list1, ListNode list2) {
        // when one list is finished, to handle null pointer exception

        if (list1 == null) return list2;
        if (list2 == null) return list1;

        // compare the heads of list1 and list2
        ListNode head;
        if (list1.val <= list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }

        head.next = mergeTwoListsR(list1, list2);

        return head;
    }

    // Time complexity O(n)
    // Space complexity O(1)
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;

        // At least one of l1 and l2 can still have nodes at this point, so connect
        // the non-null list to the end of the merged list.
        return preHead.next;
    }

}
