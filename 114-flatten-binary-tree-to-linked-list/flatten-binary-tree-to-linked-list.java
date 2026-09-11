class Solution {

    public void flatten(TreeNode root) {

        if (root == null) {
            return;
        }

        List<TreeNode> nodes = new ArrayList<>();

        preorder(root, nodes);

        for (int i = 0; i < nodes.size() - 1; i++) {

            nodes.get(i).left = null;
            nodes.get(i).right = nodes.get(i + 1);
        }

        // Last node
        TreeNode last = nodes.get(nodes.size() - 1);
        last.left = null;
        last.right = null;
    }

    private void preorder(TreeNode root, List<TreeNode> nodes) {

        if (root == null) {
            return;
        }

        nodes.add(root);

        preorder(root.left, nodes);
        preorder(root.right, nodes);
    }
}