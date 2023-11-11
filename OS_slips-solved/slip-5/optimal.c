#include <stdio.h>
#include <stdlib.h>

#define MAX_FRAMES 100

int main() {
    int n, frames[MAX_FRAMES], page_faults = 0, i, j, k, l, max, found, ref_len;
    int ref_string[] = {8, 5, 7, 8, 5, 7, 2, 3, 7, 3, 5, 9, 4, 6, 2};
    printf("Enter no.of Frames: ");
    scanf("%d", &n);
    ref_len = sizeof(ref_string) / sizeof(int); // Calculate the length of the reference string
    for (i = 0; i < n; i++) {
        frames[i] = -1; // Initialize all frames as empty (-1 represents an empty frame)
    }
    for (i = 0; i < ref_len; i++) {
        found = 0; // Flag to indicate whether the current page is already in a frame
        for (j = 0; j < n; j++) {
            if (frames[j] == ref_string[i]) {
                found = 1;
                break;
            }
        }
        if (!found) {
            page_faults++; // Increment the page fault count
            if (i < n) {
                frames[i] = ref_string[i]; // If there are empty frames, place the page in one of them
            } else {
                max = -1; // Initialize 'max' to a negative value
                for (j = 0; j < n; j++) {
                    found = 0;
                    for (k = i + 1; k < ref_len; k++) {
                        if (frames[j] == ref_string[k]) {
                            found = 1;
                            if (k > max) {
                                max = k; // Find the maximum index of the next occurrence of a page in a frame
                                l = j; // Store the index of the frame that should be replaced
                            }
                            break;
                        }
                    }
                    if (!found) {
                        l = j; // If the page won't be referenced again, replace this frame
                        break;
                    }
                }
                frames[l] = ref_string[i]; // Replace the frame determined by the above logic
            }
        }
        printf("%d: ", ref_string[i]); 
        for (l = 0; l < n; l++) {
            if (frames[l] == -1) {
                printf("X "); 
            } else {
                printf("%d ", frames[l]); 
            }
        }
        printf("\n");
    }
    printf("Total number of page faults OPT: %d\n", page_faults); 
}