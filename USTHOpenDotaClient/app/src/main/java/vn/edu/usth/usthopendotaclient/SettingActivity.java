package vn.edu.usth.usthopendotaclient;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.core.view.WindowCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import vn.edu.usth.usthopendotaclient.databinding.ActivitySettingBinding;

public class SettingActivity extends AppCompatActivity {

    public SettingActivity(){
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_setting);
        Toolbar toolbar = findViewById(R.id.setting_toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawerLayout = findViewById(R.id.setting_drawer_layout);
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
//                    Toast toast = Toast.makeText(MainActivity.this, " Home has been clicked", Toast.LENGTH_SHORT);
//                    toast.show();
                    Intent intent= new Intent(SettingActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                if (id == R.id.nav_favourite){
                    Intent intent= new Intent(SettingActivity.this, Favourites_Activity.class);
                    startActivity(intent);
                }
                if (id == R.id.nav_search){
                    Intent intent= new Intent(SettingActivity.this, Search_Activity.class);
                    startActivity(intent);
                }
                if (id == R.id.nav_setting){
                    Intent intent = new Intent(SettingActivity.this, SettingActivity.class);
                    startActivity(intent);
                }

                return true;
            }
        });
    }
}