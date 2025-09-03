import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Day4 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println("Advent of Code 2015 - Day 4\n");

        System.out.println("Part 1 result: " + part1());
        System.out.println("Part 2 result: " + part2());
    }

    public static int part1() throws NoSuchAlgorithmException {
        String leftInput = "ckczppom";

        MessageDigest md = MessageDigest.getInstance("MD5");

        int rightInput = 1;

        while (true) {
            String input = leftInput + rightInput;  

            byte[] hashBytes = md.digest(input.getBytes());

            StringBuilder hashHex = new StringBuilder();
            
            for (byte b : hashBytes) {
                hashHex.append(String.format("%02x", b));
            }

            String hashString = hashHex.toString();

            if (hashString.substring(0, 5).equals("00000")) {
                break;
            }

            rightInput++;
        }

        return rightInput;
    }
    
    public static int part2() throws NoSuchAlgorithmException {
        String leftInput = "ckczppom";

        MessageDigest md = MessageDigest.getInstance("MD5");

        int rightInput = 1;

        while (true) {
            String input = leftInput + rightInput;  

            byte[] hashBytes = md.digest(input.getBytes());

            StringBuilder hashHex = new StringBuilder();
            
            for (byte b : hashBytes) {
                hashHex.append(String.format("%02x", b));
            }

            String hashString = hashHex.toString();

            if (hashString.substring(0, 6).equals("000000")) {
                break;
            }

            rightInput++;
        }

        return rightInput;
    }
}
