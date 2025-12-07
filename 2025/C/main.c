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

int main() {
    char direction[5554];
    int number[5554];

    get_input(direction, number);
    
    int count = 50;
    int zero_count = 0;

    // int inputs[10] = {68, 30, 48, 5, 60, 55, 1, 99, 14, 82};
    // char inputs_type[10] = {'L', 'L', 'R', 'L', 'R', 'L', 'L', 'L', 'R', 'L'};

    for (int i = 0; i < 5554; i++) {
        if (direction[i] == 'L') {
          for (int ii = 0; ii < number[i];  ii++) {
            if (count == 0) {
              count = 100;
            }

            count -= 1;
          }

          if (count == 0) {
            zero_count += 1;
          }
        } else {
          for (int ii = 0; ii < number[i]; ii++) {
            count += 1;

            if (count == 100) {
              count = 0;
            }
          }

          if (count == 0) {
            zero_count += 1;
          }
        }
      }
    printf("zero_count: %d", zero_count);
        
    return 0;
}
