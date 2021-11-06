package edu.birzeit.assignemnt1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.List;
import java.util.stream.Collectors;

import edu.birzeit.assignemnt1.controller.userController;
import edu.birzeit.assignemnt1.model.Exercise;
import edu.birzeit.assignemnt1.model.User;

public class UserExerActivity extends AppCompatActivity {
        ListView listUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_exer);

        LoadListItems();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LoadListItems();
    }

    private void LoadListItems(){
        listUser = findViewById(R.id.listView_user);
        ArrayAdapter<String> arr;
        List <Exercise> l=userController.getUserExerciseList();
        arr = new ArrayAdapter<String>(
                this,
                R.layout.simple_list_item_checked,
                l.stream().map(ex-> {return ex.getTitle();}).collect(Collectors.toList())
        );
        listUser.setAdapter(arr);
        listUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(UserExerActivity.this, WorkoutActivity.class);
                intent.putExtra("WorkoutIndex",i);
                intent.putExtra("UserWorkout",true);
                startActivity(intent);
            }
        });
    }

    }