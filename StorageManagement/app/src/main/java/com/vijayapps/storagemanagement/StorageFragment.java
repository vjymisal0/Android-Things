package com.vijayapps.storagemanagement;

import android.os.*;
import android.text.format.Formatter;
import android.view.*;
import android.widget.*;

import androidx.fragment.app.Fragment;

public class StorageFragment extends Fragment {

    private TextView totalSpaceTextView;
    private TextView freeSpaceTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_storage, container, false);
        totalSpaceTextView = view.findViewById(R.id.total_space);
        freeSpaceTextView = view.findViewById(R.id.free_space);
        updateStorageInfo();
        return view;
    }

    private void updateStorageInfo() {
        StatFs stat = new StatFs(Environment.getExternalStorageDirectory().getPath());
        long totalSpace = stat.getTotalBytes();
        long freeSpace = stat.getFreeBytes();
        String totalSpaceFormatted = Formatter.formatFileSize(getActivity(), totalSpace);
        String freeSpaceFormatted = Formatter.formatFileSize(getActivity(), freeSpace);
        totalSpaceTextView.setText("Total Space: " + totalSpaceFormatted);
        freeSpaceTextView.setText("Free Space: " + freeSpaceFormatted);
    }
}
