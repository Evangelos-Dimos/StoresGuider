package com.example.storesguider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.storesguider.LogInActivity;
import com.example.storesguider.RegisterActivity;


public class MainActivity extends AppCompatActivity {

    String[] item = {"Brunch", "Coffeshop", "Club", "Bar", "Restaurant"};
    String[] item2 = {"Chill", "Casual", "High Class"};
    String[] item3 = {"Athens", "Thessaloniki", "Patra", "Ioannina", "Heraklion", "Volos"};
    String[] item4 = {"House", "Pop", "Hip-hop", "Lounge", "All"};
    String[] item5 = {"18+", "25+", "40+", "Family friendly"};

    Button searchButton;
    Button backButton;

    com.google.android.material.textfield.TextInputLayout type;
    com.google.android.material.textfield.TextInputLayout style;
    com.google.android.material.textfield.TextInputLayout location;
    com.google.android.material.textfield.TextInputLayout music;
    com.google.android.material.textfield.TextInputLayout average_age;
    RadioButton parking;
    RadioButton disabled;
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autoCompleteTextView = findViewById(R.id.autoComplete);
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_item, item);
        autoCompleteTextView.setAdapter(arrayAdapter);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, "item " + item, Toast.LENGTH_SHORT).show();
            }
        });

        autoCompleteTextView = findViewById(R.id.autoComplete2);
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_item, item2);
        autoCompleteTextView.setAdapter(arrayAdapter);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item2 = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, "item " + item2, Toast.LENGTH_SHORT).show();
            }
        });

        autoCompleteTextView = findViewById(R.id.autoComplete3);
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_item, item3);
        autoCompleteTextView.setAdapter(arrayAdapter);

        autoCompleteTextView = findViewById(R.id.autoComplete4);
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_item, item4);
        autoCompleteTextView.setAdapter(arrayAdapter);

        autoCompleteTextView = findViewById(R.id.autoComplete5);
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_item, item5);
        autoCompleteTextView.setAdapter(arrayAdapter);

        /*searchButton = findViewById(R.id.searchButton);
        searchButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openActivity4();
            }
        });

        backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openActivity1();
            }
        });*/
    }
}