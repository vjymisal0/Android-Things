package com.vijayapps.storagemanagement;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ProcessorFragment extends Fragment {

    private TextView processorTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_processor, container, false);
        processorTextView = view.findViewById(R.id.processor);
        updateProcessorInfo();
        return view;
    }

    private void updateProcessorInfo() {
        String processor = Build.HARDWARE;
        processorTextView.setText("Processor: " + processor);
    }
}
