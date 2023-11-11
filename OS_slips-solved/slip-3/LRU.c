#include <stdio.h>
#include <stdlib.h>

#define MAX 100

int main() {
    int n, frames[MAX], page_faults = 0, found, ref_len;
    int ref_string[] = {3, 5, 7, 2, 5, 1, 2, 3, 1, 3, 5, 3, 1, 6, 2};
    int counter[MAX] = {0};
    printf("Enter no.of Frames: ");
    scanf("%d", &n);
    ref_len = sizeof(ref_string) / sizeof(int); 
    for (int i = 0; i < n; i++) {
        frames[i] = -1; 
    }
    for (int i = 0; i < ref_len; i++) {
        found = 0; 
        for (int j = 0; j < n; j++) {
            if (frames[j] == ref_string[i]) {
                found = 1; 
                counter[j] = i; // Update the time of the last reference for the frame
                break;
            }
        }
        if (!found) {
            page_faults++; 
            if (i < n) {
                frames[i] = ref_string[i]; // If there are empty frames, place the page in one of them
                counter[i] = i; // Set the time of the last reference for the newly added page
            } else {
                int min = counter[0]; // Initialize 'min' with the time of the last reference for the first frame
                int min_index = 0; // Initialize 'min_index' with the index of the first frame
                for (int k = 1; k < n; k++) {
                    if (counter[k] < min) {
                        min = counter[k]; // Find the frame with the earliest last reference
                        min_index = k; // Store its index
                    }
                }
                frames[min_index] = ref_string[i]; // Replace the frame with the earliest last reference
                counter[min_index] = i; // Update the time of the last reference for the newly added page
            }
        }
        printf("%d: ", ref_string[i]); 
        for (int l = 0; l < n; l++) {
            if (frames[l] == -1) {
                printf("X "); 
            } else {
                printf("%d ", frames[l]); 
            }
        }
        printf("\n");
    }
    printf("Total number of page faults LRU: %d\n", page_faults); 
    return 0;
}
