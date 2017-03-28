package pl.jcrusader.rebusydladzieci;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import pl.jcrusader.rebusydladzieci.adapter.TextViewAdapter;
import pl.jcrusader.rebusydladzieci.game.GameController;
import pl.jcrusader.rebusydladzieci.game.impl.GameControllerImpl;

public class LevelsActivity extends AppCompatActivity {

    private GridView gridView;
    private GameController gameController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);
        gameController = new GameControllerImpl(this);

        gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new TextViewAdapter(this, gameController));
    }

}
