package com.example.asus1.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.*;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    
    //账号和密码
    private String username;
    private String password;
    private User user;

    //控件
    private EditText editText;
    private EditText editText2;
    private Button button, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Running!");
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText)findViewById(R.id.editText2);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                username = editText2.getText().toString();
                password = editText.getText().toString();

                OkHttpClient okHttpClient = new OkHttpClient();
                RequestBody formBody = new FormBody.Builder()
                        .add("username", username)
                        .add("password", password)
                        .build();
                Request request = new Request.Builder()
                        .url("http://192.168.43.59:8080/BackEnd/LoginServlet")
                        .post(formBody)
                        .build();
                Call call = okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String res = response.body().string();
                        Gson gson = new Gson();

                        if(res != null) user = gson.fromJson(res, User.class);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                if(user != null && user.id >= 1) {
                                    Toast.makeText(MainActivity.this, "Login Succeed!", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(MainActivity.this, "Login Failed!", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });

                    }
                });


            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = editText2.getText().toString();
                password = editText.getText().toString();


                OkHttpClient okHttpClient = new OkHttpClient();
                RequestBody formBody = new FormBody.Builder()
                        .add("username", username)
                        .add("password", password)
                        .build();
                Request request = new Request.Builder()
                        .url("http://192.168.43.59:8080/BackEnd/RegisterServlet")
                        .post(formBody)
                        .build();
                Call call = okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        ResponseBody body = response.body();

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, "Register Success", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });


                //Toast.makeText(MainActivity.this, "Register Success", Toast.LENGTH_SHORT).show();
            }
        });
    }

    class User {
        public int id;
        public String username;
        public String password;
    }

}
