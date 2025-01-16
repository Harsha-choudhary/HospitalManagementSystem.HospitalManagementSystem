/*
 * package com.hospital.model;
 * 
 * import lombok.Data; import jakarta.persistence.Column; import
 * jakarta.persistence.Entity; import jakarta.persistence.EnumType; import
 * jakarta.persistence.Enumerated; import jakarta.persistence.GeneratedValue;
 * import jakarta.persistence.GenerationType; import jakarta.persistence.Id;
 * import jakarta.persistence.Table;
 * 
 * @Data
 * 
 * @Entity
 * 
 * @Table(name = "patient") public class Patient {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
 * 
 * private String name; private int age; private String ailment;
 * 
 * @Enumerated(EnumType.STRING)
 * 
 * @Column(name = "status") private Status status = Status.ACTIVE; // Default to
 * ACTIVE
 * 
 * public Patient(int patientId) { // TODO Auto-generated constructor stub }
 * 
 * // Optional: Customize getter for status if you need it as a string public
 * String getStatusString() { return this.status.name(); }
 * 
 * // Optional: Customize setter for status if you need to convert from string
 * to enum public void setStatus(String status) { this.status =
 * Status.valueOf(status.toUpperCase()); }
 * 
 * // Overriding Lombok auto-generated methods if customization is required
 * public Long getId() { return this.id; }
 * 
 * public void setId(Long id) { this.id = id; }
 * 
 * public String getName() { return this.name; }
 * 
 * public void setName(String name) { this.name = name; }
 * 
 * public int getAge() { return this.age; }
 * 
 * public void setAge(int age) { this.age = age; }
 * 
 * public String getAilment() { return this.ailment; }
 * 
 * public void setAilment(String ailment) { this.ailment = ailment; }
 * 
 * public Status getStatus() { return this.status; }
 * 
 * public void setStatus(Status status) { this.status = status; }
 * 
 * // Aliases for ailment functionality public String getDisease() { return
 * this.ailment; }
 * 
 * public void setDisease(String disease) { this.ailment = disease; }
 * 
 * @Override public String toString() { return "Patient [id=" + id + ", name=" +
 * name + ", age=" + age + ", Disease =" + ailment + ", status=" + status + "]";
 * } }
 */package com.hospital.model;

import lombok.Data;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String ailment;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status = Status.ACTIVE; // Default to ACTIVE

   
    public String getStatusString() {
        return this.status.name();
    }

    
    public void setStatus(String status) {
        this.status = Status.valueOf(status.toUpperCase());
    }

    
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAilment() {
        return this.ailment;
    }

    public void setAilment(String ailment) {
        this.ailment = ailment;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
  

	public void setDisease(String disease) {
		// TODO Auto-generated method stub
		this.ailment=disease;
	}

	public String getDisease() {
		// TODO Auto-generated method stub
		return  ailment;
	}
	
	  @Override public String toString() { return "Patient [id=" + id + ", name=" +
    		  name + ", age=" + age + ", Disease =" + ailment + ", status=" + status + "]";
    		  }
}



