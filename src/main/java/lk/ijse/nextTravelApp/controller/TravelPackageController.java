package lk.ijse.nextTravelApp.controller;

import lk.ijse.nextTravelApp.dto.HotelDTO;
import lk.ijse.nextTravelApp.dto.TravelPackageDTO;
import lk.ijse.nextTravelApp.service.HotelService;
import lk.ijse.nextTravelApp.service.TravelPackageService;
import lk.ijse.nextTravelApp.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/package")
@CrossOrigin
public class TravelPackageController {
    @Autowired
    TravelPackageService travelPackageService;

    @ResponseStatus(HttpStatus.CREATED) //201
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveTravelPackage(@RequestPart("file") MultipartFile file,
                                  @RequestPart("TravelPackage") TravelPackageDTO travelPackageDTO) throws IOException {
        System.out.println("hii");
        return new ResponseUtil(200, "save", travelPackageService.saveTravelPackage(travelPackageDTO, file));
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllTravelPackage() {
        return new ResponseUtil(200, "AllPackagesGet", travelPackageService.getAllTravelPackages());
    }
}
