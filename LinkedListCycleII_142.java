import java.util.HashSet;
import java.util.Set;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
 }
public class LinkedListCycleII_142 {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        ListNode node = head;
        while (node != null) {
            if(visited.contains(node)) return node;
            visited.add(node);
            node = node.next;
        }
        return null;
    }
}
