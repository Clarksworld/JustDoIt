package com.clarkson.clarksworld.andelatestview.coinadapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.clarkson.clarksworld.andelatestview.ConversionActivityBitcoin;
import com.clarkson.clarksworld.andelatestview.Utils;
import com.clarkson.clarksworld.andelatestview.model.Currency;
import com.clarkson.clarksworld.andelatestview.R;

import java.util.ArrayList;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    private Context mContext;
    private ArrayList<Currency> mList;


    public MyAdapter(Context mContext, ArrayList<Currency> mList) {

        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_ethereum, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Currency currency = mList.get(position);
        holder.currencyName.setText(currency.getName()+"\n" + currency.getRate());
        Glide.with(mContext).load(new Utils().getImageId(currency.getName())).into(holder.currencyImage);
    }

    @Override
    public int getItemCount() {

        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
         TextView currencyName;
        ImageView currencyImage;

        public ViewHolder(View itemView) {
            super(itemView);
             currencyImage = itemView.findViewById(R.id.flag_image_view);
            currencyName = itemView.findViewById(R.id.currency_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Currency currency= mList.get(getAdapterPosition());
                    Context context = view.getContext();
                    Intent intent = new Intent(context, ConversionActivityBitcoin.class);
                    intent.putExtra(ConversionActivityBitcoin.EXTRA_POSITION, getAdapterPosition());
                    intent.putExtra("currency_rate", currency.getRate());
                    context.startActivity(intent);
                }
            });
        }
    }
}
