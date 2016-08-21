package com.example.juanlopez.newtest.Interface;

import com.example.juanlopez.newtest.Model.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by juanlopez on 8/21/16.
 * email: ljprogra911@gmail.com
 */
public interface InterfaceRest {
    @GET("/jon-hancock-phunware/nflapi-static.json")
    Call<List<Model>> getModel();
}
