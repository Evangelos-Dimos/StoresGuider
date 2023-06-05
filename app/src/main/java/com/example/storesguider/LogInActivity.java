package com.example.storesguider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.storesguider.databinding.ActivityLoginBinding;

public class LogInActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    UserDbHelper userDatabaseHelper;
    Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        userDatabaseHelper = new UserDbHelper(this);

        binding.loginButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String username = binding.username.getText().toString();
                String password = binding.password.getText().toString();
                if (username.equals("") || password.equals(""))
                    Toast.makeText(LogInActivity.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkCredentials = userDatabaseHelper.checkUsernamePassword(username, password);
                    if (checkCredentials == true) {
                        Toast.makeText(LogInActivity.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LogInActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        binding.registerButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });

    }

}