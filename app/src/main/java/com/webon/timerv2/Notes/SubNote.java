package com.webon.timerv2.Notes;

public class SubNote {
    private String title;
    private int count;

    public SubNote(String title, int count) {
        this.title = title;
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
