package com.webon.timerv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.webon.timerv2.Database.NoteDatabase;
import com.webon.timerv2.Fragments.CurrentFragment;
import com.webon.timerv2.Fragments.HistoryFragment;
import com.webon.timerv2.Fragments.OptionFragment;
import com.webon.timerv2.MVVM.MainViewModel;
import com.webon.timerv2.Notes.Note;

public class MainActivity extends AppCompatActivity {
    NoteDatabase noteDatabase;

    private Button buttonFragmentCurrent, buttonFragmentUser, buttonFragmentHistory;
    public static TextView textViewGold;
    static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        initViews();
        /*noteDatabase = NoteDatabase.getInstance(context);
        textViewGold.setText(noteDatabase.notesDao().getNotes().getValue().size());*/

        buttonFragmentCurrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainViewModel.getInstance().onClickCurrent(MainActivity.this);
            }
        });

        buttonFragmentHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainViewModel.getInstance().onClickHistory(MainActivity.this);
            }
        });
        buttonFragmentUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainViewModel.getInstance().onClickUser(MainActivity.this);
            }
        });
    }

    private void initViews() {
        buttonFragmentCurrent = findViewById(R.id.buttonFragmentCurrent);
        buttonFragmentHistory = findViewById(R.id.buttonFragmentHistory);
        buttonFragmentUser = findViewById(R.id.buttonFragmentUser);
        textViewGold = findViewById(R.id.textViewGold);
    }
}