package com.example.enc.myapplication;

public class Sub {
    static Sub instance;
    private Sub(){ // this constructor create object here

    }
    public static Sub getInstance(){
        if(instance==null) {
            instance = new Sub();
        }
        return instance;
    }
}
