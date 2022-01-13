package vn.edu.huflit.yogadaily;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity implements ItemAdapter.Listener{

    Toolbar toolbar;
    SearchView searchView;
    ItemAdapter itemAdapter;
    ArrayList<Items> arrayList;
    RecyclerView rvItemFilter;
    LinearLayout linearEmpty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        toolbar = findViewById(R.id.toolbarSearch);
        searchView = toolbar.findViewById(R.id.searchView);
        linearEmpty = findViewById(R.id.linearEmpty);
        rvItemFilter = findViewById(R.id.rvItemFilter);

        arrayList = AppData.init_data(this);
        itemAdapter= new ItemAdapter(arrayList,this);
        rvItemFilter.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvItemFilter.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        rvItemFilter.setAdapter(itemAdapter);
        setVisible(false);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                itemAdapter.getFilter().filter(newText);

                if (itemAdapter.arrayListFilter.size() == 0 || newText.isEmpty()){
                    setVisible(false);
                }else {
                    setVisible(true);
                }
                return  false;
            }
        });
    }
    public  void setVisible(boolean flag){
        if(!flag){
            linearEmpty.setVisibility((View.VISIBLE));
            rvItemFilter.setVisibility(View.GONE);
        }else{
            linearEmpty.setVisibility(View.GONE);
            rvItemFilter.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(Items items) {
        Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
        intent.putExtra("item", items);
        startActivity(intent);
    }
}