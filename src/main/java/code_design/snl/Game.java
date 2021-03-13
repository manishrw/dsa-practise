package code_design.snl;

import java.util.List;
import java.util.stream.Collectors;

import static code_design.snl.Constants.DEFAULT_BOARD_SIZE;

public class Game {
    private final List<Player> players;
    private Board board;
    private int playerTurn;
    private final Dice dice;
    private final Status status;

    public Game(List<String> playerIds, List<Snake> snakes, List<Ladder> ladders) {
        this(DEFAULT_BOARD_SIZE, playerIds, snakes, ladders);
    }

    public Game(int boardSize, List<String> playerIds, List<Snake> snakes, List<Ladder> ladders) {
        this(playerIds);
        board = new Board(boardSize, snakes, ladders);
    }

    public Game(List<String> playerIds, SnakeLadderGeneratorType generatorType) throws Exception {
        this(DEFAULT_BOARD_SIZE, playerIds, generatorType);
    }

    public Game(int boardSize, List<String> playerIds, SnakeLadderGeneratorType generatorType) throws Exception {
        this(playerIds);
        SnakeLadderGenerator generator = SnakeLadderGeneratorFactory.create(generatorType, boardSize);
        board = new Board(boardSize, generator.generateSnakes(), generator.generateLadders());
    }

    private Game(List<String> playerIds) {
        players = playerIds.stream()
                .map(Player::new)
                .collect(Collectors.toList());
        dice = DiceFactory.create(DiceType.SingleSixFacedDice);
        playerTurn = 0;
        status = new Status();
    }

    public Status play() {
        if (status.isGameOver()) return status;

        int rollValue = dice.roll();
        var player = players.get(playerTurn);
        int oldPosition = player.getPosition();
        int newPosition = board.move(oldPosition, rollValue);
        player.setPosition(newPosition);
        Move move = new Move(oldPosition, newPosition, rollValue);
        player.getMoves().add(move);
        playerTurn++;
        playerTurn %= players.size();

        status.update(player, move, board.hasPositionEnded(newPosition));
        return status;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Status getStatus() {
        return status;
    }

    public boolean isNotOver() {
        return !status.isGameOver();
    }

    public Board getBoard() {
        return board;
    }
}
