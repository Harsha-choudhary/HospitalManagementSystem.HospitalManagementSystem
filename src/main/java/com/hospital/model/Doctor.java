package com.hospital.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "doctor")
@ToString
@EqualsAndHashCode
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String specialty;
    private double consultationFee;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status = Status.ACTIVE; // Default to ACTIVE

    public Doctor(int doctorId) {
		// TODO Auto-generated constructor stub
    	this.id=id;
	}



	

	public Doctor() {
		// TODO Auto-generated constructor stub
	}



	// Manually Declared Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    // Custom setter to handle string-to-enum conversion
    public void setStatus(String status) {
        this.status = Status.valueOf(status.toUpperCase());
    }

    // Optional: If you need a string representation of the status
    public String getStatusString() {
        return this.status.name();
    }

    @Override
    public String toString() {
        return "Doctor [id=" + id + ", name=" + name + ", specialty=" + specialty + 
               ", consultationFee=" + consultationFee + ", status=" + status + "]";
    }
}

