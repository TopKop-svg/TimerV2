package com.webon.timerv2.Fragments;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.webon.timerv2.AddNoteActivity;
import com.webon.timerv2.R;

public class CurrentFragment extends Fragment {
    private Button buttonAddNote;

    private void initViews(View view) {
        buttonAddNote = view.findViewById(R.id.buttonAddNote);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_current, container, false);
        initViews(rootView);
        onClickButtonAdd();

        return rootView;
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
}