package com.cd.college.repository;
import com.cd.college.entity.CollegeProgramEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeProgramRepository extends JpaRepository<CollegeProgramEntity, Integer>, JpaSpecificationExecutor<CollegeProgramEntity> {
}
