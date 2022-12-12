package com.dataloaderportal.DataLoaderPortal.repo;

import com.dataloaderportal.DataLoaderPortal.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface PatientRepo extends JpaRepository<Patient, Integer>{
}

