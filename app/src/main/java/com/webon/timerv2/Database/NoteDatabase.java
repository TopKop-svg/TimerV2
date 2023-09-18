package com.webon.timerv2.Database;

import android.app.Application;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.webon.timerv2.Notes.Note;

@Database(entities = {Note.class}, version = 2)
public abstract class NoteDatabase extends RoomDatabase {
    private static NoteDatabase instance = null;
    private static final String DB_NOTE = "notes.db";

    public static NoteDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                            context,
                            NoteDatabase.class,
                            DB_NOTE
                    )
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }





    public abstract  NotesDao notesDao();
}
