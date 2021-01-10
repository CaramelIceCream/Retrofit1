package com.example.retrofit;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView textViewResult;
    private Button button;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.myButton);
        textViewResult = findViewById(R.id.text_view_result);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.106:8080")
  //              .baseUrl("http://10.0.2.2:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Employees employees = retrofit.create(Employees.class);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Call<Post> call = employees.getPost(editText.getText().toString());

                call.enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(Call<Post> call, Response<Post> response) {

                        if (!response.isSuccessful()) {
                            textViewResult.setText("Code: " + response.code());
                            return;
                        }

                        Post post = response.body();

                        String content = "";
                        content += "ID: " + post.getId() + "\n";
                        content += "First Name: " + post.getFirstName() + "\n";
                        content += "Last Name: " + post.getLastName() + "\n";
                        content += "Role: " + post.getRole() + "\n";
                        content += "Full Name: " + post.getName() + "\n";
                        content += "\n";
                        content += "\n";


                        textViewResult.append(content);
                    }


                    @Override
                    public void onFailure(Call<Post> call, Throwable t) {

                        textViewResult.setText(t.getMessage());
                    }
                });
            }
        });


    }
}