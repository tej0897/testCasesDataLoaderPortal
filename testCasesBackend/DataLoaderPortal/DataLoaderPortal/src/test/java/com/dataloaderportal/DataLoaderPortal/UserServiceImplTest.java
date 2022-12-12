package com.dataloaderportal.DataLoaderPortal;

import com.dataloaderportal.DataLoaderPortal.entity.Patient;
import com.dataloaderportal.DataLoaderPortal.repo.PatientRepo;
import com.dataloaderportal.DataLoaderPortal.service.PatientServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@AutoConfigureMockMvc
@SpringBootTest
public class UserServiceImplTest {

    @Mock
    private PatientRepo patientRepo;

    @InjectMocks
    private PatientServiceImpl patientService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(patientService).build();
    }

    List<Patient> patientList = new ArrayList<>();

    @Test
    public void getAllUsersSuccess() throws Exception {
        Patient patient = new Patient();
        patient.setPatientName("Tej");
        patient.setEmail("tej@gmail.com");

        patientList.add(patient);

        when(patientRepo.findAll()).thenReturn(patientList);

        List<Patient> uList = patientService.getAllPatients();

        assertEquals(patientList, uList);
    }

//    @Test
//    public void getAllUsersFailure() throws Exception {
//
//        when(patientRepo.findAll()).thenReturn(null);
//
//        List<Patient> patients = patientService.getAllPatients();
//
//        assertNull(patients);
//    }

}
