#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <dirent.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>


#define MAX_COMMAND_LENGTH 100
#define MAX_ARGUMENTS 10

void list(char* option, char* dirname) {
    DIR* dir;
    struct dirent* entry;
    struct stat filestat;
    int count = 0;

    dir = opendir(dirname);
    if (dir == NULL) {
        printf("Could not open directory %s\n", dirname);
        return;
    }

    if (strcmp(option, "f") == 0) {
        while ((entry = readdir(dir)) != NULL) {
            if (entry->d_type == DT_REG) {
                printf("%s\n", entry->d_name);
            }
        }
    } else if (strcmp(option, "n") == 0) {
        while ((entry = readdir(dir)) != NULL) {
            count++;
        }
        printf("Number of entries in %s: %d\n", dirname, count);
    } else if (strcmp(option, "i") == 0) {
        while ((entry = readdir(dir)) != NULL) {
            if (entry->d_type == DT_REG) {
                stat(entry->d_name, &filestat);
                printf("%s %ld\n", entry->d_name, filestat.st_ino);
            }
        }
    } else {
        printf("Invalid option %s\n", option);
    }

    closedir(dir);
}

int main() {
    char command[MAX_COMMAND_LENGTH];
    char* arguments[MAX_ARGUMENTS];
    char* token;
    int num_arguments;
    pid_t pid;

    while (1) {
        printf("myshell$ ");
        fgets(command, MAX_COMMAND_LENGTH, stdin);
        command[strlen(command) - 1] = '\0'; // Remove newline character

        num_arguments = 0;
        token = strtok(command, " ");
        while (token != NULL) {
            arguments[num_arguments++] = token;
            token = strtok(NULL, " ");
        }
        arguments[num_arguments] = NULL;

        if (strcmp(arguments[0], "list") == 0) {
            if (num_arguments != 3) {
                printf("Invalid number of arguments\n");
            } else {
                list(arguments[1], arguments[2]);
            }
        }
    }
    return 0;
}

/*
    Follow the steps below:

    1. Display the command prompt "myshell$".
    2. Read the command line input from the user.
    3. Tokenize the input string to separate the command and its arguments.
    4. If the command is "list", check the argument to determine whether to print the names of all files,
       the number of all entries, or the names and inodes of the files in the current directory.
    5. Open the current directory using "opendir()"S and read the directory entries using "readdir()".
    6. Print the names, number of entries, or names and inodes of the files as appropriate.
    7. Close the directory using closedir().

*/