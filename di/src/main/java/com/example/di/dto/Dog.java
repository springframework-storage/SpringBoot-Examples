package com.example.di.dto;

import com.example.di.AnimalType;

public class Dog implements AnimalType {

  private String myName;

  public void setMyName(String name) {
    this.myName = name;
  }

  @Override
  public void sound() {
    System.out.println("Dog: " + myName + "-BowWow");
  }

}
