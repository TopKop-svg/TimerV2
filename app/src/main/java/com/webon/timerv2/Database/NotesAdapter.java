package com.webon.timerv2.Database;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.webon.timerv2.Adapters.CurrentNoteSubtaskAdapter;
import com.webon.timerv2.Adapters.CurrentNoteSubtaskAdapterCount;
import com.webon.timerv2.Adapters.CurrentNoteSubtaskAdapterTime;
import com.webon.timerv2.Fragments.CurrentFragment;
import com.webon.timerv2.MainActivity;
import com.webon.timerv2.Notes.Note;
import com.webon.timerv2.Notes.SubNote;
import com.webon.timerv2.R;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NoteViewHolder>{
    private List<Note> notes = new ArrayList<>();
    private OnNoteClickListener noteClickListener;
    NoteDatabase noteDatabase;

    public interface OnNoteClickListener {
        void onNoteClick(Note note);
    }

    public NotesAdapter(NoteDatabase noteDatabase) {
        this.noteDatabase = noteDatabase;
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

        if (!note.getSubNotesList().isEmpty()){
            if (note.isTime()){
                CurrentNoteSubtaskAdapterTime currentNoteSubtaskAdapterTime = new CurrentNoteSubtaskAdapterTime(note.getSubNotesList());
                view.recyclerView.setAdapter(currentNoteSubtaskAdapterTime);
                LinearLayoutManager layoutManager = new LinearLayoutManager(new CurrentFragment().getRecyclerViewContext());
                view.recyclerView.setLayoutManager(layoutManager);
            } else {
                CurrentNoteSubtaskAdapterCount currentNoteSubtaskAdapterCount = new CurrentNoteSubtaskAdapterCount(note.getSubNotesList());
                view.recyclerView.setAdapter(currentNoteSubtaskAdapterCount);
                LinearLayoutManager layoutManager = new LinearLayoutManager(new CurrentFragment().getRecyclerViewContext());
                view.recyclerView.setLayoutManager(layoutManager);
                currentNoteSubtaskAdapterCount.setOnSubtaskClickListener(new CurrentNoteSubtaskAdapterCount.OnSubtaskClickListener() {
                    @Override
                    public void onSubtaskClick(SubNote subNote) {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                noteDatabase.notesDao().update(note);
                            }
                        }).start();
                    }
                });
            }
        }


        view.buttonHint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (note.isHint()) {
                    note.setHint(false);
                    view.recyclerView.setVisibility(View.VISIBLE);
                } else {
                    note.setHint(true);
                    view.recyclerView.setVisibility(View.GONE);
                }
            }
        });
        view.imageButtonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        noteDatabase.notesDao().remove(note.getId());
                    }
                });
                thread.start();
            }
        });

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
        private RecyclerView recyclerView;
        private ImageButton buttonHint; private ImageView imageButtonDelete, imageButtonDone;
        public NoteViewHolder(@NonNull View itemView, int viewType) {
            super(itemView);
            if (viewType == 0) {
                textView = itemView.findViewById(R.id.textViewTypeTask);
                recyclerView = itemView.findViewById(R.id.recyclerViewSubtaskNote);
                buttonHint = itemView.findViewById(R.id.buttonHint);
                imageButtonDelete = itemView.findViewById(R.id.right_view);
            }
            else {
                textView = itemView.findViewById(R.id.textViewTypeTask);
                recyclerView = itemView.findViewById(R.id.recyclerViewSubtaskNote);
                buttonHint = itemView.findViewById(R.id.buttonHint);
                imageButtonDelete = itemView.findViewById(R.id.right_view);
            }

        }
    }



}