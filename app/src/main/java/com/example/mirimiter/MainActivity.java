package com.example.mirimiter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private EditText search_cont;

    private List<CommunityData> mdatas, filteredList;
    private MainAdapter mAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private ImageButton plus_btn;

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private TextView nickView, photoGuide;
    private Button postUpload_btn,cancel_btn;
    private CircleImageView imageWho;
    private EditText writePost;

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseFirestore mStore = FirebaseFirestore.getInstance();


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

        search_cont = findViewById(R.id.search_cont);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView) ;
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        filteredList = new ArrayList<>();


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

        search_cont.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                String searchText = search_cont.getText().toString();
                searchFilter(searchText);

            }
        });
    }

    private void searchFilter(String searchText) {
        filteredList.clear();

        for (int i = 0; i < mdatas.size(); i++) {
            if (mdatas.get(i).getContent().toLowerCase().contains(searchText.toLowerCase())) {
                filteredList.add(mdatas.get(i));
            }
        }

        mAdapter.filterList(filteredList);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mdatas = new ArrayList<>();
        mStore.collection("post")
                .orderBy("timestamp", Query.Direction.DESCENDING)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable @org.jetbrains.annotations.Nullable QuerySnapshot value, @Nullable @org.jetbrains.annotations.Nullable FirebaseFirestoreException error) {
                        if(value != null){
                            mdatas.clear();
                            for(DocumentSnapshot snap: value.getDocuments()){
                                Map<String, Object> shot = snap.getData();
                                String documentId = String.valueOf(shot.get("documentID"));
                                String contents = String.valueOf(shot.get("contents"));
                                CommunityData data = new CommunityData(documentId, contents);
                                mdatas.add(data);
                            }
                            mAdapter = new MainAdapter(mdatas);
                            recyclerView.setAdapter(mAdapter);
                        }
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

    public void createNewContactDialog(){
        dialogBuilder = new AlertDialog.Builder(this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.activity_uploadpopup, null);
        nickView = (TextView) contactPopupView.findViewById(R.id.nickView);
        postUpload_btn = (Button) contactPopupView.findViewById(R.id.postUpload_btn);
        imageWho = (CircleImageView) contactPopupView.findViewById(R.id.imageWho);
        cancel_btn = (Button) contactPopupView.findViewById(R.id.cancel_btn);
        writePost = (EditText) contactPopupView.findViewById(R.id.writePost);

        dialogBuilder.setView(contactPopupView);
        dialog = dialogBuilder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.show();

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseFirestore mStore = FirebaseFirestore.getInstance();

        postUpload_btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(mAuth.getCurrentUser() != null){
                String postId = mStore.collection("post").document().getId();
                Map<String, Object> data = new HashMap<>();
                data.put("documentID", postId);
                data.put("contents", writePost.getText().toString());
                data.put("timestamp", FieldValue.serverTimestamp());
                mStore.collection("post").document(postId).set(data, SetOptions.merge());
            }

        //여기서 리사이클러뷰로 데이터 전송!
//            CommunityData mainData = new CommunityData();
//            mdatas.add(mainData);
//            mAdapter.notifyDataSetChanged();
            dialog.dismiss();
        }

    });
        cancel_btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dialog.dismiss();
        }
    });
    }
    @Override
    public void onBackPressed() {}
}
