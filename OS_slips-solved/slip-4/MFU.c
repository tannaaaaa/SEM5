#include <stdio.h>
#include <stdlib.h>

#define MAX_FRAMES 100

int main() {
    int n, frames[MAX_FRAMES], page_faults = 0, mfu[MAX_FRAMES], i, j, k, l, max, found, ref_len;
    int ref_string[] = {8, 5, 7, 8, 5, 7, 2, 3, 7, 3, 5, 9, 4, 6, 2};
    printf("Enter the number of Frames: ");
    scanf("%d", &n);
    ref_len = sizeof(ref_string) / sizeof(int);
    for (i = 0; i < n; i++) {
        frames[i] = -1; 
        mfu[i] = 0; 
    }
    for (i = 0; i < ref_len; i++) {
        found = 0; 
        for (j = 0; j < n; j++) {
            if (frames[j] == ref_string[i]) {
                found = 1; 
                mfu[j]++; 
                break;
            }
        }
        if (!found) { 
            page_faults++; 
            if (i < n) {
                frames[i] = ref_string[i]; // If there are empty frames, place the page in one of them
                mfu[i] = 1; // Set the Most Frequently Used counter to 1 for the newly added page
            } else {
                max = 0; // Initialize 'max' with the index of the first frame
                for (k = 1; k < n; k++) {
                    if (mfu[k] > mfu[max]) {
                        max = k; // Find the frame with the highest Most Frequently Used count
                    }
                }
                frames[max] = ref_string[i]; // Replace the frame with the highest Most Frequently Used count
                mfu[max] = 1; // Set the Most Frequently Used counter to 1 for the newly added page
            }
        }
        printf(" %d: ", ref_string[i]);
        for (l = 0; l < n; l++) {
            if (frames[l] == -1) {
                printf("X "); 
            } else {
                printf("%d ", frames[l]); 
            }
        }
        printf("\n");
    }
    printf("Total number of page faults MFU: %d\n", page_faults);
    return 0;
}
