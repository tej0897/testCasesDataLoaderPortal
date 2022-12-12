package com.dataloaderportal.DataLoaderPortal.service;

import com.dataloaderportal.DataLoaderPortal.entity.Patient;

import java.util.List;

public interface PatientService {
    public List<Patient> addData(List<Patient> patients);

    public List<Patient> getAllPatients();

    public boolean updatePatient(Patient patient);
    public boolean updatePatientByID(int patientID, Patient patient);


}
