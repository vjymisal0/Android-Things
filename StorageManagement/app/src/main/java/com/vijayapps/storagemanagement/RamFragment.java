package com.vijayapps.storagemanagement;


import android.widget.*;
import android.os.*;
import android.text.format.Formatter;
import android.view.*;
import android.app.ActivityManager;
import android.content.Context;


import androidx.fragment.app.Fragment;

public class RamFragment extends Fragment {

    private TextView totalRamTextView;
    private TextView usedRamTextView;
    private ActivityManager.MemoryInfo memoryInfo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ram, container, false);
        totalRamTextView = view.findViewById(R.id.total_ram);
        usedRamTextView = view.findViewById(R.id.used_ram);
        memoryInfo = new ActivityManager.MemoryInfo();
        updateRamInfo();
        return view;
    }

    private void updateRamInfo() {
        ActivityManager activityManager = (ActivityManager) getActivity().getSystemService(Context.ACTIVITY_SERVICE);
        activityManager.getMemoryInfo(memoryInfo);
        long totalRam = memoryInfo.totalMem;
        long usedRam = totalRam - memoryInfo.availMem;
        String totalRamFormatted = Formatter.formatFileSize(getActivity(), totalRam);
        String usedRamFormatted = Formatter.formatFileSize(getActivity(), usedRam);
        totalRamTextView.setText("Total RAM: " + totalRamFormatted);
        usedRamTextView.setText("Used RAM: " + usedRamFormatted);
    }
}
