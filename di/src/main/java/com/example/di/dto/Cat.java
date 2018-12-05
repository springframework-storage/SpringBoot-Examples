package com.example.di.dto;

import com.example.di.AnimalType;

public class Cat implements AnimalType {

  private String myName;

  public void setMyName(String name) {
    this.myName = name;
  }

  @Override
  public void sound() {
    System.out.println("Cat: " + myName + "-Meow");
  }

}
