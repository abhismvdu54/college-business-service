package com.cd.college.repository;
import com.cd.college.entity.CollegeProgramSpecialisationEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeProgramSpecialisationRepository extends JpaRepository<CollegeProgramSpecialisationEntity, Integer>, JpaSpecificationExecutor<CollegeProgramSpecialisationEntity> {
}
