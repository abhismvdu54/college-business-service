package com.cd.college.repository;
import com.cd.college.entity.CollegeEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeRepository extends JpaSpecificationExecutor<CollegeEntity>, JpaRepository<CollegeEntity, Integer> {
}
