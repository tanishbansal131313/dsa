class Solution {
    public int maximalRectangle(char[][] matrix) {

        if (matrix.length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] heights = new int[cols];
        int maxArea = 0;

        for (int r = 0; r < rows; r++) {

            // Build histogram for this row
            for (int c = 0; c < cols; c++) {

                if (matrix[r][c] == '1') {
                    heights[c]++;
                } else {
                    heights[c] = 0;
                }
            }

            // Solve histogram
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    private int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= heights.length; i++) {

            int currentHeight = (i == heights.length)
                    ? 0
                    : heights[i];

            while (!stack.isEmpty()
                    && heights[stack.peek()] > currentHeight) {

                int height = heights[stack.pop()];

                int width;

                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }

                maxArea = Math.max(maxArea, height * width);
            }

            if (i < heights.length) {
                stack.push(i);
            }
        }

        return maxArea;
    }
}