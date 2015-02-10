package com.example.benet.dynamicfragmentapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;



public class MainActivity extends ActionBarActivity {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.fragmentManager=this.getFragmentManager();
        this.fragmentTransaction=fragmentManager.beginTransaction();
        this.fragmentTransaction.replace(R.id.main_container, new FragmentPort());
        this.fragmentTransaction.commit();

    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        this.fragmentTransaction=fragmentManager.beginTransaction();

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {

            this.fragmentTransaction.replace(R.id.main_container,new FragmentLand());
            this.fragmentTransaction.commit();

        }else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){

            this.fragmentTransaction.replace(R.id.main_container,new FragmentPort());
            this.fragmentTransaction.commit();
        }
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


}
