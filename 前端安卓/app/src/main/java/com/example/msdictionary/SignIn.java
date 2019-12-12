package com.example.msdictionary;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import top.androidman.SuperButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.mesapi.*;

import org.greenrobot.eventbus.EventBus;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import top.androidman.SuperButton;
import com.example.msdictionary.Keys;

public class SignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //System.out.println("12345"+System.getProperty("file.encoding"));
        //Toast.makeText(this, "sda", Toast.LENGTH_SHORT).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }
        final EditText editText = findViewById(R.id.Account);
        final EditText editText1 = findViewById(R.id.public_key);
        final EditText editText2 = findViewById(R.id.private_key);
        SuperButton superButton = findViewById(R.id.ConfirmSingIn);
        superButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = editText.getText().toString();
                String public_key = editText1.getText().toString();
                String priavte_key = editText2.getText().toString();

                if(Keys.judge(account, public_key, priavte_key)){
                    Toast.makeText(SignIn.this, "登陆成功", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignIn.this, userinfo.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(SignIn.this, "登陆失败", Toast.LENGTH_SHORT).show();
                }
                editText1.setText("");
                editText2.setText("");
            }
        });
    }
}
