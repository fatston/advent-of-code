import solutions.Day1;
import solutions.Day2;
import solutions.Day3;
import solutions.Day4;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        var day1 = new Day1();
        System.out.println("day 1 part 1: " + day1.part1());
        System.out.println("day 1 part 2: " + day1.part2());

        var day2 = new Day2();
        System.out.println("day 2 part 1: " + day2.part1());
        System.out.println("day 2 part 2: " + day2.part2("src/input/day2.txt"));

        var day3 = new Day3("src/input/day3.txt");
        System.out.println("day 3 part 1: " + day3.partOne());
        System.out.println("day 3 part 2: " + day3.partTwo());

        var day4Test = new Day4("src/input/day4_test.txt");
        System.out.println("day 4 part 1 test: " + day4Test.partOne() + " = 18");
        var day4 = new Day4("src/input/day4.txt");
        System.out.println("day 4 part 1: " + day4.partOne() + " = 2685");

    }
}