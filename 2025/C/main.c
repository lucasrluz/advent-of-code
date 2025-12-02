#include <stdio.h>
#include <stdlib.h>

int main() {
    // FILE *file = fopen("input.txt", "r");

    // char line[256];

    // while (fgets(line, sizeof(line), file) != NULL) {
    //     printf("%s", line);
    // }

    int count = 50;
    int zero_count = 0;

    int inputs[10] = {68, 30, 48, 5, 60, 55, 1, 99, 14, 82};
    char inputs_type[10] = {'L', 'L', 'R', 'L', 'R', 'L', 'L', 'L', 'R', 'L'};

    for (int i = 0; i < 10; i++) {
        printf("%d\n", count);
        if (inputs_type[i] == 'L') {
            int result = count - inputs[i];

            if (result < 0) {
                count = 100 - abs(result);

                continue;
            }

            count = count - inputs[i];
        } else {
            int result = count + inputs[i];

            if (result > 100) {
                count = 0 + result;

                continue;
            }

            count = count + inputs[i];
        }


        if (count == 0) {
            zero_count += 1;
        }
    }

    printf("%d", zero_count);

    // if (input_type == 'L') {
    //     int result = count - input;

    //     if (result < 0) {
    //         count = 100 - abs(result);
    //     }

    //     count = count - input;
    // }

    // printf("%d", count);
        
    return 0;
}
