package io.github.mishrasunny174.doodleapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

    LinearLayout main_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_layout = (LinearLayout)findViewById(R.id.main_layout);
        main_layout.addView(new DoodleView(this));
    }
}
