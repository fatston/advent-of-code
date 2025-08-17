package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Day1 {

    public Integer part1() {
        var l1 = new ArrayList<Integer>();
        var l2 = new ArrayList<Integer>();

        String filePath = "src/input/day1.txt"; // change to your file path

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.trim().split("\\s+"); // split on one or more spaces
                l1.add(
                        Integer.parseInt(parts[0])
                );
                l2.add(
                        Integer.parseInt(parts[1])
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        l1.sort(Comparator.naturalOrder());
        l2.sort(Comparator.naturalOrder());

        var totalDistance = 0;
        for (int i = 0; i < l1.size(); i++) {
            totalDistance += Math.abs(l1.get(i) - l2.get(i));
        }
        return totalDistance;

    }

    public Integer part2() {
        var l1 = new ArrayList<Integer>();
        var l2 = new ArrayList<Integer>();
        String filePath = "src/input/day1.txt"; // change to your file path

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.trim().split("\\s+"); // split on one or more spaces
                l1.add(
                        Integer.parseInt(parts[0])
                );
                l2.add(
                        Integer.parseInt(parts[1])
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<Integer, Integer> count = new HashMap<>();
        for (var i : l2) {
            count.merge(i, 1, Integer::sum);
        }

        var similarityScore = 0;
        for (var i : l1) {
            if (count.containsKey(i)) {
                similarityScore += i * count.get(i);
            }
        }
        return similarityScore;
    }
}
