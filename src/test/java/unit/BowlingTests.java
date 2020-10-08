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
        BowlingGame game = new BowlingGame(new int[] {5,2, 1,1, 10,0, 5,3, 2,1, 5,4, 8,1, 4,4, 5,1, 7,2});
        int result = game.score();
        assertEquals(79, result);
    }

    // Exercise 2
    // 12 frames are played when you score a perfect game

    @Test
    public void PerfectGame() {
        BowlingGame game = new BowlingGame(new int[] {10,0, 10,0, 10,0, 10,0, 10,0, 10,0, 10,0, 10,0, 10,0, 10,0, 10,0, 10,0});
        int result = game.score();
        System.out.println("You scored: "+ result);
        assertEquals(300, result);
    }

    // Exercise 3: Apply TDD to implement alternating strikes and spares.
    @Test
    public void AlternatingGame() {
        // alternating game requires one more frame to be played, in our case where the score alternates between spare and strike,
        // our last frame will be a strike
        BowlingGame game = new BowlingGame(new int[] {10,0, 7,3, 10,0, 5,5, 10,0, 2,8, 10,0, 6,4, 10,0, 4,6, 10,0});
        int result = game.score();
        System.out.println("Your score is " + result);
        assertEquals(200, result);
    }

}
