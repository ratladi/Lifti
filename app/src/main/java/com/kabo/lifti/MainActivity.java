package com.kabo.lifti;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
//import com.firebase.client.DataSnapshot;
//import com.firebase.client.Firebase;
//import com.firebase.client.FirebaseError;
//import com.firebase.client.ValueEventListener;
import com.kabo.DashboardFragment;
import com.kabo.activity.AddTripFragment;
import com.kabo.activity.FragmentDrawer;
import com.kabo.activity.TripFragment;


public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener{

    //Firebase myFirebaseRef;
    private static String TAG = MainActivity.class.getSimpleName();

    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);

        // display the first navigation drawer view on app launch
        displayView(0);

    }
   // @Override
//    public void onStart(){
//        super.onStart();
////
////        final TextView textView = (TextView) findViewById(R.id.login_status);
////        Firebase.setAndroidContext(this);
////        myFirebaseRef = new Firebase("https://lifti.firebaseIO.com/web/data");
////        myFirebaseRef.child("message").setValue("Do you have data? You'll love Firebase.");
////
////        myFirebaseRef.child("message").addValueEventListener(new ValueEventListener() {
////
////            @Override
////            public void onDataChange(DataSnapshot snapshot) {
////                String string = (String) snapshot.getValue(); //prints "Do you have data? You'll love Firebase."
////                textView.setText(string);
////            }
////
////            @Override
////            public void onCancelled(FirebaseError error) {
////            }
////
////        });
//    }

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
        if(id == R.id.action_search){
            Toast.makeText(getApplicationContext(), "Search action is selected!", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    private void displayView(int position) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        switch (position) {
//            case 0:
//                fragment = new TripFragment();
//                title = getString(R.string.title_trips);
//                break;
            case 0:
                fragment = new AddTripFragment();
                title = getString(R.string.title_add_trips);
                break;
            case 1:
                fragment = new DashboardFragment();
                title = getString(R.string.title_dashboard);
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();

            // set the toolbar title
            getSupportActionBar().setTitle(title);
        }
    }
}
