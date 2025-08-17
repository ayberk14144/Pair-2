package org.example;

//uperclass-> Kalatin alznann class
// Subclass -> Kalitim yapan class (Car)
//(Vehicle)
// OOP'de temsil edeceğimiz nesnenin kalıbı (sınıf tanımı)
public class Car extends Vehicle {

    private int doorCount;

    public Car(String brand, String model, int year, float km, int doorCount) {
        super(brand, model, year, km);
        this.doorCount = doorCount;
    }

    public Car() {
    }

    public int getDoorCount() {
        return doorCount;
    }

    public void setDoorCount(int doorCount) {
        this.doorCount = doorCount;
    }
}



// Ecisim BelinLeyiciLec
// public => Bu class digen tüm classlardan erisilebilsin.
// protected = Bu class alt siniflardan, ayni paketlerden erisilebilsin.
// private => Yalnazca o sinifin iginden erisilebilsin.
// default => Bu class avn sinf ve avnl paket disanda erisilebilin olmasin.