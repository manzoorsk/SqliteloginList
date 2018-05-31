package com.mahabooda.sqlitelogin.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mahabooda.sqlitelogin.R;

public class ButtonsViewActivity extends AppCompatActivity {
    TextView name;
    String  Name;
    char[] charArray;
    Context context = this;
    Button myButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttons_view);

        name = (TextView) findViewById(R.id.name_text);

        Intent intent = getIntent();
        Name = intent.getStringExtra("username");
        name.setText(Name);

        charArray = Name.toCharArray();
        for(int i=0;i<charArray.length;i++){
            myButton = new Button(this);
            myButton.setId(i + 1);
            myButton.setText(myButton.getText() +""+ charArray[i]);
            LinearLayout ll = (LinearLayout)findViewById(R.id.layout);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            ll.addView(myButton, layoutParams);
            final int index = i;
            myButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Toast.makeText(view.getContext(), "Button clicked index>>> " + charArray[index] + " >> " + index, Toast.LENGTH_SHORT).show();
                    Bundle bundle = new Bundle();
                    bundle.putString("username", Name);
                    Intent intent = new Intent(ButtonsViewActivity.this, SingleActivity.class);
                    intent.putExtras(bundle);
                    intent.putExtra("CLICKED_INDEX", index);
                    startActivity(intent);
                }
            });

//        char c = Name.charAt(0);  // returns 'l' only first letter
        }
    }
}
