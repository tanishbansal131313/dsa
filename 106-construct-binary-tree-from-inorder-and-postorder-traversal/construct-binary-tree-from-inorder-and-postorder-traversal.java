class Solution {

    private int postorderIndex;
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        // Store inorder value -> index
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        // Start from the last element of postorder
        postorderIndex = postorder.length - 1;

        return build(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode build(
        int[] inorder,
        int[] postorder,
        int left,
        int right
    ) {

        // No nodes
        if (left > right) {
            return null;
        }

        // Last unused postorder element is the root
        int rootValue = postorder[postorderIndex--];

        TreeNode root = new TreeNode(rootValue);

        // Find root in inorder
        int rootIndex = map.get(rootValue);

        // IMPORTANT: build right first
        root.right = build(
            inorder,
            postorder,
            rootIndex + 1,
            right
        );

        // Then build left
        root.left = build(
            inorder,
            postorder,
            left,
            rootIndex - 1
        );

        return root;
    }
}