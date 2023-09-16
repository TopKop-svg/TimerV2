package com.webon.timerv2.Database;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.webon.timerv2.Notes.Note;
import com.webon.timerv2.R;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NoteViewHolder>{
    private List<Note> notes = new ArrayList<>();
    private OnNoteClickListener noteClickListener;

    public interface OnNoteClickListener {
        void onNoteClick(Note note);
    }


    public void setOnNoteClickListener(OnNoteClickListener onNoteClickListener) {
        this.noteClickListener = onNoteClickListener;
    }


    public List<Note> getNotes() {
        return new ArrayList<>(notes);
    }


    @SuppressLint("NotifyDataSetChanged")
    public void setNotes(List<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }



    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(NoteViewHolder view, int position) {
        Note note = notes.get(position);
        view.textView.setText(note.getTitle());
        if (note.isTime()) {
            /*view.buttonsTimer.OnClickButton(note, noteClickListener);
            view.buttonsTimer.NoteUpdateDate(note);*/


        } else {
            /*view.buttonsCount.OnClickButton(note, noteClickListener);
            view.buttonsCount.NoteUpdateDate(note);*/
            //view.buttonShowInfo.OnClickButtonShow(note);

        }

    }

    @Override
    public int getItemViewType(int position) {
        Note note = notes.get(position);
        if (note.isTime()) {
            return 0; // тип представления для заметки с временем
        } else {
            return 1; // тип представления для заметки со счетчиком
        }
    }

    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == 0) {
            view = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.note_time_item,
                    parent,
                    false);

        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.note_count_item,
                    parent,
                    false);
        }
        return new NoteViewHolder(view, viewType);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class NoteViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        public NoteViewHolder(@NonNull View itemView, int viewType) {
            super(itemView);
            textView = itemView.findViewById(R.id.textViewTypeTask);


        }
    }



}