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

//    private void nextImage() {
//        try {
//            InputStream imageStream = getImage(currentImage++);
//            imageView.setImageBitmap(BitmapFactory.decodeStream(imageStream));
//        } catch (IOException e) {
//            Log.e("Cannot open image", e.getMessage());
//            e.printStackTrace();
//        }
//
//
//    }
//
//    private InputStream getImage(Integer imageNumber) throws IOException {
//        return getAssets().open("easy/" + buildImageName(imageNumber));
//    }
//
//    private String buildImageName(Integer imageNumber) {
//        return imagePrefix + String.format("%03d", imageNumber) + extension;
//    }
}
