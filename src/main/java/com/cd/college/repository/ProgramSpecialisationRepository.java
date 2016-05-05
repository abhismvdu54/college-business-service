package com.cd.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.cd.college.entity.ProgramSpecialisationEntity;

@Repository
public interface ProgramSpecialisationRepository extends JpaSpecificationExecutor<ProgramSpecialisationEntity>, JpaRepository<ProgramSpecialisationEntity, Integer>{

}
