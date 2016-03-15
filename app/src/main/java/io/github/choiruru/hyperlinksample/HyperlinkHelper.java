package io.github.choiruru.hyperlinksample;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Choirul on 3/2/2016.
 */
public class HyperlinkHelper {

    public static void createLink(final Context context, TextView textView, String alltext, String link, final OnClick onClick){
        int[]data = getIndex(alltext,link);
        SpannableString ss = new SpannableString(alltext);
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                onClick.onClick();
            }
            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(true);
                ds.setColor(ResourceHelper.getColor(context, R.color.c_blue_dark));
            }
        };
        ss.setSpan(clickableSpan, data[0], data[1], Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(Color.TRANSPARENT);
    }

    public interface OnClick{
        void onClick();
    }

    private static int[] getIndex(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        int[] data = new int[2];
        // Check all occurrences
        while (matcher.find()) {
            data[0] = matcher.start();
            data[1] = matcher.end();
//            System.out.print("Start index: " + matcher.start());
//            System.out.print(" End index: " + matcher.end());
//            System.out.println(" Found: " + matcher.group());
        }
        return data;
    }
}
