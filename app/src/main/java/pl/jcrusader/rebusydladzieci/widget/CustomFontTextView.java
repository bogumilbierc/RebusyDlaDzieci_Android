package pl.jcrusader.rebusydladzieci.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by bogumil on 3/28/17.
 */
public class CustomFontTextView extends android.support.v7.widget.AppCompatTextView {
    private static final String sScheme =
            "http://schemas.android.com/apk/res-auto";


    public CustomFontTextView(Context context) {
        super(context);
    }

    public CustomFontTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        if (isInEditMode()) {
            return;
        } else {
            final Typeface customTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/KBZipaDeeDooDah.ttf");
            setTypeface(customTypeface);
        }
    }
}
