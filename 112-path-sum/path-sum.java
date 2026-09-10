class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }

        // If this is a leaf
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        // Subtract current node's value
        targetSum -= root.val;

        return hasPathSum(root.left, targetSum)
            || hasPathSum(root.right, targetSum);
    }
}