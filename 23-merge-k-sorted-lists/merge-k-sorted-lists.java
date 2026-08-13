import java.util.*;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        // Min heap based on node value
        PriorityQueue<ListNode> pq =
            new PriorityQueue<>(
                (a, b) -> Integer.compare(a.val, b.val)
            );

        // Add first node of every list
        for (ListNode list : lists) {
            if (list != null) {
                pq.offer(list);
            }
        }

        // Dummy node
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Process heap
        while (!pq.isEmpty()) {

            ListNode node = pq.poll();

            // Add smallest node to result
            current.next = node;
            current = current.next;

            // Add next node from same list
            if (node.next != null) {
                pq.offer(node.next);
            }
        }

        return dummy.next;
    }
}