package lk.ijse.nextTravelApp.repository;

import lk.ijse.nextTravelApp.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {
    Vehicle getByVehicleId(Integer vehicleId);
    boolean existsByVehicleCategory(String category);
    boolean existsByVehicleStatus(String status);
    List<Vehicle> getAllByVehicleCategoryAndVehicleStatus(String category,String status);
}
