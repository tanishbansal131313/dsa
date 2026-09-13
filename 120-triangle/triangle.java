class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        for (int i = triangle.size() - 2; i >= 0; i--) {

            for (int j = 0; j < triangle.get(i).size(); j++) {

                int current = triangle.get(i).get(j);

                int left = triangle.get(i + 1).get(j);
                int right = triangle.get(i + 1).get(j + 1);

                triangle.get(i).set(
                    j,
                    current + Math.min(left, right)
                );
            }
        }

        return triangle.get(0).get(0);
    }
}