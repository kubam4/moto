package com.machi.controller;

import com.machi.service.AdvertisementService;
import com.machi.uc.GetAdvertisementsUC;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    private final AdvertisementService advertisementService;
    private final GetAdvertisementsUC getAdvertisementsUC;

    public DashboardController(final AdvertisementService advertisementService, GetAdvertisementsUC getAdvertisementsUC) {
        this.advertisementService = advertisementService;
        this.getAdvertisementsUC = getAdvertisementsUC;
    }

    @GetMapping(value = {"/dashboard"})
    public String index(Model model) {
        model.addAttribute("advertisements", advertisementService.findLatest());
        return "index";
    }

    @GetMapping(value = {"/home"})
    public String home(Model model) {
        model.addAttribute("advertisements", advertisementService.findLatest());
        return "home";
    }

    @GetMapping(value = {"/upload"})
    public String upload(Model model)
    {
        return "upload";
    }

}
