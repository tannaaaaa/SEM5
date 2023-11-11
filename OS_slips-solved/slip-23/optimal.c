#include <stdio.h>
#include <stdlib.h>

#define MAX_FRAMES 100

int main() {
    int n, frames[MAX_FRAMES], page_faults = 0, i, j, k, l, max, found, ref_len;
    int ref_string[] = {8, 5, 7, 8, 5, 7, 2, 3, 7, 3, 5, 9, 4, 6, 2};
    n = 3; // number of frames
    ref_len = sizeof(ref_string) / sizeof(int);
    for (i = 0; i < n; i++) {
        frames[i] = -1;
    }
    for (i = 0; i < ref_len; i++) {
        found = 0;
        for (j = 0; j < n; j++) {
            if (frames[j] == ref_string[i]) {
                found = 1;
                break;
            }
        }
        if (!found) {
            page_faults++;
            if (i < n) {
                frames[i] = ref_string[i];
            } else {
                max = -1;
                for (j = 0; j < n; j++) {
                    found = 0;
                    for (k = i + 1; k < ref_len; k++) {
                        if (frames[j] == ref_string[k]) {
                            found = 1;
                            if (k > max) {
                                max = k;
                                l = j;
                            }
                            break;
                        }
                    }
                    if (!found) {
                        l = j;
                        break;
                    }
                }
                frames[l] = ref_string[i];
            }
        }
        printf("after reference %d: ", ref_string[i]);
        for (l = 0; l < n; l++) {
            if (frames[l] == -1) {
                printf("X ");
            } else {
                printf("%d ", frames[l]);
            }
        }
        printf("\n");
    }
    printf("Total number of page faults:: %d\n", page_faults);
    return 0;
}