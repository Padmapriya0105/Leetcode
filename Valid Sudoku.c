#include <stdbool.h>
#include <string.h>

bool isValidSudoku(char** board, int boardSize, int* boardColSize) {
    int rows[9][9] = {0};
    int cols[9][9] = {0};
    int boxes[9][9] = {0};

    for (int r = 0; r < 9; r++) {
        for (int c = 0; c < 9; c++) {
            char cell = board[r][c];
            
            if (cell == '.') continue;

            int num = cell - '1'; 
            int boxIdx = (r / 3) * 3 + (c / 3);
            if (rows[r][num] || cols[c][num] || boxes[boxIdx][num]) {
                return false;
            }
            rows[r][num] = 1;
            cols[c][num] = 1;
            boxes[boxIdx][num] = 1;
        }
    }

    return true;
}
