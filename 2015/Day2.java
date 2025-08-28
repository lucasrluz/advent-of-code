import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.util.Arrays;

public class Day2 {
    public static void main(String[] args) throws IOException {
        System.out.println("Advent of Code 2015 - Day 2");

        System.out.println("Part 1 result: " + part1());
        System.out.println("Part 2 result: " + part2());
    }

    public static int part1() throws IOException {
        Scanner sc = new Scanner(new File("input-day2.txt"));

        int sum = 0;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            // l - w - h
            String[] lineArrayString = line.split("x");

            int[] lineArrayInt = Arrays.stream(lineArrayString).mapToInt(Integer::parseInt).toArray();

            // 2*l*w + 2*w*h + 2*h*l
            int lw = lineArrayInt[0] * lineArrayInt[1];
            int wh = lineArrayInt[1] * lineArrayInt[2];
            int hl = lineArrayInt[2] * lineArrayInt[0];

            int result = 2 * lw + 2 * wh + 2 * hl;

            int min = lw;

            if (wh < min) {
                min = wh;
            }

            if (hl < min) {
                min = hl;
            }

            result += min;

            sum += result;
        }

        return sum;
    }

    public static long part2() throws IOException {
       Scanner sc = new Scanner(new File("input-day2.txt")); 

       long sum = 0;

       while (sc.hasNextLine()) {
           System.out.println(sum);
            String line = sc.nextLine();

            String[] lineArrayString = line.split("x");

            int[] lineArrayInt = Arrays.stream(lineArrayString).mapToInt(Integer::parseInt).toArray();
        
            // 2x3x4 -> 2+2+3+3 + 2*3*4
            
            sum +=
                (lineArrayInt[0] + lineArrayInt[0] + lineArrayInt[1] + lineArrayInt[1]) +
                (lineArrayInt[0] * lineArrayInt[1] * lineArrayInt[2]);
       }

       return sum;
    }
}

























