package com.example.mychat.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.example.mychat.R;
import com.google.android.material.button.MaterialButton;

public class callSetUp  extends DialogFragment {

    View view;
    ImageView back;
    MaterialButton startCall;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.call_setup_layout, container, false);
        getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Init();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        startCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                    StartCallDialog();
                }catch (Exception e){
                    Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        });
        return view;
    }

    private void Init(){
        back = view.findViewById(R.id.btnback);
        startCall = view.findViewById(R.id.startCall);
    }

    public void StartCallDialog() {

        try{
            onCall dialog = new onCall();
            dialog.setStyle(DialogFragment.STYLE_NO_TITLE, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
            dialog.show(getFragmentManager(),"dialog");
        }catch (Exception e){
            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }



    }
}
