package dsa.problems.hackerrank;

import org.junit.jupiter.api.Test;

import java.util.List;

class PerfectlyContainedBSTTest {
    @Test
    void testSingleRootPositive() {
        List<List<Integer>> nodes = List.of(
                List.of(17, -1, -1),
                List.of(15, 13, 17),
                List.of(7, -1, -1),
                List.of(13, -1, -1),
                List.of(5, 3, 7),
                List.of(3, -1, -1),
                List.of(10, 5, 15)
        );

        var expected = 10;
        var actual = PerfectlyContainedBST.findRoot(nodes);
        assert expected == actual;
    }

    @Test
    void testSingleRootPositive2() {
        List<List<Integer>> nodes = List.of(
                List.of(48,30,10),
                List.of(30,23,5),
                List.of(23,-1,-1),
                List.of(5,-1,-1),
                List.of(10,-1,-1)
        );

        var expected = 48;
        var actual = PerfectlyContainedBST.findRoot(nodes);
        assert expected == actual;
    }

    @Test
    void testSingleRootPositive3() {
        List<List<Integer>> nodes = List.of(
                List.of(48,30,10),
                List.of(30,23,5),
                List.of(23,-1,-1),
                List.of(5,-1,-1),
                List.of(10,-1,-1),
                List.of(50,48,60),
                List.of(60,-1,-1)
        );

        var expected = 50;
        var actual = PerfectlyContainedBST.findRoot(nodes);
        assert expected == actual;
    }

    @Test
    void testInvalidBST() {
        List<List<Integer>> nodes = List.of(
                List.of(15, 13, 17),
                List.of(7, -1, -1),
                List.of(13, -1, -1),
                List.of(5, 3, 7),
                List.of(3, -1, -1),
                List.of(10, 5, 15)
        );

        var expected = -1;
        var actual = PerfectlyContainedBST.findRoot(nodes);
        assert expected == actual;
    }

    @Test
    void testInvalidBSTWithMultipleParents() {
        List<List<Integer>> nodes = List.of(
                List.of(7, 3, -1),
                List.of(5, 3, 7),
                List.of(3, -1, -1)
        );

        var expected = -1;
        var actual = PerfectlyContainedBST.findRoot(nodes);
        assert expected == actual;
    }

    @Test
    void testMultipleRoots() {
        List<List<Integer>> nodes = List.of(
                List.of(30,23,5),
                List.of(23,-1,-1),
                List.of(5,-1,-1),
                List.of(10,-1,-1),
                List.of(50,48,60),
                List.of(60,-1,-1),
                List.of(70,50,80),
                List.of(80,-1,-1)
        );

        var expected = -1;
        var actual = PerfectlyContainedBST.findRoot(nodes);
        assert expected == actual;
    }
}