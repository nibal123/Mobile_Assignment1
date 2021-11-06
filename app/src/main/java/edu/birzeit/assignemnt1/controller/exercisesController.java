package edu.birzeit.assignemnt1.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import edu.birzeit.assignemnt1.model.Exercise;

public class exercisesController {

    private static ArrayList<Exercise> exercises = new ArrayList<>();

    public exercisesController() {}
    public exercisesController(boolean initializeData) {
        if(exercises.isEmpty()) {
            Exercise exercise1 = new Exercise(1, "Bridge", "Activate your core and posterior chain (a fancy term for the backside of your body) with a bridge. This is a great exercise to use as a warmup.",
                    new ArrayList<>(Arrays.asList("1.Lie on your back with your knees bent, feet flat on the floor, and your arms extended by your sides.", "2.Pushing through your feet and bracing your core, raise your bottom off the ground until your hips are fully extended, squeezing your glutes at the top.", "3.Slowly return to the starting position and repeat.")),
                    "Not needed", "bridge");
            exercises.add(exercise1);
            Exercise exercise2 = new Exercise(2, "Chair squat", "Squat to strengthen your legs and core, which will make everyday movements easier. Starting with a chair underneath you will help you master proper form.",
                    new ArrayList<>(Arrays.asList("1.Stand in front of the chair with your feet shoulder-width apart, toes pointed slightly out.", "2.Hinging at your hips and bending your knees, lower back and down until your bottom touches the chair, allowing your arms to extend out in front of you.", "3.Push up through your heels and return to the starting position.")),
                    "Chair", "chairsquat");
            exercises.add(exercise2);
            Exercise exercise3 = new Exercise(3, "Knee pushup", "A beginner-style pushup, this move will help you build strength before attempting a standard pushup.",
                    new ArrayList<>(Arrays.asList("1.Get into a high plank position from your knees.", "2.Maintaining a straight line from your head to your knees, bend your elbows to lower yourself down to the ground. Keep your elbows at a 45-degree angle.", "3.Push back up to start.")),
                    "Not needed", "kneepushup");
            exercises.add(exercise3);
            Exercise exercise4 = new Exercise(4, "Stationary lunge", "Hit your quads, hamstrings, and glutes with a stationary lunge.",
                    new ArrayList<>(Arrays.asList("1.Split your stance with your right leg in front. Your right foot should be flat on the ground, and your left foot should be up on its toes.", "2.Bend your knees and lunge, stopping when your right thigh is parallel to the ground.","3.Push up through your right foot to return to the starting position. Repeat for desired number of reps, then switch legs.")),
                    "Not needed", "stationarylunge");
            exercises.add(exercise4);
            Exercise exercise5 = new Exercise(5, "Forearm plank", "A full-body exercise that requires strength and balance, planks put the core into overdrive.",
                    new ArrayList<>(Arrays.asList("1.Assume a plank position on your forearms. Your body should form a straight line from head to feet.", "2.Ensure your lower back and hips don’t sag. Hold the position for 30 seconds to 1 minute.")),
                    "Not needed", "forearmplank");
            exercises.add(exercise5);


        }
    }

    public List<Exercise> getExercises(){
        return exercises;
    }

    public List<String> getExercisesNames(){
        return exercises.stream().map(ex ->{
            return ex.getTitle();
        }).collect(Collectors.toList());
    }

    public Exercise getByIndex(int i){
        return exercises.get(i);
    }



}
