package com.example.studioapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class MyMovieAdapter extends RecyclerView.Adapter<MyMovieAdapter.ViewHolder> {

    MyMovieData[] myMovieData;
    Context context;

    public MyMovieAdapter(MyMovieData[] myMovieData, MainActivity activity) {
        this.myMovieData = myMovieData;
        this.context = activity;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.video_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final MyMovieData myMovieDataList = myMovieData[position];
//        holder.videoImage.setImageResource(myMovieDataList.getMovieImage());
        holder.textViewDate.setText(myMovieDataList.getVideoDate());
        holder.textViewTime.setText(myMovieDataList.getVideoTime());
        holder.textViewLocation.setText(myMovieDataList.getVideoLocation());
        holder.textViewHeartRate.setText(myMovieDataList.getVideoHeartRate());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"GG",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return myMovieData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
//        ImageView videoImage;
        TextView textViewDate;
        TextView textViewTime;
        TextView textViewLocation;
        TextView textViewHeartRate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            videoImage = itemView.findViewById(R.id.imageview);
            textViewDate = itemView.findViewById(R.id.dateview);
            textViewTime = itemView.findViewById(R.id.timeview);
            textViewLocation = itemView.findViewById(R.id.locationview);
            textViewHeartRate = itemView.findViewById(R.id.heartview);
        }
    }
}
