package solutions;

import helper.FileReaderUtil;

import java.util.Collections;
import java.util.List;

public class Day2 {

    public Integer part1() {
        var path = "src/input/day2.txt";
        var data = FileReaderUtil.readFileToList(path);
        var safeCount = 0;
        for (var list : data) {
            if (list.get(0) == list.get(1)) {
                continue;
            }
            if (list.get(0) > list.get(1)) {
                Collections.reverse(list);
            }
            // now should be all increasing
            if (isSafeIncreasing(list)) {
                safeCount += 1;
            }
        }
        return safeCount;
    }

    public boolean isSafeIncreasing(List<Integer> l) {
        var prev = l.get(0);
        for (int i = 1; i < l.size(); i++) {
            var curr = l.get(i);
            if (prev >= curr || Math.abs(prev-curr) > 3) {
                return false;
            }
            prev = curr;
        }
        return true;
    }
}
