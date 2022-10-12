package code_design.snl;

public class SnakeLadderGeneratorFactory {
    public static SnakeLadderGenerator create(SnakeLadderGeneratorType type, int boardSize) {
        switch (type) {
            default:
                return new SimpleSnakeLadderGenerator(boardSize);
        }
    }
}
