package code_design.snl;

public class Status {
    private Player lastPlayer;
    private Move lastMove;
    private boolean isGameOver;
    private int moveNumber;

    public Status() {
        isGameOver = false;
        moveNumber = 0;
    }

    public Player getLastPlayer() {
        return lastPlayer;
    }

    public Move getLastMove() {
        return lastMove;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void update(Player player, Move move, boolean isGameOver) {
        lastPlayer = player;
        lastMove = move;
        this.isGameOver = isGameOver;
        moveNumber++;
    }

    @Override
    public String toString() {
        return "Status{" +
                "lastPlayer=" + lastPlayer.getId() +
                ", lastMove=" + lastMove +
                ", hasPositionEnded=" + isGameOver +
                ", moveNumber=" + moveNumber +
                '}';
    }
}