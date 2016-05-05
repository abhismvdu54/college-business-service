package com.cd.college.repository;
import com.cd.college.entity.SpecialisationEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialisationRepository extends JpaRepository<SpecialisationEntity, Integer>, JpaSpecificationExecutor<SpecialisationEntity> {
}
