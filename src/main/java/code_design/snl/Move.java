package code_design.snl;

public class Move {
    private int srcPosition;
    private int dstPosition;
    private int rollValue;

    public Move(int srcPosition, int dstPosition, int rollValue) {
        this.srcPosition = srcPosition;
        this.dstPosition = dstPosition;
        this.rollValue = rollValue;
    }

    public int getSrcPosition() {
        return srcPosition;
    }

    public int getDstPosition() {
        return dstPosition;
    }

    public int getRollValue() {
        return rollValue;
    }

    @Override
    public String toString() {
        return "Move{" +
                "srcPosition=" + srcPosition +
                ", dstPosition=" + dstPosition +
                ", rollValue=" + rollValue +
                '}';
    }
}
