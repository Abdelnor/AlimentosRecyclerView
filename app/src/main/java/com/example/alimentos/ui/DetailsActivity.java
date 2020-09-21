package com.example.alimentos.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.alimentos.R;
import com.example.alimentos.services.business.FoodBusiness;
import com.example.alimentos.services.constants.FoodConstants;
import com.example.alimentos.entities.FoodEntity;

public class DetailsActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        if(getSupportActionBar() != null){
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


        this.mViewHolder.mTextName = findViewById(R.id.text_name);
        this.mViewHolder.mTextCalories = findViewById(R.id.text_calories);
        this.mViewHolder.mTextQuantity = findViewById(R.id.text_quantity);
        this.mViewHolder.mTextUnidade = findViewById(R.id.text_unidade);
        this.mViewHolder.mTextDescription = findViewById(R.id.text_description);

        this.getData();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private void getData() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int id = bundle.getInt(FoodConstants.FOOD_ID);
            FoodEntity foodEntity = new FoodBusiness().get(id);

            this.mViewHolder.mTextName.setText(foodEntity.getName());
            this.mViewHolder.mTextQuantity.setText(String.valueOf(foodEntity.getQuantity()));
            this.mViewHolder.mTextUnidade.setText(foodEntity.getUnit());

            String strCalories = String.format("%s %s", foodEntity.getCalories(), this.getString(R.string.caloria));
            this.mViewHolder.mTextCalories.setText(strCalories);

            if(!"".equals(foodEntity.getDescription())){
                this.mViewHolder.mTextDescription.setText(foodEntity.getDescription());
            }



        }
    }


    private static class ViewHolder {
        TextView mTextName;
        TextView mTextCalories;
        TextView mTextQuantity;
        TextView mTextUnidade;
        TextView mTextDescription;

    }

}