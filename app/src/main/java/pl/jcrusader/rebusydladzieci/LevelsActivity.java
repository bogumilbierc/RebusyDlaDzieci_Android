package pl.jcrusader.rebusydladzieci;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import pl.jcrusader.rebusydladzieci.adapter.TextViewAdapter;

public class LevelsActivity extends AppCompatActivity {

    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);
        gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new TextViewAdapter(this));
    }

}