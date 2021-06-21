package com.example.mirimiter;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

public class OfficeRoomAcitivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private View drawerView;
    private TextView community_menu;
    private TextView club_menu;
    private TextView officeroom_menu;
    private TextView faq_menu;
    private TextView mypage_menu;
    private ViewFlipper v_flippr;

    private CardView office1_card;
    private CardView office2_card;
    private CardView office3_card;
    private CardView office4_card;
    private CardView office5_card;

    private TextView office1;
    private TextView o1t1;
    private TextView o1t2;
    private TextView o1t3;
    private TextView o1t4;
    private TextView o1t5;

    private TextView office2;
    private TextView o2t1;
    private TextView o2t2;
    private TextView o2t3;
    private TextView o2t4;

    private TextView office3;
    private TextView o3t1;
    private TextView o3t2;
    private TextView o3t3;

    private TextView office4;
    private TextView o4t1;
    private TextView o4t2;
    private TextView o4t3;

    private TextView office5;
    private TextView o5t1;
    private TextView o5t2;


    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_officeroom);

        int images[] = {
                R.drawable.office1,
                R.drawable.office2,
                R.drawable.office3,
                R.drawable.office4,
                R.drawable.office5
        };

        v_flippr = findViewById(R.id.image_slide);

        for(int image : images){
            fllipperImages(image);
        }

        office1_card = (CardView)findViewById(R.id.office1_btn);
        office1_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPopupOffice1();
            }
        });

        office2_card = (CardView)findViewById(R.id.office2_btn);
        office2_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPopupOffice2();
            }
        });

        office3_card = (CardView)findViewById(R.id.office3_btn);
        office3_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPopupOffice3();
            }
        });

        office4_card = (CardView)findViewById(R.id.office4_btn);
        office4_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPopupOffice4();
            }
        });

        office5_card = (CardView)findViewById(R.id.office5_btn);
        office5_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPopupOffice5();
            }
        });




        community_menu = (TextView) findViewById(R.id.community_text);
        community_menu.setOnClickListener(click);
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
    public void fllipperImages(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flippr.addView(imageView);      // 이미지 추가
        v_flippr.setFlipInterval(4000);       // 자동 이미지 슬라이드 딜레이시간(1000 당 1초)
        v_flippr.setAutoStart(true);          // 자동 시작 유무 설정

        // animation
        v_flippr.setInAnimation(this,android.R.anim.slide_in_left);
        v_flippr.setOutAnimation(this,android.R.anim.slide_out_right);
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
                    Intent intent1 = new Intent(OfficeRoomAcitivity.this, MainActivity.class);
                    startActivity(intent1);
                    break;
                case R.id.club_text:
                    Intent intent3 = new Intent(OfficeRoomAcitivity.this, ClubActivity.class);
                    startActivity(intent3);
                    break;
                case R.id.officeRoom_text:
                    Toast.makeText(OfficeRoomAcitivity.this, "현재 페이지 입니다.", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.FAQ_text:
                    Intent intent4 = new Intent(OfficeRoomAcitivity.this, FAQActivity.class);
                    startActivity(intent4);
                    break;
                case R.id.Mypage_text:
                    Intent intent5 = new Intent(OfficeRoomAcitivity.this, MypageActivity.class);
                    startActivity(intent5);
                    break;
            }
        }
    };

    public void createPopupOffice1(){
        dialogBuilder = new AlertDialog.Builder(this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.office1, null);
        office1 = (TextView) findViewById(R.id.office1);
        o1t1 = (TextView) findViewById(R.id.o1t1);
        o1t2 = (TextView) findViewById(R.id.o1t2);
        o1t3 = (TextView) findViewById(R.id.o1t3);
        o1t4 = (TextView) findViewById(R.id.o1t4);
        o1t5 = (TextView) findViewById(R.id.o1t5);

        dialogBuilder.setView(contactPopupView);
        dialog = dialogBuilder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.show();
    }

    public void createPopupOffice2(){
        dialogBuilder = new AlertDialog.Builder(this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.office2, null);
        office2 = (TextView) findViewById(R.id.office2);
        o2t1 = (TextView) findViewById(R.id.o2t1);
        o2t2 = (TextView) findViewById(R.id.o2t2);
        o2t3 = (TextView) findViewById(R.id.o2t3);
        o2t4 = (TextView) findViewById(R.id.o2t4);

        dialogBuilder.setView(contactPopupView);
        dialog = dialogBuilder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.show();
    }

    public void createPopupOffice3(){
        dialogBuilder = new AlertDialog.Builder(this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.office3, null);
        office3 = (TextView) findViewById(R.id.office3);
        o3t1 = (TextView) findViewById(R.id.o3t1);
        o3t2 = (TextView) findViewById(R.id.o3t2);
        o3t3 = (TextView) findViewById(R.id.o3t3);

        dialogBuilder.setView(contactPopupView);
        dialog = dialogBuilder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.show();
    }

    public void createPopupOffice4(){
        dialogBuilder = new AlertDialog.Builder(this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.office4, null);
        office4 = (TextView) findViewById(R.id.office4);
        o4t1 = (TextView) findViewById(R.id.o4t1);
        o4t2 = (TextView) findViewById(R.id.o4t2);
        o4t3 = (TextView) findViewById(R.id.o4t3);

        dialogBuilder.setView(contactPopupView);
        dialog = dialogBuilder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.show();
    }
    public void createPopupOffice5(){
        dialogBuilder = new AlertDialog.Builder(this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.office5, null);
        office5 = (TextView) findViewById(R.id.office5);
        o5t1 = (TextView) findViewById(R.id.o5t1);
        o5t2 = (TextView) findViewById(R.id.o5t2);

        dialogBuilder.setView(contactPopupView);
        dialog = dialogBuilder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.show();
    }

    @Override
    public void onBackPressed() {}
}
