package pl.jcrusader.rebusydladzieci.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import pl.jcrusader.rebusydladzieci.R;
import pl.jcrusader.rebusydladzieci.widget.CustomFontTextView;

public class MainMenuActivity extends AppCompatActivity {

    private TextView levelTv;
    private TextView playTv;
    private TextView optionsTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        assignObjectsToViews();
        assignListeners();
    }

    private void assignObjectsToViews() {
        levelTv = (CustomFontTextView) findViewById(R.id.levelsTextView);
        playTv = (CustomFontTextView) findViewById(R.id.playTextView);
        optionsTv = (CustomFontTextView) findViewById(R.id.optionsTextView);
    }

    private void assignListeners() {
        levelTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAndStartActivity(LevelsActivity.class);
            }
        });
        playTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAndStartActivity(GameActivity.class);
            }
        });
        optionsTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAndStartActivity(OptionsActivity.class);
            }
        });

    }

    private void createAndStartActivity(Class<?> cls) {
        Intent intent = new Intent(MainMenuActivity.this, cls);
        startActivity(intent);
    }


}
