package com.sky.androidtest;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.sky.androidtest.fragment.AndroidFragment;
import com.sky.androidtest.fragment.JavaFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener,
        AndroidFragment.OnFragmentInteractionListener {

    private static final String KEY_BOTTOM_NAVIGATION_VIEW_SELECTED_ID = "KEY_BOTTOM_NAVIGATION_VIEW_SELECTED_ID";
    private AndroidFragment mAndroidFragment;
    private JavaFragment mJavaFragment;
    private BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        mBottomNavigationView.setOnNavigationItemSelectedListener(this);

        if(savedInstanceState != null){
            FragmentManager fm = getSupportFragmentManager();
            mJavaFragment = (JavaFragment) fm.getFragment(savedInstanceState,JavaFragment.class.getSimpleName());
            mAndroidFragment = (AndroidFragment) fm.getFragment(savedInstanceState,AndroidFragment.class.getSimpleName());
        } else {
            mJavaFragment = JavaFragment.newInstance();
            mAndroidFragment = AndroidFragment.newInstance("","");
        }

        if(!mAndroidFragment.isAdded()){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content,mAndroidFragment,AndroidFragment.class.getSimpleName())
                    .commit();
        }

        if(!mJavaFragment.isAdded()){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content,mJavaFragment,JavaFragment.class.getSimpleName())
                    .commit();
        }

        mBottomNavigationView.setSelectedItemId(0);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_BOTTOM_NAVIGATION_VIEW_SELECTED_ID, mBottomNavigationView.getSelectedItemId());
        FragmentManager fm = getSupportFragmentManager();
        if(mJavaFragment.isAdded()){
            fm.putFragment(outState,JavaFragment.class.getSimpleName(),mJavaFragment);
        }
    }


    private void showFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        if (fragment instanceof AndroidFragment) {
            fm.beginTransaction()
                    .show(mAndroidFragment)
                    .hide(mJavaFragment)
                    //       .hide(mFavoritesFragment)
                    .commit();

        } else if (fragment instanceof JavaFragment) {
            fm.beginTransaction()
                    .show(mJavaFragment)
                    .hide(mAndroidFragment)
                    //        .hide(mFavoritesFragment)
                    .commit();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                showFragment(mAndroidFragment);
                return true;
            case R.id.navigation_dashboard:
                showFragment(mJavaFragment);
                return true;
            case R.id.navigation_notifications:
                return true;
        }
        return false;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
