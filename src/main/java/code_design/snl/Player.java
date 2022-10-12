package code_design.snl;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String id;
    private int position;
    private List<Move> moves;

    public Player(String id) {
        this.id = id;
        position = 0;
        moves = new ArrayList<>();
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public List<Move> getMoves() {
        return moves;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id='" + id + '\'' +
                ", position=" + position +
                ", moves=" + moves +
                '}';
    }
}
