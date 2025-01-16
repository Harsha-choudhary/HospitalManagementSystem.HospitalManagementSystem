
package com.hospital.service;

import com.hospital.model.Doctor;

import java.util.List;

public interface DoctorService {
    void addDoctor(Doctor doctor);
    void updateDoctor(Doctor doctor);
    void deleteDoctor(long id);
    Doctor getDoctor(long id);
    List<Doctor> getAllDoctors();
}
