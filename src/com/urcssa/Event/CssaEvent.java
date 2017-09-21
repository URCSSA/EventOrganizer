package com.urcssa.Event;

import com.urcssa.People.Participant;

public abstract class CssaEvent {
    private ActivityManager activityManager;

    public ActivityManager getActivityManager() {
        return activityManager;
    }

    public void setActivityManager(ActivityManager activityManager) {
        this.activityManager = activityManager;
    }
}
