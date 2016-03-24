package bhouse.travellist;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private RecyclerView mRecyclerView;
    private StaggeredGridLayoutManager mStaggeredLayoutManager;
    private TravelListAdapter mAdapter;
    private boolean isListView;
    private TravelAdapter travelAdapter;
    private Menu menu;
    Fragment fragment;
    FragmentManager manager;
    FragmentTransaction transaction;
    int i = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setUpActionBar();
        manager = getFragmentManager();
        transaction = manager.beginTransaction();
        fragment = new StartFragment();
        transaction.add(R.id.myFragment, fragment);
        transaction.commit();
    }


    private void setUpActionBar() {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        this.menu = menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_toggle) {
            toggle();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void toggle() {


        if (i == 1) {
            Bundle bundle = new Bundle();
            bundle.putInt("grid", 2);
            fragment = new StartFragment();
            fragment.setArguments(bundle);
            i = 2;

        } else if (i == 2) {
            Toast.makeText(MainActivity.this, "2", Toast.LENGTH_SHORT).show();
            fragment = new ListViewFragment();
            i = 3;
        } else if (i == 3) {
            Toast.makeText(MainActivity.this, "3", Toast.LENGTH_SHORT).show();
            fragment = new StartFragment();
            i = 1;
        }
        transaction = manager.beginTransaction();
        transaction.replace(R.id.myFragment, fragment);
        transaction.commit();
    }
}