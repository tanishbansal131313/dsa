class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(
        int[] candidates,
        int target,
        int start,
        List<Integer> current,
        List<List<Integer>> result
    ) {

        // Target reached
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try candidates
        for (int i = start; i < candidates.length; i++) {

            // Don't choose numbers bigger than remaining target
            if (candidates[i] > target) {
                continue;
            }

            // Choose
            current.add(candidates[i]);

            // i, NOT i + 1
            // because we can reuse the same number
            backtrack(
                candidates,
                target - candidates[i],
                i,
                current,
                result
            );

            // Undo
            current.remove(current.size() - 1);
        }
    }
}