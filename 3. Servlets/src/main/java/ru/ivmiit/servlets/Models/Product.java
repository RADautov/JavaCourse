package ru.ivmiit.servlets.Models;

import ru.ivmiit.servlets.Box;

public class  Product implements Box {
    private String name;
    private double weight;

    public Product(String name, double weight){
        this.name = name;
        this.weight = weight;
    }

    public double getWeight() {
        return this.weight;
    }


    public String getName() { return this.name; }

}
