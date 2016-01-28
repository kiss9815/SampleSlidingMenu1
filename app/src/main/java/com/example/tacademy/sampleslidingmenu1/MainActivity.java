package com.example.tacademy.sampleslidingmenu1;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity implements MenuFragment.OnMenuItemSelectListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setBehindContentView(R.layout.menu_layout); //메뉴 레이아웃을 새로 넣음

        if(savedInstanceState == null){ //정상적으로 작동한다면
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new MainFragment()).commit();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.menu_container, new MenuFragment()).commit();
        }

        SlidingMenu menu = getSlidingMenu();
        menu.setBehindWidthRes(R.dimen.behind_width);
        menu.setShadowDrawable(R.drawable.shadow);
        menu.setShadowWidthRes(R.dimen.shadow_width);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_drawer);
    }

    @Override
    public void onMenuItemSelected(int menuId) {
            switch (menuId){
                case MenuFragment.MENU_MAIN:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, new MainFragment())
                            .commit();
                    break;
                case MenuFragment.MENU_FIRST:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, new FirstFragment())
                            .commit();
                    break;
                case MenuFragment.MENU_SECOND:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, new SecondFragment())
                            .commit();
                    break;
            }
        showContent();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            toggle(); // home 키를 누르면 저절로 바뀌게
        }

        return super.onOptionsItemSelected(item);
    }
}
