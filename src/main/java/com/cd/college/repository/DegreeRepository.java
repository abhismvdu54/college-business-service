package com.cd.college.repository;
import com.cd.college.entity.DegreeEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DegreeRepository extends JpaSpecificationExecutor<DegreeEntity>, JpaRepository<DegreeEntity, Integer> {
}
