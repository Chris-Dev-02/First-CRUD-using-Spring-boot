package com.SpringTest.SpringTest.repository;

import com.SpringTest.SpringTest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{
    
}
