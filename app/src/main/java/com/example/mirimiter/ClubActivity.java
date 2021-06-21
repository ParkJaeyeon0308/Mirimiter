package com.example.mirimiter;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

public class ClubActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private View drawerView;
    private TextView community_menu;
    private TextView club_menu;
    private TextView officeroom_menu;
    private TextView faq_menu;
    private TextView mypage_menu;
    private CardView miven;
    private CardView js;
    private CardView omop;
    private CardView gm;
    private CardView msg;
    private CardView cpu;
    private CardView pp;
    private CardView mslr;
    private CardView anm;

    private TextView club_name_miven;
    private  TextView club_text_miven;
    private  TextView club_teacher_miven;

    private TextView club_name_js;
    private  TextView club_text_js;
    private  TextView club_teacher_js;

    private TextView club_name_cpu;
    private  TextView club_text_cpu;
    private  TextView club_teacher_cpu;

    private TextView club_name_anm;
    private  TextView club_text_anm;
    private  TextView club_teacher_anm;

    private TextView club_name_mslr;
    private  TextView club_text_mslr;
    private  TextView club_teacher_mslr;

    private TextView club_name_msg;
    private  TextView club_text_msg;
    private  TextView club_teacher_msg;

    private TextView club_name_pp;
    private  TextView club_text_pp;
    private  TextView club_teacher_pp;

    private TextView club_name_omop;
    private  TextView club_text_omop;
    private  TextView club_teacher_omop;

    private TextView club_name_gm;
    private  TextView club_text_gm;
    private  TextView club_teacher_gm;

    private ImageView info;
    private TextView info_text;
    private TextView text1;
    private TextView text2;
    private TextView text3;
    private TextView text4;

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);


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

        info = (ImageView) findViewById(R.id.info);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPopupInfo();
            }
        });

        miven = (CardView) findViewById(R.id.miven);
        miven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPopupMiven();
            }
        });

        js = (CardView) findViewById(R.id.js);
        js.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPopupJS();
            }
        });

        omop = (CardView) findViewById(R.id.omop);
        omop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPopupOMOP();
            }
        });

        gm = (CardView) findViewById(R.id.gm);
        gm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPopupGM();
            }
        });

        pp = (CardView) findViewById(R.id.pp);
        pp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPopupPP();
            }
        });

        msg = (CardView) findViewById(R.id.msg);
        msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPopupMSG();
            }
        });

        anm = (CardView) findViewById(R.id.anm);
        anm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPopupANM();
            }
        });

        mslr = (CardView) findViewById(R.id.mslr);
        mslr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPopupMSLR();
            }
        });

        cpu = (CardView) findViewById(R.id.cpu);
        cpu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPopupCPU();
            }
        });

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

    public void createPopupInfo() {
        dialogBuilder = new AlertDialog.Builder(this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.info, null);
        info_text = (TextView) findViewById(R.id.info_text);
        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
        text3 = (TextView) findViewById(R.id.text3);
        text4 = (TextView) findViewById(R.id.text4);

        dialogBuilder.setView(contactPopupView);
        dialog = dialogBuilder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.show();
    }

    public void createPopupMiven() {
        dialogBuilder = new AlertDialog.Builder(this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.miven, null);
        club_name_miven = (TextView) findViewById(R.id.club_name_miven);
        club_text_miven = (TextView) findViewById(R.id.club_text_miven);
        club_teacher_miven = (TextView) findViewById(R.id.club_teacher_miven);

        dialogBuilder.setView(contactPopupView);
        dialog = dialogBuilder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.show();
    }

    public void createPopupANM() {
        dialogBuilder = new AlertDialog.Builder(this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.appnme, null);
        club_name_anm = (TextView) findViewById(R.id.club_name_anm);
        club_text_anm = (TextView) findViewById(R.id.club_text_anm);
        club_teacher_anm = (TextView) findViewById(R.id.club_teacher_anm);

        dialogBuilder.setView(contactPopupView);
        dialog = dialogBuilder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.show();
    }

    public void createPopupPP() {
        dialogBuilder = new AlertDialog.Builder(this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.pp, null);
        club_name_pp = (TextView) findViewById(R.id.club_name_pp);
        club_text_pp = (TextView) findViewById(R.id.club_text_pp);
        club_teacher_pp = (TextView) findViewById(R.id.club_teacher_pp);

        dialogBuilder.setView(contactPopupView);
        dialog = dialogBuilder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.show();
    }

    public void createPopupOMOP() {
        dialogBuilder = new AlertDialog.Builder(this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.omop, null);
        club_name_omop = (TextView) findViewById(R.id.club_name_omop);
        club_text_omop = (TextView) findViewById(R.id.club_text_omop);
        club_teacher_omop = (TextView) findViewById(R.id.club_teacher_omop);

        dialogBuilder.setView(contactPopupView);
        dialog = dialogBuilder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.show();
    }

    public void createPopupCPU() {
        dialogBuilder = new AlertDialog.Builder(this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.cpu, null);
        club_name_cpu = (TextView) findViewById(R.id.club_name_miven);
        club_text_cpu = (TextView) findViewById(R.id.club_text_miven);
        club_teacher_cpu = (TextView) findViewById(R.id.club_teacher_cpu);

        dialogBuilder.setView(contactPopupView);
        dialog = dialogBuilder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.show();
    }

    public void createPopupMSG() {
        dialogBuilder = new AlertDialog.Builder(this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.msg, null);
        club_name_msg = (TextView) findViewById(R.id.club_name_msg);
        club_text_msg = (TextView) findViewById(R.id.club_text_msg);
        club_teacher_msg = (TextView) findViewById(R.id.club_teacher_msg);

        dialogBuilder.setView(contactPopupView);
        dialog = dialogBuilder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.show();
    }

    public void createPopupMSLR() {
        dialogBuilder = new AlertDialog.Builder(this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.mslr, null);
        club_name_mslr = (TextView) findViewById(R.id.club_name_mslr);
        club_text_mslr = (TextView) findViewById(R.id.club_text_mslr);
        club_teacher_mslr = (TextView) findViewById(R.id.club_teacher_mslr);

        dialogBuilder.setView(contactPopupView);
        dialog = dialogBuilder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.show();
    }

    public void createPopupGM() {
        dialogBuilder = new AlertDialog.Builder(this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.gamemaker, null);
        club_name_gm = (TextView) findViewById(R.id.club_name_gm);
        club_text_gm = (TextView) findViewById(R.id.club_text_gm);
        club_teacher_gm = (TextView) findViewById(R.id.club_teacher_gm);

        dialogBuilder.setView(contactPopupView);
        dialog = dialogBuilder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.show();
    }

    public void createPopupJS() {
        dialogBuilder = new AlertDialog.Builder(this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.jsstudy, null);
        club_name_js = (TextView) findViewById(R.id.club_name_js);
        club_text_js = (TextView) findViewById(R.id.club_text_js);
        club_teacher_js = (TextView) findViewById(R.id.club_teacher_js);

        dialogBuilder.setView(contactPopupView);
        dialog = dialogBuilder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.show();
    }

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.community_text:
                    Intent intent1 = new Intent(ClubActivity.this, MainActivity.class);
                    startActivity(intent1);
                    break;
                case R.id.club_text:
                    Toast.makeText(ClubActivity.this, "현재 페이지 입니다.", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.officeRoom_text:
                    Intent intent3 = new Intent(ClubActivity.this, OfficeRoomAcitivity.class);
                    startActivity(intent3);
                    break;
                case R.id.FAQ_text:
                    Intent intent4 = new Intent(ClubActivity.this, FAQActivity.class);
                    startActivity(intent4);
                    break;
                case R.id.Mypage_text:
                    Intent intent5 = new Intent(ClubActivity.this, MypageActivity.class);
                    startActivity(intent5);
                    break;
            }
        }
    };
    @Override
    public void onBackPressed() {}
}
