#include <stdlib.h>
#include <string.h>

void backtrack(int* candidates, int candidatesSize, int target, int start, int* current, int currentSize, int*** result, int* resultSize, int** columnSizes) {
    if (target == 0) {
        (*resultSize)++;
        *result = realloc(*result, (*resultSize) * sizeof(int*));
        (*columnSizes) = realloc(*columnSizes, (*resultSize) * sizeof(int));
        
        (*result)[*resultSize - 1] = malloc(currentSize * sizeof(int));
        memcpy((*result)[*resultSize - 1], current, currentSize * sizeof(int));
        (*columnSizes)[*resultSize - 1] = currentSize;
        return;
    }

    for (int i = start; i < candidatesSize; i++) {
        if (candidates[i] <= target) {
            current[currentSize] = candidates[i];
            backtrack(candidates, candidatesSize, target - candidates[i], i, current, currentSize + 1, result, resultSize, columnSizes);
        }
    }
}

int** combinationSum(int* candidates, int candidatesSize, int target, int* returnSize, int** returnColumnSizes) {
    int** result = NULL;
    int* columnSizes = NULL;
    int* current = malloc(target * sizeof(int));
    *returnSize = 0;

    backtrack(candidates, candidatesSize, target, 0, current, 0, &result, returnSize, &columnSizes);

    free(current);
    *returnColumnSizes = columnSizes;
    return result;
}
