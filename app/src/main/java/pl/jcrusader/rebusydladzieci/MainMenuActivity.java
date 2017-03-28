package pl.jcrusader.rebusydladzieci;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import pl.jcrusader.rebusydladzieci.widget.CustomFontTextView;

public class MainMenuActivity extends AppCompatActivity {

    private TextView levelTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        assignObjectsToViews();
        assignListeners();
    }

    private void assignObjectsToViews() {
        levelTv = (CustomFontTextView) findViewById(R.id.levelsTextView);
    }

    private void assignListeners() {
        levelTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, LevelsActivity.class);
                startActivity(intent);
            }
        });
    }


}
