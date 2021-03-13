package code_design.snl;

public class DiceFactory {
    public static Dice create(DiceType type) {
        switch (type) {
            default:
                return new SingleSixFacedDice();
        }
    }
}
