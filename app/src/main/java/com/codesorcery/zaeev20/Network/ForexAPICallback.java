package com.codesorcery.zaeev20.Network;

/**
 * Created by Khant Naing Set on 4/5/2017.
 */

public interface ForexAPICallback {

    void getTimeStamp(int timestamp);
    void onError();
}
