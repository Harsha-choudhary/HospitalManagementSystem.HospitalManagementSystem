
package com.hospital.dao;

import com.hospital.model.Doctor;
import java.util.List;

public interface DoctorDAO {
    void addDoctor(Doctor doctor);
    void updateDoctor(Doctor doctor);
    void deleteDoctor(long id);
    Doctor getDoctor(long id);
    List<Doctor> getAllDoctors();
}
