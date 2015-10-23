package io.github.sodacity.android101;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import io.github.sodacity.android101.model.Placeholder;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PlaceholderRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Placeholder placeholder = new Placeholder();
                adapter.add(placeholder);
                adapter.notifyItemInserted(adapter.getItemCount()-1);
                recyclerView.smoothScrollToPosition(adapter.getItemCount()-1);
            }
        });

        // Load the recycler view from the layout
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        // Create the recycler adapter
        adapter = new PlaceholderRecyclerAdapter(this);

        // Setup the recycler view with the adapter
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        // Generate placeholder items
        List<Placeholder> placeholders = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            placeholders.add(new Placeholder());
        }

        adapter.addAll(placeholders);
        adapter.notifyDataSetChanged();

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
        }else if(id == R.id.action_clearall){
            adapter.clear();
            adapter.notifyDataSetChanged();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
