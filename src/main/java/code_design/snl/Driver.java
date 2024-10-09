package code_design.snl;

import java.util.Arrays;
import java.util.List;

public class Driver {
    public static void main (String[] args) throws Exception {
        int boardSize = 100;
        List<Snake> snakes = Arrays.asList(
                new Snake(15, 2, boardSize),
                new Snake(23, 13, boardSize),
                new Snake(41, 33, boardSize),
                new Snake(87, 44, boardSize),
                new Snake(95, 78, boardSize)
        );
        List<Ladder> ladders = Arrays.asList(
                new Ladder(3, 25, boardSize),
                new Ladder(24, 34, boardSize),
                new Ladder(50, 60, boardSize),
                new Ladder(71, 82, boardSize)
        );
        List<String> playerIds = Arrays.asList(
                "A",
                "B",
                "C",
                "D",
                "E"
        );
        Game game = new Game(playerIds, snakes, ladders);
        System.out.println(game.getBoard());
        while (game.isNotOver()) {
            System.out.println(game.play());
        }

        Game game1 = new Game(playerIds, SnakeLadderGeneratorType.SIMPLE);
        System.out.println(game1.getBoard());
        while (game1.isNotOver()) {
            System.out.println(game1.play());
        }
    }
}
