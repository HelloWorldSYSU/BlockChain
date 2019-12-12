package com.example.msdictionary;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.tu.loadingdialog.LoadingDailog;
import com.google.gson.JsonObject;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.regex.*;
import java.util.regex.PatternSyntaxException;

import okhttp3.OkHttpClient;
import okhttp3.*;
import okhttp3.RequestBody;
import okhttp3.Response;
import top.androidman.SuperButton;
import com.example.msdictionary.Keys;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        final LinearLayout linearLayout = findViewById(R.id.show_infos);
        linearLayout.setVisibility(View.INVISIBLE);
        final TextView textView3 = findViewById(R.id.Reminder);
        textView3.setVisibility(View.INVISIBLE);
        SuperButton superButton = findViewById(R.id.RegisterBtn);
        final EditText editText = findViewById(R.id.register_account);
        superButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(getBaseContext(), "正在生成公钥私钥，请稍等..", Toast.LENGTH_SHORT).show();
                String Account = editText.getText().toString();
                int pos = Keys.getIndex(Account);
                final String public_key = Keys.public_keys[pos];
                final String private_key = Keys.private_keys[pos];
                TextView textView = findViewById(R.id.showPublicKey);
                TextView textView1 = findViewById(R.id.showPrivateKey);
                textView.setText(public_key);
                textView1.setText(private_key);
                LoadingDailog.Builder loadBuilder=new LoadingDailog.Builder(Register.this)
                        .setMessage("加载中...")
                        .setCancelable(true)
                        .setCancelOutside(true);
                final LoadingDailog dialog=loadBuilder.create();
                dialog.show();
                Thread myThread=new Thread(){//创建子线程
                    @Override
                    public void run() {
                        try{
                            sleep(1000);
                            dialog.cancel();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                };
                myThread.start();
                textView3.setVisibility(View.VISIBLE);
                textView3.setVisibility(View.GONE);
                linearLayout.setVisibility(View.VISIBLE);
            }
        });
    }
}
