package com.machi.repository;

import com.machi.model.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {

    //public Advertisement findByBrand(String brand);

    List<Advertisement> findAll();

    //List<Advertisement> listAllAdvertisements();

    List<Advertisement> findByBrandContainingOrModelContaining(String brand, String model);

    List<Advertisement> findTop6ByOrderByIdDesc();

    //List<Advertisement> findByUser_IdContaining();
}
