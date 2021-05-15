package com.example.mirimiter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AccountSettingActivity extends AppCompatActivity {
    private Button settingDone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountsetting);

        settingDone = (Button)findViewById(R.id.settingDone_btn);
        settingDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccountSettingActivity.this, MypageActivity.class);
                startActivity(intent);
            }
        });

    }
}
