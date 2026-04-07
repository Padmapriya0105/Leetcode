#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* countAndSay(int n) {
    if (n <= 0) return NULL;
    char* current = malloc(2);
    strcpy(current, "1");

    for (int i = 1; i < n; i++) {
        char* next = malloc(strlen(current) * 3); 
        int nextIdx = 0;
        int count = 1;
        int len = strlen(current);

        for (int j = 0; j < len; j++) {
            if (j + 1 < len && current[j] == current[j + 1]) {
                count++;
            } else {
                nextIdx += sprintf(next + nextIdx, "%d%c", count, current[j]);
                count = 1;
            }
        }
        
        free(current);
        current = next;
    }

    return current;
}
