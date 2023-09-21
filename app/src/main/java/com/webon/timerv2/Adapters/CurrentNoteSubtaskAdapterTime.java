package com.webon.timerv2.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.webon.timerv2.Notes.SubNote;
import com.webon.timerv2.R;

import java.util.ArrayList;

public class CurrentNoteSubtaskAdapterTime  extends RecyclerView.Adapter<CurrentNoteSubtaskAdapterTime.ViewHolder>{
    private ArrayList<SubNote> itemList;

    public CurrentNoteSubtaskAdapterTime(ArrayList<SubNote> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public CurrentNoteSubtaskAdapterTime.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subtask_current_note_item_time, parent, false);
        return new CurrentNoteSubtaskAdapterTime.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CurrentNoteSubtaskAdapterTime.ViewHolder holder, int position) {
        SubNote item = itemList.get(position);
        holder.progressBar.setMax(10);
        holder.progressBar.setProgress(item.getCount());

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ProgressBar progressBar;
        private ImageButton button;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            progressBar = itemView.findViewById(R.id.progressBarSubtask);
            button = itemView.findViewById(R.id.imageButtonPlay);
        }
    }
}
