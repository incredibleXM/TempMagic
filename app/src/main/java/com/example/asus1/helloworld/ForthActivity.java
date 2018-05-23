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

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ForthActivity extends AppCompatActivity {

    private EditText tx1, tx2, tx3;
    private Button bt3, bt4;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_forth);

        bt3 = (Button) findViewById(R.id.button3);
        bt4 = (Button) findViewById(R.id.button4);
        tx1 = (EditText) findViewById(R.id.input1);
        tx2 = (EditText) findViewById(R.id.input2);
        tx3 = (EditText) findViewById(R.id.input3);

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tx1.getText().toString().equals(tx2.getText().toString())) {

                    //left to be continued
                    String username = tx3.getText().toString();
                    String password = tx1.getText().toString();

                    OkHttpClient okHttpClient = new OkHttpClient();
                    RequestBody formBody = new FormBody.Builder()
                            .add("username", username)
                            .add("password", password)
                            .build();
                    Request request = new Request.Builder()
                            .url("http://192.168.43.59:8080/BackEnd/ChangeServlet")
                            .post(formBody)
                            .build();
                    Call call = okHttpClient.newCall(request);
                    call.enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {

                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {

                                    Toast.makeText(ForthActivity.this, "Successful Modification!", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(ForthActivity.this, SecondActivity.class);
                                    startActivity(intent);

                                }
                            });

                        }
                    });

                } else {
                    Toast.makeText(ForthActivity.this, "Different Input!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForthActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

    }

    class User {
        public int id;
        public String username;
        public String password;
    }
}
