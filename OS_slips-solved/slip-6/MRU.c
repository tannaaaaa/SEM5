#include <stdio.h>
#include <stdlib.h>

#define MAX_FRAMES 100

int main() {
    int n, frames[MAX_FRAMES], page_faults = 0, i, j, k, l, found, ref_len;
    int ref_string[] = {8, 5, 7, 8, 5, 7, 2, 3, 7, 3, 5, 9, 4, 6, 2};
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
                found = 1; // Page is found in one of the frames
                frames[j] = ref_string[i]; // Update the frame to the MFU page
                break;
            }
        }
        if (!found) {
            page_faults++; 
            if (i < n) {
                frames[i] = ref_string[i]; // If there are empty frames, place the page in one of them
            } else {
                int max = -1; // Initialize 'max' to a negative value
                int max_index = 0; // Initialize 'max_index' with the index of the first frame
                for (k = 0; k < n; k++) {
                    if (frames[k] != -1) { // Check if the frame is not empty
                        if (max == -1 || max < frames[k]) {
                            max = frames[k]; // Find the frame with the maximum page number (most recently used)
                            max_index = k; // Store its index
                        }
                    }
                }
                frames[max_index] = ref_string[i]; // Replace the frame with the most recently used page
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
    printf("Total number of page faults using MRU: %d\n", page_faults);
    return 0;
}