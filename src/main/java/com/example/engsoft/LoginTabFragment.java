package com.example.engsoft;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class LoginTabFragment extends Fragment {

    ViewPager username, pass, comfirm_pass, login;
    float v = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_tab_fragment, container, false);

        username = root.findViewById(R.id.username);
        pass = root.findViewById(R.id.pass);
        comfirm_pass = root.findViewById(R.id.confirm_pass);
        login = root.findViewById(R.id.button);

        username.setTranslationY(300);
        pass.setTranslationY(300);
        comfirm_pass.setTranslationY(300);
        login.setTranslationY(300);

        username.setAlpha(v);
        pass.setAlpha(v);
        comfirm_pass.setAlpha(v);
        login.setAlpha(v);

        username.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(300).start();
        pass.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(500).start();
        comfirm_pass.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(500).start();
        login.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(700).start();

        return root;
    }
}
