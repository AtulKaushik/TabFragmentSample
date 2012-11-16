
package com.tutorial.fragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class FragmentTabActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fragment_tab);
        showHome();
    }

    private void showHome() {
        FragmentManager fm = getFragmentManager();

        if (fm != null) {
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_content, new HomeFragmentActivity());
            ft.commit();
        }
    }

}
