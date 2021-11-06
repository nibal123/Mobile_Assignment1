package edu.birzeit.assignemnt1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import edu.birzeit.assignemnt1.controller.exercisesController;

public class AllExercises extends AppCompatActivity {
    ListView ListAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        exercisesController exercisesController = new exercisesController(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_exercises);
        ListAll = findViewById(R.id.list_All);
        ArrayAdapter<String> arr;
        arr = new ArrayAdapter<String>(
                this,
                R.layout.simple_list_item_checked,
                exercisesController.getExercisesNames()
                );
        ListAll.setAdapter(arr);
        ListAll.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(AllExercises.this, WorkoutActivity.class);
                intent.putExtra("WorkoutIndex",i);
                intent.putExtra("UserWorkout",false);
                startActivity(intent);
            }
        });
    }
}