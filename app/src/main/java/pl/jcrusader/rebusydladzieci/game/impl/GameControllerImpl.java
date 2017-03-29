package pl.jcrusader.rebusydladzieci.game.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;

import pl.jcrusader.rebusydladzieci.game.AnswersContainer;
import pl.jcrusader.rebusydladzieci.game.GameConstants;
import pl.jcrusader.rebusydladzieci.game.GameController;
import pl.jcrusader.rebusydladzieci.game.LocalDataService;

/**
 * Created by bogumil on 3/28/17.
 */

public class GameControllerImpl implements GameController {

    private Context context;
    private LocalDataService localDataService;
    private Integer currentRiddle;
    private boolean allRiddlesSolved;

    public GameControllerImpl(Context context) {
        this.context = context;
        this.localDataService = new LocalDataServiceImpl(context);
        this.currentRiddle = localDataService.getHighestSolvedRiddleNumber();
    }

    public GameControllerImpl(Context context, Integer currentRiddle) {
        this(context);
        this.currentRiddle = currentRiddle;
    }

    @Override
    public boolean submitAnswer(String userAnswer) {
        boolean isAnswerCorrect = userAnswer.equalsIgnoreCase(AnswersContainer.ANSWERS[currentRiddle]);
        if (isAnswerCorrect) {
            if (currentRiddle < GameConstants.MAX_LEVEL) {
                currentRiddle++;
                checkIfCurrentRiddleIsHighestAndSaveIfSo();
            } else {
                allRiddlesSolved = true;
            }
        }
        return isAnswerCorrect;
    }

    @Override
    public Bitmap getCurrentRiddleImage() {
        try {
            InputStream imageStream = getImage(currentRiddle);
            return BitmapFactory.decodeStream(imageStream);
        } catch (IOException e) {
            Log.e("Cannot open image", e.getMessage());
        }
        return null; //todo: return error image and update documentation
    }

    @Override
    public boolean isRiddleAvailable(Integer riddleNumber) {
        return localDataService.getHighestSolvedRiddleNumber() >= riddleNumber;
    }

    @Override
    public boolean areAllRiddlesSolved() {
        return allRiddlesSolved;
    }

    private void checkIfCurrentRiddleIsHighestAndSaveIfSo() {
        if (currentRiddle > localDataService.getHighestSolvedRiddleNumber()) {
            localDataService.incrementHighestSolvedRiddleNumber();
        }
    }


    private InputStream getImage(Integer imageNumber) throws IOException {
        return context.getAssets().open("easy/" + buildImageName(imageNumber));
    }

    private String buildImageName(Integer imageNumber) {
        return String.format("image%03d.jpg", imageNumber);
    }

}
