import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return buildTrees(1, n);
    }

    private List<TreeNode> buildTrees(int start, int end) {
        List<String> list = new ArrayList<>();
        List<TreeNode> allTrees = new ArrayList<>();
        
        // Base case: if start > end, there is no value to create a node, return a list containing null
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        // Iterate through all values from start to end to pick each as the root
        for (int i = start; i <= end; i++) {
            // Generate all unique left subtrees
            List<TreeNode> leftTrees = buildTrees(start, i - 1);
            // Generate all unique right subtrees
            List<TreeNode> rightTrees = buildTrees(i + 1, end);

            // Connect each left and right subtree combination to the root node 'i'
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    allTrees.add(root);
                }
            }
        }
        return allTrees;
    }
}
