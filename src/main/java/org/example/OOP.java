package org.example;

public class OOP {
    public static void main(String[] args) {
        // Her class aynz zamanda yeni bir veri türü.
      Car car = new Car();
      car.setModel("1999");
      Motorcycle m1= new Motorcycle();
      m1.isHasBag();
      System.out.println("****");
      Vehicle V1= new Car();
      Vehicle V2= new Motorcycle();
      V1.startRent();
      V2.startRent();

      Car c=(Car)V1;
      c.getDoorCount();

    }
}
