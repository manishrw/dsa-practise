package dsa.problems.leetcode;

import dsa.problems.leetcode.E339.NestedInteger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.ArrayList;
import java.util.List;

class E339Test {

    private final E339 solution = new E339();

    @Test
    @Timeout(3)
    public void test1() {
        var nestedList = new ArrayList<NestedInteger>();
        nestedList.add(new NestedInteger(List.of(
            new NestedInteger(1),
            new NestedInteger(1)
        )));
        nestedList.add(new NestedInteger(2));
        nestedList.add(new NestedInteger(List.of(
                new NestedInteger(1),
                new NestedInteger(1)
        )));

        var expected = 10;
        var actual = solution.depthSum(nestedList);
        assert expected == actual : actual;
    }
}