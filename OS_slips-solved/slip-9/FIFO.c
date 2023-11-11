#include <stdio.h>
#include <stdlib.h>
 
#define MAX 100

int main() {
    int n, frames[MAX], page_faults = 0, found, ref_len;
    int ref_string[] = {3, 4, 5, 6, 3, 4, 7, 3, 4, 5, 6, 7, 2, 4, 6};

    printf("Enter number of Frames: ");
    scanf("%d", &n);
    ref_len = sizeof(ref_string) / sizeof(int);//Initialize memory frames
    for (int i = 0; i < n; i++) {
        frames[i] = -1; //Initialize the frames array with -1 (indicating empty frames)
    }
    for (int i = 0; i < ref_len; i++) {
        found = 0;
        for (int j = 0; j < n; j++) {
            if (frames[j] == ref_string[i]) {
                found = 1;
                break;
            }
        }
        if (!found) { //If the page is not found in any frame, it means a page fault has occurred
            page_faults++;
            if (i < n) {
                frames[i] = ref_string[i];
            } else {                            //After all frames are filled, the FIFO algorithm is applied
                for (int j = 0; j < n - 1; j++) {   // the oldest page in the frames is replaced with the new page.
                    frames[j] = frames[j + 1];
                }
                frames[n - 1] = ref_string[i];
            }
        }
        printf(" %d: ", ref_string[i]); //Print the memory state after each reference:
        for (int l = 0; l < n; l++) {
            if (frames[l] == -1) {
                printf("X ");
            } else {
                printf("%d ", frames[l]);
            }
        }
        printf("\n");
    }
    printf("\nTotal number of page faults FIFO: %d\n", page_faults);
    return 0;
}