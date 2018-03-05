package com.test.dynamic;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Administrator on 2018-03-05.
 */

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        TextView textView=findViewById(R.id.textView);
        String s=getIntent().getStringExtra("result");
        textView.setText(s);

    }
}
