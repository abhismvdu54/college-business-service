package com.cd.college.repository;
import com.cd.college.entity.CollegeTypeEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeTypeRepository extends JpaSpecificationExecutor<CollegeTypeEntity>, JpaRepository<CollegeTypeEntity, Integer> {
}
