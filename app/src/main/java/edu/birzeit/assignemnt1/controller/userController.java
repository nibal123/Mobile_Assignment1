package edu.birzeit.assignemnt1.controller;


import java.util.List;

import edu.birzeit.assignemnt1.model.Exercise;


public class userController {
     private static List<Exercise> userExerciseList;

    public static void setExerciseList(List<Exercise> list){
        userController.userExerciseList = list;
    }
    public static List<Exercise> getUserExerciseList(){
        return userController.userExerciseList;
    }

    public static boolean addUserExercises(Exercise exercise){
        if(userController.userExerciseList!=null && userController.userExerciseList.stream().anyMatch(ex->ex.getId() == exercise.getId()))
            return false;
        userController.userExerciseList.add(exercise);
        return true;

    }
    public static  List <Exercise> deleteUserExercise(Exercise e){
        userController.userExerciseList.removeIf(ex-> ex.getId() == e.getId());
        return userController.userExerciseList;
    }




}
