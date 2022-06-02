package com.alaswad.userservice.repo;

import com.alaswad.userservice.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<AppUser,Long> {
    AppUser findByUsername(String username);
}
