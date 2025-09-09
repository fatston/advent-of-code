import solutions.Day1;
import solutions.Day2;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        var day1 = new Day1();
        System.out.println("day 1 part 1: " + day1.part1());
        System.out.println("day 1 part 2: " + day1.part2());

        var day2 = new Day2();
        System.out.println("day 2: " + day2.part1());
    }
}