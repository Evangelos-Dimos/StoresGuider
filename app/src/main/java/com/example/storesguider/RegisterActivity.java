package com.example.storesguider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.storesguider.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {

    ActivityRegisterBinding binding;
    UserDbHelper userDatabaseHelper;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        userDatabaseHelper = new UserDbHelper(this);

        binding.doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = binding.username.getText().toString();
                String password = binding.password.getText().toString();
                String email = binding.email.getText().toString();
                String phoneNumber = binding.phoneNumber.getText().toString();

                if (username.equals("") || password.equals("") || email.equals("") || phoneNumber.equals("")) {
                    Toast.makeText(RegisterActivity.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                } else
                {
                    Boolean checker = userDatabaseHelper.checkUsername(username);
                    if (checker == false) {
                        Boolean insert = userDatabaseHelper.insertData(username, password);
                        if (insert == true) {
                            Toast.makeText(RegisterActivity.this, "Register Successfully!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), LogInActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(RegisterActivity.this, "Register Failed!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(RegisterActivity.this, "Username already exists!", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        binding.backButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(), LogInActivity.class);
                startActivity(intent);
            }
        });

    }
}