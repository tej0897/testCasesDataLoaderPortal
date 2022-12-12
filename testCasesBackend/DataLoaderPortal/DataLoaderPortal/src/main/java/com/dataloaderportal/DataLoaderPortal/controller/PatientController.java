package com.dataloaderportal.DataLoaderPortal.controller;

import com.dataloaderportal.DataLoaderPortal.entity.Patient;
import com.dataloaderportal.DataLoaderPortal.service.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin
public class PatientController {

    @Autowired
    private PatientServiceImpl patientService;

    @PostMapping("/addData")
    public ResponseEntity<?>addData(@RequestBody List<Patient> patientList){
        if (patientService.addData(patientList)!=null){
            return new ResponseEntity<>(patientList, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Operation Failure", HttpStatus.CONFLICT);
    }

    @GetMapping("/getAllPatients")
    public ResponseEntity<?> getAllPatient(){
        List<Patient> patientList = patientService.getAllPatients();
        if (patientList!=null){
           return new ResponseEntity<>(patientList, HttpStatus.OK);
        }
        return new ResponseEntity<>("Operation Failure", HttpStatus.CONFLICT);
    }

    @PutMapping("/updatePatient")
    public ResponseEntity<?> updatePatient(@RequestBody Patient patient){
        if (patientService.updatePatient(patient)){
            return new ResponseEntity<>(patient, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("cannot be updated", HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @PutMapping("/updatePatient/{patientID}")
    public ResponseEntity<?> updatePatient(@PathVariable int patientID, @RequestBody Patient patient){
        if (patientService.updatePatientByID(patientID, patient)){
            return new ResponseEntity<>(patient, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("cannot be updated", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
