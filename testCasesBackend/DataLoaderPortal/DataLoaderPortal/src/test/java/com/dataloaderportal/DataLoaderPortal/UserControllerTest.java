package com.dataloaderportal.DataLoaderPortal;

import com.dataloaderportal.DataLoaderPortal.controller.PatientController;
import com.dataloaderportal.DataLoaderPortal.entity.Patient;
import com.dataloaderportal.DataLoaderPortal.service.PatientServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@AutoConfigureMockMvc
@SpringBootTest
public class UserControllerTest {

    @Mock
    private PatientServiceImpl patientService;

    @InjectMocks
    private PatientController patientController;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(patientController).build();
    }

    List<Patient> patientList = new ArrayList<>();

    @Test
    public void getAllUsersSuccess() throws Exception {
        Patient patient = new Patient();
        patient.setPatientName("Tej");
        patient.setEmail("tej@gmail.com");

        patientList.add(patient);

        when(patientService.getAllPatients()).thenReturn(patientList);

        List<Patient> uList = patientService.getAllPatients();

        assertEquals(patientList, uList);

        // check the http status and the URL working

        mockMvc.perform(MockMvcRequestBuilders.get("/getAllPatients").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getAllUsersFailure() throws Exception{
        patientList.clear();
        when(patientService.getAllPatients()).thenReturn(patientList);

        assertEquals(0, patientList.size());

        mockMvc.perform(MockMvcRequestBuilders.get("/getAllPatients").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

//    @Test
//    public void addPatientSuccess() throws Exception{
//        Patient patient = new Patient();
//        patient.setPatientName("Kumar");
//        patient.setEmail("kumar@gmail.com");
//
//        patientList.add(patient);
//        when(patientService.addData(any())).thenReturn((List<Patient>) patient);
//
//        assertEquals(1, patientList.size());
//        mockMvc.perform(MockMvcRequestBuilders.post("/addData")
//                .contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(patient)))
//                .andExpect(MockMvcResultMatchers.status().isCreated());
//    }
}
