package com.example.mirimiter;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

import petrov.kristiyan.colorpicker.ColorPicker;

public class MypageActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private View drawerView;
    private TextView community_menu;
    private TextView club_menu;
    private TextView officeroom_menu;
    private TextView faq_menu;
    private TextView mypage_menu;
    private TextView chat_menu;
    private TextView nickname;
    private Button colorChangebtn;
    private Button accountChangebtn;
    private Button logout_btn;
    private Button killAccount_btn;


    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        nickname = (TextView)findViewById(R.id.nickName);
        colorChangebtn = (Button)findViewById(R.id.colorChange_btn);
        colorChangebtn.setOnClickListener(color);
        accountChangebtn = (Button)findViewById(R.id.AccountChange_btn);
        community_menu = (TextView) findViewById(R.id.community_text);
        community_menu.setOnClickListener(pageSwitch);
        club_menu = (TextView) findViewById(R.id.club_text);
        club_menu.setOnClickListener(pageSwitch);
        officeroom_menu = (TextView) findViewById(R.id.officeRoom_text);
        officeroom_menu.setOnClickListener(pageSwitch);
        faq_menu = (TextView) findViewById(R.id.FAQ_text);
        faq_menu.setOnClickListener(pageSwitch);
        mypage_menu = (TextView) findViewById(R.id.Mypage_text);
        mypage_menu.setOnClickListener(pageSwitch);

        logout_btn = findViewById(R.id.Logout_btn);
        killAccount_btn = findViewById(R.id.killAccount_btn);

        drawerLayout = (DrawerLayout) findViewById(R.id.draw_layout);
        drawerView = (View) findViewById(R.id.drawer);

        firebaseAuth = FirebaseAuth.getInstance();

        accountChangebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(MypageActivity.this, AccountSettingActivity.class);
                startActivity(intent4);
            }
        });

        logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                Intent intent = new Intent(MypageActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        
        killAccount_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.getCurrentUser().delete();

                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String email = "";
                if(user!=null){
                    for (UserInfo profile : user.getProviderData()) {
                        email = profile.getEmail();
                    }
                }
                String[] userid = email.split("@");

                FirebaseFirestore db = FirebaseFirestore.getInstance();
                db.collection("students").document(userid[0])
                        .delete()
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(getApplicationContext(), "회원탈퇴 완료:D", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(MypageActivity.this, LoginActivity.class);
                                startActivity(intent);
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getApplicationContext(), "회원탈퇴 실패:D", Toast.LENGTH_LONG).show();
                            }
                        });
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
    View.OnClickListener pageSwitch = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.community_text:
                    Intent intent1 = new Intent(MypageActivity.this, MainActivity.class);
                    startActivity(intent1);
                    break;
                case R.id.club_text:
                    Intent intent3 = new Intent(MypageActivity.this, ClubActivity.class);
                    startActivity(intent3);
                    break;
                case R.id.officeRoom_text:
                    Intent intent4 = new Intent(MypageActivity.this, OfficeRoomAcitivity.class);
                    startActivity(intent4);
                    break;
                case R.id.FAQ_text:
                    Intent intent5 = new Intent(MypageActivity.this, FAQActivity.class);
                    startActivity(intent5);
                    break;
                case R.id.Mypage_text:
                    Toast.makeText(MypageActivity.this, "현재 페이지 입니다.", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    View.OnClickListener color = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            openColorPicker();
        }
    };

    public void openColorPicker() {
        final ColorPicker colorPicker = new ColorPicker(this);  // ColorPicker 객체 생성
        ArrayList<String> colors = new ArrayList<>();  // Color 넣어줄 list

        colors.add("#ffab91");
        colors.add("#F48FB1");
        colors.add("#ce93d8");
        colors.add("#b39ddb");
        colors.add("#9fa8da");
        colors.add("#90caf9");
        colors.add("#81d4fa");
        colors.add("#80deea");
        colors.add("#80cbc4");
        colors.add("#c5e1a5");
        colors.add("#e6ee9c");
        colors.add("#fff59d");
        colors.add("#ffe082");
        colors.add("#ffcc80");
        colors.add("#bcaaa4");

        colorPicker.setColors(colors)  // 만들어둔 list 적용
                .setColumns(5)  // 5열로 설정
                .setRoundColorButton(true)  // 원형 버튼으로 설정
                .setOnChooseColorListener(new ColorPicker.OnChooseColorListener() {
                    @Override
                    public void onChooseColor(int position, int color) {
                        nickname.setTextColor(color);  // OK 버튼 클릭 시 이벤트
                    }

                    @Override
                    public void onCancel() {
                        // Cancel 버튼 클릭 시 이벤트
                    }
                }).show();  // dialog 생성
    }

}

