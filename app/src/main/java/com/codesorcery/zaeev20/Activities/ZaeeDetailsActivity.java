package com.codesorcery.zaeev20.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import com.codesorcery.zaeev20.R;
import com.squareup.picasso.Picasso;

import butterknife.Bind;

public class ZaeeDetailsActivity extends AppCompatActivity {

    @Bind(R.id.zaees_detail_prices)
    ImageView zaeePrices;
    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zaee_details);
        String value = getIntent().getStringExtra("Type");

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        if (value.equals("Rice")) {
            zaeePrices.setImageResource(R.drawable.rice_prices_img);
            //Picasso.with(getApplicationContext()).load(R.drawable.rice_prices_img).into(zaeePrices);
        } else if (value.equals("Oil")) {
            zaeePrices.setImageResource(R.drawable.oil_prices_img);
            //Picasso.with(getApplicationContext()).load(R.drawable.rice_prices_img).into(zaeePrices);
        }
        if (value.equals("Onion")) {
            zaeePrices.setImageResource(R.drawable.onion_prices_img);
            //Picasso.with(getApplicationContext()).load(R.drawable.rice_prices_img).into(zaeePrices);
        }
        if (value.equals("Garlic")) {
            zaeePrices.setImageResource(R.drawable.garlic_prices_img);
            //Picasso.with(getApplicationContext()).load(R.drawable.rice_prices_img).into(zaeePrices);
        }
        if (value.equals("Pepper")) {
            zaeePrices.setImageResource(R.drawable.pepper_prices_img);
            //Picasso.with(getApplicationContext()).load(R.drawable.rice_prices_img).into(zaeePrices);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }

}
