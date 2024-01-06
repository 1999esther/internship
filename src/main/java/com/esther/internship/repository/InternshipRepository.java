package com.esther.internship.repository;

import com.esther.internship.model.Internship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternshipRepository extends JpaRepository<Internship, Integer> {
    boolean existsByEmail(String email);
}
