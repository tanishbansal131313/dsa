class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        // Dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Find node before 'left'
        ListNode prev = dummy;

        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // First node of the section to reverse
        ListNode curr = prev.next;

        // Reverse the section
        for (int i = 0; i < right - left; i++) {

            ListNode next = curr.next;

            curr.next = next.next;

            next.next = prev.next;

            prev.next = next;
        }

        return dummy.next;
    }
}