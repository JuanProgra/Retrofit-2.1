package com.example.juanlopez.newtest.Rest;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by juanlopez on 8/21/16.
 * email: ljprogra911@gmail.com
 */
public class ServiceGenerator {
    public static final String API_URL_BASE = "https://s3.amazonaws.com/";

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Retrofit.Builder builder
            =
            new Retrofit.Builder()
                    .baseUrl(API_URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass){
        Retrofit retrofit = builder.client(httpClient.build()).build();
        return retrofit.create(serviceClass);
    }

}
