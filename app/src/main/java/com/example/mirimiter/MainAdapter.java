package com.example.mirimiter;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.CustoViewHolder> {

    private List<CommunityData> datas;

    public MainAdapter(List<CommunityData> datas) {
        this.datas = datas;
    }
    public static String docID = "";

    @NonNull
    @NotNull
    @Override
    //처음 만들어지고나서 생명주기
    public CustoViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new CustoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_comunity, parent,false));
    }

    //추가될때 생명주기
    @Override
    public void onBindViewHolder(@NonNull @NotNull MainAdapter.CustoViewHolder holder, int position) {
        CommunityData data = datas.get(position);
        holder.content.setText(data.getContent());

        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.content.getContext(), CommentActivity.class);
                ContextCompat.startActivity(holder.itemView.getContext(),intent, null);
                docID = data.getDocumentId();
            }
        });

        holder.comment_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.content.getContext(), CommentActivity.class);
                ContextCompat.startActivity(holder.itemView.getContext(),intent, null);
                docID = data.getDocumentId();
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                remove(holder.getAdapterPosition());
                return true;
            }
        });
    }
    @Override
    public int getItemCount() {
        return (null!= datas ? datas.size():0);
        //추가버튼을 누르면 하나씩 추가되는건 따로 구현하는거
        //
    }

    public void remove(int position){
        try{
            datas.remove(position);
            notifyItemRemoved(position);
            //새로고침 리스트 뷰를 지우고 새로고침을 해야 add, remove, modify가 잘됌
        }catch (IndexOutOfBoundsException ex){
            ex.printStackTrace();
        }
    }

    public class CustoViewHolder extends RecyclerView.ViewHolder {

        public Button comment_btn;
        protected TextView content;
        //        protected EditText comment;
//12분 부터 보기
        public CustoViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            this.content = (TextView) itemView.findViewById(R.id.content);
            this.comment_btn = itemView.findViewById(R.id.comment_btn);
//            this.comment = (EditText) itemView.findViewById(R.id.comment);
        }
    }
}
