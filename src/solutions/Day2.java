package solutions;

import helper.FileReaderUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Day2 {

    public Integer part1() {
        var path = "src/input/day2.txt";
        var data = FileReaderUtil.readFileToList(path);
        var safeCount = 0;
        for (var list : data) {
            if (isSafe(list)) {
                safeCount += 1;
            }
        }
        return safeCount;
    }

    public Integer part2(String path) {
        var data = FileReaderUtil.readFileToList(path);
        var safeCount = 0;
        for (var list : data) {
            for (int i = 0; i < list.size(); i++) {
                var tempList = new ArrayList<>(list);
                tempList.remove(i);
                if (isSafe(tempList)) {
                    safeCount++;
                    break;
                }
            }
        }
        return safeCount;
    }

    private Boolean isSafe(List<Integer> list) {
        if (list.get(0).equals(list.get(1))) {
            return false;
        }
        if (list.get(0) > list.get(1)) {
            Collections.reverse(list);
        }
        return isSafeIncreasing(list);
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
