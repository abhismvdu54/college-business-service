package com.cd.college.repository;
import com.cd.college.entity.SubjectEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectEntity, Integer>, JpaSpecificationExecutor<SubjectEntity> {
}
