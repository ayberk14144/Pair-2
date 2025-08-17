package org.example;

public class Motorcycle extends Vehicle{
    private boolean hasBag;

    public Motorcycle() {
    }

    public Motorcycle(boolean hasBag) {
        this.hasBag = hasBag;
    }

    public boolean isHasBag() {
        return hasBag;
    }

    public void setHasBag(boolean hasBag) {
        this.hasBag = hasBag;
    }

    @Override
    public void startRent() {
        System.out.println("mOTORCYCLE CALİŞTİ");
        super.startRent();
    }
}
