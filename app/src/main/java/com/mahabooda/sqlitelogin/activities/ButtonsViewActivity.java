package com.mahabooda.sqlitelogin.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mahabooda.sqlitelogin.R;

public class ButtonsViewActivity extends AppCompatActivity implements View.OnClickListener {
    TextView name;
    String  Name;
    char[] charArray;
    Button b_one;
    LinearLayout linearLayout;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttons_view);

        name = (TextView) findViewById(R.id.name_text);

        linearLayout = (LinearLayout) findViewById(R.id.layout);
        Intent intent = getIntent();
        Name = intent.getStringExtra("username");
        name.setText(Name);

        charArray = Name.toCharArray();
        for(int i=0;i<charArray.length;i++){
            Button myButton = new Button(this);
            myButton.setText(myButton.getText() +""+ charArray[i]);
            LinearLayout ll = (LinearLayout)findViewById(R.id.layout);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            ll.addView(myButton, layoutParams);
            myButton.setOnClickListener(ButtonsViewActivity.this);
//        char c = Name.charAt(0);  // returns 'l' only first letter
        }
    }

    @Override
    public void onClick(View v) {
//        String str = v.getTag().toString();
//        if(str.equals("0")){
//        }
        Intent intent = new Intent(ButtonsViewActivity.this,SingleActivity.class);
        startActivity(intent);
        Toast.makeText(v.getContext(),"Button clicked index " , Toast.LENGTH_SHORT).show();
    }
}
