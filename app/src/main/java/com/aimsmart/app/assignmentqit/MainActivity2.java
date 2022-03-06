package com.aimsmart.app.assignmentqit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity2 extends AppCompatActivity {
    RecyclerView recyclerView;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    RecyclerAdapter adapter;
    List<String> list;
    Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recyclerView = findViewById(R.id.recycle1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        logout = findViewById(R.id.logout);
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://newsapi.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        dataAPI dataAPI =  retrofit.create(dataAPI.class);
        Call<data1> call = dataAPI.getdata();
        call.enqueue(new Callback<data1>() {
            @Override
            public void onResponse(Call<data1> call, Response<data1> response) {
                if(!response.isSuccessful()){
                    Log.i("TAG", "onFailure: Main2" + response.code());
                    return;
                }
                Log.i("TAG12", "onSuc: Main2" + response.message());
                data1 data = response.body();
//                Toast.makeText(MainActivity2.this, response.code(), Toast.LENGTH_SHORT).show();
                adapter = new RecyclerAdapter(MainActivity2.this,data.getData());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<data1> call, Throwable t) {
                Log.i("TAG", "onFailure: Main2" + t.getMessage());
                Toast.makeText(MainActivity2.this, " failed:" + t.getMessage()  , Toast.LENGTH_SHORT).show();
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                startActivity(new Intent(MainActivity2.this,MainActivity.class));
                finish();
            }
        });
    }
}