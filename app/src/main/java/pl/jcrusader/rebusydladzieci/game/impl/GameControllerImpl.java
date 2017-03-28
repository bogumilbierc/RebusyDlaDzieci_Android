package pl.jcrusader.rebusydladzieci.game.impl;

import android.content.Context;
import android.graphics.Bitmap;

import pl.jcrusader.rebusydladzieci.game.GameController;
import pl.jcrusader.rebusydladzieci.game.LocalDataService;

/**
 * Created by bogumil on 3/28/17.
 */

public class GameControllerImpl implements GameController {

    private Context context;
    private LocalDataService localDataService;

    private Integer currentImage = 001;
    private String imagePrefix = "image";
    private String extension = ".jpg";

    public GameControllerImpl(Context context) {
        this.context = context;
        this.localDataService = new LocalDataServiceImpl(context);
    }

    @Override
    public boolean checkAnswer(String userAnswer) {
        return false;
    }

    @Override
    public Bitmap giveRiddle() {
        return null;
    }

    @Override
    public boolean riddleAvailable(Integer riddleNumber) {
        return localDataService.getCurrentRiddleNumber() >= riddleNumber;
    }


}
