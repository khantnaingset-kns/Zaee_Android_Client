package com.codesorcery.zaeev20.Activities;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.codesorcery.zaeev20.Fragments.CurrencyExchangeFragment;
import com.codesorcery.zaeev20.Fragments.ZaeeBookFragment;
import com.codesorcery.zaeev20.Fragments.ZaeeCalculatorFragment;
import com.codesorcery.zaeev20.Fragments.ZaeesFragment;
import com.codesorcery.zaeev20.R;
import com.github.florent37.awesomebar.ActionItem;
import com.github.florent37.awesomebar.AwesomeBar;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @Bind(R.id.nv_view)
    NavigationView mNavigationView;
    @Bind(R.id.bar)
    AwesomeBar mToolbar;
    ActionBarDrawerToggle mDrawerToggle;


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
//        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        //  mDrawerToggle.onConfigurationChanged(newConfig);



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mNavigationView.setItemIconTintList(null);
        // mDrawerToggle = setupDrawerToggle();
        setupDrawerContent(mNavigationView);
        mDrawerLayout.addDrawerListener(mDrawerToggle);


        mToolbar.addAction(R.drawable.ic_settings_white_24dp, "Setting");
        mToolbar.setActionItemClickListener(new AwesomeBar.ActionItemClickListener() {
            @Override
            public void onActionItemClicked(int position, ActionItem actionItem) {
                Toast.makeText(getBaseContext(), actionItem.getText() + " clicked", Toast.LENGTH_LONG).show();
            }
        });
        mToolbar.setOnMenuClickedListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(GravityCompat.START);

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        SelectDrawerMenuItem(menuItem);
                        return true;
                    }
                });
    }

//    private ActionBarDrawerToggle setupDrawerToggle() {
//        return new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close);
//    }

    private void SelectDrawerMenuItem(MenuItem menuItem) {
        Fragment fragment = null;
        Class fragmentClass = null;
        switch (menuItem.getItemId()) {
            case R.id.zaees:
                fragmentClass = ZaeesFragment.class;
                break;
            case R.id.currency_exchange:
                fragmentClass = CurrencyExchangeFragment.class;
                break;
            case R.id.zaee_book:
                fragmentClass = ZaeeBookFragment.class;
                break;
            case R.id.zaee_calculator:
                fragmentClass = ZaeeCalculatorFragment.class;
                break;
        }
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment_holder, fragment).commit();

        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());
        mDrawerLayout.closeDrawers();


    }
}
