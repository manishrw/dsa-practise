package code_design.snl;

import java.util.Random;

public class SingleSixFacedDice implements Dice {
    private final Random random;
    private static final int DICE_SIZE = 6;


    public SingleSixFacedDice() {
        this.random = new Random();
    }

    @Override
    public int roll() {
        return random.nextInt(DICE_SIZE) + 1;
    }
}
