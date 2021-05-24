package com.example.mirimiter;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.jetbrains.annotations.NotNull;

public class AccountSettingActivity extends AppCompatActivity {

    private EditText originalPass;
    private EditText newPass1;
    private EditText newPass2;

    private Button settingDone;
    private Button pwChk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountsetting);

        settingDone = (Button)findViewById(R.id.settingDone_btn);
        pwChk = findViewById(R.id.pwChkBtn);
        originalPass = findViewById(R.id.originalPass);
        newPass1 = findViewById(R.id.newPass);
        newPass2 = findViewById(R.id.newPassCheck);

        final boolean[] pcnt = {false};

        pwChk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(newPass1.getText().toString().length() <= 0){
                    Toast.makeText(getApplicationContext(), "비밀번호를 입력해주세요:D", Toast.LENGTH_LONG).show();
                }else if(newPass1.getText().toString().equals(newPass2.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "재확인 완료:D", Toast.LENGTH_LONG).show();
                    pcnt[0] = true;
                }else{
                    Toast.makeText(getApplicationContext(), "비밀번호를 다시 입력해주세요:D", Toast.LENGTH_LONG).show();
                    newPass2.setText("");
                }
            }
        });

        settingDone.setOnClickListener(new View.OnClickListener() {
            int cnt = 0;
            @Override
            public void onClick(View v) {
                if(originalPass.getText().toString().length() <= 0){
                    Toast.makeText(getApplicationContext(), "기존 비밀번호를 입력해주세요:D", Toast.LENGTH_LONG).show();
                } else if(!pcnt[0]){
                    Toast.makeText(getApplicationContext(), "비밀번호를 재확인해주세요:D", Toast.LENGTH_LONG).show();
                }else{
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                    Task<Void> voidTask = user.updatePassword(newPass2.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        cnt += 1;
                                    }
                                }
                            });

                    String email = "";
                    if(user!=null){
                        for (UserInfo profile : user.getProviderData()) {
                            email = profile.getEmail();
                        }
                    }
                    String[] userid = email.split("@");

                    FirebaseFirestore db = FirebaseFirestore.getInstance();
                    DocumentReference change_pw = db.collection("students").document(userid[0]);

                    change_pw
                            .update("pw", newPass2.getText().toString())
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    cnt += 1;
                                }
                            });

                    if(cnt == 2){
                        Toast.makeText(getApplicationContext(), "비밀번호 변경 완료:D", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(AccountSettingActivity.this, MypageActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(), "비밀번호 변경 실패:D", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }
}
