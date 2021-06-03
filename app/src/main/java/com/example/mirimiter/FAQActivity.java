package com.example.mirimiter;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

public class FAQActivity extends AppCompatActivity {private DrawerLayout drawerLayout;
    private View drawerView;
    private TextView community_menu;
    private TextView club_menu;
    private TextView officeroom_menu;
    private TextView faq_menu;
    private TextView mypage_menu;
    private TextView chat_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        community_menu = (TextView) findViewById(R.id.community_text);
        community_menu.setOnClickListener(click);
        chat_menu = (TextView) findViewById(R.id.chat_text);
        chat_menu.setOnClickListener(click);
        club_menu = (TextView) findViewById(R.id.club_text);
        club_menu.setOnClickListener(click);
        officeroom_menu = (TextView) findViewById(R.id.officeRoom_text);
        officeroom_menu.setOnClickListener(click);
        faq_menu = (TextView) findViewById(R.id.FAQ_text);
        faq_menu.setOnClickListener(click);
        mypage_menu = (TextView) findViewById(R.id.Mypage_text);
        mypage_menu.setOnClickListener(click);

        drawerLayout = (DrawerLayout) findViewById(R.id.draw_layout);
        drawerView = (View) findViewById(R.id.drawer);

        ImageButton open = (ImageButton) findViewById(R.id.menu_open);
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(drawerView);
            }
        });

        ImageButton close = (ImageButton) findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawers();

            }
        });
        drawerLayout.setDrawerListener(listener);
        drawerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
    }

    DrawerLayout.DrawerListener listener = new DrawerLayout.DrawerListener() {
        @Override
        public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

        }

        @Override
        public void onDrawerOpened(@NonNull View drawerView) {

        }

        @Override
        public void onDrawerClosed(@NonNull View drawerView) {

        }

        @Override
        public void onDrawerStateChanged(int newState) {

        }
    };
    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.community_text:
                    Intent intent1 = new Intent(FAQActivity.this, FAQActivity.class);
                    startActivity(intent1);
                case R.id.chat_text:
                    Intent intent2 = new Intent(FAQActivity.this, ChatActivity.class);
                    startActivity(intent2);
                    break;
                case R.id.club_text:
                    Intent intent3 = new Intent(FAQActivity.this, ClubActivity.class);
                    startActivity(intent3);
                    break;
                case R.id.officeRoom_text:
                    Intent intent4 = new Intent(FAQActivity.this, OfficeRoomAcitivity.class);
                    startActivity(intent4);
                    break;
                case R.id.FAQ_text:
                    Toast.makeText(FAQActivity.this, "현재 페이지 입니다.", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.Mypage_text:
                    Intent intent5 = new Intent(FAQActivity.this, MypageActivity.class);
                    startActivity(intent5);
                    break;
            }
        }
    };
}

