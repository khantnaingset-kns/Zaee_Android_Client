package com.codesorcery.zaeev20.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;


/**
 * Created by Khant Naing Set on 3/23/2017.
 */
@Data
public class CurencyExchangeRates {

    @SerializedName("info")
    @Expose
    private String info;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("rates")
    @Expose
    private Rates rates;


}
