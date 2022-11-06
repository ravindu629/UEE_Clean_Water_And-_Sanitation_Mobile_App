package com.example.ueemobileapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SanitationPracticeRVAdapter extends RecyclerView.Adapter<SanitationPracticeRVAdapter.ViewHolder> {

    private ArrayList<SanitationPracticeRVModal> sanitationPracticeRVModalArrayList;
    private Context context;
    int lastPos = -1;
    private PracticeClickInterface practiceClickInterface;

    public SanitationPracticeRVAdapter(ArrayList<SanitationPracticeRVModal> sanitationPracticeRVModalArrayList, Context context, PracticeClickInterface practiceClickInterface) {
        this.sanitationPracticeRVModalArrayList = sanitationPracticeRVModalArrayList;
        this.context = context;
        this.practiceClickInterface = practiceClickInterface;
    }

    @NonNull
    @Override
    public SanitationPracticeRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.practice_rv_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SanitationPracticeRVAdapter.ViewHolder holder, int position) {
        SanitationPracticeRVModal sanitationPracticeRVModal = sanitationPracticeRVModalArrayList.get(position);
        holder.topicNameTV.setText(sanitationPracticeRVModal.getTopicName());
        holder.userNameTV.setText(sanitationPracticeRVModal.getUserName());
        Picasso.get().load(sanitationPracticeRVModal.getImgLink()).into(holder.practiceIV);
        setAnimation(holder.itemView, position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                practiceClickInterface.onPracticeClick(position);
            }
        });
    }

    private void setAnimation(View itemView, int position) {
        if(position > lastPos) {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            itemView.setAnimation(animation);
            lastPos = position;
        }
    }


    @Override
    public int getItemCount() {
        return sanitationPracticeRVModalArrayList.size();
    }

    public interface PracticeClickInterface{
        void onPracticeClick(int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView topicNameTV, userNameTV;
        private ImageView practiceIV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            topicNameTV = itemView.findViewById(R.id.idTVTopicName);
            userNameTV = itemView.findViewById(R.id.idTVNurseName);
            practiceIV = itemView.findViewById(R.id.idIVPractice);
        }
    }


}
