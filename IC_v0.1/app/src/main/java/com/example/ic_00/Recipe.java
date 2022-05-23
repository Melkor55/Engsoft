package com.example.ic_00;

public class Recipe {
    private int id;
    private String username;
    private String name;
    private String description;
    private int cooking_time;

    public Recipe(int id, String username, String name, String description, int cooking_time) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.description = description;
        this.cooking_time = cooking_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCooking_time() {
        return cooking_time;
    }

    public void setCooking_time(int cooking_time) {
        this.cooking_time = cooking_time;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cooking_time=" + cooking_time +
                '}';
    }
}
