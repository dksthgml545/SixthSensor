package kr.ac.kopo.hdyw0w.sixthsensor;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

public class NavActivity extends AppCompatActivity {

    private final int LIST_FRAGMENT = 0;
    private final int SETT_FRAGMENT = 1;

    private Fragment[] fragments;

    private BackPressCloseHandler backPressCloseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_activity);
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.navigation);

        initFragments();

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.navigation_list:
                                selectedFragment = fragments[LIST_FRAGMENT];
                                break;
                            case R.id.navigation_setting:
                                selectedFragment = fragments[SETT_FRAGMENT];
                                break;
                        }
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_layout, selectedFragment);
                        transaction.commit();
                        return true;
                    }
                });

        bottomNavigationView.setSelectedItemId(R.id.navigation_list);

        //Manually displaying the first fragment - one time only
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, fragments[LIST_FRAGMENT]);
        transaction.commit();

        //Used to select an item programmatically
        //bottomNavigationView.getMenu().getItem(2).setChecked(true);

        backPressCloseHandler = new BackPressCloseHandler(this);
    }

    private void initFragments() {
        fragments = new Fragment[2];
        fragments[LIST_FRAGMENT] = ListFragment.newInstance();
        fragments[SETT_FRAGMENT] = SettingFragment.newInstance();
    }

    public interface onKeyBackPressedListener {
        public void onBack();
    }
    private onKeyBackPressedListener mOnKeyBackPressedListener;

    public void setOnKeyBackPressedListener(onKeyBackPressedListener listener) {
        mOnKeyBackPressedListener = listener;
    }

    @Override
    public void onBackPressed() {
        if (mOnKeyBackPressedListener != null) {
            mOnKeyBackPressedListener.onBack();
        } else {
//            super.onBackPressed();
        backPressCloseHandler.onBackPressed();
        }
    }
}

