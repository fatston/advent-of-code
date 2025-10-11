package solutions;

import helper.FileReaderUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Day4 {
    private List<String> input;
    private Integer iMax;
    private Integer jMax;

    public Day4(String path) {
        input = FileReaderUtil.readFileToStringList(path);
        iMax = input.size();
        jMax = input.get(0).length();
    }

    public Integer partOne() {

        var fullList = new ArrayList<String>();

        // get diagonals
        fullList.add(getDiagonal(0, 0, input));
        for (int i = 1; i < iMax; i++) {
            fullList.add(
                    getDiagonal(i,0, input)
            );
        }
        for (int j = 1; j < jMax; j++) {
            fullList.add(
                    getDiagonal(0, j, input)
            );
        }

        // get reverse diagonals
        fullList.add(getReverseDiagonal(iMax - 1, 0, input));
        for (int j = 1; j < jMax; j++) {
            fullList.add(getReverseDiagonal(iMax - 1, j, input));
        }
        for (int i = iMax - 2; i >= 0; i--) {
            fullList.add(getReverseDiagonal(i, 0, input));
        }


        // get downs as list of chars
        for (int j = 0; j < jMax; j++) {
            fullList.add(
                    getDown(j, input)
            );
        }
        // get across
        for (int i = 0; i < iMax; i++) {
            fullList.add(
                    input.get(i)
            );
        }

        // pass all lists into countXmases and return
        var count = 0;
        for (String s : fullList) {
            count += countXmases(s, Pattern.compile("XMAS"));
            count += countXmases(s, Pattern.compile("SAMX"));
        }
        return count;
    }

    /**
     * find A
     * find diagonal neighbour M
     * opposite must be S
     * find other diagonal neighbour M
     * opposite must be S
     * @return
     */
    public Integer partTwo() {
        var op = 0;
        for (int i = 1; i < iMax-1; i++) {
            for (int j = 1; j < jMax-1; j++) {
                if (input.get(i).charAt(j) == 'A') {
                    if (isXmas(input,i,j)) {
                        op++;
                    }
                }
            }
        }
        return op;
    }

    private Boolean isXmas(List<String> grid, Integer i, Integer j) {
        if (i == 0 || j == 0 || i == iMax-1 || j == jMax-1) {
            return false;
        }
        var tl = grid.get(i-1).charAt(j-1);
        var br = grid.get(i+1).charAt(j+1);
        var tr = grid.get(i-1).charAt(j+1);
        var bl = grid.get(i+1).charAt(j-1);

        return isMS(tl,br) && isMS(tr,bl);
    }

    private Boolean isMS(Character a, Character b) {
        return (a == 'M' && b == 'S') || (a == 'S' && b == 'M');
    }

    private String getDown(Integer j, List<String> grid) {
        var sb = new StringBuilder();
        for (int i = 0; i < iMax; i++) {
            sb.append(
                    grid.get(i).charAt(j)
            );
        }
        return sb.toString();
    }

    private String getDiagonal(Integer i, Integer j, List<String> grid) {
        var sb = new StringBuilder();
        while (i < iMax && j < jMax) {
            sb.append(
                    grid.get(i).charAt(j)
            );
            i++;
            j++;
        }
        return sb.toString();
    }

    private String getReverseDiagonal(Integer i, Integer j, List<String> grid) {
        var sb = new StringBuilder();
        while (i >= 0 && j < jMax) {
            sb.append(
                    grid.get(i).charAt(j)
            );
            i--;
            j++;
        }
        return sb.toString();
    }

    private Integer countXmases(String s, Pattern pattern) {
        var matcher = pattern.matcher(s);
        var count = 0;
        while (matcher.find()) count++;
        return count;
    }
}
