package com.cd.college.repository;
import com.cd.college.entity.UniversityEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends JpaSpecificationExecutor<UniversityEntity>, JpaRepository<UniversityEntity, Integer> {
}
