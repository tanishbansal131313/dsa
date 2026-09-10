class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(root, targetSum, path, result);

        return result;
    }

    private void dfs(
        TreeNode root,
        int targetSum,
        List<Integer> path,
        List<List<Integer>> result
    ) {

        if (root == null) {
            return;
        }

        // Add current node to path
        path.add(root.val);

        // Subtract current value
        targetSum -= root.val;

        // Check if current node is a leaf
        if (root.left == null && root.right == null) {

            if (targetSum == 0) {
                result.add(new ArrayList<>(path));
            }

        } else {

            // Continue exploring
            dfs(root.left, targetSum, path, result);
            dfs(root.right, targetSum, path, result);
        }

        // Backtrack
        path.remove(path.size() - 1);
    }
}