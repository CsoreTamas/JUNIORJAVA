package first;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FirstTask {
    public static List<Integer> getNumsAboveThreshold(List<Integer> numbers, int threshold) {
        return numbers.stream()
                .filter(number -> number >= threshold)
                .collect(Collectors.toList());
    }
}
