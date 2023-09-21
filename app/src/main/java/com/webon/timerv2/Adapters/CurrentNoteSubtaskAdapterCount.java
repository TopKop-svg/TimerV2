package com.webon.timerv2.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.webon.timerv2.Notes.SubNote;
import com.webon.timerv2.R;

import java.util.ArrayList;

public class CurrentNoteSubtaskAdapterCount  extends RecyclerView.Adapter<CurrentNoteSubtaskAdapterCount.ViewHolder>{
    private ArrayList<SubNote> itemList;
    private OnSubtaskClickListener onSubtaskClickListener;

    public CurrentNoteSubtaskAdapterCount(ArrayList<SubNote> itemList) {
        this.itemList = itemList;
    }

    public interface OnSubtaskClickListener {
        void onSubtaskClick(SubNote subNote);
    }

    public void setOnSubtaskClickListener(OnSubtaskClickListener onSubtaskClickListener) {
        this.onSubtaskClickListener = onSubtaskClickListener;
    }

    @NonNull
    @Override
    public CurrentNoteSubtaskAdapterCount.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subtask_current_note_item_count, parent, false);
        return new CurrentNoteSubtaskAdapterCount.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CurrentNoteSubtaskAdapterCount.ViewHolder holder, int position) {
        SubNote item = itemList.get(position);
        holder.progressBar.setMax(10);
        holder.textView.setText(item.getCount() + "/" + item.getAimCount());
        holder.progressBar.setProgress(item.getCount());
        holder.buttonLess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item.setCount(item.getCount()-1);
                holder.textView.setText(item.getCount()+"/10");
                holder.progressBar.setProgress(item.getCount());
                onSubtaskClickListener.onSubtaskClick(item);

            }
        });

        holder.buttonMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item.setCount(item.getCount()+1);
                holder.textView.setText(item.getCount()+"/10");
                holder.progressBar.setProgress(item.getCount());
                onSubtaskClickListener.onSubtaskClick(item);
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ProgressBar progressBar;
        private ImageButton buttonLess, buttonMore;
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            progressBar = itemView.findViewById(R.id.progressBarSubtask);
            buttonLess = itemView.findViewById(R.id.buttonLess);
            buttonMore = itemView.findViewById(R.id.buttonMore);
            textView = itemView.findViewById(R.id.textViewCurrentCountSubtask);

        }
    }
}
