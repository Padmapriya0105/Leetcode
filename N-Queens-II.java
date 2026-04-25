class Solution {
    private int count = 0;
    private boolean[] cols;
    private boolean[] diag1;
    private boolean[] diag2;

    public int totalNQueens(int n) {
        cols = new boolean[n];
        diag1 = new boolean[2 * n];
        diag2 = new boolean[2 * n];
        backtrack(0, n);
        return count;
    }

    private void backtrack(int row, int n) {
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row + col;
            int d2 = row - col + n;
            if (!cols[col] && !diag1[d1] && !diag2[d2]) {
                cols[col] = diag1[d1] = diag2[d2] = true;
                backtrack(row + 1, n);
                cols[col] = diag1[d1] = diag2[d2] = false;
            }
        }
    }
}
