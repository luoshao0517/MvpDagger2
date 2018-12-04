package com.tfkj.dagger2demo.bean;

import javax.inject.Inject;

public class Person {
    private String name;

    @Inject
    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
