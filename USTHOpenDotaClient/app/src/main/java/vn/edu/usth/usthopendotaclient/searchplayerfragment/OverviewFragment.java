package vn.edu.usth.usthopendotaclient.searchplayerfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import vn.edu.usth.usthopendotaclient.ModelClass;
import vn.edu.usth.usthopendotaclient.R;


public class OverviewFragment extends Fragment {
    TextView player_name;
    ModelClass user;

    public OverviewFragment(ModelClass user) {
        this.user = user;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_overview, container, false);

        player_name = view.findViewById(R.id.A_name);
        player_name.setText(user.getUserName());
        return  view;
    }
}
