package code_design.snl;

public class Ladder {
    private final int start;
    private final int end;

    public Ladder(int start, int end, int boardSize) throws Exception {
        if (start < 1 || end < 1 || start > boardSize || end > boardSize)
            throw new Exception("InvalidLadder " + start + " " + end + " " + boardSize);
        if (start >= end)
            throw new Exception("InvalidLadder " + start + " " + end + " "  + boardSize);
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
