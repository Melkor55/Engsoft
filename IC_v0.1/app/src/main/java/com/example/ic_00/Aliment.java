package com.example.ic_00;

public class Aliment {
    private int id;
    private String aliment;


    public Aliment(int id, String aliment) {
        this.id = id;
        this.aliment = aliment;

    }

    public int getId() {
        return id;
    }

    public String getAliment() {
        return aliment;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAliment(String aliment) {
        this.aliment = aliment;
    }

    @Override
    public String toString() {
        return "Aliment{" +
                "id='" + id + '\'' +
                ", aliment='" + aliment + '\'' +
                '}';
    }
}