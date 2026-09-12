class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {

            List<Integer> row = new ArrayList<>();

            // First element
            row.add(1);

            // Middle elements
            if (i > 0) {

                List<Integer> previous = result.get(i - 1);

                for (int j = 1; j < i; j++) {

                    row.add(
                        previous.get(j - 1) + previous.get(j)
                    );
                }

                // Last element
                row.add(1);
            }

            result.add(row);
        }

        return result;
    }
}