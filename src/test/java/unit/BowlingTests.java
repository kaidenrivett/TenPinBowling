package unit;

import app.BowlingGame;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BowlingTests {
    @Test
    public void HookUp() {
        assertTrue(true);
    }
    @Test
    public void AllGutterBallsScores0() {
        // Arrange
        BowlingGame game = new BowlingGame(new int[] {0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0});

        // Act
        int result = game.score();

        // Assert
        assertEquals(0, result);
    }

    @Test
    public void PlayerKnocksDownOnePin() {
        // Arrange
        BowlingGame game = new BowlingGame(new int[]{0,0, 0,0, 0,0, 0,0, 1,0, 0,0, 0,0, 0,0, 0,0, 0,0});

        // Act
        int result = game.score();

        // Assert
        assertEquals(1, result);
    }

    @Test
    public void PlayerRollsASpareAndThenFours() {
        BowlingGame game = new BowlingGame(new int[]{4,4, 3,7, 4,4, 4,4, 4,4, 4,4, 4,4, 4,4, 4,4, 4,4});
        int result = game.score();

        assertEquals(86, result);
    }

    // Exercise 1

    @Test
    public void ThirdFrameStrike() {
        BowlingGame game = new BowlingGame(new int[] {2,1, 4,2, 10,0, 3,2, 5,4, 5,2, 1,8, 5,3, 1,5, 7,1});
        int result = game.score();

//        assertEquals();
    }

    // Exercise 2

    @Test
    public void PerfectGame() {
        BowlingGame game = new BowlingGame(new int[] {});
        int result = game.score();

//        assertEquals();
    }

    // Exercise 3: Apply TDD to implemet alternating strikes and spares.

}
