package com.elisabet.odyssey_api.repository;

import com.elisabet.odyssey_api.entity.Rhapsody;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RhapsodyRepository extends JpaRepository<Rhapsody, Long> {
    Optional<Rhapsody> findByNumber(Integer number);
}
