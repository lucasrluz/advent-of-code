import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class Day3 {
    public static void main(String[] args) throws IOException {
        System.out.println("Advent of Code 2015 - Day 3\n");

        System.out.println("Part 1 result: " + part1());
        System.out.println("Part 2 result: " + part2());
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

    public static int part2() throws IOException {
        FileReader fr = new FileReader("input-day3.txt"); 

        int santaX = 0;
        int santaY = 0;

        int robotSantaX = 0;
        int robotSantaY = 0;

        ArrayList<String> santaMap = new ArrayList<>();
        ArrayList<String> robotSantaMap = new ArrayList<>();

        santaMap.add("0:0");
        robotSantaMap.add("0:0");

        int character;
        boolean isSanta = true;

        while ((character = fr.read()) != -1) {
            if (isSanta) {
                switch ((char) character) {
                    case '^':
                        santaY++;
                        break;
                    case 'v':
                        santaY--;
                        break;
                    case '>':
                        santaX++;
                        break;
                    case '<':
                        santaX--;
                        break;
                } 

                if (!santaMap.contains(santaX + ":" + santaY)) {
                    santaMap.add(santaX + ":" + santaY);
                }
            } else {
                switch ((char) character) {
                    case '^':
                        robotSantaY++;
                        break;
                    case 'v':
                        robotSantaY--;
                        break;
                    case '>':
                        robotSantaX++;
                        break;
                    case '<':
                        robotSantaX--;
                        break;
                }
                
                if (!robotSantaMap.contains(robotSantaX + ":" + robotSantaY)) {
                    robotSantaMap.add(robotSantaX + ":" + robotSantaY);
                }
            }

            isSanta = !isSanta;
        }

        ArrayList<String> finalMap = new ArrayList<>();

        for (String coordinates : santaMap) {
            if (!finalMap.contains(coordinates)) {
                finalMap.add(coordinates);
            }
        }

        for (String coordinates : robotSantaMap) {
            if (!finalMap.contains(coordinates)) {
                finalMap.add(coordinates);
            }
        }

        return finalMap.size();
    }
}
