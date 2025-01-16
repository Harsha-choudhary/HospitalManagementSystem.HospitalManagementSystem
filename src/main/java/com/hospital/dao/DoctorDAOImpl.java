package com.hospital.dao;

import com.hospital.model.Doctor;
import com.hospital.model.Status;
import com.hospital.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class DoctorDAOImpl implements DoctorDAO {
    @SuppressWarnings("deprecation")
	@Override
    public void addDoctor(Doctor doctor) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(doctor);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(doctor);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteDoctor(long id) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Doctor doctor = session.get(Doctor.class, id);
            if (doctor != null) {
                doctor.setStatus(Status.DELETED); // Soft delete
                session.update(doctor);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public Doctor getDoctor(long id) {
        Session session = HibernateUtil.getSession();
        Doctor doctor = null;
        try {
            doctor = session.get(Doctor.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return doctor;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        Session session = HibernateUtil.getSession();
        List<Doctor> doctors = null;
        try {
            Query<Doctor> query = session.createQuery("FROM Doctor WHERE status != :status", Doctor.class);
            query.setParameter("status", Status.DELETED);
            doctors = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return doctors;
    }
}

