package pl.jcrusader.rebusydladzieci.game;

import android.graphics.Bitmap;

/**
 * Created by bogumil on 3/28/17.
 */

public interface GameController {
    boolean submitAnswer(String userAnswer);

    Bitmap getCurrentRiddleImage();

    boolean isRiddleAvailable(Integer riddleNumber);
}
