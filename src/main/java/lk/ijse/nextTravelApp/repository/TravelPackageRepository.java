package lk.ijse.nextTravelApp.repository;

import lk.ijse.nextTravelApp.entity.TravelPackage;
import lk.ijse.nextTravelApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelPackageRepository extends JpaRepository<TravelPackage,Integer> {
}
