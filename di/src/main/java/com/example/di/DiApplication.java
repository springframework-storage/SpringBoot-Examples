package com.example.di;

import com.example.di.dto.Cat;
import com.example.di.dto.Dog;
import com.example.di.dto.PetOwner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DiApplication {

  public static void main(String[] args) {
    AnimalType animal1 = new Dog();
    ((Dog) animal1).setMyName("poodle");
    PetOwner person1 = new PetOwner(animal1);
    person1.play();

    AnimalType animal2 = new Cat();
    ((Cat) animal2).setMyName("kikat");
    PetOwner person2 = new PetOwner(animal2);
    person2.play();

    SpringApplication.run(DiApplication.class, args);
  }
}
