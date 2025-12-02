package day01;

import util.InputLoader;

public class Day01 {
    public static void main(String[] args) {
        String input = InputLoader.read("input/day01.txt");
        //System.out.println("Input: " + input);

        System.out.println("Part 1: " + part1(input));
        System.out.println("Part 2: " + part2(input));
    }

    public static int part1(String input) {
        int currentPosition = 50;
        int zeroCount = 0;

        for (String rotation:input.split("\n")) {
            int rotationAmount = Integer.parseInt(rotation.substring(1).strip());
            if (rotation.charAt(0) == 'R') {
                currentPosition += rotationAmount;
            } else {
                currentPosition -= rotationAmount;
            }

            while (currentPosition > 99) {
                currentPosition -= 100;
            }

            while (currentPosition < 0) {
                currentPosition += 100;
            }

            if (currentPosition == 0) {
                zeroCount++;
            }
        }

        // Solve part 1 here
        return zeroCount;
    }

    public static int part2(String input) {
        int currentPosition = 50;
        int zeroCount = 0;

        for (String rotation:input.split("\n")) {
            int rotationAmount = Integer.parseInt(rotation.substring(1).strip());

            int fullRotations = rotationAmount / 100;
            zeroCount += fullRotations;

            int rotationRemaining = rotationAmount % 100;

            while (rotationRemaining > 0) {
                if (rotation.charAt(0) == 'R') {
                    currentPosition += 1;
                } else {
                    currentPosition -= 1;
                }
                rotationRemaining--;

                if (currentPosition < 0) {
                    currentPosition += 100;
                }
                if (currentPosition > 99) {
                    currentPosition -= 100;
                }

                if (currentPosition == 0) {
                    zeroCount++;
                }
            }
        }

        // Solve part 2 here
        return zeroCount;
    }
}
