package com.codesorcery.zaeev20.UICompoents;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codesorcery.zaeev20.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Khant Naing Set on 3/30/2017.
 */

public class CurrencyExchangeRatesRVAdapter extends RecyclerView.Adapter<CurrencyExchangeRatesRVAdapter.MyViewHolder>{


    public List<String> currency;
    public List<String> rate;
    Context context;

    public CurrencyExchangeRatesRVAdapter(Context context, List<String> currency, List<String> rate) {
        this.context = context;
        this.currency = currency;
        this.rate = rate;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.currencyexchange_rv_view,parent,false);
        return new MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.Bind(currency,rate,position);
    }



    @Override
    public int getItemCount() {
       return rate.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        @Bind(R.id.currency)
        TextView currencytxt;
        @Bind(R.id.rate)
        TextView ratetxt;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void Bind(final List<String> currency, List<String> rate,int position){
            currencytxt.setText(currency.get(position));
            ratetxt.setText(rate.get(position));

        }
    }
}
