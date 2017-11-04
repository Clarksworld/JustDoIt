package com.clarkson.clarksworld.andelatestview.interfaces;

import com.clarkson.clarksworld.andelatestview.CurrencyExchange;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by davidson on 10/30/17.
 */

public interface ExchangeService {
    @GET("data/price?")
    Call<CurrencyExchange> loadCurrencyExchange(@Query("fsym") String coins, @Query("tsyms") String currency);
}
