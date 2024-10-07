package dsa.utils;

import java.util.Comparator;
import java.util.List;

import static dsa.utils.CustomSort.sortNestedLists;

public class CustomAssertions {
    public static <T extends Comparable<T>> void assertNestedListEqualsWithoutOrder(List<List<T>> expected, List<List<T>> actual) {
        if (expected.size() != actual.size()) {
            throw new AssertionError("Expected list size: " + expected.size() + " but was: " + actual.size());
        }

        expected = sortNestedLists(expected, Comparator.naturalOrder(), Comparator.comparing(list -> list.get(0)));
        actual = sortNestedLists(actual, Comparator.naturalOrder(), Comparator.comparing(list -> list.get(0)));

        for (int i = 0; i < expected.size(); i++) {
            if (!expected.get(i).equals(actual.get(i))) {
                throw new AssertionError("Expected: " + expected.get(i) + " but was: " + actual.get(i));
            }
        }
    }
}
