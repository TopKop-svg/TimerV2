package com.webon.timerv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.Switch;

import com.webon.timerv2.Adapters.AddNoteAdapter;
import com.webon.timerv2.Notes.SubNote;
import com.webon.timerv2.R;

import java.util.ArrayList;

public class AddNoteActivity extends AppCompatActivity {
    private AddNoteAdapter addNoteAdapter; Handler handler;
    private EditText editTextTitle, editTextCount;
    private RadioButton buttonTime, buttonCount;
    private NumberPicker numberPickerHour, numberPickerMin;
    private Switch switchNotify;
    private Button buttonSubtaskVisible, buttonSubtaskAdd, buttonSubtaskDelete, buttonSave;
    private RecyclerView recyclerViewSubtask;
    private boolean isSubtaskOn;
    private ArrayList<SubNote> subNoteList;

    private void initViews() {
        editTextTitle = findViewById(R.id.editTextTitle);
        editTextCount = findViewById(R.id.editTextCount);
        buttonTime = findViewById(R.id.radioButtonTime);
        buttonCount = findViewById(R.id.radioButtonCount);
        numberPickerHour = findViewById(R.id.numberPickerHour);
        numberPickerMin = findViewById(R.id.numberPickerMinute);
        switchNotify = findViewById(R.id.switchNotify);
        buttonSubtaskVisible = findViewById(R.id.buttonShowSubtask);
        buttonSubtaskAdd = findViewById(R.id.buttonAddSubtask);
        buttonSubtaskDelete = findViewById(R.id.buttonDeleteSubtask);
        buttonSave = findViewById(R.id.buttonSave);
        isSubtaskOn = false;

        subNoteList = new ArrayList<>();
        recyclerViewSubtask = findViewById(R.id.recyclerViewSubtaskAddNote);
        addNoteAdapter = new AddNoteAdapter(subNoteList);
        recyclerViewSubtask.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewSubtask.setAdapter(addNoteAdapter);

        handler = new Handler(Looper.getMainLooper());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        initViews();
        onClickNoteType();
        onCLickSubtask();
    }

    private void onClickNoteType() {
        buttonTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPickerHour.setVisibility(View.VISIBLE);
                numberPickerMin.setVisibility(View.VISIBLE);
                editTextCount.setVisibility(View.GONE);
            }
        });
        buttonCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextCount.setVisibility(View.VISIBLE);
                numberPickerHour.setVisibility(View.GONE);
                numberPickerMin.setVisibility(View.GONE);
            }
        });
    }

    private void onCLickSubtask() {
        buttonSubtaskVisible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSubtaskOn) {
                    recyclerViewSubtask.setVisibility(View.VISIBLE);
                    isSubtaskOn = false;
                    buttonSubtaskVisible.setText("SUBTASK ON");
                } else {
                    recyclerViewSubtask.setVisibility(View.GONE);
                    isSubtaskOn = true;
                    buttonSubtaskVisible.setText("SUBTASK OFF");
                }
            }
        });

        buttonSubtaskDelete.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View v) {
                if (subNoteList.size() >= 1) {
                    subNoteList.remove(subNoteList.size()-1);
                    addNoteAdapter.notifyDataSetChanged();
                }
            }
        });

        buttonSubtaskAdd.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View v) {
                subNoteList.add(new SubNote(" ", 0));
                addNoteAdapter.notifyDataSetChanged();
            }
        });

    }


}