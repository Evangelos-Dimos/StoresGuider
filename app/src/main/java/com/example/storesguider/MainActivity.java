package com.example.storesguider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.storesguider.LogInActivity;
import com.example.storesguider.RegisterActivity;
import com.example.storesguider.databinding.ActivityLoginBinding;
import com.example.storesguider.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    String[] item1 = {"Brunch", "Coffeshop", "Club", "Bar", "Restaurant"};
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
    RadioButton radioButton_parking;
    RadioButton radioButton_disabled_access;
    AutoCompleteTextView autoCompleteTextView_type ;
    AutoCompleteTextView autoCompleteTextView_style ;
    AutoCompleteTextView autoCompleteTextView_location ;
    AutoCompleteTextView autoCompleteTextView_music ;
    AutoCompleteTextView autoCompleteTextView_averageAge ;
    ArrayAdapter<String> arrayAdapter;

    StoresDbHelper storeDatabaseHelper;
    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        storeDatabaseHelper= new StoresDbHelper(this);

        Boolean check = storeDatabaseHelper.insertStore("ABC","coffe","casual","skg","hiphop","18+",true,true);

        autoCompleteTextView_type = findViewById(R.id.autoComplete);
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_item, item1);
        autoCompleteTextView_type.setAdapter(arrayAdapter);
        autoCompleteTextView_type.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, "You select the type: " + item, Toast.LENGTH_SHORT).show();
            }
        });

        autoCompleteTextView_style = findViewById(R.id.autoComplete2);
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_item, item2);
        autoCompleteTextView_style.setAdapter(arrayAdapter);
        autoCompleteTextView_style.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item2 = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, "You select the style: " + item2, Toast.LENGTH_SHORT).show();
            }
        });

        autoCompleteTextView_location = findViewById(R.id.autoComplete3);
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_item, item3);
        autoCompleteTextView_location.setAdapter(arrayAdapter);
        autoCompleteTextView_location.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item3 = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, "You select the location: " + item3, Toast.LENGTH_SHORT).show();
            }
        });

        autoCompleteTextView_music = findViewById(R.id.autoComplete4);
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_item, item4);
        autoCompleteTextView_music.setAdapter(arrayAdapter);
        autoCompleteTextView_music.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item4 = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, "You select the music: " + item4, Toast.LENGTH_SHORT).show();
            }
        });

        autoCompleteTextView_averageAge = findViewById(R.id.autoComplete5);
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_item, item5);
        autoCompleteTextView_averageAge.setAdapter(arrayAdapter);
        autoCompleteTextView_averageAge.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item5 = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, "You select the age: " + item5, Toast.LENGTH_SHORT).show();
            }
        });

        //RadioButton Parking
        radioButton_parking = findViewById(R.id.parking);
        radioButton_parking.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "Parking is checked ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //RadioButton
        radioButton_disabled_access = findViewById(R.id.disabled_access);
        radioButton_disabled_access.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "Access for disabled people is checked ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type;
                String style;
                String location;
                String music;
                String averageAge;
                boolean parking;
                boolean disablePeople;

                int i = autoCompleteTextView_type.getListSelection();
                type = item1[i];

                int j = autoCompleteTextView_style.getListSelection();
                style = item2[j];

                int k = autoCompleteTextView_location.getListSelection();
                location = item3[k];

                int z = autoCompleteTextView_music.getListSelection();
                music = item4[z];

                int l = autoCompleteTextView_averageAge.getListSelection();
                averageAge = item5[l];

                parking = radioButton_parking.isChecked();
                disablePeople = radioButton_disabled_access.isChecked();

                //storeDatabaseHelper.searchStores(type,style,location,music,averageAge,parking,disablePeople);
            }
        });

    }

    /*public void findStores(View view){
        StoresDbHelper dataBase= new StoresDbHelper(this);
        String type;
        String style;
        String location;
        String music;
        String averageAge;
        boolean parking;
        boolean disablePeople;

        int i = autoCompleteTextView_type.getListSelection();
        type = item1[i];

        int j = autoCompleteTextView_style.getListSelection();
        style = item2[j];

        int k = autoCompleteTextView_location.getListSelection();
        location = item3[k];

        int z = autoCompleteTextView_music.getListSelection();
        music = item4[z];

        int l = autoCompleteTextView_averageAge.getListSelection();
        averageAge = item5[l];

        parking = radioButton_parking.isChecked();
        disablePeople = radioButton_disabled_access.isChecked();

        dataBase.searchStores(type,style,location,music,averageAge,parking,disablePeople);
        //εδώ θα επιστρέφονται τα αποτελέσματα της και ανάλογα θα το συνδέσουμε με το 4 activity
    }*/


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
