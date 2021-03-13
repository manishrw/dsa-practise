package code_design.snl;

import java.util.*;

import static code_design.snl.Constants.*;


public class SimpleSnakeLadderGenerator implements SnakeLadderGenerator {
    private final Set<Integer> visited;
    private final int boardSize;
    private final Random random;

    public SimpleSnakeLadderGenerator(int boardSize) {
        this.boardSize = boardSize;
        visited = new HashSet<>();
        random = new Random();
    }

    @Override
    public List<Snake> generateSnakes(int n) throws Exception {
        List<Snake> snakes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int head = random.nextInt(boardSize - MIN_SL_SIZE) + MIN_SL_SIZE;
            while (visited.contains(head) || head < 1) {
                head = random.nextInt(boardSize - MIN_SL_SIZE) + MIN_SL_SIZE;
            }
            int size = MAX_SL_SIZE - MIN_SL_SIZE;
            size = Math.min(size, head);
            int tail = head -  random.nextInt(size) - 1;
            while (visited.contains(tail) || tail < 1) {
                tail = head -  random.nextInt(size) - 1;
            }
            snakes.add(new Snake(head, tail, boardSize));
        }
        return snakes;
    }

    @Override
    public List<Ladder> generateLadders(int n) throws Exception {
        List<Ladder> ladders = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = random.nextInt(boardSize - MIN_SL_SIZE);
            while (visited.contains(start) || start < 1) {
                start = random.nextInt(boardSize - MIN_SL_SIZE);
            }
            int size = MAX_SL_SIZE - MIN_SL_SIZE;
            int end = start + MIN_SL_SIZE + random.nextInt(size);
            while (visited.contains(end) || end >= boardSize) {
                end = start + MIN_SL_SIZE + random.nextInt(size);
            }
            ladders.add(new Ladder(start, end, boardSize));
        }
        return ladders;
    }

    @Override
    public void reset() {
        visited.clear();
    }
}
