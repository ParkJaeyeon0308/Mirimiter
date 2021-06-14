package com.example.mirimiter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import petrov.kristiyan.colorpicker.CustomDialog;


public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private View drawerView;
    private TextView community_menu;
    private TextView club_menu;
    private TextView officeroom_menu;
    private TextView faq_menu;
    private TextView mypage_menu;
    private Button comment_btn;

    private ArrayList<CommunityData> arrayList;
    private MainAdapter mainAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private ImageButton plus_btn;

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private TextView nickView, photoGuide;
    private Button postUpload_btn,cancel_btn;
    private CircleImageView imageWho;
    private EditText writePost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plus_btn = (ImageButton)findViewById(R.id.plus_btn);
        plus_btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                createNewContactDialog();
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

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView) ;
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        arrayList = new ArrayList<>();

        mainAdapter = new MainAdapter(arrayList);
        recyclerView.setAdapter(mainAdapter);




        //추가 버튼누르면 나오게 하는 거 아직 팝업창을 만들지 않았음 23:23초
        //https://www.youtube.com/watch?v=kNq9w1_nhL4&t=1s   참고

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
    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.community_text:
                    Toast.makeText(MainActivity.this, "현재 페이지 입니다.", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.club_text:
                    Intent intent2 = new Intent(MainActivity.this, ClubActivity.class);
                    startActivity(intent2);
                    break;
                case R.id.officeRoom_text:
                    Intent intent3 = new Intent(MainActivity.this, OfficeRoomAcitivity.class);
                    startActivity(intent3);
                    break;
                case R.id.FAQ_text:
                    Intent intent4 = new Intent(MainActivity.this, FAQActivity.class);
                    startActivity(intent4);
                    break;
                case R.id.Mypage_text:
                    Intent intent5 = new Intent(MainActivity.this, MypageActivity.class);
                    startActivity(intent5);
                    break;
            }
        }
    };
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

    public  void createNewContactDialog(){
        dialogBuilder = new AlertDialog.Builder(this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.activity_uploadpopup, null);
        nickView = (TextView) contactPopupView.findViewById(R.id.nickView);
        postUpload_btn = (Button) contactPopupView.findViewById(R.id.postUpload_btn);
        imageWho = (CircleImageView) contactPopupView.findViewById(R.id.imageWho);
        cancel_btn = (Button) contactPopupView.findViewById(R.id.cancel_btn);
        writePost = (EditText) contactPopupView.findViewById(R.id.writePost);

        dialogBuilder.setView(contactPopupView);
        dialog = dialogBuilder.create();
        dialog.show();

        postUpload_btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        //여기서 리사이클러뷰로 데이터 전송!
            CommunityData mainData = new CommunityData("헤헤");
            arrayList.add(mainData);
            mainAdapter.notifyDataSetChanged();
        }

    });
        cancel_btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dialog.dismiss();
        }
    });
    }
}
