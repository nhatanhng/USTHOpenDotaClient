package vn.edu.usth.usthopendotaclient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import vn.edu.usth.usthopendotaclient.searchplayerfragment.PlayerHeroesFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        // Player heroes fragment initial
//        PlayerHeroesFragment firstFragment = new PlayerHeroesFragment();
//        getSupportFragmentManager().beginTransaction().add(
//                R.id.container, firstFragment
//        ).commit();

    }
}