package com.machi.service;

import com.machi.model.Advertisement;
import com.machi.uc.AdvertisementDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface AdvertisementService {



    List<Advertisement> findAll();

    //List<Advertisement> listAllAdvertisements();

    List<Advertisement> findLatest();

    List<Advertisement> search(String keyword);

    //List<Advertisement> findById();

    Advertisement findOne(long id);

    long countAll();

    Advertisement save(AdvertisementDto advertisement);

    void delete(long id);

    void update(long id, Advertisement advertisement);

    void create(Advertisement advertisement);

    Advertisement findById(long id);

    void saveImage(MultipartFile imageFile, AdvertisementDto advertisementDto) throws Exception;

    //Advertisement getOne(Integer );
}
