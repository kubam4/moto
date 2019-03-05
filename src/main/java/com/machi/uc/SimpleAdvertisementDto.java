package com.machi.uc;

import com.machi.model.Advertisement;

import java.util.Objects;

public class SimpleAdvertisementDto {

    private Long id;
    private String brand;
    private String model;
    private int mileage;
    private int year;
    private int liters;
    private int power;
    private String fuel;
    private double price;
    private String shortDescription;

    public SimpleAdvertisementDto() {
    }

    public SimpleAdvertisementDto(final Advertisement advertisement) {
        this.id = advertisement.getId();
        this.brand = advertisement.getBrand();
        this.model = advertisement.getModel();
        this.mileage = advertisement.getMileage();
        this.year = advertisement.getYear();
        this.liters = advertisement.getLiters();
        this.power = advertisement.getPower();
        this.fuel = advertisement.getFuel();
        this.price = advertisement.getPrice();
        this.shortDescription = advertisement.getBrand() + " " + advertisement.getModel();
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(final String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(final String model) {
        this.model = model;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(final int mileage) {
        this.mileage = mileage;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(final String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public int getYear() {
        return year;
    }

    public void setYear(final int year) {
        this.year = year;
    }

    public int getLiters() {
        return liters;
    }

    public void setLiters(final int liters) {
        this.liters = liters;
    }

    public int getPower() {
        return power;
    }

    public void setPower(final int power) {
        this.power = power;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(final String fuel) {
        this.fuel = fuel;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(final double price) {
        this.price = price;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SimpleAdvertisementDto)) {
            return false;
        }
        final SimpleAdvertisementDto that = (SimpleAdvertisementDto) o;
        return mileage == that.mileage && year == that.year && liters == that.liters && power == that.power && Double.compare(that.price, price) == 0 && Objects.equals(id, that.id) && Objects.equals(brand, that.brand) && Objects.equals(model, that.model) && Objects.equals(fuel, that.fuel) && Objects.equals(shortDescription, that.shortDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, model, mileage, year, liters, power, fuel, price, shortDescription);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SimpleAdvertisementDto{");
        sb.append("id=").append(id);
        sb.append(", brand='").append(brand).append('\'');
        sb.append(", model='").append(model).append('\'');
        sb.append(", mileage=").append(mileage);
        sb.append(", year=").append(year);
        sb.append(", liters=").append(liters);
        sb.append(", power=").append(power);
        sb.append(", fuel='").append(fuel).append('\'');
        sb.append(", price=").append(price);
        sb.append(", shortDescription='").append(shortDescription).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
