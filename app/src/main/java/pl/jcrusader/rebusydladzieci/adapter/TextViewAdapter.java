package pl.jcrusader.rebusydladzieci.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import pl.jcrusader.rebusydladzieci.game.GameConstants;
import pl.jcrusader.rebusydladzieci.widget.CustomFontTextView;

/**
 * Created by bogumil on 3/28/17.
 */

public class TextViewAdapter extends BaseAdapter {

    private Context context;

    public TextViewAdapter(Context context) {
        this.context = context;
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
            textView.setText("test");
        } else {
            textView = (CustomFontTextView) convertView;
        }
        return textView;
    }
}