package com.machi.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.machi.uc.AdvertisementDto;

import javax.persistence.*;

@Entity
@Table(name = "advertisement")
public class Advertisement extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    private Long id;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name ="mileage", nullable = false)
    private int mileage;

    @Column(name ="year", nullable = false)
    private int year;

    @Column(name ="liters", nullable = false)
    private int liters;

    @Column(name ="power", nullable = false)
    private int power;

    @Column(name ="fuel", nullable = false)
    private String fuel;

    @Column(name ="gearbox", nullable = false)
    private String gearbox;

    @Column(name="price", nullable = false)
    private double price;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "path")
    private String path;

    @Column(name = "fileName")
    private String fileName;

    @ManyToOne
    @JoinColumn(name = "user_id", updatable = false, nullable = false)
    private User user;

    public Advertisement() {
    }

    // tylko do kopiowania nowoprzychodzących Dto, jak będzie update trzeba pamiętać aby skopiować tez id
    public Advertisement(AdvertisementDto advertisementDto, final User user) {
        // w przypadku tworzenia nowego obiektu nie posiada on id
        this.brand = advertisementDto.getBrand();
        this.model = advertisementDto.getModel();
        this.mileage = advertisementDto.getMileage();
        this.year = advertisementDto.getYear();
        this.liters = advertisementDto.getLiters();
        this.power = advertisementDto.getPower();
        this.fuel = advertisementDto.getFuel();
        this.price = advertisementDto.getPrice();
        this.gearbox = advertisementDto.getGearbox();
        this.description = advertisementDto.getDescription();
        this.path = advertisementDto.getPath();
        this.fileName = advertisementDto.getFileName();
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getLiters() {
        return liters;
    }

    public void setLiters(int liters) {
        this.liters = liters;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
