package solutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day3Test {

    Day3 day3 = new Day3("src/input/day3_test.txt");
    @Test
    void partTwo() {
        var expected = 48;
        var actual = day3.partTwo();
        assertEquals(expected, actual);
    }
}