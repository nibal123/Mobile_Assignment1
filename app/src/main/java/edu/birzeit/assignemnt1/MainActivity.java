package edu.birzeit.assignemnt1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;

import edu.birzeit.assignemnt1.controller.userController;
import edu.birzeit.assignemnt1.model.User;

public class MainActivity extends AppCompatActivity {
    private Spinner genderSpinner;
    private EditText nameEditText;
    private EditText ageEditText;
    private CheckBox rememberCheck;
    ArrayList<String> genderList = new ArrayList<String>(Arrays.asList("Female","Male"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        setContentView(R.layout.activity_main);
        nameEditText=findViewById(R.id.nameEditText);
        ageEditText=findViewById(R.id.ageEditText);
        genderSpinner=findViewById(R.id.genderSpinner);
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,genderList);
        genderSpinner.setAdapter(adp);
        rememberCheck=findViewById(R.id.rememberCheckBox);
        if(prefs.getBoolean("rememberMe",false)) {
            Gson gson = new Gson();
            String userStr = prefs.getString("user", "");
            User user = gson.fromJson(userStr, User.class);
            nameEditText.setText(user.getName());
            ageEditText.setText(user.getAge()+"");
            rememberCheck.setChecked(true);
            genderSpinner.setSelection(genderList.indexOf(user.getGender()));
        }
        else{
            nameEditText.setText("");
            ageEditText.setText("");
            rememberCheck.setChecked(false);

        }


    }


    public void loginBtn_click(View view){
        nameEditText=findViewById(R.id.nameEditText);
        ageEditText=findViewById(R.id.ageEditText);
        genderSpinner=findViewById(R.id.genderSpinner);
        rememberCheck=findViewById(R.id.rememberCheckBox);
        String name = nameEditText.getText().toString();
        int age = Integer.parseInt(ageEditText.getText().toString());
        String gender = genderSpinner.getSelectedItem().toString();
        boolean remember = rememberCheck.isChecked();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        if(remember){
            editor.putBoolean("rememberMe", true);
            Gson gson = new Gson();
            User user = new User(name,gender,age);
            String userString = gson.toJson(user);
            editor.putString("user", userString);
            editor.putString("userName", user.getName());
            editor.commit();

        }
        else{
            editor.putBoolean("rememberMe", false);
            editor.commit();
        }
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);


    }

}