package code_design.snl;

import java.util.List;

import static code_design.snl.Constants.DEFAULT_LADDERS_SIZE;
import static code_design.snl.Constants.DEFAULT_SNAKES_SIZE;

public interface SnakeLadderGenerator {
    default List<Snake> generateSnakes() throws Exception {
        return generateSnakes(DEFAULT_SNAKES_SIZE);
    }

    default List<Ladder> generateLadders() throws Exception {
        return generateLadders(DEFAULT_LADDERS_SIZE);
    }

    List<Snake> generateSnakes(int n) throws Exception;
    List<Ladder> generateLadders(int n) throws Exception;
    void reset();
}
