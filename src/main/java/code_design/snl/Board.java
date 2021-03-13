package code_design.snl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static code_design.snl.Constants.DEFAULT_BOARD_SIZE;

public class Board {
    private final int size;
    private final Map<Integer, Snake> snakeMap;
    private final Map<Integer, Ladder> ladderMap;

    public Board(int size, List<Snake> snakes, List<Ladder> ladders) {
        this.size = size;
        snakeMap = new HashMap<>();
        ladderMap = new HashMap<>();
        snakes.forEach(snake -> {
            if (!snakeMap.containsKey(snake.getHead())) {
                snakeMap.put(snake.getHead(), snake);
            }
        });
        ladders.forEach(ladder -> {
            if (!snakeMap.containsKey(ladder.getStart()) &&
                !ladderMap.containsKey(ladder.getStart())) {
                ladderMap.put(ladder.getStart(), ladder);
            }
        });
    }

    public Board(List<Snake> snakes, List<Ladder> ladders) {
        this(DEFAULT_BOARD_SIZE, snakes, ladders);
    }

    public int move(int srcPosition, int rollValue) {
        int endPosition = srcPosition + rollValue;
        if (endPosition > size)
            return srcPosition;
        if (snakeMap.containsKey(endPosition))
            return snakeMap.get(endPosition).getTail();
        if (ladderMap.containsKey(endPosition))
            return ladderMap.get(endPosition).getEnd();
        return endPosition;
    }

    public boolean hasPositionEnded(int position) {
        return position == size;
    }

    @Override
    public String toString() {
        return "Board{" +
                "size=" + size +
                ", snakeMap=" + snakeMap +
                ", ladderMap=" + ladderMap +
                '}';
    }
}
