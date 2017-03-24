package com.codesorcery.zaeev20.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.codesorcery.zaeev20.Activities.ZaeeDetailsActivity;
import com.codesorcery.zaeev20.R;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class ZaeesFragment extends Fragment {

    ImageView ricePrices,oilPrices,garlicPrices,pepperPrices,onionPrices;
    SliderLayout sliderLayout;

    public ZaeesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_zaees, container, false);
        initSlider(v);
        ImagesClickEvents(v);

        return v;
    }



    private void ImagesClickEvents(View v){
        ricePrices = (ImageView) v.findViewById(R.id.rice_prices);
        ricePrices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(),ZaeeDetailsActivity.class);
                i.putExtra("Type","Rice");
                startActivity(i);
            }
        });

        oilPrices = (ImageView) v.findViewById(R.id.oil_prices);
        oilPrices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(),ZaeeDetailsActivity.class);
                i.putExtra("Type","Oil");
                startActivity(i);
            }
        });

        onionPrices = (ImageView) v.findViewById(R.id.onion_prices);
        onionPrices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(),ZaeeDetailsActivity.class);
                i.putExtra("Type","Onion");
                startActivity(i);
            }
        });

        garlicPrices = (ImageView) v.findViewById(R.id.garlic_prices);
        garlicPrices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(),ZaeeDetailsActivity.class);
                i.putExtra("Type","Garlic");
                startActivity(i);
            }
        });

        pepperPrices = (ImageView) v.findViewById(R.id.pepper_prices);
        pepperPrices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(),ZaeeDetailsActivity.class);
                i.putExtra("Type","Pepper");
                startActivity(i);
            }
        });

    }

    private void initSlider(View v){
        sliderLayout = (SliderLayout) v.findViewById(R.id.slider);
        TextSliderView textSliderView = new TextSliderView(getContext());
        textSliderView.description("Tranding Fruit").image("http://www.cayennediane.com/wp-content/uploads/Ghost-Peppers.jpg");
        sliderLayout.addSlider(textSliderView);
    }

}
