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
    RecyclerView recyclerView;
    ArrayList<ModelClass> arrayList = new ArrayList<>();
    ArrayList<ModelClass> searchList;
    String[] fruitList = new String[] {"a","b","c","d","e","f"}; //user name
    String[] fruitNum = new String[] {"1","2","3","4","5","6"}; // user id
    int[] imgList = new int[] {R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        recyclerView=findViewById(R.id.recyclerView);
        searchView=findViewById(R.id.searchView);
        searchView.setIconified(false);
        searchView.clearFocus();

        Toolbar toolbar = findViewById(R.id.search_toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawerLayout = findViewById(R.id.search_drawer_layout);
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
                    Toast toast = Toast.makeText(Search_Activity.this, " Setting has been clicked", Toast.LENGTH_SHORT);
                    toast.show();
                }

                return true;
            }
        });


        for (int i = 0; i < fruitList.length; i++) {
            ModelClass modelClass = new ModelClass();
            modelClass.setFruitName(fruitList[i]);
            modelClass.setFruitNum(fruitNum[i]);
            modelClass.setImg(imgList[i]);
            arrayList.add(modelClass);
        }

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Search_Activity.this);
        recyclerView.setLayoutManager(layoutManager);

        SearchAdapter fruitAdapter = new SearchAdapter(Search_Activity.this,arrayList);
        recyclerView.setAdapter(fruitAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchList = new ArrayList<>();
                if (query.length() > 0) {
                    for (int i = 0; i < arrayList.size(); i++) {
                        if (arrayList.get(i).getFruitName().toUpperCase().contains(query.toUpperCase()) || arrayList.get(i).getFruitNum().toUpperCase().contains(query.toUpperCase())) {
                            ModelClass modelClass = new ModelClass();
                            modelClass.setFruitName(arrayList.get(i).getFruitName());
                            modelClass.setFruitNum(arrayList.get(i).getFruitNum());
                            modelClass.setImg(arrayList.get(i).getImg());
                            searchList.add(modelClass);
                        }
                    }

                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Search_Activity.this);
                    recyclerView.setLayoutManager(layoutManager);

                    SearchAdapter fruitAdapter = new SearchAdapter(Search_Activity.this,searchList);
                    recyclerView.setAdapter(fruitAdapter);
                }

                else{
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Search_Activity.this);
                    recyclerView.setLayoutManager(layoutManager);

                    SearchAdapter fruitAdapter = new SearchAdapter(Search_Activity.this,arrayList);
                    recyclerView.setAdapter(fruitAdapter);
                }

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchList = new ArrayList<>();
                if (newText.length() > 0) {
                    for (int i = 0; i < arrayList.size(); i++) {
                        if (arrayList.get(i).getFruitName().toUpperCase().contains(newText.toUpperCase()) || arrayList.get(i).getFruitNum().toUpperCase().contains(newText.toUpperCase())) {
                            ModelClass modelClass = new ModelClass();
                            modelClass.setFruitName(arrayList.get(i).getFruitName());
                            modelClass.setFruitNum(arrayList.get(i).getFruitNum());
                            modelClass.setImg(arrayList.get(i).getImg());
                            searchList.add(modelClass);
                        }
                    }

                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Search_Activity.this);
                    recyclerView.setLayoutManager(layoutManager);

                    SearchAdapter fruitAdapter = new SearchAdapter(Search_Activity.this,searchList);
                    recyclerView.setAdapter(fruitAdapter);
                }

                else{
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Search_Activity.this);
                    recyclerView.setLayoutManager(layoutManager);

                    SearchAdapter fruitAdapter = new SearchAdapter(Search_Activity.this,arrayList);
                    recyclerView.setAdapter(fruitAdapter);
                }
                return false;
            }
        });
    }
}