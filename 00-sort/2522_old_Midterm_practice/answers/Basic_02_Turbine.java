package org.bcit.comp2522.winter2023.midterm_takeup.answers;

public class Basic_02_Turbine {
  Basic_02_FuelTank fuelTank;
  Basic_02_Altimeter_Ans altimeter;

  public Basic_02_Turbine(Basic_02_FuelTank fuelTank, Basic_02_Altimeter_Ans altimeter) {
    this.fuelTank = fuelTank;
    this.altimeter = altimeter;
  }

  public void fly() {
    if (fuelTank.getFuelValue() >= 5) {
      altimeter.setAltitude(altimeter.getAltitude() + 10);
      fuelTank.setFuelValue(fuelTank.getFuelValue() - 5);
    }
  }
}
