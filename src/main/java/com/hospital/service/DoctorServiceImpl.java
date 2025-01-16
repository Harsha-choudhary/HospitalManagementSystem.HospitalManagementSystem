
package com.hospital.service;

import com.hospital.dao.DoctorDAO;
import com.hospital.dao.DoctorDAOImpl;
import com.hospital.model.Doctor;

import java.util.List;

public class DoctorServiceImpl implements DoctorService {

    private final DoctorDAO doctorDAO;

    public DoctorServiceImpl() {
        this.doctorDAO = new DoctorDAOImpl(); // Initializing DAO implementation
    }

    @Override
    public void addDoctor(Doctor doctor) {
        doctorDAO.addDoctor(doctor);
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        doctorDAO.updateDoctor(doctor);
    }

    @Override
    public void deleteDoctor(long id) {
        doctorDAO.deleteDoctor(id);
    }

    @Override
    public Doctor getDoctor(long id) {
        return doctorDAO.getDoctor(id);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorDAO.getAllDoctors();
    }
}
