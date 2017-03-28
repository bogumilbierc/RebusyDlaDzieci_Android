package pl.jcrusader.rebusydladzieci.adapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import pl.jcrusader.rebusydladzieci.game.GameConstants;
import pl.jcrusader.rebusydladzieci.game.GameController;
import pl.jcrusader.rebusydladzieci.widget.CustomFontTextView;

/**
 * Created by bogumil on 3/28/17.
 */

public class TextViewAdapter extends BaseAdapter {

    private Context context;
    private GameController gameController;

    public TextViewAdapter(Context context, GameController gameController) {
        this.context = context;
        this.gameController = gameController;
    }

    @Override
    public int getCount() {
        return GameConstants.MAX_LEVEL;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CustomFontTextView textView;
        if (convertView == null) {
            textView = new CustomFontTextView(context);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        } else {
            textView = (CustomFontTextView) convertView;
        }
        textView.setText(String.format("%d", position + 1));
        if (gameController.riddleAvailable(position + 1)) {
            textView.setTextColor(ColorStateList.valueOf(Color.GREEN));
        } else {
            textView.setTextColor(ColorStateList.valueOf(Color.RED));
        }
        textView.setGravity(Gravity.CENTER);
        return textView;
    }
}
