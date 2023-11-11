#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h>


#define MAX_COMMAND_LENGTH 100
#define MAX_ARGUMENTS 10

void count(char* option, char* filename) {
    FILE* fp;
    int count = 0;
    char c;

    fp = fopen(filename, "r");
    if (fp == NULL) {
        printf("Could not open file %s\n", filename);
        return;
    }

    if (strcmp(option, "c") == 0) {
        while ((c = fgetc(fp)) != EOF) {
            count++;
        }
        printf("Number of characters in %s: %d\n", filename, count);
    } else if (strcmp(option, "w") == 0) {
        while ((c = fgetc(fp)) != EOF) {
            if (c == ' ' || c == '\n' || c == '\t') {
                count++;
            }
        }
        printf("Number of words in %s: %d\n", filename, count + 1);
    } else if (strcmp(option, "l") == 0) {
        while ((c = fgetc(fp)) != EOF) {
            if (c == '\n') {
                count++;
            }
        }
        printf("Number of lines in %s: %d\n", filename, count + 1);
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

        if (strcmp(arguments[0], "count") == 0) {
            if (num_arguments != 3) {
                printf("Invalid number of arguments\n");
            } else {
                count(arguments[1], arguments[2]);
            }
        } 
    }

    return 0;
}

/*
    follow the steps below:

    1. Display the command prompt "myshell$".
    2. Read the command line input from the user.
    3. Tokenize the input string to separate the command and its arguments.
    4. If the command is "count", check the argument to determine whether to count characters, words, or lines.
    5. Open the file specified in the argument and count the characters, words, or lines as appropriate.
    6. Print the result to the console
*/