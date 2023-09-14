package com.webon.timerv2.Adapters;

import androidx.room.TypeConverter;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.webon.timerv2.Notes.SubNote;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class NoteConverter {
    @TypeConverter
    public static ArrayList<SubNote> fromString(String value) {
        Type listType = new TypeToken<ArrayList<SubNote>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromList(ArrayList<SubNote> list) {
        return new Gson().toJson(list);
    }
}
