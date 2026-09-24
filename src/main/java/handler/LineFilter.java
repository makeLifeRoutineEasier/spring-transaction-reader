package handler;

import java.util.Set;
import java.util.function.UnaryOperator;

public class LineFilter {

    private static final UnaryOperator<String> normalizeEOL = line ->
            line.replaceAll("\\r\\n|\\r|\\n", System.lineSeparator());
    private static final UnaryOperator<String> clearEmptyPlaces = line ->
            line.replaceAll("(?m)^\s+", "");


    private static final Set<UnaryOperator<String>> allFilters = Set.of(
            normalizeEOL,
            clearEmptyPlaces
            );

    public static String applyFilters(String line) {
        String result = line;
        for (UnaryOperator<String> filter : allFilters) {
            result = filter.apply(result);
        }
        return result;
    }
}


