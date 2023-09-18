package vn.edu.usth.usthopendotaclient.searchplayerfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import vn.edu.usth.usthopendotaclient.R;


public class Hero_info extends Fragment {
    private LinearLayout mlinearLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.hero_info, container, false);
        return v;
    }
}