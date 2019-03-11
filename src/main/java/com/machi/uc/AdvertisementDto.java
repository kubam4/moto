package com.machi.uc;

import com.machi.model.Advertisement;

import java.util.Objects;

public class AdvertisementDto {

    private Long id;
    private String brand;
    private String model;
    private int mileage;
    private int year;
    private int liters;
    private int power;
    private String fuel;
    private String gearbox;
    private double price;
    private String description;
    private String shortDescription;
    private String path;
    private String fileName;
    private long userId;

    public AdvertisementDto() {
    }


    public AdvertisementDto(final Advertisement advertisement) {

        this.id = advertisement.getId();
        this.brand = advertisement.getBrand();
        this.model = advertisement.getModel();
        this.mileage = advertisement.getMileage();
        this.year = advertisement.getYear();
        this.liters = advertisement.getLiters();
        this.power = advertisement.getPower();
        this.fuel = advertisement.getFuel();
        this.price = advertisement.getPrice();
        this.gearbox = advertisement.getGearbox();
        this.description = advertisement.getDescription();
        this.path = advertisement.getPath();
        this.fileName = advertisement.getFileName();
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

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(final String gearbox) {
        this.gearbox = gearbox;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(final double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getPath() { return path;  }

    public void setPath(String path) { this.path = path; }

    public String getFileName() { return fileName; }

    public void setFileName(String fileName) {  this.fileName = fileName; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdvertisementDto that = (AdvertisementDto) o;
        return mileage == that.mileage &&
                year == that.year &&
                liters == that.liters &&
                power == that.power &&
                Double.compare(that.price, price) == 0 &&
                Objects.equals(id, that.id) &&
                Objects.equals(brand, that.brand) &&
                Objects.equals(model, that.model) &&
                Objects.equals(fuel, that.fuel) &&
                Objects.equals(gearbox, that.gearbox) &&
                Objects.equals(description, that.description) &&
                Objects.equals(shortDescription, that.shortDescription) &&
                Objects.equals(path, that.path) &&
                Objects.equals(fileName, that.fileName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, model, mileage, year, liters, power, fuel, gearbox, price, description, shortDescription, path, fileName);
    }

    @Override
    public String toString() {
        return "AdvertisementDto{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", mileage=" + mileage +
                ", year=" + year +
                ", liters=" + liters +
                ", power=" + power +
                ", fuel='" + fuel + '\'' +
                ", gearbox='" + gearbox + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", path='" + path + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getUserId() {
        return userId;
    }
}
