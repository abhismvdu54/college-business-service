package com.cd.college.repository;
import com.cd.college.entity.ProgramEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramRepository extends JpaRepository<ProgramEntity, Integer>, JpaSpecificationExecutor<ProgramEntity> {
}
