import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class Day3 {
    public static void main(String[] args) throws IOException {
        System.out.println("Part 1 result: " + part1());
    }

    public static int part1() throws IOException {
        System.out.println("Advent of Code 2015 - Day 3\n");

        FileReader fr = new FileReader("input-day3.txt"); 

        int x = 0;
        int y = 0;

        ArrayList<String> map = new ArrayList<>();
        map.add("0:0");

        int character;

        while ((character = fr.read()) != -1) {
            switch ((char) character) {
                case '^':
                    y++;
                    break;
                case 'v':
                    y--;
                    break;
                case '>':
                    x++;
                    break;
                case '<':
                    x--;
                    break;
            }

            if (!map.contains(x + ":" + y)) {
                map.add(x + ":" + y);
            }
        }

        return map.size();
    }
}
