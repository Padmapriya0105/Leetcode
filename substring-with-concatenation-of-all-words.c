#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    char* word;
    int count;
} WordFreq;
int findWord(WordFreq* table, int size, char* target) {
    for (int i = 0; i < size; i++) {
        if (strcmp(table[i].word, target) == 0) return i;
    }
    return -1;
}
int* findSubstring(char * s, char ** words, int wordsSize, int* returnSize) {
    *returnSize = 0;
    if (!s || !words || wordsSize == 0) return NULL;

    int sLen = strlen(s);
    int wordLen = strlen(words[0]);
    int totalLen = wordsSize * wordLen;
    if (sLen < totalLen) return NULL;
    WordFreq* originalTable = malloc(wordsSize * sizeof(WordFreq));
    int uniqueWords = 0;
    for (int i = 0; i < wordsSize; i++) {
        int idx = findWord(originalTable, uniqueWords, words[i]);
        if (idx != -1) {
            originalTable[idx].count++;
        } else {
            originalTable[uniqueWords].word = words[i];
            originalTable[uniqueWords].count = 1;
            uniqueWords++;
        }
    }
    int* result = malloc(sLen * sizeof(int));
    int* currentCounts = malloc(uniqueWords * sizeof(int));
    char* tempWord = malloc((wordLen + 1) * sizeof(char));
    for (int i = 0; i < wordLen; i++) {
        int left = i, right = i, wordsFound = 0;
        memset(currentCounts, 0, uniqueWords * sizeof(int));
        while (right + wordLen <= sLen) {
            strncpy(tempWord, s + right, wordLen);
            tempWord[wordLen] = '\0';
            right += wordLen;
            int idx = findWord(originalTable, uniqueWords, tempWord);
            if (idx != -1) {
                currentCounts[idx]++;
                wordsFound++;
                while (currentCounts[idx] > originalTable[idx].count) {
                    char* leftWord = malloc((wordLen + 1) * sizeof(char));
                    strncpy(leftWord, s + left, wordLen);
                    leftWord[wordLen] = '\0';
                    int leftIdx = findWord(originalTable, uniqueWords, leftWord);
                    currentCounts[leftIdx]--;
                    wordsFound--;
                    left += wordLen;
                    free(leftWord);
                }

                if (wordsFound == wordsSize) {
                    result[(*returnSize)++] = left;
                }
            } else {
                memset(currentCounts, 0, uniqueWords * sizeof(int));
                wordsFound = 0;
                left = right;
            }
        }
    }
    free(originalTable);
    free(currentCounts);
    free(tempWord);
    return result;
}
