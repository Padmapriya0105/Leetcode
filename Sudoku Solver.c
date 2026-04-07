#include <stdbool.h>

bool isValid(char** board, int r, int c, char val) {
    for (int i = 0; i < 9; i++) {
     
        if (board[r][i] == val) return false;
   
        if (board[i][c] == val) return false;
   
        if (board[3 * (r / 3) + i / 3][3 * (c / 3) + i % 3] == val) return false;
    }
    return true;
}

bool solve(char** board) {
    for (int r = 0; r < 9; r++) {
        for (int c = 0; c < 9; c++) {
            if (board[r][c] == '.') {
                for (char val = '1'; val <= '9'; val++) {
                    if (isValid(board, r, c, val)) {
                        board[r][c] = val;
                        if (solve(board)) return true;
                        board[r][c] = '.'; 
                    }
                }
                return false;
            }
        }
    }
    return true; 
}

void solveSudoku(char** board, int boardSize, int* boardColSize) {
    solve(board);
}
