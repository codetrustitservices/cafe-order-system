package com.cafe_management.Repository;

import com.cafe_management.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository  extends JpaRepository<Admin , Long> {
    Admin findByUsername(String username);
}
