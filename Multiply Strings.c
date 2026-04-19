#include <stdio.h>
#include <string.h>
#include <stdlib.h>
char* multiply(char* num1, char* num2) {
    int len1 = strlen(num1);
    int len2 = strlen(num2); 
    if (num1[0] == '0' || num2[0] == '0') {
        char* zero = (char*)malloc(2 * sizeof(char));
        strcpy(zero, "0");
        return zero;
    }
    int resLen = len1 + len2;
    int* res = (int*)calloc(resLen, sizeof(int));
    for (int i = len1 - 1; i >= 0; i--) {
        for (int j = len2 - 1; j >= 0; j--) {
            int mul = (num1[i] - '0') * (num2[j] - '0');
            int p1 = i + j;
            int p2 = i + j + 1;
            int sum = mul + res[p2];
            res[p2] = sum % 10;
            res[p1] += sum / 10;
        }
    }
    char* resultStr = (char*)malloc((resLen + 1) * sizeof(char));
    int k = 0;
    int i = 0;
    while (i < resLen && res[i] == 0) i++;
    while (i < resLen) {
        resultStr[k++] = res[i++] + '0';
    }
    resultStr[k] = '\0';
    free(res);
    return resultStr;
}
