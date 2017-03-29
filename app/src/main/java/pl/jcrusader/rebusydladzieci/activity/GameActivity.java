package pl.jcrusader.rebusydladzieci.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import pl.jcrusader.rebusydladzieci.R;
import pl.jcrusader.rebusydladzieci.game.GameController;
import pl.jcrusader.rebusydladzieci.game.impl.GameControllerImpl;
import pl.jcrusader.rebusydladzieci.widget.CustomFontTextView;

public class GameActivity extends AppCompatActivity {

    public static final String LEVEL_KEY = "pl.jcrusader.rebusydladzieci.LEVEL";

    private ImageView imageView;
    private EditText answerEt;
    private CustomFontTextView allRiddlesSolvedTv;
    private CustomFontTextView checkAnswerTv;
    private CustomFontTextView correctAnswerTv;
    private CustomFontTextView incorrectAnswerTv;
    private GameController gameController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        imageView = (ImageView) findViewById(R.id.imageView);
        checkAnswerTv = (CustomFontTextView) findViewById(R.id.checkAnswerTv);
        answerEt = (EditText) findViewById(R.id.answerEt);
        incorrectAnswerTv = (CustomFontTextView) findViewById(R.id.inCorrectAnswerTv);
        correctAnswerTv = (CustomFontTextView) findViewById(R.id.correctAnswerTv);
        allRiddlesSolvedTv = (CustomFontTextView) findViewById(R.id.allRiddlesSolvedTv);

        checkAnswerTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitAnswer();
            }
        });

        incorrectAnswerTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideAllControls();
                showGameControls();
            }
        });

        correctAnswerTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideAllControls();
                showGameControls();
                answerEt.setText("");
                drawRiddle();
            }
        });

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
        if (gameController.areAllRiddlesSolved()) {
            hideAllControls();
            showAllRiddlesSolvedView();
        } else {
            imageView.setImageBitmap(gameController.getCurrentRiddleImage());
        }
    }

    private void submitAnswer() {
        String userAnswer = answerEt.getText().toString();
        if (gameController.submitAnswer(userAnswer)) {
            handleCorrectAnswer();
        } else {
            handleWrongAnswer();
        }
    }

    private void handleCorrectAnswer() {
        hideAllControls();
        showOkView();
    }

    private void handleWrongAnswer() {
        hideAllControls();
        showBadAnswerView();
    }

    private void hideAllControls() {
        imageView.setVisibility(View.GONE);
        answerEt.setVisibility(View.GONE);
        checkAnswerTv.setVisibility(View.GONE);
        correctAnswerTv.setVisibility(View.GONE);
        incorrectAnswerTv.setVisibility(View.GONE);
    }

    private void showGameControls() {
        imageView.setVisibility(View.VISIBLE);
        answerEt.setVisibility(View.VISIBLE);
        checkAnswerTv.setVisibility(View.VISIBLE);
    }

    private void showOkView() {
        correctAnswerTv.setVisibility(View.VISIBLE);
    }

    private void showBadAnswerView() {
        incorrectAnswerTv.setVisibility(View.VISIBLE);
    }

    private void showAllRiddlesSolvedView() {
        allRiddlesSolvedTv.setVisibility(View.VISIBLE);
    }


}
