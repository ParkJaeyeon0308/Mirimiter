package com.example.mirimiter;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;

import org.w3c.dom.Comment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CommentActivity extends AppCompatActivity {
    private ImageButton back_main;
    private TextView commuText_view;
    private EditText inputCom;
    private Button pushCom;

    private List<CommentData> mdatas;
    private CommentAdapter mAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseFirestore mStore = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        commuText_view = findViewById(R.id.commuText_view);
        inputCom = findViewById(R.id.inputCom);
        recyclerView = (RecyclerView)findViewById(R.id.comment_recyc) ;
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        back_main =(ImageButton)findViewById(R.id.back_main);
        back_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommentActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        pushCom = findViewById(R.id.pushCom);
        pushCom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inputCom.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "댓글을 입력해주세요!", Toast.LENGTH_LONG).show();
                }else{
                    createNewComment();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        String now_cont = getIntent().getExtras().getString("DOC");

        FirebaseFirestore.getInstance().collection("post").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                if(document.get("documentID").toString().equals(now_cont)){
                                    commuText_view.setText(document.get("contents").toString());
                                }
                            }
                        } else {
                            Log.d("Error", "Error getting documents: ", task.getException());
                        }
                    }
                });

        mdatas = new ArrayList<>();
        mStore.collection("comment")
                .whereEqualTo("documentID", MainAdapter.docID)
                .orderBy("timestamp", Query.Direction.ASCENDING)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable @org.jetbrains.annotations.Nullable QuerySnapshot value, @Nullable @org.jetbrains.annotations.Nullable FirebaseFirestoreException error) {
                        if(value != null){
                            mdatas.clear();
                            for(DocumentSnapshot snap: value.getDocuments()){
                                Map<String, Object> shot = snap.getData();
                                String documentId = String.valueOf(shot.get("documentID"));
                                String comments = String.valueOf(shot.get("comment"));
                                CommentData data = new CommentData(documentId, comments);
                                mdatas.add(data);
                            }
                            mAdapter = new CommentAdapter(mdatas);
                            recyclerView.setAdapter(mAdapter);
                        }
                    }
                });
    }

    private void createNewComment() {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseFirestore mStore = FirebaseFirestore.getInstance();

        if(mAuth.getCurrentUser() != null){
            String commId = mStore.collection("comment").document().getId();
            Map<String, Object> data = new HashMap<>();
            data.put("documentID", MainAdapter.docID);
            data.put("comment", inputCom.getText().toString());
            data.put("timestamp", FieldValue.serverTimestamp());
            mStore.collection("comment").document(commId).set(data, SetOptions.merge());
        }

        inputCom.setText("");
    }
}