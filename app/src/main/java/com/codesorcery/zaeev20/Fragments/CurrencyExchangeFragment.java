package com.codesorcery.zaeev20.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codesorcery.zaeev20.UICompoents.CurrencyExchangeRatesRVAdapter;
import com.codesorcery.zaeev20.Network.ForexAPI;
import com.codesorcery.zaeev20.R;
import com.codesorcery.zaeev20.UICompoents.DividerItemDecoration;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


/**
 * A simple {@link Fragment} subclass.
 */
public class CurrencyExchangeFragment extends Fragment implements Callback<ResponseBody>{

    @Bind(R.id.currency_exchange_rv_view)
    RecyclerView cxRecyclerView;

    private CurrencyExchangeRatesRVAdapter mCurrencyExchangeRatesRVAdapter;
    private List<String> currency = new ArrayList<>();
    private List<String> rate = new ArrayList<>();



    public static final String baseURL = "http://forex.cbm.gov.mm";
    public CurrencyExchangeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCurrencyExchangeRatesRVAdapter = new CurrencyExchangeRatesRVAdapter(getContext(),currency,rate);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v=  inflater.inflate(R.layout.fragment_currency_exchange, container, false);
        ButterKnife.bind(this,v);
        cxRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        cxRecyclerView.setItemAnimator(new DefaultItemAnimator());
        cxRecyclerView.setAdapter(mCurrencyExchangeRatesRVAdapter);
        cxRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(),LinearLayoutManager.VERTICAL));
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .build();
        ForexAPI forexAPI = retrofit.create(ForexAPI.class);
        Call<ResponseBody> call = forexAPI.getResponseBody("latest");
        call.enqueue(this);
        return v;
    }



    @Override
    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        if(response.isSuccessful()) {
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
                Map<String, String> rates = new HashMap<String, String>();
                rates = objectMapper.readValue(inode.toString(), new TypeReference<HashMap<String, String>>() {
                });
                for(String key: rates.keySet()){
                    currency.add(key);
                }
                for (Map.Entry<String,String> entry:rates.entrySet()){
                    rate.add(entry.getValue());
                }
                mCurrencyExchangeRatesRVAdapter.notifyDataSetChanged();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onFailure(Call<ResponseBody> call, Throwable t) {

    }

}
