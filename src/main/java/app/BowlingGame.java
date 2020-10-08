package app;

import java.util.ArrayList;
import java.util.*;

public class BowlingGame {

    public static final int NUMBER_OF_FRAMES = 10;
    private final int[] rolls;

    public BowlingGame(int[] rolls) {
        this.rolls = rolls;
    }


    public int score() {
        int result = 0;
        ArrayList<BowlingFrame> frames = createFrames();
        for (BowlingFrame frame: frames) {
            result += frame.score();
        }
        return result;
    }

    private ArrayList<BowlingFrame> createFrames() {
        ArrayList<BowlingFrame> frames = new ArrayList<>();
        int rollIndex = 0;
        for (int i = 0; i < NUMBER_OF_FRAMES; i++) {
            ArrayList<Integer> frameRolls = new ArrayList<>();

            // if an alternating game is played
//            if((rolls[rollIndex] == 10) || (rolls[rollIndex] + rolls[rollIndex+1] == 10)){
//                frameRolls.add(rolls[rollIndex]);
//                frameRolls.add(rolls[rollIndex+2]);
//                frameRolls.add(rolls[rollIndex+3]);
////                frameRolls.add(rolls[rollIndex+3]);
//            }

            // if a perfect game is played
            if((rolls[rollIndex] == 10)  && (rolls[rollIndex+1] == 0) && (rolls[rollIndex+2] == 10)){
                frameRolls.add(rolls[rollIndex]);
                frameRolls.add(rolls[rollIndex+2]);
                frameRolls.add(rolls[rollIndex+3]);
            }

            ////// The next if() and else if() statements will also check for the alternating between strikes and spares

            // if a spare is rolled
             if ((rolls[rollIndex] + rolls[rollIndex + 1] == 10) && (rolls[rollIndex+1]) != 0) {
//                System.out.println("You rolled a spare!");
                frameRolls.add(rolls[rollIndex]);
                frameRolls.add(rolls[rollIndex + 1]);
                frameRolls.add(rolls[rollIndex + 2]);
            }
            // if a single strike is rolled
            else if((rolls[rollIndex] == 10)  && (rolls[rollIndex+1] == 0) && (rolls[rollIndex+2] != 10)){
//                System.out.println("You rolled a strike!");
                frameRolls.add(rolls[rollIndex] );
                frameRolls.add(rolls[rollIndex+2]);
                frameRolls.add(rolls[rollIndex+3]);
            }

            else{
                frameRolls.add(rolls[rollIndex]);
                frameRolls.add(rolls[rollIndex + 1]);
            }
            rollIndex += 2;
            frames.add(new BowlingFrame(frameRolls));
        }
        return frames;
    }
}
