package org.bcit.comp2522.winter2023.midterm_takeup.questions;

/**
 * This alternative question, themed around planes, tests the same concepts as the previous car-themed question
 * by examining understanding of class composition, object interactions, and conditional statements.
 * In both questions, the requirement is to create three classes representing different components of the system
 * (turbine, fuel storage, and measurement device) and construct a main class that composes them.
 * We create a method in the engine class that modifies the state of the other two classes
 */
public class Basic_02_Plane {


  // TODO 0: Create a copy of this file in the answers package.


  // TODO 1: Create three new classes as declared here and edit them
  // in a moment, start by simply creating the classes.
  Basic_02_Turbine turbine; // the thing that makes the plane fly, i.e., increase altitude
  Basic_02_FuelTank fuelTank; // where the fuel is stored
  Basic_02_Altimeter altimeter; // the thing that says how high you're flying

  public Basic_02_Plane() {
    this.altimeter = new Basic_02_Altimeter(); // starts at 0 by default
    this.fuelTank = new Basic_02_FuelTank(200); // starts with 200 fuel
    this.engine = new Basic_02_Engine(fuelTank, altimeter);
  }

  // TODO 2: Create a function in Basic_02_Engine called "fly" that:
  //  (1) increases Basic_02_Altimeter.altitude by 10
  //  (2) decreases Basic_02_FuelTank.fuel by 5
  //  (3) Does the above IF and ONLY IF Basic_02_FuelTank.fuel >= 5

  public void fly() {
    engine.fly();
  }

  public static void main(String[] args) {
    Basic_02_Plane plane = new Basic_02_Plane();
    for (int i = 0; i < 39; i++) {
      plane.fly();
    }
    // plane.altimeter.altitude  == 390;
    // plane.fuelTank.fuel  == 5;

    plane.fly();
    // plane.altimeter.altitude == 400
    // plane.fuelTank.fuel  == 0;

    plane.fly();
    // plane.altimeter.altitude == 400
    // plane.fuelTank.fuel  == 0;
  }

}

