
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

public class FAQActivity extends AppCompatActivity {
    private ImageView back_btn;
    private EditText inputchat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        back_btn = (ImageView)findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(FAQActivity.this, MainActivity.class);
                startActivity(intent1);
            }
        });
        inputchat = (EditText) findViewById(R.id.inputChat);
        inputchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(FAQActivity.this , inputchat);

                MenuInflater inf = popup.getMenuInflater();
                inf.inflate(R.menu.chatmenu, popup.getMenu());
                popup.show();
            }
        });
    }
    //edittext 클릭 후 메뉴 생성, 실행 한번 해보고 edittext 입력창 숨길지 말지 함 봐줭.
    //메뉴 디자인은 추후에 내가 수정할게욤.
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.chatmenu, menu);
        return true;
    }

    //아이템 선택후 액션 여기서 지정하면 됌!
    //아이템 수정할 menu xml은 menu폴더 안에 있음 chatmenu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.itemOne) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

