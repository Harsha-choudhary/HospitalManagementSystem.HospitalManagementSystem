package com.hospital.dao;

import com.hospital.model.Patient;
import com.hospital.model.Status;
import com.hospital.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PatientDAOImpl implements PatientDAO {

    @Override
    public void addPatient(Patient patient) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(patient);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void updatePatient(Patient patient) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(patient);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void deletePatient(long id) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Patient patient = session.get(Patient.class, id);
            if (patient != null) {
                patient.setStatus(Status.DELETED); // Soft delete by setting status
                session.update(patient);
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
    public Patient getPatient(long id) {
        Session session = HibernateUtil.getSession();
        Patient patient = null;
        try {
            patient = session.get(Patient.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return patient;
    }

    @Override
    public List<Patient> getAllPatients() {
        Session session = HibernateUtil.getSession();
        List<Patient> patients = null;
        try {
            Query<Patient> query = session.createQuery("FROM Patient WHERE status != :status", Patient.class);
            query.setParameter("status", Status.DELETED); // Exclude soft-deleted patients
            patients = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return patients;
    }
}
