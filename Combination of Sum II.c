#include <stdlib.h>
#include <string.h>
int compare(const void* a, const void* b) {
    return (*(int*)a - *(int*)b);
}
void backtrack(int* candidates, int size, int target, int start, int* current, int currentSize, int*** res, int* resSize, int** colSizes) {
    if (target == 0) {
        (*resSize)++;
        *res = realloc(*res, (*resSize) * sizeof(int*));
        (*colSizes) = realloc(*colSizes, (*resSize) * sizeof(int));
        (*res)[*resSize - 1] = malloc(currentSize * sizeof(int));
        memcpy((*res)[*resSize - 1], current, currentSize * sizeof(int));
        (*colSizes)[*resSize - 1] = currentSize;
        return;
    }

    for (int i = start; i < size; i++) {
        if (i > start && candidates[i] == candidates[i - 1]) continue;
        if (candidates[i] > target) break;
        current[currentSize] = candidates[i];
        backtrack(candidates, size, target - candidates[i], i + 1, current, currentSize + 1, res, resSize, colSizes);
    }
}

int** combinationSum2(int* candidates, int candidatesSize, int target, int* returnSize, int** returnColumnSizes) {
    qsort(candidates, candidatesSize, sizeof(int), compare);
    
    int** res = NULL;
    int* colSizes = NULL;
    int* current = malloc(target * sizeof(int));
    *returnSize = 0;

    backtrack(candidates, candidatesSize, target, 0, current, 0, &res, returnSize, &colSizes);

    free(current);
    *returnColumnSizes = colSizes;
    return res;
}
