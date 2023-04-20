package lk.carsnow.spring.repo;

import lk.carsnow.spring.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin,String> {

    Admin findByPasswordAndName(String password,String name);

}
