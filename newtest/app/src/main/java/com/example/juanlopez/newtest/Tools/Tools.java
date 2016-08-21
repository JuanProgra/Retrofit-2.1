package com.example.juanlopez.newtest.Tools;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * Created by juanlopez on 8/21/16.
 * email: ljprogra911@gmail.com
 */
public class Tools {

    public boolean isOnline(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
            Log.e("networkInfo","true");
            return true;
        } else {
            Log.e("networkInfo","false");
            return false;
        }
    }
}
