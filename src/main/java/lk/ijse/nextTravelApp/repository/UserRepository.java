package lk.ijse.nextTravelApp.repository;

import lk.ijse.nextTravelApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    boolean existsByEmail(String email);
    boolean existsByNic(String nic);
    User getByEmail(String email);
}
