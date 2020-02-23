package com.qavan.vi_db.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.qavan.vi_db.R;
import com.qavan.vi_db.Task;

import java.util.ArrayList;
import java.util.List;


public class TaskAdapter extends RecyclerView.Adapter {
    private List<Task> mTasksDataset = new ArrayList<>();
    private LayoutInflater mInflater;

    public TaskAdapter(List<Task> tasks, LayoutInflater inflater) {
        this.mTasksDataset = tasks;
        this.mInflater = inflater;
    }

    public class TaskHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView tvStatus;
        public TextView tvTaskTitle;
        public TextView tvAddress;
        public TextView tvExpireDate;
        public TextView tvClient;

        public TaskHolder(View itemView) {
            super(itemView);
            tvStatus = itemView.findViewById(R.id.idListItemStatus);
            tvTaskTitle = itemView.findViewById(R.id.idListItemTitle);
            tvAddress = itemView.findViewById(R.id.idListItemAddress);
            tvExpireDate = itemView.findViewById(R.id.idListItemExpireDate);
            tvClient = itemView.findViewById(R.id.idListItemClient);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mTasksDataset.remove(getLayoutPosition());
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_route, parent, false);
        return new TaskHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mTasksDataset.size();
    }
}


