package solutions;

import helper.FileReaderUtil;

import java.util.List;
import java.util.regex.Pattern;

public class Day3 {

    private List<String> input;

    public Day3(String path) {
        input = FileReaderUtil.readFileToStringList(path);
    }

    public Integer partOne() {
        var pattern = Pattern.compile("mul\\((\\d+),(\\d+)\\)");
        var result = 0;
        for (String s : input) {
            var matcher = pattern.matcher(s);
            while (matcher.find()) {
                int x = Integer.parseInt(matcher.group(1));
                int y = Integer.parseInt(matcher.group(2));
                result += x * y;
            }
        }
        return result;
    }
}
