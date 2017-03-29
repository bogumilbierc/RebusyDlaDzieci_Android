package pl.jcrusader.rebusydladzieci.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import pl.jcrusader.rebusydladzieci.R;
import pl.jcrusader.rebusydladzieci.game.LocalDataService;
import pl.jcrusader.rebusydladzieci.game.impl.LocalDataServiceImpl;

public class OptionsActivity extends AppCompatActivity {

    private TextView resetLevelsProgres;
    private LocalDataService localDataService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        resetLevelsProgres = (TextView) findViewById(R.id.resetLevelsProgresTextView);
        localDataService = new LocalDataServiceImpl(this);

        resetLevelsProgres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                localDataService.resetHighestSolvedRiddleNumber();
            }
        });
    }
}
