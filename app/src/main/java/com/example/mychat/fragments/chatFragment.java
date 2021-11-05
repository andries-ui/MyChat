package com.example.mychat.fragments;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.example.mychat.R;
import com.google.android.material.button.MaterialButton;

public class chatFragment extends Fragment {

    View view;
    MaterialButton inviteFriends;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.chat_fragment, container, false);

        Init();

        inviteFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InviteDialof();
            }
        });

       return view;
    }

    private  void Init(){
        inviteFriends = view.findViewById(R.id.inviteNewFriends);
    }

    private void InviteDialof(){
            finfFriends dialog = new finfFriends();
            dialog.setStyle(DialogFragment.STYLE_NO_TITLE, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
            dialog.show(getFragmentManager(),"dialog");

    }
}
