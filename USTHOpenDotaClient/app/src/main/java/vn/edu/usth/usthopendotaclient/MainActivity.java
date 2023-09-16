package vn.edu.usth.usthopendotaclient;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

import vn.edu.usth.usthopendotaclient.searchplayerfragment.HomeFragment;
import vn.edu.usth.usthopendotaclient.searchplayerfragment.PlayerHeroesFragment;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        // Player heroes fragment initial
//        PlayerHeroesFragment firstFragment = new PlayerHeroesFragment();
//        getSupportFragmentManager().beginTransaction().add(
//                R.id.container, firstFragment
//        ).commit();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                drawerLayout.closeDrawer(GravityCompat.START);
                if (id == R.id.nav_home){
                    Toast toast = Toast.makeText(MainActivity.this, " Homw has been clicked", Toast.LENGTH_SHORT);
                    toast.show();
//                    Intent intent= new Intent(MainActivity.this, HomeFragment.class);
//                    startActivity(intent);
                }
                if (id == R.id.nav_favourite){
                    Toast toast = Toast.makeText(MainActivity.this, " Favourite has been clicked", Toast.LENGTH_SHORT);
                    toast.show();
                }
                if (id == R.id.nav_search){
                    Toast toast = Toast.makeText(MainActivity.this, " Search has been clicked", Toast.LENGTH_SHORT);
                    toast.show();
                }
                if (id == R.id.nav_setting){
                    Toast toast = Toast.makeText(MainActivity.this, " Setting has been clicked", Toast.LENGTH_SHORT);
                    toast.show();
                }

                return true;
            }
        });
    }
}