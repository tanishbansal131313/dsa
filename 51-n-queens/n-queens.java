class Solution {
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];

        // Fill board with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        boolean[] columns = new boolean[n];
        boolean[] diagonal1 = new boolean[2 * n - 1];
        boolean[] diagonal2 = new boolean[2 * n - 1];

        backtrack(0, n, board, columns, diagonal1, diagonal2, result);

        return result;
    }

    private void backtrack(
            int row,
            int n,
            char[][] board,
            boolean[] columns,
            boolean[] diagonal1,
            boolean[] diagonal2,
            List<List<String>> result) {

        // All queens placed
        if (row == n) {

            List<String> solution = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                solution.add(new String(board[i]));
            }

            result.add(solution);
            return;
        }

        // Try every column in this row
        for (int col = 0; col < n; col++) {

            int d1 = row - col + n - 1;
            int d2 = row + col;

            // Check if position is safe
            if (columns[col] || diagonal1[d1] || diagonal2[d2]) {
                continue;
            }

            // Place queen
            board[row][col] = 'Q';

            columns[col] = true;
            diagonal1[d1] = true;
            diagonal2[d2] = true;

            // Move to next row
            backtrack(
                row + 1,
                n,
                board,
                columns,
                diagonal1,
                diagonal2,
                result
            );

            // Remove queen (BACKTRACK)
            board[row][col] = '.';

            columns[col] = false;
            diagonal1[d1] = false;
            diagonal2[d2] = false;
        }
    }
}