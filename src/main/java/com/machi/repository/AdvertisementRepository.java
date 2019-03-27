package com.machi.repository;

import com.machi.model.Advertisement;
import com.machi.uc.AdvertisementDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Repository
public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {

    //public Advertisement findByBrand(String brand);

    List<Advertisement> findAll();

    //List<Advertisement> listAllAdvertisements();

    List<Advertisement> findByBrandContainingOrModelContaining(String brand, String model);

    List<Advertisement> findTop6ByOrderByIdDesc();

    public default void savePhotoImage(AdvertisementDto advertisementDto, MultipartFile imageFile) throws Exception {
        // this gets us to src/main/resources without knowing the full path (hardcoding)
        Path currentPath = Paths.get("."); // kropka oznacza current folder
        Path absolutePath = currentPath.toAbsolutePath();
        String imageFolderAbsolutePath = absolutePath + "/src/main/resources/static/img/";

        //
        String imagesDirecotry = "pobrane z propertisa";
        String twojaSuperSciezkaDoPliczku = imagesDirecotry + "/" + advertisementDto.getId() + "/" +  imageFile.getOriginalFilename();

        // zmienna path tak naprawde zawiera kompletna sciezke do zdjecia
        advertisementDto.setPath(imageFolderAbsolutePath + imageFile.getOriginalFilename());

        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(advertisementDto.getPath());
        Files.write(path, bytes);
    }

}
