package com.example.mirimiter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText editId = findViewById(R.id.editId);
        EditText editPw = findViewById(R.id.editPw);
        Button LoginButton = findViewById(R.id.LoginBtn);

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                String userid = editId.getText().toString();
                String userpw = editPw.getText().toString();

                DocumentReference docRef = db.collection("students").document(userid);
                docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            if (document.exists()) {
                                if(userid.equals(document.getString("id")) && userpw.equals(document.getString("pw"))){
                                    Toast.makeText(getApplicationContext(), "로그인 성공:D", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    startActivity(intent);
                                }else{
                                    Toast.makeText(getApplicationContext(), "로그인 실패:D", Toast.LENGTH_LONG).show();
                                    editId.setText("");
                                    editPw.setText("");
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "로그인 실패:D", Toast.LENGTH_LONG).show();
                                editId.setText("");
                                editPw.setText("");
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "로그인 실패:D", Toast.LENGTH_LONG).show();
                            editId.setText("");
                            editPw.setText("");
                        }
                    }
                });
            }
        });

        TextView SignUpLink = (TextView) findViewById(R.id.SignUpLink);
        SignUpLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
    }
}