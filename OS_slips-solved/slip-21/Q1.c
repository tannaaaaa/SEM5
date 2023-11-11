#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>

int main() {
    pid_t pid = fork();

    if (pid == 0) {
        printf("I am Child Process\n");
    } else if (pid > 0) {
        printf("I am Parent Process\n");
        printf("Parent Process ID: %d\n", getppid());
        printf("Child Process ID: %d\n", getpid());
    } else {
        perror("Fork failed");
        return 1;
    }

    return 0;
}
