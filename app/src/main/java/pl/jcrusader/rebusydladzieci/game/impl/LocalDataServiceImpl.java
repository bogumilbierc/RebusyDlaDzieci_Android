package pl.jcrusader.rebusydladzieci.game.impl;

import android.content.Context;
import android.content.SharedPreferences;

import pl.jcrusader.rebusydladzieci.R;
import pl.jcrusader.rebusydladzieci.game.GameConstants;
import pl.jcrusader.rebusydladzieci.game.LocalDataService;

/**
 * Created by bogumil on 3/28/17.
 */

public class LocalDataServiceImpl implements LocalDataService {

    private static final String RIDDLE_NUMBER_KEY = "RIDDLE_NUMBER_KEY";

    private Context context;

    public LocalDataServiceImpl(Context context) {
        this.context = context;
    }

    @Override
    public Integer getHighestSolvedRiddleNumber() {
        return getPreferences().getInt(RIDDLE_NUMBER_KEY, GameConstants.MIN_LEVEL);
    }

    @Override
    public void incrementHighestSolvedRiddleNumber() {
        Integer currentNumber = getHighestSolvedRiddleNumber();
        SharedPreferences sharedPreferences = getPreferences();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(RIDDLE_NUMBER_KEY, ++currentNumber);
        editor.commit();
    }

    @Override
    public void resetHighestSolvedRiddleNumber() {
        SharedPreferences sharedPreferences = getPreferences();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(RIDDLE_NUMBER_KEY, GameConstants.MIN_LEVEL);
        editor.commit();
    }

    private SharedPreferences getPreferences() {
        return context.getSharedPreferences(context.getString(R.string.preference_file_key), Context.MODE_PRIVATE);
    }
}
