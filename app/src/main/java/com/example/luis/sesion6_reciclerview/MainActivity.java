package com.example.luis.sesion6_reciclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> names;
    private RecyclerView rv;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager manager;
    private int cont = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        names = getNames();

        rv = (RecyclerView) findViewById(R.id.rv);
        //manager = new LinearLayoutManager(this);
        //manager = new GridLayoutManager(this, 2);
        //manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        adapter = new ReciclerAdapter(names, R.layout.recicler_view_item, new ReciclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String name, int position) {
                deleteName(position);
            }
        });

        //para controlar si el layout no varia
        rv.setHasFixedSize(true);
        //animaciones
        rv.setItemAnimator(new DefaultItemAnimator());

        rv.setLayoutManager(manager);
        rv.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.add:
                this.addName(0);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void addName(int i) {
        names.add(i, "name " + (++cont));
        adapter.notifyItemInserted(i);
        manager.scrollToPosition(i);
    }

    private void deleteName(int i){
        names.remove(i);
        adapter.notifyItemRemoved(i);
    }

    private List<String> getNames(){
        return new ArrayList<String>(){{
            add("Luis 1");
            add("Luis 2");
            add("Luis 3");
            add("Luis 4");
            add("Luis 5");
        }};
    }
}
