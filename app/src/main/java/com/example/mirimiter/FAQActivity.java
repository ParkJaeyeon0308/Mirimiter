package com.example.mirimiter;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class FAQActivity extends AppCompatActivity {
    ListView listView;
    OtherMSGAdapter otherMSGAdapter;

    private ImageView back_btn;
    private Button chat1;
    private Button chat2;
    private Button chat3;
    private Button chat4;
    private Button chat5;
    private Button chat6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        listView = findViewById(R.id.chat_listview);
        otherMSGAdapter = new OtherMSGAdapter();

        listView.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);

        //만들어둔 챗봇 선택지 정의해놨음! 사용하셈
        chat1 = (Button) findViewById(R.id.chat1);
        chat2 = (Button) findViewById(R.id.chat2);
        chat3 = (Button) findViewById(R.id.chat3);
        chat4 = (Button) findViewById(R.id.chat4);
        chat5 = (Button) findViewById(R.id.chat5);
        chat6 = (Button) findViewById(R.id.chat6);

        chat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otherMSGAdapter.addOtherMSG(new OtherMSG("★학교 행사★\n5월    과학탐구대회 / 창업아이템 경진대회 / 비즈쿨 마켓 / 체육대회\n" +
                        "7월    비즈쿨 경제글쓰기대회 / 창의아이디어경진대회 교내 예선 / 선도부 조직 / 정부회장 선거\n" +
                        "8월    학생회 조직\n" +
                        "10월  S/W경진대회 / CA발표회"));
                listView.setAdapter(otherMSGAdapter);
                listView.setSelection(otherMSGAdapter.getCount() - 1);
            }
        });

        chat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otherMSGAdapter.addOtherMSG(new OtherMSG("★동아리★\n수요일 석식 후에 실시하는 선택적 전공동아리\n" +
                        "  -> 자세한 사항은 동아리 메뉴 방문!\n" +
                        "수요일 6,7교시에 실시하는 필수적 일반동아리(CA)"));
                listView.setAdapter(otherMSGAdapter);
                listView.setSelection(otherMSGAdapter.getCount() - 1);
            }
        });

        chat3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otherMSGAdapter.addOtherMSG(new OtherMSG("★특별실 위치★\n신관\n" +
                        "1층 학생쉼터(학생회실) / 컨설팅룸 / 아트스튜디오 / 음악감상실\n" +
                        "2층 CO-WORKING SPACE / 가사실습실\n" +
                        "3층 영어카페 / 예절교육실\n" +
                        "\n" +
                        "본관\n" +
                        "1층 도서관\n" +
                        "2층 수학교실 / 영어교실 / 과학실 / 진로체험실(보건교육실) / 상담실\n" +
                        "3층 NCS응용프로그래밍개발실습실01~05 / APP세미나실 / 소프트웨어허브실 / Business Center(교내기업실) / 방송실\n" +
                        "4층 NCS응용프로그래밍개발실습실06 / 광고콘텐츠제작실습실01 / NCS스마트문화앱콘텐츠제작실습실01 / 무한상상Cafe"));
                listView.setAdapter(otherMSGAdapter);
                listView.setSelection(otherMSGAdapter.getCount() - 1);
            }
        });

        chat4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otherMSGAdapter.addOtherMSG(new OtherMSG("★교무실 위치★\n본관\n" +
                        "2층 교장실 / 교사연구실1~3 / 여교사휴게실 / 남교사휴게실 / 행정실 / 보건실\n" +
                        "3층 교사연구실4~5(취업지원센터) / 소프트웨어지원센터(조교실)\n" +
                        "  -> 자세한 사항은 교무실 메뉴 방문!"));
                listView.setAdapter(otherMSGAdapter);
                listView.setSelection(otherMSGAdapter.getCount() - 1);
            }
        });

        chat5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otherMSGAdapter.addOtherMSG(new OtherMSG("★글로벌 현장학습★\n1학년 교육부 ASEAN 교육협력 사업 및 교육청 맞춤형국제화교육사업(태국)\n" +
                        "2학년 글로벌 인턴십(학교 주관)(일본)\n" +
                        "3학년 교육부 글로벌 현장학습(사업단 선정시 추진)(영국)"));
                listView.setAdapter(otherMSGAdapter);
                listView.setSelection(otherMSGAdapter.getCount() - 1);
            }
        });


        chat6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otherMSGAdapter.addOtherMSG(new OtherMSG("★와이파이 IP★\nIP주소 : 10.96.12A.B\n" +
                        "  A : 현재 자신의 학년\n" +
                        "  B : 부여받은 번호(홀수 : 컴퓨터, 짝수 : 핸드폰)\n" +
                        "서브넷 마스크 : 255.255.248.0\n" +
                        "기본 게이트웨이 : 10.96.120.254\n" +
                        "기본 설정 DNS 서버 : 168.126.63.1\n" +
                        "보조 DNS 서버 : 8.8.8.8"));
                listView.setAdapter(otherMSGAdapter);
                listView.setSelection(otherMSGAdapter.getCount() - 1);
            }
        });


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

