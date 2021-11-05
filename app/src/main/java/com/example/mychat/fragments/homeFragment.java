package com.example.mychat.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.mychat.R;

public class homeFragment extends Fragment {

    View view;
    RelativeLayout startCall;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.home_fragment, container, false);
        Init();

        startCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });

       return view;
    }

    private void Init(){
        startCall = view.findViewById(R.id.startCall);
    }

    public void openDialog() {
        callSetUp dialog = new callSetUp();
        dialog.setStyle(DialogFragment.STYLE_NO_TITLE, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        dialog.show(getFragmentManager(),"dialog");

    }

}
