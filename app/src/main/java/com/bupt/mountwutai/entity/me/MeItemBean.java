package com.bupt.mountwutai.entity.me;

/**
 * Created by Wyf on 2017/5/11.
 */

public class MeItemBean {
    private int icon;
    private String title;

    public MeItemBean(int icon, String title) {
        this.icon = icon;
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}