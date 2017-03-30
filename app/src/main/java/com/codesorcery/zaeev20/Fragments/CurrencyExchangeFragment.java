package com.codesorcery.zaeev20.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.codesorcery.zaeev20.Models.CurencyExchangeRates;
import com.codesorcery.zaeev20.Network.ForexAPI;
import com.codesorcery.zaeev20.R;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Request;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class CurrencyExchangeFragment extends Fragment{
    @Bind(R.id.txt_usd)
    TextView usdRate;
    @Bind(R.id.txt_pkr)
    TextView pkrRate;
    @Bind(R.id.txt_thb)
    TextView thbRate;




    public static final String baseURL = "http://forex.cbm.gov.mm";
    public CurrencyExchangeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v=  inflater.inflate(R.layout.fragment_currency_exchange, container, false);
        ButterKnife.bind(v);
        //Picasso.with(getContext()).load(R.drawable.bank_img).resize(500,500).into(bankimg);
        Callback<ResponseBody> curencyExchangeRatesCallback = new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){
                   byte[] jsonData = null;
                    try {
                        jsonData = response.body().bytes();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    ObjectMapper objectMapper = new ObjectMapper();
                    try {
                        JsonNode jsonNode = objectMapper.readTree(jsonData);
                        JsonNode inode = jsonNode.path("rates");
                        Map<String,String> rates = new HashMap<String,String>();
                        rates = objectMapper.readValue(inode.toString(), new TypeReference<HashMap<String,String>>(){});
                        Log.d("Json Node",rates.get("PKR").toString());


                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        };

        this.StartAPICall(curencyExchangeRatesCallback);
        return v;
    }

    public void StartAPICall(Callback<ResponseBody> ratesCallback) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .build();
        ForexAPI forexAPI = retrofit.create(ForexAPI.class);
        Call<ResponseBody> call = forexAPI.getResponseBody("latest");
        call.enqueue(ratesCallback);

    }

//    @Override
//    public void onResponse(Call<CurencyExchangeRates> call, Response<CurencyExchangeRates> response) {
//
//
//        if(response.isSuccessful()){
//            CurencyExchangeRates curencyExchangeRates = response.body();
//
//        }
//
//
//    }
//
//    @Override
//    public void onFailure(Call<CurencyExchangeRates> call, Throwable t) {
//
//    }
}
