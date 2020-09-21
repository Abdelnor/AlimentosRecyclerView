package com.example.alimentos.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.alimentos.services.listener.OnListClick;
import com.example.alimentos.ui.adapter.FoodAdapter;
import com.example.alimentos.services.business.FoodBusiness;
import com.example.alimentos.services.constants.FoodConstants;
import com.example.alimentos.entities.FoodEntity;
import com.example.alimentos.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();
    private FoodBusiness mFoodBusiness = new FoodBusiness();
    private OnListClick mListener;
    private int mFilter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.mListener = new OnListClick() {
            @Override
            public void onClick(int id) {
                Bundle bundle = new Bundle();
                bundle.putInt(FoodConstants.FOOD_ID,id);

                Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
                intent.putExtras(bundle);

                startActivity(intent);

            }
        };


        this.mViewHolder.mRecyclerFood = findViewById(R.id.recycler_Food);
        this.mViewHolder.mRecyclerFood.setLayoutManager(new LinearLayoutManager(this));

        this.listfood();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        ActionMode mode;
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.action_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        item.setChecked(true);

        switch (item.getItemId()){
            case R.id.filter_low: {
                this.mFilter = FoodConstants.FILTER.CAL_LOW;
                break;

            }
            case R.id.filet_medium: {
                this.mFilter = FoodConstants.FILTER.CAL_MEDIUM;
                break;

            }
            default: {
                this.mFilter = FoodConstants.FILTER.CAL_HIGH;
                break;

            }
        }

        this.listfood();
        return super.onOptionsItemSelected(item);
    }

    private void listfood(){

        List<FoodEntity> list = this.mFoodBusiness.getList(this.mFilter);
        this.mViewHolder.mRecyclerFood.setAdapter(new FoodAdapter(list, this.mListener));

    }

    private static class ViewHolder {
        RecyclerView mRecyclerFood;
    }

}