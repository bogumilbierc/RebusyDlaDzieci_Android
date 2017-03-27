package pl.jcrusader.rebusydladzieci;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class MainMenuActivity extends AppCompatActivity {

    private Button testButton;
    private ImageView imageView;

    private Integer currentImage = 001;
    private String imagePrefix = "image";
    private String extension = ".jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        imageView = (ImageView) findViewById(R.id.imageView);

        testButton = (Button) findViewById(R.id.goNextButton);
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextImage();
            }
        });
    }

    private void nextImage() {
        try {
            InputStream imageStream = getImage(currentImage++);
            imageView.setImageBitmap(BitmapFactory.decodeStream(imageStream));
        } catch (IOException e) {
            Log.e("Cannot open image", e.getMessage());
            e.printStackTrace();
        }


    }

    private InputStream getImage(Integer imageNumber) throws IOException {
        return getAssets().open("easy/" + buildImageName(imageNumber));
    }

    private String buildImageName(Integer imageNumber) {
        return imagePrefix + String.format("%03d", imageNumber) + extension;
    }
}
