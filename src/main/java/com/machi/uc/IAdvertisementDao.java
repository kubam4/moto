package com.machi.uc;

import org.springframework.web.multipart.MultipartFile;

public interface IAdvertisementDao {

    void savePhotoImage(AdvertisementDto advertisementDto, MultipartFile imageFile) throws Exception;

    void save(AdvertisementDto advertisementDto);
}
