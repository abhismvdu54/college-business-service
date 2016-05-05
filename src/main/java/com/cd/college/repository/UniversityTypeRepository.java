package com.cd.college.repository;
import com.cd.college.entity.UniversityTypeEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityTypeRepository extends JpaSpecificationExecutor<UniversityTypeEntity>, JpaRepository<UniversityTypeEntity, Integer> {
}
