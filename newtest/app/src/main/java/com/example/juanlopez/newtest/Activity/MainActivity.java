package com.example.juanlopez.newtest.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.juanlopez.newtest.Interface.InterfaceRest;
import com.example.juanlopez.newtest.Model.Model;
import com.example.juanlopez.newtest.R;
import com.example.juanlopez.newtest.Rest.ServiceGenerator;
import com.example.juanlopez.newtest.Tools.Tools;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Model> data = new ArrayList<>();
    static List<Model> modelArrayList;
    private Tools tools;
    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tools = new Tools();
        modelArrayList = new ArrayList<>();

        textView = (TextView)findViewById(R.id.textView);
        imageView = (ImageView) findViewById(R.id.imageView);

        if (!tools.isOnline(this)){
            Toast.makeText(this, "Verifique su acceso a internet", Toast.LENGTH_SHORT).show();
        }else {
            InterfaceRest interfaceRest = ServiceGenerator.createService(InterfaceRest.class);
            Call<List<Model>> modelCall = interfaceRest.getModel();
            modelCall.enqueue(new Callback<List<Model>>() {
                @Override
                public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                    modelArrayList = response.body();
                    for (int i = 0; i < modelArrayList.size(); i++) {
                        Model model = new Model();
                        model.setId(response.body().get(i).getId());
                        model.setName(response.body().get(i).getName());
                        model.setImage_url(response.body().get(i).getImage_url());
                        data.add(model);
                    }
                    if (data.size() > 0){
                        textView.setText(data.get(1).getName());
                        Picasso.with(getBaseContext()).load(data.get(1).getImage_url()).into(imageView);
                    }
                }

                @Override
                public void onFailure(Call<List<Model>> call, Throwable t) {
                    Log.e("onFailure",t.toString());
                }
            });
        }
    }
}
