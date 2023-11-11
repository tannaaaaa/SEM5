#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h>

#define MAX_COMMAND_LENGTH 100
#define MAX_ARGUMENTS 10
#define MAX_LINE_LENGTH 100

void search(char* option, char* filename, char* pattern) {
    FILE* fp;
    char line[MAX_LINE_LENGTH];
    int count = 0;

    fp = fopen(filename, "r");
    if (fp == NULL) {
        printf("Could not open file %s\n", filename); // Handle file opening errors
        return;
    }

    if (strcmp(option, "f") == 0) {
        while (fgets(line, MAX_LINE_LENGTH, fp) != NULL) {
            if (strstr(line, pattern) != NULL) {
                printf("%s", line); // Print the first line containing the pattern
                break;
            }
        }
    } else if (strcmp(option, "a") == 0) {
        while (fgets(line, MAX_LINE_LENGTH, fp) != NULL) {
            if (strstr(line, pattern) != NULL) {
                printf("%s", line); // Print all lines containing the pattern
            }
        }
    } else if (strcmp(option, "c") == 0) {
        while (fgets(line, MAX_LINE_LENGTH, fp) != NULL) {
            if (strstr(line, pattern) != NULL) {
                count++; // Count the no.of occurrences of the pattern
            }
        }
        printf("Number of occurrences of %s in %s: %d\n", pattern, filename, count); 
    } else {
        printf("Invalid option %s\n", option); // Handle invalid options
    }
    fclose(fp); // Close the file
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

        if (strcmp(arguments[0], "search") == 0) {
            if (num_arguments != 4) {
                printf("Invalid number of arguments\n"); 
            } else {
                search(arguments[1], arguments[2], arguments[3]); 
            }
        }
    }

    return 0;
}
