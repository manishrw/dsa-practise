package problems.leetcode;

public class H84 {
    public boolean debug = false;

    public H84() {}

    public H84(final boolean debug) {
        this.debug = debug;
    }

    public int largestRectangleArea(int[] heights) {
        return heights == null || heights.length == 0 ? 0 : largestRectangleArea(heights, 0, heights.length - 1);
    }

    public int largestRectangleArea(int[] heights, int left, int right) {
        if (left == right) return heights[left];
        int minIndex = findMinIndex(heights, left, right);
        int leftArea = largestRectangleArea(heights, left, Math.max(minIndex - 1, left));
        int rightArea = largestRectangleArea(heights, Math.min(minIndex + 1, right), right);
        int currentArea = (right - left + 1) * heights[minIndex];
        return Math.max(currentArea, Math.max(leftArea, rightArea));
    }

    public static int findMinIndex(int[] heights, int left, int right) {
        int minIndex = left;
        for (int i = left; i <= right; i++) {
            if (heights[i] < heights[minIndex]) minIndex = i;
        }
        return minIndex;
    }
}