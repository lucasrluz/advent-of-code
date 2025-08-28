import java.io.FileReader;
import java.io.IOException;

public class Day1 {
    public static void main(String[] args) throws IOException {
        System.out.println("Advent of Code 2015 - Day 1");

        System.out.println("Part 1 result: " + part1());
        System.out.println("Part 2 result: " + part2());
    }

    public static int part1() throws IOException {
        FileReader fr = new FileReader("input-day1.txt");

        int character;

        int floor = 0;

        while ((character = fr.read()) != -1) {
            if (character == '(') {
                floor++;
            } else {
                floor--;
            }
        }

        return floor;
    }

    public static int part2() throws IOException {
        FileReader fr = new FileReader("input-day1.txt");

        int character;

        int floor = 0;
        int count = 1;

        while ((character = fr.read()) != -1) {
            if (character == '(') {
                floor++;
            } else {
                floor--;
            }

            if (floor == -1) {
                break;
            }

            count++;
        }

        return count;
    }
}








