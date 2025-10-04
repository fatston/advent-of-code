package solutions;

import helper.FileReaderUtil;

import java.util.List;
import java.util.regex.Pattern;

public class Day4 {
    private List<String> input;

    public Day4(String path) {
        input = FileReaderUtil.readFileToStringList(path);
    }

    public Integer partOne() {
        var n = input.size();
        var m = input.get(0).length();

        // get all diagonals as list of integers
        // get downs as list of integers
        // pass all lists into countXmases and return

        return 0;

    }

    private Integer countXmases(String s) {
        var pattern = Pattern.compile("XMAS|SAMX");
        var matcher = pattern.matcher(s);
        var count = 0;
        while (matcher.find()) count++;
        return count;
    }
}
