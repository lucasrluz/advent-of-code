#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void get_input(char directions[], int numbers[]) {
    FILE *file = fopen("input.txt", "r");

    char line[6];
    char number[4];

    int i = 0;

    while (fgets(line, sizeof(line), file) != NULL) {
        directions[i] = line[0];

        if (strlen(line) == 5) {
            strncpy(number, line + 1, 3);
            number[3] = '\0';
        }

        if (strlen(line) == 4) {
            strncpy(number, line + 1, 2);
            number[2] = '\0';
        }

        if (strlen(line) == 3) {
            strncpy(number, line + 1, 1);
            number[1] = '\0';
        }

        numbers[i] = atoi(number);

        i++;
    }
}

int run_part_1(char directions[], int numbers[]) {
    int dial = 50;
    int password = 0;

    for (int i = 0; i < 5554; i++) {
        if (directions[i] == 'L') {
            for (int j = 0; j < numbers[i]; j++) {
                if (dial == 0) {
                    dial = 100;
                }

                dial -= 1;
            }

            if (dial == 0) {
                password += 1;
            }
        }

        if (directions[i] == 'R') {
            for (int j = 0; j < numbers[i]; j++) {
                dial += 1;

                if (dial == 100) {
                    dial = 0;
                }
            }

            if (dial == 0) {
                password += 1;
            }
        }
    }

    return password;
}

int main() {
    char direction[5554];
    int number[5554];

    get_input(direction, number);

    int password = run_part_1(direction, number);
    printf("Part 1 password: %d", password);
        
    return 0;
}
