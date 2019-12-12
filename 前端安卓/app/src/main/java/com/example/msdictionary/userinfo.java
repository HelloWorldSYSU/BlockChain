package com.example.msdictionary;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import top.androidman.SuperButton;

import com.android.tu.loadingdialog.LoadingDailog;
import com.example.msdictionary.*;


public class userinfo extends AppCompatActivity {

    public Infos user = new Infos("msb", 100, 100, 100, 0);
    public Trans[] trans = new Trans[100];
    public Infos[] infos = new Infos[100];
    public String[] data = new String[100];
    public int tag = 0;

    public void transTodata(){
        for(int i = 0; i < 100; i ++){
            if(trans[i] == null){
                data[i] = "null";
                continue;
            }
            if(!trans[i].from.equals("")){
                data[i] = trans[i].from + " send to " +  trans[i].to + " " + String.valueOf(trans[i].value) + "$";
            }
            else{
                data[i] = "null";
            }
        }
    }

    public void infosTodata(){
        for(int i = 0; i < 100; i ++){
            if(infos[i] == null){
                data[i] = "null";
                continue;
            }
            if(!infos[i].accounts.equals("")){
                data[i] = "企业ID： " + infos[i].accounts + "  企业信用剩余额度: " + infos[i].left_credit;
            }
            else{
                data[i] = "null";
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinfo);
        final LinearLayout linearLayout = findViewById(R.id.btns);
        final LinearLayout linearLayout1 = findViewById(R.id.userInfo);
        final LinearLayout linearLayout2 = findViewById(R.id.Send);
        linearLayout1.setVisibility(View.INVISIBLE);
        final ListView listView = findViewById(R.id.list_view);
        final ArrayAdapter<String> transAdapter = new ArrayAdapter<String>(userinfo.this, android.R.layout.simple_list_item_1, data);
        final ArrayAdapter<String> companysAdapter = new ArrayAdapter<>(userinfo.this, android.R.layout.simple_list_item_1, data);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        SuperButton superButton = findViewById(R.id.ShowCompanys);
        SuperButton superButton1 = findViewById(R.id.ShowAllTrans);
        SuperButton superButton2 = findViewById(R.id.SendTran);
        SuperButton superButton3 = findViewById(R.id.SendTrans);
        SuperButton superButton4 = findViewById(R.id.SendBtn);
        pushCom(new Infos("msb", 100, 100, 100, 0));
        trick();



        listView.setVisibility(View.INVISIBLE);
        superButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadingDailog.Builder loadBuilder=new LoadingDailog.Builder(userinfo.this)
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
                linearLayout.setVisibility(View.GONE);
                listView.setVisibility(View.VISIBLE);
                infosTodata();
                listView.setAdapter(companysAdapter);
                if(tag == 0){
                    pushCom(new Infos("SYSU", 100, 100, 300, 0));
                    tag += 1;
                }
                else{
                    infos[1].left_credit = 50;
                }
            }
        });
        superButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadingDailog.Builder loadBuilder=new LoadingDailog.Builder(userinfo.this)
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
                linearLayout.setVisibility(View.GONE);
                listView.setVisibility(View.VISIBLE);
                transTodata();
                listView.setAdapter(transAdapter);
                pushTrans(new Trans("SYSU", "msb", 350));
            }
        });
        superButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadingDailog.Builder loadBuilder=new LoadingDailog.Builder(userinfo.this)
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

                linearLayout.setVisibility(View.GONE);
                listView.setVisibility(View.GONE);
                linearLayout1.setVisibility(View.VISIBLE);
                TextView e1 = findViewById(R.id.AccInfo);
                TextView e2 = findViewById(R.id.ALLInfo);
                TextView e3 = findViewById(R.id.LeftInfo);
                TextView e4 = findViewById(R.id.ValueInfo);
                TextView e5 = findViewById(R.id.DebtInfo);
                e1.setText("企业ID：" + user.accounts);
                e2.setText("信用额度： " + String.valueOf(user.all_credit));
                e3.setText("剩余额度： " + String.valueOf(user.left_credit));
                e4.setText("账户余额： " + String.valueOf(user.money));
                e5.setText("欠款： " + String.valueOf(user.debt));
                user.money = 350 + user.money;
            }
        });
        superButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                linearLayout.setVisibility(View.GONE);
                listView.setVisibility(View.GONE);
                linearLayout1.setVisibility(View.GONE);
                linearLayout2.setVisibility(View.VISIBLE);
            }
        });
        superButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView e1 = findViewById(R.id.error);
                EditText e2 = findViewById(R.id.sendTo);
                e1.setText("");
                EditText e3 = findViewById(R.id.value);

                int value = Integer.parseInt(e3.getText().toString());
                String to = e2.getText().toString();


                if(user.left_credit + user.money < value){
                    e1.setText("转账失败：银行贷款剩余额度： " + String.valueOf(user.left_credit) + ", 账户余额剩余： " + String.valueOf(user.money));
                }
                else{
                    LoadingDailog.Builder loadBuilder=new LoadingDailog.Builder(userinfo.this)
                            .setMessage("转账中...")
                            .setCancelable(true)
                            .setCancelOutside(true);
                    final LoadingDailog dialog = loadBuilder.create();
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
                    e1.setText("转账成功");
                    int temp = user.money;
                    user.money = (value > user.money) ? 0 : user.money - value;
                    user.left_credit = (value > temp) ? (user.left_credit - (value - temp)) : user.left_credit;
                    pushTrans(new Trans(user.accounts, to, value));
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        final LinearLayout linearLayout = findViewById(R.id.btns);
        final ListView listView = findViewById(R.id.list_view);
        final LinearLayout linearLayout1 = findViewById(R.id.userInfo);
        final LinearLayout linearLayout2 = findViewById(R.id.Send);
        listView.setVisibility(View.GONE);
        linearLayout.setVisibility(View.VISIBLE);
        linearLayout1.setVisibility(View.GONE);
        linearLayout2.setVisibility(View.GONE);
    }

    public void pushTrans(Trans tran){
        for (int i = 0; i < 100; i ++){
            if(trans[i] == null){
                trans[i] = tran;
                break;
            }
        }
    }

    public void pushCom(Infos info){
        for (int i = 0; i < 100; i ++){
            if(infos[i] == null){
                infos[i] = info;
                break;
            }
        }
    }

    public void trick(){
        pushTrans(new Trans("SYSU", "car", 200));
        pushTrans(new Trans("car", "glass", 400));
        pushTrans(new Trans("SYSU", "msb", 500));
        pushTrans(new Trans("SYSU", "glass", 600));
        pushTrans(new Trans("glass", "car", 800));
        pushTrans(new Trans("msb", "car", 200));
        pushCom(new Infos("glass", 200, 300, 400, 0));
        pushCom(new Infos("car", 400, 500, 260, 0));

    }
}
