package lk.ijse.nextTravelApp.service;

import lk.ijse.nextTravelApp.dto.HotelDTO;
import lk.ijse.nextTravelApp.dto.TravelPackageDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface TravelPackageService {
    TravelPackageDTO saveTravelPackage(TravelPackageDTO travelPackageDTO, MultipartFile file) throws IOException;

    List<TravelPackageDTO> getAllTravelPackages();
}
