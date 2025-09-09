package helper;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class FileReaderUtil {
    public static List<List<Integer>> readFileToList(String pathString) {
        var path = Paths.get(pathString);
        try {
            return readFileToList(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<List<Integer>> readFileToList(Path path) throws IOException {
        return Files.lines(path)
                .map(line -> Arrays.stream(line.trim().split("\\s+"))
                                   .map(Integer::parseInt)
                                   .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }
}
