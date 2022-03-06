package com.aimsmart.app.assignmentqit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.gms.common.data.DataHolder;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerviewHolder> {

    Context context;
    private List<data> mData;
    public RecyclerAdapter(Context context,List<data> data) {
        this.context = context;
        this.mData = data;
    }

    @NonNull
    @Override
    public RecyclerviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.customrec, parent, false);
        return new RecyclerviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerviewHolder holder, int position) {
          holder.time.setText(mData.get(position).getTime().substring(0,10));
          holder.sourse.setText("techcrunch");
          holder.title.setText(mData.get(position).getTitle());
        holder.description.setText(mData.get(position).getDescription().substring(0,50));
        Glide.with(context).load(mData.get(position).getUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void updateList(List<data> temp) {
        this.mData = temp;
    }

    public class RecyclerviewHolder extends RecyclerView.ViewHolder{
        TextView time,sourse,title,description;
        ImageView imageView;
        public RecyclerviewHolder(@NonNull View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.time);
            sourse = itemView.findViewById(R.id.source);
            title = itemView.findViewById(R.id.Title);
            description = itemView.findViewById(R.id.Description);
            imageView = itemView.findViewById(R.id.imagecustom);
        }
    }
}
