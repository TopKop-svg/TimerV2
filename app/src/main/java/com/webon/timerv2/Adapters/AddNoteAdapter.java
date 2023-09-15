package com.webon.timerv2.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.webon.timerv2.Notes.SubNote;
import com.webon.timerv2.R;

import java.util.ArrayList;

public class AddNoteAdapter extends RecyclerView.Adapter<AddNoteAdapter.ViewHolder>{
    private ArrayList<SubNote> itemList;

    public AddNoteAdapter(ArrayList<SubNote> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subtask_add_note_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SubNote item = itemList.get(position);
        holder.editTextTitle.setText(item.getTitle());
        holder.editTextCount.setText(String.valueOf(item.getCount()));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        EditText editTextTitle, editTextCount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            editTextTitle = itemView.findViewById(R.id.editTextTitle);
            editTextCount = itemView.findViewById(R.id.editTextCount);
        }
    }
}
