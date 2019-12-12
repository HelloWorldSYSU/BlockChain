package com.example.msdictionary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class TitleController extends LinearLayout {

    public  TitleController(Context context, AttributeSet attrs){
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.titlebar,this);
        ImageButton back = (ImageButton)findViewById(R.id.Back);
        ImageButton user = (ImageButton)findViewById(R.id.User_head);
        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)getContext()).finish();
            }
        });
        user.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), userinfo.class);
                getContext().startActivity(intent);
            }
        });
    }
}
