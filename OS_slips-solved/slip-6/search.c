#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

#define MAX_COMMAND_LENGTH 100
#define MAX_ARGUMENTS 10
#define MAX_LINE_LENGTH 100

void search(char* option, char* filename, char* pattern) {
    FILE* fp;
    char line[MAX_LINE_LENGTH];
    int count = 0;

    fp = fopen(filename, "r");
    if (fp == NULL) {
        printf("Could not open file %s\n", filename);
        return;
    }

    if (strcmp(option, "f") == 0) {
        while (fgets(line, MAX_LINE_LENGTH, fp) != NULL) {
            if (strstr(line, pattern) != NULL) {
                printf("%s", line);
                break;
            }
        }
    } else if (strcmp(option, "a") == 0) {
        while (fgets(line, MAX_LINE_LENGTH, fp) != NULL) {
            if (strstr(line, pattern) != NULL) {
                printf("%s", line);
            }
        }
    } else if (strcmp(option, "c") == 0) {
        while (fgets(line, MAX_LINE_LENGTH, fp) != NULL) {
            if (strstr(line, pattern) != NULL) {
                count++;
            }
        }
        printf("Number of occurrences of %s in %s: %d\n", pattern, filename, count);
    } else {
        printf("Invalid option %s\n", option);
    }
    fclose(fp);
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

/*
    Follow the steps below:

    1. Display the command prompt "myshell$".
    2. Read the command line input from the user.
    3. Tokenize the input string to separate the command and its arguments.
    4. If the command is "search", check the argument to determine whether to display the first occurrence of the pattern, 
     search for all occurrences of the pattern, or count the number of occurrences of the pattern in the file.
    5. Open the file specified in the argument and search for the pattern as appropriate.
    6. Print the result to the console
*/