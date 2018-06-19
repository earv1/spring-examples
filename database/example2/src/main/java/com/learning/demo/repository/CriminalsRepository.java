package com.learning.demo.repository;

import com.learning.demo.model.Criminal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Repository
public interface CriminalsRepository extends JpaRepository<Criminal, Long> {

    List<Criminal> findCriminalByNameContains(@NotBlank String name);

}
