package com.elisabet.odyssey_api.repository;

import com.elisabet.odyssey_api.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Long> {
}


