package solutions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class day4 {
    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader("inputs/day4.txt"));

        // String[] input = reader.lines().toArray(String[]::new);

        // Read the input file into an array of strings, each string is separated by an empty line
        String[] input = reader.lines().collect(Collectors.joining("\n")).split("\\n\\n");

        // Make sure each string is on one line
        for (int i = 0; i < input.length; i++) {
            input[i] = input[i].replace("\n", " ");
        }

        // System.out.println(Day4Part1(input));
        System.out.println(Day4Part2(input));
        // System.out.println(validHGT("183cm"));
    }

    public static int Day4Part1(String[] input) {
        int numValid = 0;
        String[] essential = new String[] { "byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid" };
        for (String passport : input) {
            boolean valid = true;
            for (String field : essential) {
                if (!passport.contains(field)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                numValid++;
            }
        }
        return numValid;
    }

    public static int Day4Part2(String[] input) {
        int numValid = 0;
        String[] essential = new String[] { "byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid" };
        for (String passport : input) {
            boolean validPassport = true;
            String[] parts = passport.split(" ");
            for (String key : essential) {
                if (!passport.contains(key)) {
                    validPassport = false;
                    break;
                }
            }
            for (String part : parts) {
                String[] keyValues = part.split(":");
                if (!checkValidValues(keyValues)) {
                    validPassport = false;
                    break;
                }
            }
            if (validPassport) {
                System.out.println("Valid passport: " + passport);
                numValid++;
            }
        }
        System.out.println("Number of valid passports: " + numValid);
        return numValid;
    }
    

    private static boolean checkValidValues(String[] keyValues) {
        String key = keyValues[0].toLowerCase();
        String value = keyValues[1];
    
        boolean isValid = true;
    
        switch (key) {
            case "byr":
                isValid = validBYR(Integer.parseInt(value));
                break;
            case "iyr":
                isValid = validIYR(Integer.parseInt(value));
                break;
            case "eyr":
                isValid = validEYR(Integer.parseInt(value));
                break;
            case "hgt":
                isValid = validHGT(value);
                break;
            case "hcl":
                isValid = validHCL(value);
                break;
            case "ecl":
                isValid = validECL(value);
                break;
            case "pid":
                isValid = validPID(value);
                break;
        }

        return isValid;
    }    

    public static boolean validBYR(int byr) {
        if (byr <= 2002 && byr >= 1920) {
            return true;
        }
        else {
            // System.out.println("Invalid BYR: " + byr);
            return false;
        }
    }

    public static boolean validIYR(int iyr) {
        if (iyr <= 2020 && iyr >= 2010) {
            return true;
        }
        else {
            // System.out.println("Invalid IYR: " + iyr);
            return false;
        }
    }

    public static boolean validEYR(int eyr) {
        if (eyr <= 2030 && eyr >= 2020) {
            return true;
        }
        else{
            // System.out.println("Invalid EYR: " + eyr);
            return false;
        }
    }

    public static boolean validHGT(String hgt) {
        String units = hgt.substring(hgt.length() - 2);
        if (!units.equals("cm") && !units.equals("in")){
            return false;
        }
        int height = Integer.parseInt(hgt.substring(0, hgt.length() - 2));

        if (units.equals("cm")) {
            if (height >= 150 && height <= 193) {
                return true;
            }
        } else if (units.equals("in")) {
            if (height >= 59 && height <= 76) {
                return true;
            }
        }
        // System.out.println("Invalid HGT: " + hgt);
        return false;
    }

    public static boolean validHCL(String hcl) {
        Pattern pattern = Pattern.compile("#[a-f0-9]{6}");
        Matcher matcher = pattern.matcher(hcl);
        if (matcher.find()) {
            return true;
        } else {
            // System.out.println("Invalid HCL: " + hcl);
            return false;
        }
    }

    public static boolean validECL(String ecl) {
        String[] validColours = { "amb", "blu", "brn", "gry", "grn", "hzl", "oth" };
        for (String colour : validColours) {
            if (ecl.equals(colour)) {
                return true;
            }
        }
        // System.out.println("Invalid ECL: " + ecl);
        return false;
    }

    public static boolean validPID(String pid) {
        Pattern pattern = Pattern.compile("[0-9]{9}");
        Matcher matcher = pattern.matcher(pid);
        if (matcher.find()) {
            return true;
        } else {
            // System.out.println("Invalid PID: " + pid);
            return false;
        }
    }

}
