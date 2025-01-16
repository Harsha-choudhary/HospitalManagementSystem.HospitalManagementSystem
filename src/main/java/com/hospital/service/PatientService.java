
package com.hospital.service;

import com.hospital.model.Patient;

import java.util.List;

public interface PatientService {
    void addPatient(Patient patient);
    void updatePatient(Patient patient);
    void deletePatient(long id);
    Patient getPatient(long id);
    List<Patient> getAllPatients();
}
