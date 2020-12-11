package com.EffectiveJavaObjects;

public class Bunny {
    String name;
    String type;

    public Bunny(String name, String type){
        this.name = name;
        this.type = type;
    }

    public static Bunny createDefaultBunny(String name){
        return new Bunny(name, "rex");
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}

