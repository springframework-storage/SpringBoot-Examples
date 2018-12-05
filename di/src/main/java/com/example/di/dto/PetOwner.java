package com.example.di.dto;

import com.example.di.AnimalType;

public class PetOwner {

  private AnimalType animal;

  public PetOwner(AnimalType animal) {
    this.animal = animal;
  }

  public void play() {
    animal.sound();
  }

}
