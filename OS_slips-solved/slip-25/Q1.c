#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>

void bubbleSort(int arr[], int n) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}

int main() {
    int n;
    printf("Enter the number of integers: ");
    scanf("%d", &n);

    int arr[n];

    printf("Enter the integers:\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    bubbleSort(arr, n);
    printf("Parent Process Sorted Array:\n");
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
    int pipefd[2];
    if (pipe(pipefd) == -1) {
        perror("Pipe failed");
        return 1;
    }

    pid_t pid = fork();

    if (pid == 0) {
        // Child process - Execute binary search program
        close(pipefd[1]); // Close write end of the pipe
        dup2(pipefd[0], STDIN_FILENO); // Redirect stdin to read from the pipe
        close(pipefd[0]); // Close read end of the pipe
        execl("./binary_search", "binary_search", NULL);
        perror("exec");
        exit(1);
    } else if (pid > 0) {
        close(pipefd[0]); // Close read end of the pipe
        for (int i = 0; i < n; i++) {
            write(pipefd[1], &arr[i], sizeof(int)); // Write each integer to the pipe
        }
        close(pipefd[1]); // Close write end of the pipe
        wait(NULL); // Wait for the child process to finish
    } else {
        perror("Fork failed");
        return 1;
    }
    return 0;
}