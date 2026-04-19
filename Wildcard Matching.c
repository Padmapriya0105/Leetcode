#include <stdbool.h>
#include <string.h>

bool isMatch(char * s, char * p) {
    int s_ptr = 0, p_ptr = 0;
    int star_idx = -1, s_tmp_idx = -1;

    while (s[s_ptr] != '\0') {
        if (p[p_ptr] == '?' || p[p_ptr] == s[s_ptr]) {
            s_ptr++;
            p_ptr++;
        } else if (p[p_ptr] == '*') {
            star_idx = p_ptr;
            s_tmp_idx = s_ptr;
            p_ptr++;
        } else if (star_idx != -1) {
            p_ptr = star_idx + 1;
            s_tmp_idx++;
            s_ptr = s_tmp_idx;
        } else {
            return false;
        }
    }

    while (p[p_ptr] == '*') {
        p_ptr++;
    }

    return p[p_ptr] == '\0';
}
