package com.machi.uc;

import com.machi.repository.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.jms.core.JmsTemplate;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AdvertisementDao implements IAdvertisementDao{

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private AdvertisementRepository advertisementRepository;

    @Override
    public void savePhotoImage(AdvertisementDto advertisementDto, MultipartFile imageFile) throws Exception {
        // this gets us to src/main/resources without knowing the full path (hardcoding)
        Path currentPath = Paths.get(".");
        Path absolutePath = currentPath.toAbsolutePath();
        advertisementDto.setPath(absolutePath + "/src/main/resources/static/img/");
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(advertisementDto.getPath() + imageFile.getOriginalFilename());
        Files.write(path, bytes);
        jmsTemplate.convertAndSend("photos", path.normalize().toString());
    }

    @Override
    public void save(AdvertisementDto advertisementDto) {
        advertisementRepository.save(advertisementDto);
    }
}
