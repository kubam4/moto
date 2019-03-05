package com.machi.service;

public class AdvertisementNotFoundException extends RuntimeException {

    private final long id;

    public AdvertisementNotFoundException(final long id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        return "Nie znaleziono ogłoszenia o identyfikatorze " + id; // TODO advertisement_not_fond ( errorCode )
    }

}
