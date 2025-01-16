
package com.hospital.service;

import com.hospital.dao.PatientDAO;
import com.hospital.dao.PatientDAOImpl;
import com.hospital.model.Patient;

import java.util.List;

public class PatientServiceImpl implements PatientService {

    private final PatientDAO patientDAO;

    public PatientServiceImpl() {
        this.patientDAO = new PatientDAOImpl(); // Initializing DAO implementation
    }

    @Override
    public void addPatient(Patient patient) {
        patientDAO.addPatient(patient);
    }

    @Override
    public void updatePatient(Patient patient) {
        patientDAO.updatePatient(patient);
    }

    @Override
    public void deletePatient(long id) {
        patientDAO.deletePatient(id);
    }

    @Override
    public Patient getPatient(long id) {
        return patientDAO.getPatient(id);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientDAO.getAllPatients();
    }
}
