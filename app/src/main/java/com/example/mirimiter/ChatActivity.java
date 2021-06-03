package com.example.mirimiter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ChatActivity extends AppCompatActivity {
    private ImageView back_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        back_btn = (ImageView)findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ChatActivity.this, MainActivity.class);
                startActivity(intent1);
            }
        });

    }
}
