package solutions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * day1
 */
public class day1 {

    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader reader =  new BufferedReader(new FileReader("inputs/day1.txt"));
        // Read each line of file into an array of ints
        int[] input = reader.lines().mapToInt(Integer::parseInt).toArray();
        System.out.println(Day1Part1(input));
        System.out.println(Day1Part2(input));
        
    }

    public static int Day1Part1(int[] input) {
        for (int i=0; i<input.length; i++) {
            for (int j=i+1; j<input.length; j++) {
                if (input[i] + input[j] == 2020) {
                    return input[i] * input[j];
                }
            }
        }
        return -1;
    }

    public static int Day1Part2(int[] input) {
        for (int i=0; i<input.length; i++) {
            for (int j=i+1; j<input.length; j++) {
                for (int k=j+1; k<input.length; k++) {
                    if (input[i] + input[j] + input[k] == 2020) {
                        return input[i] * input[j] * input[k];
                    }
                }
            }
        }
        return -1;
    }
}