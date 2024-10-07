package dsa.problems.leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

import static dsa.utils.CustomAssertions.assertNestedListEqualsWithoutOrder;

class M49Test {
    M49 test = new M49();

    @Test
    void groupAnagrams() {
        String[] words = {"eat","tea","tan","ate","nat","bat"};
        var expected = List.of(
                List.of("bat"),
                List.of("nat","tan"),
                List.of("ate","eat","tea")
        );
        var actual = test.groupAnagrams(words);
        assertNestedListEqualsWithoutOrder(expected, actual);
    }
}