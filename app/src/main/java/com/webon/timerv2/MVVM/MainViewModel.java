package com.webon.timerv2.MVVM;

import android.content.Context;

import androidx.fragment.app.FragmentTransaction;

import com.webon.timerv2.Fragments.CurrentFragment;
import com.webon.timerv2.Fragments.HistoryFragment;
import com.webon.timerv2.Fragments.OptionFragment;
import com.webon.timerv2.MainActivity;
import com.webon.timerv2.R;

public class MainViewModel {

    private static MainViewModel instance;

    // Создаем синглтон
    public static MainViewModel getInstance() {
        if (instance == null) {
            instance = new MainViewModel();
        }
        return instance;
    }

    private MainViewModel() {
        // Приватный конструктор для синглтона
    }

    public void onClickCurrent(Context context) {
        CurrentFragment currentTask = new CurrentFragment();
        FragmentTransaction ft = ((MainActivity) context).getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.cont, currentTask);
        ft.commit();
    }

    public void onClickHistory(Context context) {
        HistoryFragment history = new HistoryFragment();
        FragmentTransaction ft = ((MainActivity) context).getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.cont, history);
        ft.commit();
    }

    public void onClickUser(Context context) {
        OptionFragment option = new OptionFragment();
        FragmentTransaction ft = ((MainActivity) context).getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.cont, option);
        ft.commit();
    }
}