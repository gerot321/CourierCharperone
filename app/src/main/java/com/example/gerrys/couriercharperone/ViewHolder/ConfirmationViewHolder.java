package com.example.gerrys.couriercharperone.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.gerrys.couriercharperone.Interface.ItemClickListener;
import com.example.gerrys.couriercharperone.R;


public class ConfirmationViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView txtOrderId;

    private ItemClickListener itemClickListener;

    public ConfirmationViewHolder(View itemView) {
        super(itemView);

        txtOrderId = (TextView)itemView.findViewById(R.id.order_id);

        itemView.setOnClickListener(this);

    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v, getAdapterPosition(), false);
    }
}
