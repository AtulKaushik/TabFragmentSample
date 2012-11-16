package com.tutorial.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HomeFragmentActivity extends Fragment{

    private Button mNextButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.home_fragment_activity, container, false);
        mNextButton = (Button) view.findViewById(R.id.next_btn);   
        mNextButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();

                if (fm != null) {
                    // Perform the FragmentTransaction to load in the first tab content.
                    // Using FragmentTransaction#replace will destroy any Fragments
                    // currently inside R.id.fragment_content and add the new Fragment
                    // in its place.
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.fragment_content, new SecondFragment());
                    ft.commit();
                }

            }
        });

        return view;
    }


}
