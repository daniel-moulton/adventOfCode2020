package solutions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.Buffer;

public class day3 {
    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader("inputs/day3.txt"));

        String[] input = reader.lines().toArray(String[]::new);
        System.out.println(Day3Part1(input));

        int[][] slopes = { { 1, 1 }, { 3, 1 }, { 5, 1 }, { 7, 1 }, { 1, 2 } };

        System.out.println(Day3Part2(input, slopes));

    }

    public static int Day3Part1(String[] input) {
        int numTrees = 0;
        // Convert input to 2D array of chars
        char[][] map = new char[input.length][input[0].length()];
        for (int i = 0; i < input.length; i++) {
            map[i] = input[i].toCharArray();
        }

        int x = 0;
        int y = 0;
        while (y < map.length) {
            char spot = map[y][x];
            if (spot == '#') {
                numTrees++;
            }
            x += 3;
            y += 1;
            if (x >= map[0].length) {
                x -= map[0].length;
            }
        }
        return numTrees;
    }

    public static int Day3Part2(String[] input, int[][] slopes){
        int numTrees=0;
        int multTotal=1;

        // Convert input to 2D array of chars
        char[][] map = new char[input.length][input[0].length()];
        for (int i=0; i<input.length; i++) {
            map[i] = input[i].toCharArray();
        }

        for (int i=0; i<slopes.length; i++){
            int x=0;
            int y=0;
            while (y<map.length){
                char spot=map[y][x];
                if (spot=='#'){numTrees++;}
                x+=slopes[i][0];
                y+=slopes[i][1];
                if (x>=map[0].length){
                    x-=map[0].length;
                }
            }
            multTotal*=numTrees;
            numTrees=0;
        }
        return multTotal;
    }
}
