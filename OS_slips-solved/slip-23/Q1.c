#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>

int main() {
    pid_t pid = fork();

    if (pid == 0) {
        sleep(2); // Simulate child's task
        printf("Child Process (PID %d) finished its task.\n", getpid());
    } else if (pid > 0) {
        printf("Parent Process (PID %d) created child (PID %d) and terminated.\n", getpid(), pid);
    } else {
        perror("Fork failed");
        return 1;
    }

    return 0;
}
