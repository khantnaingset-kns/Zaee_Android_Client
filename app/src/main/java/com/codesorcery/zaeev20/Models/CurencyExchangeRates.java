package com.codesorcery.zaeev20.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Khant Naing Set on 3/23/2017.
 */
@Data
public class CurencyExchangeRates {

    private String info;
    private String description;
    private String timestamp;
    private Rates rates[];


}
