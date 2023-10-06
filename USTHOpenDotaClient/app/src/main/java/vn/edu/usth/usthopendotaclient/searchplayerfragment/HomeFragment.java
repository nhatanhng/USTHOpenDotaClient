package vn.edu.usth.usthopendotaclient.searchplayerfragment;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import vn.edu.usth.usthopendotaclient.R;


public class HomeFragment extends Fragment {
    private RelativeLayout relativeLayoutSearch_1;
    private SharedPreferences sharedPreferences;
    private LinearLayout linearLayoutHome;
    private int storedColor;

//    private TextView textView_2;
//    private TextView textView_3;
//    private TextView textView_4;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

//        relativeLayoutSearch_1 = v.findViewById(R.id.rectangle_2);
//        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext());
//        storedColor = sharedPreferences.getInt("selected_color", getResources().getColor(R.color.background));
//        relativeLayoutSearch_1.setBackgroundColor(storedColor);

        // change color for text
//        int storedTextColor = sharedPreferences.getInt("selected_text_color", getResources().getColor(R.color.purple));
//        // Set the background color and text color of the fragment's root view
//        v.setBackgroundColor(storedColor);
//        textView_2 = v.findViewById(R.id.text2);
//        textView_3 = v.findViewById(R.id.text3);
//        textView_4 = v.findViewById(R.id.text4);
//        textView_2.setTextColor(storedTextColor);
//        textView_3.setTextColor(storedTextColor);
//        textView_4.setTextColor(storedTextColor);


        return v;
    }

//    @Override
//    public void onResume() {
//        super.onResume();
//        int updatedColor = sharedPreferences.getInt("selected_color", getResources().getColor(R.color.background));
//        if (storedColor != updatedColor) {
//            storedColor = updatedColor;
//            relativeLayoutSearch_1.setBackgroundColor(storedColor);
//        }
//    }
}