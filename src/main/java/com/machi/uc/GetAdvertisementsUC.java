package com.machi.uc;

import com.machi.model.Advertisement;
import com.machi.service.AdvertisementService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetAdvertisementsUC {

    private final AdvertisementService advertisementService;

    public GetAdvertisementsUC(final AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    @Transactional(readOnly = true)
    public List<SimpleAdvertisementDto> getAdvertisements() {
        final List<Advertisement> advertisements = advertisementService.findAll();

        return advertisements.stream()
                .map(SimpleAdvertisementDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public AdvertisementDto getAdvertisement(final long id) {
        final Advertisement advertisement = advertisementService.findById(id);
        return new AdvertisementDto(advertisement);
    }

}
