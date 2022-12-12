package com.dataloaderportal.DataLoaderPortal.service;


import com.dataloaderportal.DataLoaderPortal.entity.Patient;
import com.dataloaderportal.DataLoaderPortal.repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepo patientRepo;


    @Override
    public List<Patient> addData(List<Patient> patientList) {
        return patientRepo.saveAll(patientList);
    }

    @Override
    public List<Patient> getAllPatients() {
        List<Patient> patientList = patientRepo.findAll();
        if (patientList.size() > 0){
            return patientList;
        } else {
            return null;
        }
    }

    @Override
    public boolean updatePatient(Patient patient) {
        Patient patient1 = patientRepo.getById(patient.getPatientID());

        if (patient1 != null){
            patient1.setPatientName(patient.getPatientName());
            patient1.setAddress(patient.getAddress());
            patient1.setDob(patient.getDob());
            patient1.setEmail(patient.getEmail());
            patient1.setPhone(patient.getPhone());
            patient1.setDrugID(patient.getDrugID());
            patient1.setDrugName(patient.getDrugName());
            patientRepo.saveAndFlush(patient1);
            return true;
        }
        return false;
    }

    @Override
    public boolean updatePatientByID(int patientID, Patient patient) {
        Patient patient1 = patientRepo.getById(patient.getPatientID());
        if (patient1 != null){
            patient1.setPatientName(patient.getPatientName());
            patient1.setAddress(patient.getAddress());
            patient1.setDob(patient.getDob());
            patient1.setEmail(patient.getEmail());
            patient1.setPhone(patient.getPhone());
            patient1.setDrugID(patient.getDrugID());
            patient1.setDrugName(patient.getDrugName());
            patientRepo.saveAndFlush(patient1);
            return true;
        }
        return false;
    }
}
