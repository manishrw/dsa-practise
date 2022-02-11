/*
 * InterviewBit - Valid Path problem
 * https://www.interviewbit.com/problems/valid-path/
 */
package problems.interviewbit;

import java.util.*;

import static java.lang.System.out;

public class ValidPath {
    private final boolean debugFlag;

    public ValidPath() {
        this.debugFlag = false;
    }

    public ValidPath(boolean debugFlag) {
        this.debugFlag = debugFlag;
    }

    static class Circle {
        int r;
        Point center;

        Circle (int r, int x, int y) {
            this.r = r;
            center = new Point(x, y);
        }

        Circle(int r, Point center) {
            this.r = r;
            this.center = center;
        }

        boolean hasPoint(int px, int py) {
            int x = center.x;
            int y = center.y;
            return px <= x + r
                    && px >= x - r
                    && py <= y + r
                    && py >= y - r;
        }

        boolean hasPoint(Point p) {
            return hasPoint(p.x, p.y);
        }

        @Override
        public String toString() {
            return "Circle{" +
                    "radius=" + r +
                    ", center=" + center +
                    '}';
        }
    }

    static class Point {
        int x, y;

        Point (int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }

            if (obj.getClass() != this.getClass()) {
                return false;
            }

            final Point other = (Point) obj;

            return this.x == other.x && this.y == other.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        boolean isLeft(Point p) {
            return p.x > this.x;
        }

        boolean isDown(Point p) {
            return p.y > this.y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    enum Result {
        YES("YES"),
        NO("NO");

        private final String value;

        Result(String value) {
            this.value = value;
        }

        String getValue() {
            return value;
        }
    }

    void debug(String message, Object... args) {
        if (debugFlag) {
            out.printf(message, args);
        }
    }

    public String solve(int A, int B, int C, int D, List<Integer> E, List<Integer> F) {
//        if (debug) out.printf("A: %d, B: %d, C: %d, D: %d, E: %s, F: %s%n", A, B, C, D, E, F);
        debug("A: %d, B: %d, C: %d, D: %d, E: %s, F: %s%n%n", A, B, C, D, E, F);

        Point start = new Point(0, 0);
        Point end = new Point(A, B);
        List<Circle> circles = new ArrayList<>();
        for (var i = 0; i < C; i++) {
            circles.add(new Circle(D, E.get(i), F.get(i)));
        }
        debug("Added circles - %s%n", circles);

        LinkedList<Point> queue = new LinkedList<>();
        debug("Adding start point to queue - %s%n%n", start);
        queue.add(start);

        var visited = new HashSet<Point>();
        visited.add(start);

        while (!queue.isEmpty()) {
            Point p = queue.pop();
            debug("%nExploring point from queue - %s%n", p);

            // Check end for solution
            debug("Checking for solution: %s and %s%n", p, end);
            if (p.equals(end)) {
                debug("Found solution.%n");
                return Result.YES.getValue();
            }

            debug("Visited: %s%n", visited);
            // Check right
            if (p.isLeft(end)) {
                Point right = new Point(p.x + 1, p.y);
                if (!visited.contains(right) && circles.stream().noneMatch(c -> c.hasPoint(right))) {
                    debug("Adding right point to queue - %s%n", right);
                    queue.add(right);
                    visited.add(right);
                }
            }

            // Check down
            if (p.isDown(end)) {
                Point up = new Point(p.x, p.y + 1);
                if (!visited.contains(up) && circles.stream().noneMatch(c -> c.hasPoint(up))) {
                    debug("Adding up point to queue - %s%n", up);
                    queue.add(up);
                    visited.add(up);
                }
            }
        }

        return Result.NO.getValue();
    }
}
