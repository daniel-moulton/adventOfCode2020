package solutions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.Buffer;

public class day2 {
    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader reader =  new BufferedReader(new FileReader("inputs/day2.txt"));
        
        // Read each line of file into an array of strings
        String[] input = reader.lines().toArray(String[]::new);

        System.out.println(Day2Part1(input));
        System.out.println(Day2Part2(input));
        
    }

    public static int Day2Part1(String[] inputs) {
        int numValid=0;
        for (String input : inputs) {
            String[] parts = input.split(" ");

            String[] lowerUpper = parts[0].split("-");
            int lower = Integer.parseInt(lowerUpper[0]);
            int upper = Integer.parseInt(lowerUpper[1]);

            char match = parts[1].charAt(0);
            
            int numOccurences = numOccurences(match, parts[2]);

            if (numOccurences>=lower && numOccurences<=upper) {
                numValid++;
            }
        }
        return numValid;
    }

    
    public static int Day2Part2(String[] inputs) {
        int numValid=0;
        for (String input : inputs) {
            String[] parts = input.split(" ");

            String[] numStrings = parts[0].split("-");
            int[] indexes = new int[numStrings.length];
            for (int i=0; i<numStrings.length; i++) {
                indexes[i] = Integer.parseInt(numStrings[i])-1;
            }

            char match = parts[1].charAt(0);

            // Was going to do for loop through indexes so works if more or less than 2 indexes but then couldn't use this nifty xor!
            if (parts[2].charAt(indexes[0])==match ^ parts[2].charAt(indexes[1])==match){
                numValid++;
            }
        }
        return numValid;

    }

    public static int numOccurences(char match, String string) {
        int count=0;
        for (char ch : string.toCharArray()){
            if (ch==match){
                count++;
            }
        }
        return count;
    }
}
