package com.webon.timerv2.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.webon.timerv2.Notes.SubNote;
import com.webon.timerv2.R;

import java.util.ArrayList;

public class CurrentNoteSubtaskAdapter extends RecyclerView.Adapter<CurrentNoteSubtaskAdapter.ViewHolder>{
    private ArrayList<SubNote> itemList;

    public CurrentNoteSubtaskAdapter(ArrayList<SubNote> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public CurrentNoteSubtaskAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subtask_current_note_item_time, parent, false);
        return new CurrentNoteSubtaskAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CurrentNoteSubtaskAdapter.ViewHolder holder, int position) {
        SubNote item = itemList.get(position);
        holder.progressBar.setMax(10);

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ProgressBar progressBar;
        private Button button;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            progressBar = itemView.findViewById(R.id.progressBarSubtask);
            button = itemView.findViewById(R.id.buttonPlay);
        }
    }
}

