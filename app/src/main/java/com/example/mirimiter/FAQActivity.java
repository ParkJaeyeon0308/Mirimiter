package com.example.mirimiter;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class FAQActivity extends AppCompatActivity {
    private ImageView back_btn;
    private EditText inputchat;
    private CardView chat1;
    private CardView chat2;
    private CardView chat3;
    private CardView chat4;
    private CardView chat5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        //화면 시작때 키패드 나오지 않게
        inputchat = (EditText) findViewById(R.id.inputChat);
        inputchat.setInputType(0);

        //만들어둔 챗봇 선택지 정의해놨음! 사용하셈
        chat1 = (CardView) findViewById(R.id.chat1);
        chat2 = (CardView) findViewById(R.id.chat2);
        chat3 = (CardView) findViewById(R.id.chat3);
        chat4 = (CardView) findViewById(R.id.chat4);
        chat5 = (CardView) findViewById(R.id.chat5);

        //뒤로가기
        back_btn = (ImageView) findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(FAQActivity.this, MainActivity.class);
                startActivity(intent1);
            }
        });
    }
}

