package solutions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

public class day5 {
    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader("inputs/day5.txt"));

        String[] input = reader.lines().toArray(String[]::new);

        // System.out.println(Day5Part1(input));
        System.out.println(Day5Part2(input));
    }

    public static int Day5Part1(String[] input) {
        int highest = 0;
        for (int i = 0; i < input.length; i++) {
            String rowBin, colBin;
            rowBin = input[i].substring(0, 7);
            colBin = input[i].substring(7);

            rowBin = rowBin.replace('F', '0');
            rowBin = rowBin.replace('B', '1');

            colBin = colBin.replace('L', '0');
            colBin = colBin.replace('R', '1');

            int row = Integer.parseInt(rowBin, 2);
            int col = Integer.parseInt(colBin, 2);

            int id = row * 8 + col;

            if (id > highest) {
                highest = id;
            }
        }
        return highest;
    }

    public static int Day5Part2(String[] input) {
        int[] ids = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            String rowBin, colBin;
            rowBin = input[i].substring(0, 7);
            colBin = input[i].substring(7);

            rowBin = rowBin.replace('F', '0');
            rowBin = rowBin.replace('B', '1');

            colBin = colBin.replace('L', '0');
            colBin = colBin.replace('R', '1');

            int row = Integer.parseInt(rowBin, 2);
            int col = Integer.parseInt(colBin, 2);

            int id = row * 8 + col;

            ids[i] = id;
        }

        Arrays.sort(ids);
        for (int id : ids) {
            System.out.print(id + ",");
        }
        for (int i = 0; i < input.length; i++) {
            int j = i + 1;
            if (Math.abs(ids[j] - ids[i]) == 2) {
                System.out.println("J: " + ids[j]);
                System.out.println("i: " + ids[i]);
                if (ids[j] > ids[i]) {
                    return ids[j] - 1;
                } else {
                    return ids[i] - 1;
                }
            }
        }
        return -1;

    }
}
