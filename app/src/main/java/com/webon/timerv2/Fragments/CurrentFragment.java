package com.webon.timerv2.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webon.timerv2.AddNoteActivity;
import com.webon.timerv2.Database.NoteDatabase;
import com.webon.timerv2.Database.NotesAdapter;
import com.webon.timerv2.Notes.Note;
import com.webon.timerv2.R;

import java.util.List;

public class CurrentFragment extends Fragment {
    private static RecyclerView recyclerView;
    private NoteDatabase noteDatabase;
    private NotesAdapter notesAdapter;
    private Button buttonAddNote;

    private void initViews(View view) {
        buttonAddNote = view.findViewById(R.id.buttonAddNote);
        recyclerView = view.findViewById(R.id.recyclerViewNotes);
        noteDatabase = NoteDatabase.getInstance(getContext());
        notesAdapter = new NotesAdapter(noteDatabase);

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_current, container, false);

        Context context = getContext();

        initViews(rootView);
        initAdapterNote();
        onClickButtonAdd();
        setNotesAdapter();

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);

        return rootView;
    }
    public Context getRecyclerViewContext() {
        return recyclerView.getContext();
    }

    private void onClickButtonAdd() {
        buttonAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(requireActivity(), AddNoteActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initAdapterNote() {
        notesAdapter.setOnNoteClickListener(new NotesAdapter.OnNoteClickListener() {
            @Override
            public void onNoteClick(Note note) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        noteDatabase.notesDao().update(note);
                    }
                }).start();

            }
        });
    }

    private void setNotesAdapter() {
        recyclerView.setAdapter(notesAdapter);
        noteDatabase.notesDao().getNotes().observe(getViewLifecycleOwner(), new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                notesAdapter.setNotes(notes);

            }
        });
    }
}