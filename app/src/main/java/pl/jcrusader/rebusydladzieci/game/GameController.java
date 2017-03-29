package pl.jcrusader.rebusydladzieci.game;

import android.graphics.Bitmap;

/**
 * Created by bogumil on 3/28/17.
 */

public interface GameController {

    /**
     * Submits user answer to current riddle. If answer is correct then current riddle would be changed to new one.
     *
     * @param userAnswer answer given by user
     * @return true if answer was correct, false otherwise
     */
    boolean submitAnswer(String userAnswer);

    /**
     * Gets riddle image for current riddle (kept in GameController).
     *
     * @return image corresponding to current riddle or null in case there was an issue while reading it
     */
    Bitmap getCurrentRiddleImage();

    /**
     * Checks whether riddle with given number should be available to the user (if he solved all previous ones).
     *
     * @param riddleNumber number of riddle to check
     * @return true if riddle should be available to the user, false otherwise
     */
    boolean isRiddleAvailable(Integer riddleNumber);

    /**
     * Checks whether all riddles are solved, so user can be notified about such fact.
     *
     * @return true if all riddles are solved, false otherwise
     */
    boolean areAllRiddlesSolved();
}
