package vn.edu.usth.usthopendotaclient;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.util.Log;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.MenuItem;

import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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
    private RelativeLayout relativeLayoutSetting;

    public SettingActivity(){
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_setting);
        relativeLayoutSetting = findViewById(R.id.relative_layout_setting);
        RadioGroup radioGroup = findViewById(R.id.Themes);

        RadioButton hyperfuseRadioButton = findViewById(R.id.Theme_Hyperfuse);
        RadioButton skyDolchRadioButton = findViewById(R.id.Theme_SkyDolch);
        Log.d("SettingActivity", "radioGroup: " + radioGroup);
        Log.d("SettingActivity", "hyperfuseRadioButton: " + hyperfuseRadioButton);
        Log.d("SettingActivity", "skyDolchRadioButton: " + skyDolchRadioButton);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                int color = 0;
                int text_color = 0;
                int tool_bar_color = 0;

                if (checkedId == R.id.Theme_Hyperfuse) {
                    color = getResources().getColor(R.color.hyper_fuse);
                    text_color = getResources().getColor(R.color.white);
                    tool_bar_color = getResources().getColor(R.color.hyper_fuse_bar);
                    Toast.makeText(SettingActivity.this, "Hyperfuse selected", Toast.LENGTH_SHORT).show();
                } else if (checkedId == R.id.Theme_SkyDolch) {
                    color = getResources().getColor(R.color.sky_dolch);
                    text_color = getResources().getColor(R.color.black);
                    tool_bar_color = getResources().getColor(R.color.sky_dolch_bar);
                    Toast.makeText(SettingActivity.this, "Sky Dolch selected", Toast.LENGTH_SHORT).show();
                } else if (checkedId == R.id.Theme_Default) {
                    color = getResources().getColor(R.color.background);
                    text_color = getResources().getColor(R.color.white);
                    tool_bar_color = getResources().getColor(R.color.item);
                    Toast.makeText(SettingActivity.this, "Sky Dolch selected", Toast.LENGTH_SHORT).show();
                } else if (checkedId == R.id.Theme_Invisibility) {
                    color = getResources().getColor(R.color.invisibility);
                    text_color = getResources().getColor(R.color.black);
                    tool_bar_color = getResources().getColor(R.color.invisibility_bar);
                    Toast.makeText(SettingActivity.this, "Sky Dolch selected", Toast.LENGTH_SHORT).show();
                } else if (checkedId == R.id.Theme_FUWA_FUWA_PINK) {
                    color = getResources().getColor(R.color.pink);
                    text_color = getResources().getColor(R.color.black);
                    tool_bar_color = getResources().getColor(R.color.pink_bar);
                    Toast.makeText(SettingActivity.this, "Sky Dolch selected", Toast.LENGTH_SHORT).show();
                } else if (checkedId == R.id.Theme_NightDota) {
                    color = getResources().getColor(R.color.night_dota);
                    text_color = getResources().getColor(R.color.white);
                    tool_bar_color = getResources().getColor(R.color.night_dota_bar);
                    Toast.makeText(SettingActivity.this, "Sky Dolch selected", Toast.LENGTH_SHORT).show();
                }

                relativeLayoutSetting.setBackgroundColor(color);


                // Get all radio buttons in the activity
                RadioButton[] radioButtons = {
                        findViewById(R.id.Theme_Default),
                        findViewById(R.id.Theme_SkyDolch),
                        findViewById(R.id.Theme_Hyperfuse),
                        findViewById(R.id.Theme_Invisibility),
                        findViewById(R.id.Theme_FUWA_FUWA_PINK),
                        findViewById(R.id.Theme_NightDota)
                };

                // Set the text color of all radio buttons
                for (RadioButton radioButton : radioButtons) {
                    radioButton.setTextColor(text_color);
                }
                // Set the toolbar background color
                Toolbar toolbar = findViewById(R.id.setting_toolbar);
                toolbar.setBackgroundColor(tool_bar_color);
            }
        });



        relativeLayoutSetting = findViewById(R.id.relative_layout_setting);
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
                    Intent intent = new Intent(SettingActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish(); // Finish the current activity to prevent going back to it
                } else if (id == R.id.nav_favourite){
                    Intent intent = new Intent(SettingActivity.this, Favourites_Activity.class);
                    startActivity(intent);
                    finish(); // Finish the current activity to prevent going back to it
                } else if (id == R.id.nav_search){
                    Intent intent = new Intent(SettingActivity.this, Search_Activity.class);
                    startActivity(intent);
                    finish(); // Finish the current activity to prevent going back to it
                } else if (id == R.id.nav_setting){
                    Intent intent = new Intent(SettingActivity.this, SettingActivity.class);
                    startActivity(intent);
                    finish();
                }

                return true;
            }
        });
    }
}