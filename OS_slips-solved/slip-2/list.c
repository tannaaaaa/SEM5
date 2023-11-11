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
        printf("Could not open directory %s\n", dirname);// Handle directory opening errors
        return;
    }

    if (strcmp(option, "f") == 0) {
        while ((entry = readdir(dir)) != NULL) {
            if (entry->d_type == DT_REG) {
                printf("%s\n", entry->d_name);// Print the names of all regular files
            }
        }
    } else if (strcmp(option, "n") == 0) {
        while ((entry = readdir(dir)) != NULL) {
            count++; // Count the number of entries
        }
        printf("Number of entries in %s: %d\n", dirname, count);// Print the no.of entries
    } else if (strcmp(option, "i") == 0) {
        while ((entry = readdir(dir)) != NULL) {
            if (entry->d_type == DT_REG) {
                stat(entry->d_name, &filestat);
                printf("%s %ld\n", entry->d_name, filestat.st_ino);// Print names & inodes 
            }
        }
    } else {
        printf("Invalid option %s\n", option);// Handle invalid options
    }

    closedir(dir); // Close the directory
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
        command[strlen(command) - 1] = '\0'; 

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
