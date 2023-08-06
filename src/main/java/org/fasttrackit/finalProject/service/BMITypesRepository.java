package org.fasttrackit.finalProject.service;

import org.fasttrackit.finalProject.model.BMITypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BMITypesRepository extends JpaRepository<BMITypes,Long> {
}
