package lk.ijse.nextTravelApp.repository;

import lk.ijse.nextTravelApp.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {
    Vehicle getByVehicleId(Integer vehicleId);
}
