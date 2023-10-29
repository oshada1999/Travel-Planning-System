package lk.ijse.nextTravelApp.repository;

import lk.ijse.nextTravelApp.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,Integer> {
    boolean existsByHotelEmail(String email);
    Hotel getByHotelEmail(String email);
    Hotel getByHotelId(Integer hotelId);
}
