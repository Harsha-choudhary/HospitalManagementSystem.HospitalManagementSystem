/*
 * package com.hospital.main;
 * 
 * import com.hospital.model.Appointment; import com.hospital.model.Doctor;
 * import com.hospital.model.Patient; import com.hospital.model.Status; import
 * com.hospital.util.HibernateUtil; import org.hibernate.Session; import
 * org.hibernate.query.Query;
 * 
 * import java.sql.Date; import java.util.List; import java.util.Scanner;
 * 
 * public class HospitalManagementSystem {
 * 
 * private static Object appointmentService;
 * 
 * 
 * // Main menu for managing doctors and patients public static void mainMenu()
 * { Scanner scanner = new Scanner(System.in);
 * 
 * while (true) {
 * System.out.println("\n===== Hospital Management System =====");
 * System.out.println("1. Manage Doctors");
 * System.out.println("2. Manage Patients"); //
 * System.out.println("3. Manage Appointments"); System.out.println("3. Exit");
 * 
 * System.out.print("Enter your choice: ");
 * 
 * int choice = scanner.nextInt(); scanner.nextLine(); // Consume newline
 * left-over
 * 
 * switch (choice) { case 1: manageDoctors(scanner); break; case 2:
 * managePatients(scanner); break;
 * 
 * case 3: System.out.println("Exiting..."); return; default:
 * System.out.println("Invalid choice!");
 * 
 * } } }
 * 
 * // Manage Doctors public static void manageDoctors(Scanner scanner) { while
 * (true) { System.out.println("\n--- Manage Doctors ---");
 * System.out.println("1. Add Doctor"); System.out.println("2. Update Doctor");
 * System.out.println("3. Delete Doctor");
 * System.out.println("4. View Doctor by ID");
 * System.out.println("5. View All Doctors");
 * System.out.println("6. Back to Main Menu");
 * System.out.print("Enter your choice: ");
 * 
 * int choice = scanner.nextInt(); scanner.nextLine(); // Consume newline
 * left-over after nextInt()
 * 
 * switch (choice) { case 1: addDoctor(scanner); break; case 2:
 * updateDoctor(scanner); break; case 3: deleteDoctor(scanner); break; case 4:
 * viewDoctorById(scanner); break; case 5: viewAllDoctors(); break; case 6:
 * return; // Go back to main menu default:
 * System.out.println("Invalid choice. Please try again."); } } }
 * 
 * // Manage Patients public static void managePatients(Scanner scanner) { while
 * (true) { System.out.println("\n--- Manage Patients ---");
 * System.out.println("1. Add Patient");
 * System.out.println("2. Update Patient");
 * System.out.println("3. Delete Patient");
 * System.out.println("4. View Patient by ID");
 * System.out.println("5. View All Patients");
 * System.out.println("6. Back to Main Menu");
 * System.out.print("Enter your choice: ");
 * 
 * int choice = scanner.nextInt(); scanner.nextLine(); // Consume newline
 * left-over after nextInt()
 * 
 * switch (choice) { case 1: addPatient(scanner); break; case 2:
 * updatePatient(scanner); break; case 3: deletePatient(scanner); break; case 4:
 * viewPatientById(scanner); break; case 5: viewAllPatients(); break; case 6:
 * return; // Go back to main menu default:
 * System.out.println("Invalid choice. Please try again."); } } }
 * 
 * // Add Doctor public static void addDoctor(Scanner scanner) {
 * System.out.print("Enter Doctor Name: "); String name = scanner.nextLine();
 * 
 * System.out.print("Enter Specialty: "); String specialty = scanner.nextLine();
 * 
 * System.out.print("Enter Consultation Fee: "); double consultationFee =
 * scanner.nextDouble(); scanner.nextLine(); // Consume newline left-over
 * 
 * // Create doctor object and save Doctor doctor = new Doctor();
 * doctor.setName(name); doctor.setSpecialty(specialty);
 * doctor.setConsultationFee(consultationFee); doctor.setStatus("ACTIVE");
 * 
 * try (Session session = HibernateUtil.getSession()) {
 * session.beginTransaction(); session.save(doctor);
 * session.getTransaction().commit(); }
 * 
 * System.out.println("Doctor added successfully!"); }
 * 
 * // Add Patient public static void addPatient(Scanner scanner) {
 * System.out.print("Enter Patient Name: "); String name = scanner.nextLine();
 * 
 * System.out.print("Enter Age: "); int age = scanner.nextInt();
 * scanner.nextLine(); // Consume newline left-over
 * 
 * System.out.print("Enter Disease: "); String disease = scanner.nextLine();
 * 
 * // Create patient object and save Patient patient = new Patient();
 * patient.setName(name); patient.setAge(age); patient.setDisease(disease);
 * 
 * try (Session session = HibernateUtil.getSession()) {
 * session.beginTransaction(); session.save(patient);
 * session.getTransaction().commit(); }
 * 
 * System.out.println("Patient added successfully!"); }
 * 
 * // Update Doctor public static void updateDoctor(Scanner scanner) {
 * System.out.print("Enter Doctor ID to update: "); int id = scanner.nextInt();
 * scanner.nextLine(); // Consume newline left-over
 * 
 * try (Session session = HibernateUtil.getSession()) { Doctor doctor =
 * session.get(Doctor.class, id); if (doctor != null) {
 * System.out.print("Enter new Doctor Name (Leave empty to keep current): ");
 * String name = scanner.nextLine(); if (!name.isEmpty()) {
 * doctor.setName(name); }
 * 
 * System.out.print("Enter new Specialty (Leave empty to keep current): ");
 * String specialty = scanner.nextLine(); if (!specialty.isEmpty()) {
 * doctor.setSpecialty(specialty); }
 * 
 * System.out.print("Enter new Consultation Fee (Leave empty to keep current): "
 * ); String feeInput = scanner.nextLine(); if (!feeInput.isEmpty()) { double
 * consultationFee = Double.parseDouble(feeInput); ((Doctor)
 * doctor).setConsultationFee(consultationFee); }
 * 
 * // Update status if needed
 * System.out.print("Enter new status (ACTIVE/INACTIVE/DELETED): "); String
 * status = scanner.nextLine(); doctor.setStatus(status.toUpperCase());
 * 
 * session.beginTransaction(); session.update(doctor);
 * session.getTransaction().commit();
 * 
 * System.out.println("Doctor updated successfully!"); } else {
 * System.out.println("Doctor with ID " + id + " not found."); } } }
 * 
 * // Update Patient public static void updatePatient(Scanner scanner) {
 * System.out.print("Enter Patient ID to update: "); int id = scanner.nextInt();
 * scanner.nextLine(); // Consume newline left-over
 * 
 * try (Session session = HibernateUtil.getSession()) { Patient patient =
 * session.get(Patient.class, id); if (patient != null) {
 * System.out.print("Enter new Patient Name (Leave empty to keep current): ");
 * String name = scanner.nextLine(); if (!name.isEmpty()) {
 * patient.setName(name); }
 * 
 * System.out.print("Enter new Age (Leave empty to keep current): "); String
 * ageInput = scanner.nextLine(); if (!ageInput.isEmpty()) { int age =
 * Integer.parseInt(ageInput); patient.setAge(age); }
 * 
 * System.out.print("Enter new Disease (Leave empty to keep current): "); String
 * disease = scanner.nextLine(); if (!disease.isEmpty()) {
 * patient.setDisease(disease); }
 * 
 * session.beginTransaction(); session.update(patient);
 * session.getTransaction().commit();
 * 
 * System.out.println("Patient updated successfully!"); } else {
 * System.out.println("Patient with ID " + id + " not found."); } } }
 * 
 * // Delete Doctor public static void deleteDoctor(Scanner scanner) {
 * System.out.print("Enter Doctor ID to delete: "); int id = scanner.nextInt();
 * scanner.nextLine(); // Consume newline left-over
 * 
 * try (Session session = HibernateUtil.getSession()) { Doctor doctor =
 * session.get(Doctor.class, id); if (doctor != null) {
 * session.beginTransaction(); session.delete(doctor);
 * session.getTransaction().commit();
 * System.out.println("Doctor deleted successfully!"); } else {
 * System.out.println("Doctor with ID " + id + " not found."); } } }
 * 
 * // Delete Patient public static void deletePatient(Scanner scanner) {
 * System.out.print("Enter Patient ID to delete: "); int id = scanner.nextInt();
 * scanner.nextLine(); // Consume newline left-over
 * 
 * try (Session session = HibernateUtil.getSession()) { Patient patient =
 * session.get(Patient.class, id); if (patient != null) {
 * session.beginTransaction(); session.delete(patient);
 * session.getTransaction().commit();
 * System.out.println("Patient deleted successfully!"); } else {
 * System.out.println("Patient with ID " + id + " not found."); } } }
 * 
 * // View Doctor by ID public static void viewDoctorById(Scanner scanner) {
 * System.out.print("Enter Doctor ID to view: "); int id = scanner.nextInt();
 * scanner.nextLine(); // Consume newline left-over
 * 
 * try (Session session = HibernateUtil.getSession()) { Doctor doctor =
 * session.get(Doctor.class, id); if (doctor != null) {
 * System.out.println("Doctor Details:"); System.out.println("ID: " +
 * doctor.getId()); System.out.println("Name: " + doctor.getName());
 * System.out.println("Specialty: " + doctor.getSpecialty());
 * System.out.println("Consultation Fee: " + doctor.getConsultationFee());
 * System.out.println("Status: " + doctor.getStatusString()); } else {
 * System.out.println("Doctor with ID " + id + " not found."); } } }
 * 
 * // View Patient by ID public static void viewPatientById(Scanner scanner) {
 * System.out.print("Enter Patient ID to view: "); int id = scanner.nextInt();
 * scanner.nextLine(); // Consume newline left-over
 * 
 * try (Session session = HibernateUtil.getSession()) { Patient patient =
 * session.get(Patient.class, id); if (patient != null) {
 * System.out.println("Patient Details:"); System.out.println("ID: " +
 * patient.getId()); System.out.println("Name: " + patient.getName());
 * System.out.println("Age: " + patient.getAge());
 * System.out.println("Disease: " + patient.getDisease()); } else {
 * System.out.println("Patient with ID " + id + " not found."); } } }
 * 
 * // View All Doctors public static void viewAllDoctors() { try (Session
 * session = HibernateUtil.getSession()) { Query<Doctor> query =
 * session.createQuery("FROM Doctor", Doctor.class); List<Doctor> doctors =
 * query.list();
 * 
 * if (doctors.isEmpty()) { System.out.println("No doctors found."); } else {
 * System.out.println("\n--- All Doctors ---"); for (Doctor doctor : doctors) {
 * System.out.println("ID: " + doctor.getId() + ", Name: " + doctor.getName() +
 * ", Specialty: " + doctor.getSpecialty() + ", Fee: " +
 * doctor.getConsultationFee() + ", Status: " + doctor.getStatusString()); } } }
 * }
 * 
 * // View All Patients public static void viewAllPatients() { try (Session
 * session = HibernateUtil.getSession()) { Query<Patient> query =
 * session.createQuery("FROM Patient", Patient.class); List<Patient> patients =
 * query.list();
 * 
 * if (patients.isEmpty()) { System.out.println("No patients found."); } else {
 * System.out.println("\n--- All Patients ---"); for (Patient patient :
 * patients) { System.out.println("ID: " + patient.getId() + ", Name: " +
 * patient.getName() + ", Age: " + patient.getAge() + ", Disease: " +
 * patient.getDisease()); } } } }
 * 
 * 
 * 
 * 
 * // Main method to start the program public static void main(String[] args) {
 * mainMenu(); // Start the main menu } }
 */

