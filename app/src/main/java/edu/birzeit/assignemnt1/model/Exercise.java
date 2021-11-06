package edu.birzeit.assignemnt1.model;

import java.util.List;

public class Exercise {
    int id;
    String title;
    String description;
    List<String> directions;
    String equipments;
    String image;

    public Exercise(int id, String title, String description, List<String> directions, String equipments, String image) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.directions = directions;
        this.equipments = equipments;
        this.image = image;
    }

    public List<String> getDirections() {
        return directions;
    }

    public void setDirections(List<String> directions) {
        this.directions = directions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEquipments() {
        return equipments;
    }

    public void setEquipments(String equipments) {
        this.equipments = equipments;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
