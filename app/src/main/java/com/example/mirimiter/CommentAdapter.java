package com.example.mirimiter;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CustoViewHolder> {

    private List<CommentData> datas;

    public CommentAdapter(List<CommentData> datas) {
        this.datas = datas;
    }

    @NonNull
    @NotNull
    @Override
    //처음 만들어지고나서 생명주기
    public CommentAdapter.CustoViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new CommentAdapter.CustoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.comment, parent,false));
    }

    //추가될때 생명주기
    @Override
    public void onBindViewHolder(@NonNull @NotNull CommentAdapter.CustoViewHolder holder, int position) {
        CommentData data = datas.get(position);
        holder.commentView.setText(data.getComment());
        holder.itemView.setTag(position);
    }
    @Override
    public int getItemCount() {
        return (null!= datas ? datas.size():0);
    }


    public class CustoViewHolder extends RecyclerView.ViewHolder {

        public TextView commentView;

        public CustoViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            this.commentView = (TextView) itemView.findViewById(R.id.writeComment);
        }
    }
}
