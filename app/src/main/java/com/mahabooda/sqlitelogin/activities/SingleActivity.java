package com.mahabooda.sqlitelogin.activities;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mahabooda.sqlitelogin.R;

public class SingleActivity extends AppCompatActivity {
    TextView name_text;
    char[] charArray;
    Button myButton;
    TextView textView;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);

        name_text = findViewById(R.id.name_text);
        linearLayout = findViewById(R.id.lay_out);

        Bundle bundle = getIntent().getExtras();
        String name = null;
        int index = 0;
        if (bundle != null) {
            name = bundle.getString("username");
            index = bundle.getInt("CLICKED_INDEX", 0);
        }

        name_text.setText(name);
        charArray = name.toCharArray();
//        for (int i = 0; i < charArray.length; i++) {
//            myButton = new Button(this);
//            if (i == index) {
//                myButton.setAllCaps(true);
//            } else {
//                myButton.setAllCaps(false);
//            }
//            myButton.setText(myButton.getText() + "" + charArray[i]);
//            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
//                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//            linearLayout.addView(myButton, layoutParams);
//        }

        for (int i = 0; i < charArray.length; i++) {
            textView = new TextView(this);
            if (i == index) {
                textView.setAllCaps(true);
            } else {
                textView.setAllCaps(false);
            }
            textView.setText(textView.getText() + "" + charArray[i]);
            textView.setTextSize(22);
            textView.setTextColor(Color.RED);
            textView.setGravity(Gravity.CENTER );
//            linearLayout.setBackgroundColor(Color.BLACK);

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            linearLayout.addView(textView,layoutParams);
        }
    }
}
