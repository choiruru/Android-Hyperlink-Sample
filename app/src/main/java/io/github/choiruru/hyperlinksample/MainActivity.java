package io.github.choiruru.hyperlinksample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String quote = "Nurture your minds with great thoughts. To believe in the heroic makes heroes.";
        TextView textView = (TextView)findViewById(R.id.textview);

        HyperlinkHelper.createLink(this, textView, quote, "believe", new HyperlinkHelper.OnClick() {
            @Override
            public void onClick() {
                Toast.makeText(MainActivity.this, "Hyperlink clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
