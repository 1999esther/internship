package com.esther.internship.repository;

import com.esther.internship.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {
 Users findByName(String email);
}
