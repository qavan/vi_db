package com.qavan.vi_db.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.qavan.vi_db.MainActivity;
import com.qavan.vi_db.R;
import com.qavan.vi_db.Task;

import java.util.List;


public class TaskAdapter extends RecyclerView.Adapter {
    private List<Task> mTasksDataset;
    private LayoutInflater mInflater;
    private Activity mActivity;

    public TaskAdapter(List<Task> tasks, LayoutInflater inflater, Activity activity) {
        this.mTasksDataset = tasks;
        this.mInflater = inflater;
        this.mActivity = activity;
    }

    public class TaskHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private Task task;

        private TaskHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Task task = mTasksDataset.get(getLayoutPosition());
            Long taskId = task.getId();
            ((MainActivity) mActivity).getmTaskDao().deleteByKey(taskId);
            ((MainActivity) mActivity).updateTasks();
        }

        public void bindTask(Task cat) {
            this.task = cat;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new TaskHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Task task = mTasksDataset.get(position);
//        holder.bindTask(task);
    }

    @Override
    public int getItemCount() {
        return mTasksDataset.size();
    }

    public void setTasks(List<Task> tasks) {
        mTasksDataset = tasks;
        notifyDataSetChanged();
    }
}


