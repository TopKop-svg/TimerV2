package com.webon.timerv2.Notes;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.webon.timerv2.Adapters.NoteConverter;

import java.util.ArrayList;

@Entity(tableName = "notes")
@TypeConverters(NoteConverter.class)
public class Note {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title, currentCount, goalCount;
    private int count, countAim;
    private final boolean isTime;
    //private boolean isNotify;
    private boolean isOnClickStart = true;

    private ArrayList<SubNote> subNotesList;

    public Note(int id, boolean isTime) {
        this.id = id;
        this.isTime = isTime;
    }
    @Ignore
    public Note(String title, String currentCount, String goalCount,
                int countAim, boolean isTime, ArrayList<SubNote> subNotesList) {
        this.title = title;
        this.currentCount = currentCount;
        this.goalCount = goalCount;
        this.countAim = countAim;
        this.isTime = isTime;
        this.subNotesList = subNotesList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(String currentCount) {
        this.currentCount = currentCount;
    }

    public String getGoalCount() {
        return goalCount;
    }

    public void setGoalCount(String goalCount) {
        this.goalCount = goalCount;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCountAim() {
        return countAim;
    }

    public void setCountAim(int countAim) {
        this.countAim = countAim;
    }

    public boolean isTime() {
        return isTime;
    }

    public boolean isOnClickStart() {
        return isOnClickStart;
    }

    public void setOnClickStart(boolean onClickStart) {
        isOnClickStart = onClickStart;
    }

    public ArrayList<SubNote> getSubNotesList() {
        return subNotesList;
    }

    public void setSubNotesList(ArrayList<SubNote> subNotesList) {
        this.subNotesList = subNotesList;
    }
}
