package pl.jcrusader.rebusydladzieci;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import pl.jcrusader.rebusydladzieci.game.GameController;
import pl.jcrusader.rebusydladzieci.game.impl.GameControllerImpl;

public class GameActivity extends AppCompatActivity {

    public static final String LEVEL_KEY = "pl.jcrusader.rebusydladzieci.LEVEL";

    private ImageView imageView;
    private GameController gameController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        imageView = (ImageView) findViewById(R.id.imageView);

        initializeGameController();
        drawRiddle();
    }

    private void initializeGameController() {
        Intent intent = getIntent();
        Integer level = intent.getIntExtra(LEVEL_KEY, -1);

        if (level != -1) {
            gameController = new GameControllerImpl(this, level);
        } else {
            gameController = new GameControllerImpl(this);
        }
    }

    private void drawRiddle() {
        imageView.setImageBitmap(gameController.getCurrentRiddleImage());
    }


}
