package lk.ijse.nextTravelApp.repository;

import lk.ijse.nextTravelApp.entity.Guide;
import lk.ijse.nextTravelApp.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuideRepository extends JpaRepository<Guide,Integer> {
    boolean existsByGuideEmail(String email);

    Guide getByGuideEmail(String email);
    Guide getByGuideId(Integer guideId);
}
