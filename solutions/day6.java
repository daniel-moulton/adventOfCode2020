package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class day6 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("inputs/day6.txt"));

        String line;
        List<List<String>> groups = new ArrayList<List<String>>();
        List<String> group = new ArrayList<String>();
        while ((line = reader.readLine()) != null) {
            if (line.equals("")) {
                groups.add(group);
                group = new ArrayList<String>();
            } else {
                group.add(line);
            }
        }
        groups.add(group);

        System.out.println(Day6Part1(groups));
        System.out.println(Day6Part2(groups));
    }

    public static int Day6Part1(List<List<String>> groups) {
        int total = 0;
        for (List<String> group : groups) {
            Set answers = new HashSet<>();
            for (String person : group) {
                for (char answer : person.toCharArray()) {
                    answers.add(answer);
                }
            }
            total+=answers.size();
        }
        return total;
    }

    public static int Day6Part2(List<List<String>> groups) {
        int total = 0;
        for (List<String> group : groups) {
            System.out.println("NEW GROUP: " + group);
            Set<Character> answers = new HashSet<>();
            
            String firstPerson = group.get(0);
            for (char answer : firstPerson.toCharArray()) {
                answers.add(answer);
            }
            
            for (int i = 1; i < group.size(); i++) {
                String person = group.get(i);
                Set<Character> personAnswers = new HashSet<>();
                for (char answer : person.toCharArray()) {
                    personAnswers.add(answer);
                }
                answers.retainAll(personAnswers);
            }
            
            System.out.println(answers);
            total += answers.size();
        }
        
        return total;
    }
    

}
