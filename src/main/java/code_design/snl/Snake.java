package code_design.snl;

public class Snake {
    private final int head;
    private final int tail;

    public Snake(int head, int tail, int boardSize) throws Exception {
        if (head < 1 || tail < 1 || head > boardSize || tail > boardSize)
            throw new Exception("InvalidSnake " + head + " " + tail + " " + boardSize);
        if (head <= tail)
            throw new Exception("InvalidSnake " + head + " " + tail + " " + boardSize);
        this.head = head;
        this.tail = tail;
    }

    public int getHead() {
        return head;
    }

    public int getTail() {
        return tail;
    }
}
