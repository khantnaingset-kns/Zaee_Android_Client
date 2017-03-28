package com.codesorcery.zaeev20.Network;

import com.codesorcery.zaeev20.Models.CurencyExchangeRates;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Khant Naing Set on 3/28/2017.
 */

public class ForexAPIController implements Callback<CurencyExchangeRates> {

    public static final String baseURL = "http://forex.cbm.gov.mm";


    public void Start() {
        Gson gson = new GsonBuilder()
                .setDateFormat("dd-MM-yyyy'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        ForexAPI forexAPI = retrofit.create(ForexAPI.class);
        Call<CurencyExchangeRates> call = forexAPI.getResponseBody("latest");
        call.enqueue(this);

    }


    @Override
    public void onResponse(Call<CurencyExchangeRates> call, Response<CurencyExchangeRates> response) {

    }

    @Override
    public void onFailure(Call<CurencyExchangeRates> call, Throwable t) {

    }
}
