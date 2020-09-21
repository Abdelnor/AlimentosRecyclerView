package com.example.alimentos.ui.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alimentos.services.listener.OnListClick;
import com.example.alimentos.R;
import com.example.alimentos.entities.FoodEntity;

public class FoodViewHolder extends RecyclerView.ViewHolder {

    private TextView mTextName;
    private TextView mTextCalories;
    private TextView mTextQuantity;
    private TextView mTextUnity;

    private Context mContext;

    public FoodViewHolder(@NonNull View itemView) {
        super(itemView);

        this.mContext = itemView.getContext();

        this.mTextName = itemView.findViewById(R.id.text_name);
        this.mTextCalories = itemView.findViewById(R.id.text_calories);
        this.mTextQuantity = itemView.findViewById(R.id.text_quantity);
        this.mTextUnity = itemView.findViewById(R.id.text_unity);





    }

    public void bind (final FoodEntity food, final OnListClick listener){

        // Atribui os valores para os elementos de interface
        this.mTextName.setText(food.getName());

        String strCalories = String.format("%s %s", food.getCalories(), this.mContext.getString(R.string.caloria));
        this.mTextCalories.setText(strCalories);
        this.mTextQuantity.setText(String.valueOf(food.getQuantity()));
        this.mTextUnity.setText(food.getUnit());




        //Toda linha recebe o evento de clique
        this.mTextName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(food.getId());

            }
        });

    }

}