package com.hospital.main;

import com.hospital.model.Doctor;
import com.hospital.model.Patient;
import com.hospital.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class HospitalManagementSystem {

    // Main menu for managing doctors and patients
    public static void mainMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Hospital Management System =====");
            System.out.println("1. Manage Doctors");
            System.out.println("2. Manage Patients");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    manageDoctors(scanner);
                    break;
                case 2:
                    managePatients(scanner);
                    break;
                case 3:
                    System.out.println("Exiting the system.");
                    return; // Exit from the program
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Manage Doctors
    public static void manageDoctors(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Manage Doctors ---");
            System.out.println("1. Add Doctor");
            System.out.println("2. Update Doctor");
            System.out.println("3. Delete Doctor");
            System.out.println("4. View Doctor by ID");
            System.out.println("5. View All Doctors");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over after nextInt()

            switch (choice) {
                case 1:
                    addDoctor(scanner);
                    break;
                case 2:
                    updateDoctor(scanner);
                    break;
                case 3:
                    deleteDoctor(scanner);
                    break;
                case 4:
                    viewDoctorById(scanner);
                    break;
                case 5:
                    viewAllDoctors();
                    break;
                case 6:
                    return;  // Go back to main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Manage Patients
    public static void managePatients(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Manage Patients ---");
            System.out.println("1. Add Patient");
            System.out.println("2. Update Patient");
            System.out.println("3. Delete Patient");
            System.out.println("4. View Patient by ID");
            System.out.println("5. View All Patients");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over after nextInt()

            switch (choice) {
                case 1:
                    addPatient(scanner);
                    break;
                case 2:
                    updatePatient(scanner);
                    break;
                case 3:
                    deletePatient(scanner);
                    break;
                case 4:
                    viewPatientById(scanner);
                    break;
                case 5:
                    viewAllPatients();
                    break;
                case 6:
                    return;  // Go back to main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Add Doctor
    public static void addDoctor(Scanner scanner) {
        System.out.print("Enter Doctor Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Specialty: ");
        String specialty = scanner.nextLine();

        System.out.print("Enter Consultation Fee: ");
        double consultationFee = scanner.nextDouble();
        scanner.nextLine(); // Consume newline left-over

        // Create doctor object and save
        Doctor doctor = new Doctor();
        doctor.setName(name);
        doctor.setSpecialty(specialty);
        doctor.setConsultationFee(consultationFee);
        doctor.setStatus("ACTIVE");

        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.save(doctor);
            session.getTransaction().commit();
        }

        System.out.println("Doctor added successfully!");
    }

    // Add Patient
    public static void addPatient(Scanner scanner) {
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        System.out.print("Enter Disease: ");
        String disease = scanner.nextLine();

        // Create patient object and save
        Patient patient = new Patient();
        patient.setName(name);
        patient.setAge(age);
        patient.setDisease(disease);

        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.save(patient);
            session.getTransaction().commit();
        }

        System.out.println("Patient added successfully!");
    }

    // Update Doctor
    public static void updateDoctor(Scanner scanner) {
        System.out.print("Enter Doctor ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        try (Session session = HibernateUtil.getSession()) {
            Doctor doctor = session.get(Doctor.class, id);
            if (doctor != null) {
                System.out.print("Enter new Doctor Name (Leave empty to keep current): ");
                String name = scanner.nextLine();
                if (!name.isEmpty()) {
                    doctor.setName(name);
                }

                System.out.print("Enter new Specialty (Leave empty to keep current): ");
                String specialty = scanner.nextLine();
                if (!specialty.isEmpty()) {
                    doctor.setSpecialty(specialty);
                }

                System.out.print("Enter new Consultation Fee (Leave empty to keep current): ");
                String feeInput = scanner.nextLine();
                if (!feeInput.isEmpty()) {
                    double consultationFee = Double.parseDouble(feeInput);
                    doctor.setConsultationFee(consultationFee);
                }

                // Update status if needed
                System.out.print("Enter new status (ACTIVE/INACTIVE/DELETED): ");
                String status = scanner.nextLine();
                doctor.setStatus(status.toUpperCase());

                session.beginTransaction();
                session.update(doctor);
                session.getTransaction().commit();

                System.out.println("Doctor updated successfully!");
            } else {
                System.out.println("Doctor with ID " + id + " not found.");
            }
        }
    }

    // Update Patient
    public static void updatePatient(Scanner scanner) {
        System.out.print("Enter Patient ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        try (Session session = HibernateUtil.getSession()) {
            Patient patient = session.get(Patient.class, id);
            if (patient != null) {
                System.out.print("Enter new Patient Name (Leave empty to keep current): ");
                String name = scanner.nextLine();
                if (!name.isEmpty()) {
                    patient.setName(name);
                }

                System.out.print("Enter new Age (Leave empty to keep current): ");
                String ageInput = scanner.nextLine();
                if (!ageInput.isEmpty()) {
                    int age = Integer.parseInt(ageInput);
                    patient.setAge(age);
                }

                System.out.print("Enter new Disease (Leave empty to keep current): ");
                String disease = scanner.nextLine();
                if (!disease.isEmpty()) {
                    patient.setDisease(disease);
                }

                session.beginTransaction();
                session.update(patient);
                session.getTransaction().commit();

                System.out.println("Patient updated successfully!");
            } else {
                System.out.println("Patient with ID " + id + " not found.");
            }
        }
    }

    // Delete Doctor
    public static void deleteDoctor(Scanner scanner) {
        System.out.print("Enter Doctor ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        try (Session session = HibernateUtil.getSession()) {
            Doctor doctor = session.get(Doctor.class, id);
            if (doctor != null) {
                session.beginTransaction();
                session.delete(doctor);
                session.getTransaction().commit();
                System.out.println("Doctor deleted successfully!");
            } else {
                System.out.println("Doctor with ID " + id + " not found.");
            }
        }
    }

    // Delete Patient
    public static void deletePatient(Scanner scanner) {
        System.out.print("Enter Patient ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        try (Session session = HibernateUtil.getSession()) {
            Patient patient = session.get(Patient.class, id);
            if (patient != null) {
                session.beginTransaction();
                session.delete(patient);
                session.getTransaction().commit();
                System.out.println("Patient deleted successfully!");
            } else {
                System.out.println("Patient with ID " + id + " not found.");
            }
        }
    }

    // View Doctor by ID
    public static void viewDoctorById(Scanner scanner) {
        System.out.print("Enter Doctor ID to view: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        try (Session session = HibernateUtil.getSession()) {
            Doctor doctor = session.get(Doctor.class, id);
            if (doctor != null) {
                System.out.println("Doctor Details:");
                System.out.println("ID: " + doctor.getId());
                System.out.println("Name: " + doctor.getName());
                System.out.println("Specialty: " + doctor.getSpecialty());
                System.out.println("Consultation Fee: " + doctor.getConsultationFee());
                System.out.println("Status: " + doctor.getStatus());
            } else {
                System.out.println("Doctor with ID " + id + " not found.");
            }
        }
    }

    // View Patient by ID
    public static void viewPatientById(Scanner scanner) {
        System.out.print("Enter Patient ID to view: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        try (Session session = HibernateUtil.getSession()) {
            Patient patient = session.get(Patient.class, id);
            if (patient != null) {
                System.out.println("Patient Details:");
                System.out.println("ID: " + patient.getId());
                System.out.println("Name: " + patient.getName());
                System.out.println("Age: " + patient.getAge());
                System.out.println("Disease: " + patient.getDisease());
            } else {
                System.out.println("Patient with ID " + id + " not found.");
            }
        }
    }

    // View All Doctors
    public static void viewAllDoctors() {
        try (Session session = HibernateUtil.getSession()) {
            Query<Doctor> query = session.createQuery("FROM Doctor", Doctor.class);
            List<Doctor> doctors = query.list();

            if (doctors.isEmpty()) {
                System.out.println("No doctors found.");
            } else {
                System.out.println("\n--- All Doctors ---");
                for (Doctor doctor : doctors) {
                    System.out.println("ID: " + doctor.getId() + ", Name: " + doctor.getName() + ", Specialty: " + doctor.getSpecialty() + ", Fee: " + doctor.getConsultationFee() + ", Status: " + doctor.getStatus());
                }
            }
        }
    }

    // View All Patients
    public static void viewAllPatients() {
        try (Session session = HibernateUtil.getSession()) {
            Query<Patient> query = session.createQuery("FROM Patient", Patient.class);
            List<Patient> patients = query.list();

            if (patients.isEmpty()) {
                System.out.println("No patients found.");
            } else {
                System.out.println("\n--- All Patients ---");
                for (Patient patient : patients) {
                    System.out.println("ID: " + patient.getId() + ", Name: " + patient.getName() + ", Age: " + patient.getAge() + ", Disease: " + patient.getDisease());
                }
            }
        }
    }

    // Main method to start the program
    public static void main(String[] args) {
        mainMenu(); // Start the main menu
    }
}

