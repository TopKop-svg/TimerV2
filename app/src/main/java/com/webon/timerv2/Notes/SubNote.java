package com.webon.timerv2.Notes;

public class SubNote {
    private String title;
    private int count;
    private final int aimCount;

    public SubNote(String title, int count, int aimCount) {
        this.title = title;
        this.count = count;
        this.aimCount = aimCount;
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

    public int getAimCount() {
        return aimCount;
    }
}
