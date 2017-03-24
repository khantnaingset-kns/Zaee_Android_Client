package com.codesorcery.zaeev20.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.codesorcery.zaeev20.R;
import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class CurrencyExchangeFragment extends Fragment {

    ImageView bankimg;
    public CurrencyExchangeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=  inflater.inflate(R.layout.fragment_currency_exchange, container, false);
        bankimg = (ImageView) v.findViewById(R.id.bankimg);
        Picasso.with(getContext()).load(R.drawable.bank_img).resize(500,500).into(bankimg);
        return v;
    }

}
