package edu.birzeit.assignemnt1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import edu.birzeit.assignemnt1.controller.userController;
import edu.birzeit.assignemnt1.model.Exercise;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String userName =prefs.getString("userName","");
        Gson gson = new Gson();
        List<Exercise> list = gson.fromJson(prefs.getString(userName+"list",""),   new TypeToken<List<Exercise>>() {
        }.getType());
        if(list !=null)
        userController.setExerciseList(list);
        else
            userController.setExerciseList(new ArrayList<>());
    }
    public void showAll_click(View view) {
        Intent intent = new Intent(this,AllExercises.class);
        startActivity(intent);
    }
    public void showUserEx_click(View view){
        Intent intent = new Intent(this,UserExerActivity.class);
        startActivity(intent);
    }

    public void btnStopWatch_click(View view){
        Intent intent = new Intent(this,StopWatchActivity.class);
        startActivity(intent);
    }

}