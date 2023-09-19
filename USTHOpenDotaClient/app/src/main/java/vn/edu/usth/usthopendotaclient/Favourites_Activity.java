package vn.edu.usth.usthopendotaclient;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import vn.edu.usth.usthopendotaclient.databinding.ActivityFavouritesBinding;

public class Favourites_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);

        Toolbar toolbar = findViewById(R.id.favourites_toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawerLayout = findViewById(R.id.fav_drawer_layout);
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
//                    Toast toast = Toast.makeText(MainActivity.this, " Homw has been clicked", Toast.LENGTH_SHORT);
//                    toast.show();
                    Intent intent= new Intent(Favourites_Activity.this, MainActivity.class);
                    startActivity(intent);
                }
                if (id == R.id.nav_favourite){
                    Intent intent= new Intent(Favourites_Activity.this, Favourites_Activity.class);
                    startActivity(intent);
                }
                if (id == R.id.nav_search){
                    Intent intent= new Intent(Favourites_Activity.this, Search_Activity.class);
                    startActivity(intent);
                }
                if (id == R.id.nav_setting){
                    Toast toast = Toast.makeText(Favourites_Activity.this, " Setting has been clicked", Toast.LENGTH_SHORT);
                    toast.show();
                }

                return true;
            }
        });
    }
}