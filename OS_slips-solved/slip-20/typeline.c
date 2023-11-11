#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

#define MAX_COMMAND_LENGTH 100
#define MAX_ARGUMENTS 10
#define MAX_LINE_LENGTH 100

void typeline(char* option, char* filename) {
    FILE* fp;
    char line[MAX_LINE_LENGTH];
    int count = 0;

    fp = fopen(filename, "r");
    if (fp == NULL) {
        printf("Could not open file %s\n", filename);
        return;
    }

    if (strcmp(option, "a") == 0) {
        while (fgets(line, MAX_LINE_LENGTH, fp) != NULL) {
            printf("%s", line);
        }
    } else if (option[0] == '+') {
        int n = atoi(option + 1);
        while (fgets(line, MAX_LINE_LENGTH, fp) != NULL && count < n) {
            printf("%s", line);
            count++;
        }
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

        if (strcmp(arguments[0], "typeline") == 0) {
            if (num_arguments != 3) {
                printf("Invalid number of arguments\n");
            } else {
                typeline(arguments[1], arguments[2]);
            }
        } 
    }

    return 0;
}

/*

    1. Display the command prompt "myshell$".
    2. Read the command line input from the user.
    3. Tokenize the input string to separate the command and its arguments.
    4. If the command is "typeline", check the argument to determine whether to print the first n lines or all lines.
    5. Open the file specified in the argument and print the first n lines or all lines as appropriate.
    6. Print the result to the console.

*/