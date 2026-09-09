class Solution {
    public TreeNode sortedListToBST(ListNode head) {

        if (head == null) {
            return null;
        }

        // Only one node
        if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        // Find middle
        while (fast != null && fast.next != null) {

            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Disconnect left half from middle
        prev.next = null;

        // Middle becomes root
        TreeNode root = new TreeNode(slow.val);

        // Build left subtree
        root.left = sortedListToBST(head);

        // Build right subtree
        root.right = sortedListToBST(slow.next);

        return root;
    }
}