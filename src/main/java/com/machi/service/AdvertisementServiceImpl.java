package com.machi.service;

import com.machi.model.Advertisement;
import com.machi.repository.AdvertisementRepository;
import com.machi.uc.AdvertisementDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    private final AdvertisementRepository advertisementRepository;

    public AdvertisementServiceImpl(final AdvertisementRepository advertisementRepository) {
        this.advertisementRepository = advertisementRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Advertisement> findAll() {
        return advertisementRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Advertisement> findLatest() {
        return advertisementRepository.findTop6ByOrderByIdDesc();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Advertisement> search(String keyword) {
        return advertisementRepository.findByBrandContainingOrModelContaining(keyword, keyword);
    }

    @Override
    @Transactional(readOnly = true)
    public Advertisement findOne(long id) {
        return advertisementRepository.getOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public long countAll() {
        return advertisementRepository.count();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Advertisement save(AdvertisementDto advertisement) {
        return advertisementRepository.save(advertisement);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(long id) {
        advertisementRepository.deleteById(id);
    }

    @Override
    public void update(final long id, final Advertisement newAdvertisement) {
        final Advertisement advertisement = advertisementRepository.getOne(id);
        advertisement.setBrand(newAdvertisement.getBrand());
        advertisement.setModel(newAdvertisement.getModel());
    }

    @Override
    public void create(final Advertisement advertisement) {
        advertisementRepository.save(advertisement);
    }

    @Override
    public Advertisement findById(final long id) {
        return advertisementRepository.findById(id).orElseThrow(() -> new AdvertisementNotFoundException(id));
    }

    @Override
    public void saveImage(MultipartFile imageFile, AdvertisementDto advertisementDto) throws Exception {
        advertisementDao.savePhotoImage(advertisementDto, imageFile);
        advertisementDao.save(advertisementDto);
    }

}


