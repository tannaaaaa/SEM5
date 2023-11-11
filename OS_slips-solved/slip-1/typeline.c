#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h>

#define MAX_COMMAND_LENGTH 100
#define MAX_ARGUMENTS 10
#define MAX_LINE_LENGTH 100

void typeline(char* option, char* filename) {
    FILE* fp;
    char line[MAX_LINE_LENGTH];
    int count = 0;

    fp = fopen(filename, "r");
    if (fp == NULL) {
        printf("Could not open file %s\n", filename); // Handle file opening errors
        return;
    }

    if (strcmp(option, "a") == 0) {
        while (fgets(line, MAX_LINE_LENGTH, fp) != NULL) {
            printf("%s", line); // Print all lines from the file
        }
    } else if (option[0] == '+') {
        int n = atoi(option + 1);
        while (fgets(line, MAX_LINE_LENGTH, fp) != NULL && count < n) {
            printf("%s", line); // Print the first 'n' lines from the file
            count++;
        }
    } else {
        printf("Invalid option %s\n", option); // Handle invalid options
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
        printf("myshell$ "); // Display the command prompt
        fgets(command, MAX_COMMAND_LENGTH, stdin); // Read the command line input from the user
        command[strlen(command) - 1] = '\0'; // Remove the newline character

        num_arguments = 0;
        token = strtok(command, " "); // Tokenize the input string to separate the command and its arguments
        while (token != NULL) {
            arguments[num_arguments++] = token;
            token = strtok(NULL, " ");
        }
        arguments[num_arguments] = NULL;

        if (strcmp(arguments[0], "typeline") == 0) {
            if (num_arguments != 3) {
                printf("Invalid number of arguments\n"); // Handle invalid argument count
            } else {
            }
        } 
    }

    return 0;
}