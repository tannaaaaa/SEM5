#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/resource.h>

int main() {
    pid_t pid = fork();

    if (pid == 0) {
        nice(10); // Increase the child's priority
        printf("Child Process Priority: %d\n", getpriority(PRIO_PROCESS, 0));
    } else if (pid > 0) {
        printf("Parent Process Priority: %d\n", getpriority(PRIO_PROCESS, 0));
    } else {
        perror("Fork failed");
        return 1;
    }

    return 0;
}
