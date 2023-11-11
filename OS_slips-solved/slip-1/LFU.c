#include <stdio.h>
#include <stdlib.h>

#define MAX_FRAMES 100

int main() {
    int n, frames[MAX_FRAMES], page_faults = 0, i, j, k, l, found, ref_len;
    int ref_string[] = {3, 4, 5, 4, 3, 4, 7, 2, 4, 5, 6, 7, 2, 4, 6};
    int counter[MAX_FRAMES] = {0};
    printf("Enter no.of Frames:");
    scanf("%d", &n); 
    ref_len = sizeof(ref_string) / sizeof(int); 
    for (i = 0; i < n; i++) {
        frames[i] = -1; 
    }
    for (i = 0; i < ref_len; i++) {
        found = 0;
        for (j = 0; j < n; j++) {
            if (frames[j] == ref_string[i]) { 
                found = 1;
                counter[j]++; 
                break;
            }
        }
        if (!found) { 
            page_faults++; 
            if (i < n) { // if there are empty frames
                frames[i] = ref_string[i]; // put the page in an empty frame
                counter[i] = 1; // set its counter to 1
            } else { // if there are no empty frames
                int min = counter[0];
                int min_index = 0;
                for (k = 1; k < n; k++) {
                    if (counter[k] < min) { // find the frame with the smallest counter
                        min = counter[k];
                        min_index = k;
                    }
                }
                frames[min_index] = ref_string[i]; // replace the page in that frame with the new page
                counter[min_index] = 1; // set its counter to 1
            }
        }
        printf(" %d: ", ref_string[i]); 
        for (l = 0; l < n; l++) { 
            if (frames[l] == -1) {
                printf("- "); 
            } else {
                printf("%d ", frames[l]); 
            }
        }
        printf("\n"); 
    }
    printf("Total number of page faults LFU: %d\n", page_faults); 
    return 0;
}