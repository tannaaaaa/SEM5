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
        printf("Could not open file %s\n", filename); // Handle file opening errors
        return;
    }

    if (strcmp(option, "c") == 0) {
        while ((c = fgetc(fp)) != EOF) {
            count++; // Count characters
        }
        printf("Number of characters in %s: %d\n", filename, count); // Print the count
    } else if (strcmp(option, "w") == 0) {
        while ((c = fgetc(fp)) != EOF) {
            if (c == ' ' || c == '\n' || c == '\t') {
                count++; // Count word separators (spaces, newlines, tabs)
            }
        }
        printf("Number of words in %s: %d\n", filename, count + 1);//Add 1 to account for the first word
    } else if (strcmp(option, "l") == 0) {
        while ((c = fgetc(fp)) != EOF) {
            if (c == '\n') {
                count++; // Count newlines
            }
        }
        printf("Number of lines in %s: %d\n", filename, count + 1);//Add 1 to account for the first line
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
