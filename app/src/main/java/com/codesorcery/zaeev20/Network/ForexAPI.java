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
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Khant Naing Set on 3/28/2017.
 */



public interface ForexAPI {

    @GET("/api/{value}")
    Call<CurencyExchangeRates> getResponseBody(@Path("value") String value);

}
