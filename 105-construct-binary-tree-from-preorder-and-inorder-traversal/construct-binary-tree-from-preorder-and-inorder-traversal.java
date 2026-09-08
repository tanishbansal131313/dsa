class Solution {

    private int preorderIndex = 0;
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // Store inorder value -> index
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {

        // No nodes in this range
        if (left > right) {
            return null;
        }

        // First unused preorder value is the root
        int rootValue = preorder[preorderIndex++];

        TreeNode root = new TreeNode(rootValue);

        // Find root in inorder
        int rootIndex = map.get(rootValue);

        // Build left subtree
        root.left = build(preorder, left, rootIndex - 1);

        // Build right subtree
        root.right = build(preorder, rootIndex + 1, right);

        return root;
    }
}