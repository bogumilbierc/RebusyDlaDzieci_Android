package pl.jcrusader.rebusydladzieci;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import pl.jcrusader.rebusydladzieci.game.GameController;
import pl.jcrusader.rebusydladzieci.game.impl.GameControllerImpl;

public class GameActivity extends AppCompatActivity {

    private ImageView imageView;
    private GameController gameController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        imageView = (ImageView) findViewById(R.id.imageView);
        gameController = new GameControllerImpl(this);
    }


}
