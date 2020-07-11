package com.example.project1;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import static androidx.core.app.ActivityCompat.requestPermissions;

public class MainActivity extends AppCompatActivity {
    MenuItem mSearch;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_dial,R.id.navigation_phonebook, R.id.navigation_pictures, R.id.navigation_randomgame)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.actionbar_actions, menu);

        mSearch = menu.findItem(R.id.item_search);

        mSearch.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {
            //확장 기능 True -> 여기에는 현재 검색 결과를 띄워야함
            @Override
            public boolean onMenuItemActionExpand(MenuItem menuItem) {

                return true;
            }
            //축소 기능 True -> 여기에 원래 Phone list 띄워야함
            @Override
            public boolean onMenuItemActionCollapse(MenuItem menuItem) {
                return true;
            }
        });

        SearchView sv = (SearchView) mSearch.getActionView();

        sv.setSubmitButtonEnabled(true);
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            //검색 내용을 제출했을 때.
            @Override
            public boolean onQueryTextSubmit(String s) {
                return true;
            }
            //텍스트가 바뀔때 마다 호출. 여기에 현재 검색 결과를 띄워야 할듯
            @Override
            public boolean onQueryTextChange(String s) {
                return true;
            }
        });
        return true;
    }


    /*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search :
                // TODO : process the click event for action_search item.
                Toast.makeText(this, "fdfdf", Toast.LENGTH_SHORT).show();
                mSearch.expandActionView();
                return true ;
            // ...
            // ...
            default :
                return super.onOptionsItemSelected(item) ;
        }
*/
}




