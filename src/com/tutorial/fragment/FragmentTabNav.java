package com.tutorial.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;


public class FragmentTabNav extends Fragment{

    private static final int TAB_ONE_STATE = 0x1;
    private static final int TAB_TWO_STATE = 0x2;
    
    private int mTabState;
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tab_nav, container, false);
        
        // Grab the tab buttons from the layout and attach event handlers. The code just uses standard
        // buttons for the tab widgets. These are bad tab widgets, design something better, this is just
        // to keep the code simple.
        LinearLayout tabOne = (LinearLayout) view.findViewById(R.id.home_tab_timer);
        LinearLayout tabTwo = (LinearLayout) view.findViewById(R.id.home_tab_run);
        LinearLayout tabThree = (LinearLayout) view.findViewById(R.id.home_tab_awards);
        LinearLayout tabFour = (LinearLayout) view.findViewById(R.id.home_tab_gallery);
        LinearLayout tabFive = (LinearLayout) view.findViewById(R.id.home_tab_more);
        
        
        tabOne.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // Switch the tab content to display the first view.
                gotoTabOne();
            }
        });
        
        tabTwo.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // Switch the tab content to display the second view.
                gotoTabTwo();
            }
        });
        
        tabThree.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // Switch the tab content to display the first view.
                gotoTabOne();
            }
        });
        
        tabFour.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // Switch the tab content to display the second view.
                gotoTabTwo();
            }
        });
        
        tabFive.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // Switch the tab content to display the first view.
                gotoTabOne();
            }
        });
        
        return view;
    
    }
    
    public void gotoTabOne() {
        // mTabState keeps track of which tab is currently displaying its contents.
        // Perform a check to make sure the list tab content isn't already displaying.
        
        if (mTabState != TAB_ONE_STATE) {
            // Update the mTabState 
            mTabState = TAB_ONE_STATE;
            
            // Fragments have access to their parent Activity's FragmentManager. You can
            // obtain the FragmentManager like this.
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
    }
    
    public void gotoTabTwo() {
        
        if (mTabState != TAB_TWO_STATE) {
            mTabState = TAB_TWO_STATE;
            
            FragmentManager fm = getFragmentManager();
            
            if (fm != null) {
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment_content, new FirstFragment());
                ft.commit();
            }
        }
    }
}
