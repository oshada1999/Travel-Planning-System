package lk.ijse.nextTravelApp.repository;

import lk.ijse.nextTravelApp.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<ImageEntity, Long> {
}