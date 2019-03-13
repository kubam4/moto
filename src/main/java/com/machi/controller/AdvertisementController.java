package com.machi.controller;

import com.machi.model.Advertisement;
import com.machi.service.AdvertisementService;
import com.machi.service.UserService;
import com.machi.uc.AdvertisementDto;
import com.machi.uc.GetAdvertisementsUC;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class AdvertisementController {

    private final AdvertisementService advertisementService;
    private final UserService userService;
    private final GetAdvertisementsUC getAdvertisementsUC;

    public AdvertisementController(final AdvertisementService advertisementService, final UserService userService, final GetAdvertisementsUC getAdvertisementsUC) {
        this.advertisementService = advertisementService;
        this.userService = userService;
        this.getAdvertisementsUC = getAdvertisementsUC;
    }

    @RequestMapping("/advertisement/all")
    public String listAdvertisements(Model model) {
        model.addAttribute("advertisements", getAdvertisementsUC.getAdvertisements());
        return "advertisement/all";
    }

    @RequestMapping("/home")
    public String allListAdvertisements(Model model) {
        model.addAttribute("advertisements", getAdvertisementsUC.getAdvertisements());
        return "home";
    }

    @GetMapping("/advertisement/form")
    public String add(Model model) {
        model.addAttribute("advertisement", new Advertisement());
        return "advertisement/form";
    }

    @GetMapping("/advertisement/{id}")
    public String show(@PathVariable long id, Model model) {
        model.addAttribute("advertisement", getAdvertisementsUC.getAdvertisement(id));
        return "advertisement/one";
    }

    // CRUD START

    @ResponseStatus(HttpStatus.CREATED)
    @PatchMapping(value = "/advertisements", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public void createAdvertisement(Advertisement advertisement) {
        advertisementService.create(advertisement);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping(value = "/advertisements", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<Advertisement> readAllAdvertisement() {
        return advertisementService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping(value = "/home", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<Advertisement> readAllListAdvertisement() {
        return advertisementService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping(value = "/advertisements/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Advertisement readOneAdvertisement(@PathVariable long id) {
        return advertisementService.findOne(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(value = "/advertisements/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public void updateAdvertisement(@PathVariable long id, Advertisement advertisement) {
        advertisementService.update(id, advertisement);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/advertisements/{id}")
    @ResponseBody
    public void deleteAdvertisement(@PathVariable long id) {
        advertisementService.delete(id);
    }

    // CRUD END

    @PostMapping(value = "/advertisement/form/save")
    public ModelAndView save(@RequestParam("imageFile") MultipartFile imageFile, @ModelAttribute AdvertisementDto advertisementDto, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        final long userId = (long) session.getAttribute("userId");
        advertisementDto.setFileName(imageFile.getOriginalFilename());

        modelAndView.addObject("advertisementDto", advertisementDto);
        advertisementDto.setUserId(userId);

        try {
            advertisementService.saveImage(imageFile, advertisementDto);
        } catch (Exception e) {
            e.printStackTrace();
            modelAndView.setViewName("error");
            return modelAndView;
        }

        try {
            advertisementService.save(advertisementDto);
        } catch (Exception e) {
            e.printStackTrace();
            modelAndView.setViewName("error");
            return modelAndView;
        }

        modelAndView.setViewName("success");

        return modelAndView;
    }

    @GetMapping("/advertisement/{id}/upload")
    public String getUpload(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("advertisement", advertisementService.findOne(id));
        return "user/advertisement_upload";
    }

    @GetMapping("/advertisement/latest")
    public ResponseEntity<Iterable<Advertisement>> findLatest() {
        return new ResponseEntity<>(advertisementService.findAll(), HttpStatus.OK);
    }


    @GetMapping("/advertisement/search")
    public ResponseEntity<List<Advertisement>> search(@RequestParam("keyword") String keyword) {
        return new ResponseEntity<>(advertisementService.search(keyword), HttpStatus.OK);
    }

    @RequestMapping("/advertisement/all/delete{id}")
    public String delete(@PathVariable long id, RedirectAttributes redirectAttrs) {
        advertisementService.delete(id);
        redirectAttrs.addFlashAttribute("message", "Ogłoszenie zostało usunięte");
        return "redirect:/advertisement/all";
    }

    @PostMapping("/uploadImage")
    public String uploadImage(@RequestParam("imageFile")MultipartFile imageFile) throws Exception {
        String returnValue="start";

//        advertisementDto advertisementDto = new AdvertisementDto();
//        advertisementDto.setFileName(imageFile.getOriginalFilename());
//        advertisementDto.setPath("/photo");
//
//        try {
//            advertisementService.saveImage(imageFile, advertisementDto);
//        } catch (Exception e) {
//            e.printStackTrace();
//            returnValue = "error";
//        }

        return returnValue;
    }

}
