package com.codesorcery.zaeev20.Models;

/**
 * Created by Khant Naing Set on 3/23/2017.
 */

public class CurencyExchangeRates {
    private String info;
    private String description;
    private String timestamp;
    private Rates rates;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Rates getRates() {
        return rates;
    }

    public void setRates(Rates rates) {
        this.rates = rates;
    }

    public CurencyExchangeRates(String description, String info, Rates rates, String timestamp) {
        this.description = description;
        this.info = info;
        this.rates = rates;
        this.timestamp = timestamp;
    }
}
