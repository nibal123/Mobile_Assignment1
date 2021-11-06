package edu.birzeit.assignemnt1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.List;
import java.util.stream.Collectors;

import edu.birzeit.assignemnt1.controller.exercisesController;
import edu.birzeit.assignemnt1.controller.userController;
import edu.birzeit.assignemnt1.model.Exercise;
import edu.birzeit.assignemnt1.model.User;

public class WorkoutActivity extends AppCompatActivity {
    TextView title;
    TextView desc;
    TextView equip;
    TextView dir;
    ImageView image;
    Button delete;
    Button add;
    int index;
    Exercise exercise;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
        exercisesController exercisesController = new exercisesController();
        Intent intent= getIntent();
         index=intent.getIntExtra("WorkoutIndex",1);
        boolean isUserWorkout = intent.getBooleanExtra("UserWorkout",false);
        add = findViewById(R.id.button_add);
        delete = findViewById(R.id.button_delete);
        if(!isUserWorkout){
            delete.setVisibility(View.GONE);
        }
        else{
            delete.setVisibility(View.VISIBLE);
            add.setVisibility(View.GONE);
        }
         if(isUserWorkout)
             exercise=userController.getUserExerciseList().get(index);
             else
             exercise = exercisesController.getByIndex(index);
        image=findViewById(R.id.image_workout);
        int resID = getResources().getIdentifier(exercise.getImage(), "drawable",  getPackageName());
        image.setImageResource(resID);
        title=findViewById(R.id.textView_title);
        title.setText(exercise.getTitle());
        desc=findViewById(R.id.textView_allDesc);
        desc.setText(exercise.getDescription());
        equip=findViewById(R.id.textView_allEquip);
        equip.setText(exercise.getEquipments());
        dir=findViewById(R.id.textView_allDir);
        String directions = exercise.getDirections().stream().map(d ->{
            return d+"\n";
        }).collect(Collectors.joining());
        dir.setText(directions);
    }

    public void add_click(View view){
        if(userController.addUserExercises(exercise)) {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
            String userName = prefs.getString("userName", "");
            SharedPreferences.Editor editor = prefs.edit();
            Gson gson = new Gson();
            String ListString = gson.toJson(userController.getUserExerciseList());
            editor.putString(userName+"list", ListString);
            editor.commit();
            Toast.makeText(this, "Added Successfully", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "This exercise is already added", Toast.LENGTH_SHORT).show();
        }



    }
    public void delete_click(View view){
        userController.deleteUserExercise(exercise);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String userName = prefs.getString("userName", "");
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String ListString = gson.toJson(userController.getUserExerciseList());
        editor.putString(userName+"list", ListString);
        editor.commit();
        Toast.makeText(this, "Deleted Successfully", Toast.LENGTH_SHORT).show();
        finish();

    }
}