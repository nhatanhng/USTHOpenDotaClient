package vn.edu.usth.usthopendotaclient;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class Search_Activity extends AppCompatActivity {
    SearchView searchView;
    private RecyclerView recyclerView;
    private SearchAdapter searchAdapter;
    ArrayList<ModelClass> arrayList = new ArrayList<>();
    ArrayList<ModelClass> searchList;

    // player infor
    String[] userList = new String[] {"jojo","kaykay","jack","max","bon","david"}; //user name
    String[] userNum = new String[] {"185476982","785412058","369801472","487621007","998745301","235014785"}; // user id
    String[] userWinList = new String[] {"1", "8","45","10","6","21"};
    String[] userLooseList = new String[] {"5","2","10","22","4","18"};
    int[] imgList = new int[] {R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        recyclerView=findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Search_Activity.this);
        recyclerView.setLayoutManager(linearLayoutManager);

        searchView=findViewById(R.id.searchView);
        searchView.setIconified(false);
        searchView.clearFocus();

        Toolbar toolbar = findViewById(R.id.search_toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawerLayout = findViewById(R.id.search_drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);

        // navigation
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
                    Intent intent= new Intent(Search_Activity.this, MainActivity.class);
                    startActivity(intent);
                }
                if (id == R.id.nav_favourite){
                    Intent intent= new Intent(Search_Activity.this, Favourites_Activity.class);
                    startActivity(intent);
                }
                if (id == R.id.nav_search){
                    Intent intent= new Intent(Search_Activity.this, Search_Activity.class);
                    startActivity(intent);
                }
                if (id == R.id.nav_setting){
                    Intent intent = new Intent(Search_Activity.this, SettingActivity.class);
                    startActivity(intent);
                }

                return true;
            }
        });

        // add player infor to user
        for (int i = 0; i < userList.length; i++) {
            ModelClass modelClass = new ModelClass();
            modelClass.setUserName(userList[i]);
            modelClass.setUserNum(userNum[i]);
            modelClass.setImg(imgList[i]);
            modelClass.setUserWin(userWinList[i]);
            modelClass.setUserLose(userLooseList[i]);
            arrayList.add(modelClass);
        }

        searchAdapter = new SearchAdapter(Search_Activity.this,arrayList);
        recyclerView.setAdapter(searchAdapter);

        // search bar
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchList = new ArrayList<>();
                if (query.length() > 0) {
                    for (int i = 0; i < arrayList.size(); i++) {
                        if (arrayList.get(i).getUserName().toUpperCase().contains(query.toUpperCase()) || arrayList.get(i).getUserNum().toUpperCase().contains(query.toUpperCase())) {
                            ModelClass modelClass = new ModelClass();
                            modelClass.setUserName(arrayList.get(i).getUserName());
                            modelClass.setUserNum(arrayList.get(i).getUserNum());
                            modelClass.setImg(arrayList.get(i).getImg());
                            modelClass.setUserWin(arrayList.get(i).getUserWin());
                            modelClass.setUserLose(arrayList.get(i).getUserLose());
                            searchList.add(modelClass);
                        }
                    }

                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Search_Activity.this);
                    recyclerView.setLayoutManager(layoutManager);

                    SearchAdapter userAdapter = new SearchAdapter(Search_Activity.this,searchList);
                    recyclerView.setAdapter(userAdapter);
                }

                else{
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Search_Activity.this);
                    recyclerView.setLayoutManager(layoutManager);

                    SearchAdapter userAdapter = new SearchAdapter(Search_Activity.this,arrayList);
                    recyclerView.setAdapter(userAdapter);
                }

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchList = new ArrayList<>();
                if (newText.length() > 0) {
                    for (int i = 0; i < arrayList.size(); i++) {
                        if (arrayList.get(i).getUserName().toUpperCase().contains(newText.toUpperCase()) || arrayList.get(i).getUserNum().toUpperCase().contains(newText.toUpperCase())) {
                            ModelClass modelClass = new ModelClass();
                            modelClass.setUserName(arrayList.get(i).getUserName());
                            modelClass.setUserNum(arrayList.get(i).getUserNum());
                            modelClass.setImg(arrayList.get(i).getImg());
                            modelClass.setUserWin(arrayList.get(i).getUserWin());
                            modelClass.setUserLose(arrayList.get(i).getUserLose());
                            searchList.add(modelClass);
                        }
                    }

                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Search_Activity.this);
                    recyclerView.setLayoutManager(layoutManager);

                    SearchAdapter userAdapter = new SearchAdapter(Search_Activity.this,searchList);
                    recyclerView.setAdapter(userAdapter);
                }

                else{
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Search_Activity.this);
                    recyclerView.setLayoutManager(layoutManager);

                    SearchAdapter userAdapter = new SearchAdapter(Search_Activity.this,arrayList);
                    recyclerView.setAdapter(userAdapter);
                }
                return false;
            }
        });


    }
}