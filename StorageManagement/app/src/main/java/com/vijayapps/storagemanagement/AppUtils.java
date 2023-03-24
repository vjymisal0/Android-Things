package com.vijayapps.storagemanagement;

import android.os.Build;

import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AppUtils {

    public static String getModel() {
        return Build.MODEL;
    }

    public static String getVersion() {
        return Build.VERSION.RELEASE;
    }

    public static long getTotalStorage() {
        StatFs stat = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return stat.getTotalBytes();
    }

    public static long getFreeStorage() {
        StatFs stat = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return stat.getFreeBytes();
    }

    public static long getUsedStorage() {
        return getTotalStorage() - getFreeStorage();
    }
}
