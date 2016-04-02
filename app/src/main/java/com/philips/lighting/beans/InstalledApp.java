package com.philips.lighting.beans;

/**
 * Created by srihari on 2/4/16.
 */
public class InstalledApp {
    private long appnumber;
    private String appName;
    private String color;

    public long getAppnumber() {
        return appnumber;
    }

    public void setAppnumber(long appnumber) {
        this.appnumber = appnumber;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
