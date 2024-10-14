package com.solvd;

import com.solvd.db.jdbc.models.*;
import com.solvd.db.jdbc.services.*;
import com.solvd.db.utils.SqlResetUtil;
import com.solvd.db.utils.TestConnection;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {

        // Test the connection
        TestConnection.testConnection();

        // Reset All Tables
        SqlResetUtil.reset();

        // Create 20 Persons
        Person p1 = new Person();
        p1.setFirstName("Alice");
        p1.setLastName("Johnson");
        p1.setDob(Date.valueOf("1990-03-22"));
        p1.setGender("F");
        p1.setAddress("1234 Elm St, Springfield");
        p1.setPhoneNumber("123-456-7890");
        p1.setEmail("alice.johnson@example.com");

        Person p2 = new Person();
        p2.setFirstName("Chavo");
        p2.setLastName("Delocho");
        p2.setDob(Date.valueOf("1988-07-15"));
        p2.setGender("M");
        p2.setAddress("4321 Oak St, Springfield");
        p2.setPhoneNumber("321-654-0987");
        p2.setEmail("chavo.delocho@example.com");

        Person p3 = new Person();
        p3.setFirstName("Bob");
        p3.setLastName("Smith");
        p3.setDob(Date.valueOf("1995-05-10"));
        p3.setGender("M");
        p3.setAddress("5678 Pine St, Springfield");
        p3.setPhoneNumber("234-567-8901");
        p3.setEmail("bob.smith@example.com");

        Person p4 = new Person();
        p4.setFirstName("Diana");
        p4.setLastName("Prince");
        p4.setDob(Date.valueOf("1992-02-14"));
        p4.setGender("F");
        p4.setAddress("3456 Maple St, Springfield");
        p4.setPhoneNumber("345-678-9012");
        p4.setEmail("diana.prince@example.com");

        Person p5 = new Person();
        p5.setFirstName("Clark");
        p5.setLastName("Kent");
        p5.setDob(Date.valueOf("1984-06-18"));
        p5.setGender("M");
        p5.setAddress("7890 Birch St, Springfield");
        p5.setPhoneNumber("456-789-0123");
        p5.setEmail("clark.kent@example.com");

        Person p6 = new Person();
        p6.setFirstName("Wanda");
        p6.setLastName("Maximoff");
        p6.setDob(Date.valueOf("1991-08-23"));
        p6.setGender("F");
        p6.setAddress("1357 Cedar St, Springfield");
        p6.setPhoneNumber("567-890-1234");
        p6.setEmail("wanda.maximoff@example.com");

        Person p7 = new Person();
        p7.setFirstName("Tony");
        p7.setLastName("Stark");
        p7.setDob(Date.valueOf("1980-11-12"));
        p7.setGender("M");
        p7.setAddress("2468 Fir St, Springfield");
        p7.setPhoneNumber("678-901-2345");
        p7.setEmail("tony.stark@example.com");

        Person p8 = new Person();
        p8.setFirstName("Bruce");
        p8.setLastName("Wayne");
        p8.setDob(Date.valueOf("1989-04-16"));
        p8.setGender("M");
        p8.setAddress("8642 Poplar St, Springfield");
        p8.setPhoneNumber("890-123-4567");
        p8.setEmail("bruce.wayne@example.com");

        Person p9 = new Person();
        p9.setFirstName("Ozzy");
        p9.setLastName("Osbourne");
        p9.setDob(Date.valueOf("1990-05-20"));
        p9.setGender("M");
        p9.setAddress("1234 Elm St, Springfield");
        p9.setPhoneNumber("123-456-7890");
        p9.setEmail("ozzy.osbourne@example.com");

        Person p10 = new Person();
        p10.setFirstName("Chavo");
        p10.setLastName("Delocho");
        p10.setDob(Date.valueOf("1988-07-15"));
        p10.setGender("M");
        p10.setAddress("4321 Oak St, Springfield");
        p10.setPhoneNumber("321-654-0987");
        p10.setEmail("chavo.delocho2@example.com");

        Person p11 = new Person();
        p11.setFirstName("Natasha");
        p11.setLastName("Romanoff");
        p11.setDob(Date.valueOf("1986-12-03"));
        p11.setGender("F");
        p11.setAddress("567 Cedar St, Springfield");
        p11.setPhoneNumber("789-012-3456");
        p11.setEmail("natasha.romanoff@example.com");

        Person p12 = new Person();
        p12.setFirstName("Steve");
        p12.setLastName("Rogers");
        p12.setDob(Date.valueOf("1987-07-04"));
        p12.setGender("M");
        p12.setAddress("123 Liberty St, Springfield");
        p12.setPhoneNumber("012-345-6789");
        p12.setEmail("steve.rogers@example.com");

        Person p13 = new Person();
        p13.setFirstName("Peter");
        p13.setLastName("Parker");
        p13.setDob(Date.valueOf("1993-08-10"));
        p13.setGender("M");
        p13.setAddress("456 Web St, Springfield");
        p13.setPhoneNumber("234-567-8901");
        p13.setEmail("peter.parker@example.com");

        Person p14 = new Person();
        p14.setFirstName("Carol");
        p14.setLastName("Danvers");
        p14.setDob(Date.valueOf("1989-11-11"));
        p14.setGender("F");
        p14.setAddress("789 Cosmic St, Springfield");
        p14.setPhoneNumber("345-678-9012");
        p14.setEmail("carol.danvers@example.com");

        Person p15 = new Person();
        p15.setFirstName("Bruce");
        p15.setLastName("Banner");
        p15.setDob(Date.valueOf("1981-12-18"));
        p15.setGender("M");
        p15.setAddress("135 Hulk St, Springfield");
        p15.setPhoneNumber("456-789-0123");
        p15.setEmail("bruce.banner@example.com");

        Person p16 = new Person();
        p16.setFirstName("Thor");
        p16.setLastName("Odinson");
        p16.setDob(Date.valueOf("1990-01-17"));
        p16.setGender("M");
        p16.setAddress("246 Asgard Ave, Springfield");
        p16.setPhoneNumber("567-890-1234");
        p16.setEmail("thor.odinson@example.com");

        Person p17 = new Person();
        p17.setFirstName("Loki");
        p17.setLastName("Laufeyson");
        p17.setDob(Date.valueOf("1992-05-01"));
        p17.setGender("M");
        p17.setAddress("789 Mischief Ln, Springfield");
        p17.setPhoneNumber("678-901-2345");
        p17.setEmail("loki.laufeyson@example.com");

        Person p18 = new Person();
        p18.setFirstName("Wade");
        p18.setLastName("Wilson");
        p18.setDob(Date.valueOf("1985-09-25"));
        p18.setGender("M");
        p18.setAddress("135 Pool St, Springfield");
        p18.setPhoneNumber("789-012-3456");
        p18.setEmail("wade.wilson@example.com");

        Person p19 = new Person();
        p19.setFirstName("Stephen");
        p19.setLastName("Strange");
        p19.setDob(Date.valueOf("1978-11-11"));
        p19.setGender("M");
        p19.setAddress("456 Mystic St, Springfield");
        p19.setPhoneNumber("890-123-4567");
        p19.setEmail("stephen.strange@example.com");

        Person p20 = new Person();
        p20.setFirstName("Bucky");
        p20.setLastName("Barnes");
        p20.setDob(Date.valueOf("1986-04-13"));
        p20.setGender("M");
        p20.setAddress("123 Winter St, Springfield");
        p20.setPhoneNumber("123-456-7890");
        p20.setEmail("bucky.barnes@example.com");

        // INSERT PERSONS
        new PersonService().insert(p1);
        new PersonService().insert(p2);
        new PersonService().insert(p3);
        new PersonService().insert(p4);
        new PersonService().insert(p5);
        new PersonService().insert(p6);
        new PersonService().insert(p7);
        new PersonService().insert(p8);
        new PersonService().insert(p9);
        new PersonService().insert(p10);
        new PersonService().insert(p11);
        new PersonService().insert(p12);
        new PersonService().insert(p13);
        new PersonService().insert(p14);
        new PersonService().insert(p15);
        new PersonService().insert(p16);
        new PersonService().insert(p17);
        new PersonService().insert(p18);
        new PersonService().insert(p19);
        new PersonService().insert(p20);

        // Create 3 Doctors
        Doctor d1 = new Doctor();
        d1.setPerson(new PersonService().getById(1));
        d1.setSpecialization("Cardiology");
        d1.setLicenseNumber("LIC12345");
        d1.setHireDate(Date.valueOf("2010-06-01"));

        Doctor d2 = new Doctor();
        d2.setPerson(new PersonService().getById(2));
        d2.setSpecialization("Pediatrics");
        d2.setLicenseNumber("LIC67890");
        d2.setHireDate(Date.valueOf("2012-08-15"));

        Doctor d3 = new Doctor();
        d3.setPerson(new PersonService().getById(3));
        d3.setSpecialization("Neurology");
        d3.setLicenseNumber("LIC54321");
        d3.setHireDate(Date.valueOf("2018-04-20"));

        // INSERT DOCTORS
        new DoctorService().insert(d1);
        new DoctorService().insert(d2);
        new DoctorService().insert(d3);

        // Create 3 Nurses
        Nurse n1 = new Nurse();
        n1.setPerson(new PersonService().getById(4));
        n1.setShift("Day");
        n1.setHireDate(Date.valueOf("2015-03-10"));

        Nurse n2 = new Nurse();
        n2.setPerson(new PersonService().getById(5));
        n2.setShift("Night");
        n2.setHireDate(Date.valueOf("2016-07-22"));

        Nurse n3 = new Nurse();
        n3.setPerson(new PersonService().getById(6));
        n3.setShift("Evening");
        n3.setHireDate(Date.valueOf("2019-11-28"));

        // INSERT NURSES
        new NurseService().insert(n1);
        new NurseService().insert(n2);
        new NurseService().insert(n3);

        // Create 3 Patients
        Patient pa1 = new Patient();
        pa1.setPerson(new PersonService().getById(7));
        pa1.setAdmissionDate(Date.valueOf("2024-01-10"));
        pa1.setDischargeDate(null);
        pa1.setMedicalHistory("Diabetes Type 2");

        Patient pa2 = new Patient();
        pa2.setPerson(new PersonService().getById(8));
        pa2.setAdmissionDate(Date.valueOf("2024-02-15"));
        pa2.setDischargeDate(null);
        pa2.setMedicalHistory("Hypertension");

        Patient pa3 = new Patient();
        pa3.setPerson(new PersonService().getById(9));
        pa3.setAdmissionDate(Date.valueOf("2024-03-01"));
        pa3.setDischargeDate(null);
        pa3.setMedicalHistory("Asthma");

        // INSERT PATIENTS
        new PatientService().insert(pa1);
        new PatientService().insert(pa2);
        new PatientService().insert(pa3);

        // Create 3 Management
        Management m1 = new Management();
        m1.setPerson(new PersonService().getById(10));
        m1.setDepartment("Finance");
        m1.setPosition("CFO");
        m1.setHireDate(Date.valueOf("2008-09-01"));

        Management m2 = new Management();
        m2.setPerson(new PersonService().getById(11));
        m2.setDepartment("IT");
        m2.setPosition("CTO");
        m2.setHireDate(Date.valueOf("2011-05-12"));

        Management m3 = new Management();
        m3.setPerson(new PersonService().getById(12));
        m3.setDepartment("Operations");
        m3.setPosition("COO");
        m3.setHireDate(Date.valueOf("2019-01-15"));

        // INSERT MANAGEMENT
        new ManagementService().insert(m1);
        new ManagementService().insert(m2);
        new ManagementService().insert(m3);

        // Create 3 AdministrativeEmployee
        AdministrativeEmployee a1 = new AdministrativeEmployee();
        a1.setPerson(new PersonService().getById(13));
        a1.setDepartment("Human Resources");
        a1.setHireDate(Date.valueOf("2020-02-18"));

        AdministrativeEmployee a2 = new AdministrativeEmployee();
        a2.setPerson(new PersonService().getById(14));
        a2.setDepartment("Accounting");
        a2.setHireDate(Date.valueOf("2021-03-05"));

        AdministrativeEmployee a3 = new AdministrativeEmployee();
        a3.setPerson(new PersonService().getById(15));
        a3.setDepartment("Legal");
        a3.setHireDate(Date.valueOf("2023-07-22"));

        // INSERT ADMINISTRATIVE EMPLOYEE
        new AdministrativeEmployeeService().insert(a1);
        new AdministrativeEmployeeService().insert(a2);
        new AdministrativeEmployeeService().insert(a3);

        // Create 2 Suppliers
        Supplier s1 = new Supplier();
        s1.setName("MediSupply");
        s1.setContactPerson("Alice Green");
        s1.setPhoneNumber("555-7890");
        s1.setEmail("alice@medisupply.com");

        Supplier s2 = new Supplier();
        s2.setName("HealthGoods");
        s2.setContactPerson("Bob White");
        s2.setPhoneNumber("555-4321");
        s2.setEmail("bob@healthgoods.com");

        // INSERT SUPPLIERS
        new SupplierService().insert(s1);
        new SupplierService().insert(s2);

        // Create 1 Equipment
        Equipment e1 = new Equipment();
        e1.setName("MRI Scanner");
        e1.setType("Imaging");
        e1.setPurchaseDate(Date.valueOf("2022-05-05"));
        e1.setWarrantyEnd(Date.valueOf("2025-05-05"));
        e1.setSupplier(new SupplierService().getById(1));

        // INSERT EQUIPMENT
        new EquipmentService().insert(e1);

        // Create 1 Medical Supply
        MedicalSupplies me1 = new MedicalSupplies();
        me1.setName("Gloves");
        me1.setQuantity(1000);
        me1.setUnitPrice(0.2F);
        me1.setSupplier(new SupplierService().getById(2));

        // INSERT MEDICAL SUPPLIES
        new MedicalSuppliesService().insert(me1);

        // Create 4 Appointments
        Appointment ap1 = new Appointment();
        ap1.setDoctor(new DoctorService().getById(1));
        ap1.setPatient(new PatientService().getById(1));
        ap1.setAppointmentDate(Date.valueOf("2024-10-01"));
        ap1.setReasonForVisit("Routine Check-up'");

        Appointment ap2 = new Appointment();
        ap2.setDoctor(new DoctorService().getById(1));
        ap2.setPatient(new PatientService().getById(2));
        ap2.setAppointmentDate(Date.valueOf("2024-10-05"));
        ap2.setReasonForVisit("Follow-up for Diabetes");

        Appointment ap3 = new Appointment();
        ap3.setDoctor(new DoctorService().getById(2));
        ap3.setPatient(new PatientService().getById(1));
        ap3.setAppointmentDate(Date.valueOf("2024-10-07"));
        ap3.setReasonForVisit("Flu Symptoms");

        Appointment ap4 = new Appointment();
        ap4.setDoctor(new DoctorService().getById(2));
        ap4.setPatient(new PatientService().getById(2));
        ap4.setAppointmentDate(Date.valueOf("2024-10-10"));
        ap4.setReasonForVisit("Blood Pressure Check");

        // INSERT APPOINTMENTS
        new AppointmentService().insert(ap1);
        new AppointmentService().insert(ap2);
        new AppointmentService().insert(ap3);
        new AppointmentService().insert(ap4);

        // READ ALL
        System.out.println("Persons: " + new PersonService().getAll());
        System.out.println("Administrative Employees: " + new AdministrativeEmployeeService().getAll());
        System.out.println("Doctors: " + new DoctorService().getAll());
        System.out.println("Equipment: " + new EquipmentService().getAll());
        System.out.println("Management: " + new ManagementService().getAll());
        System.out.println("Medical Supplies: " + new MedicalSuppliesService().getAll());
        System.out.println("Nurses: " + new NurseService().getAll());
        System.out.println("Patients: " + new PatientService().getAll());
        System.out.println("Suppliers: " + new SupplierService().getAll());
        System.out.println("Persons: " + new PersonService().getAll());

        // UPDATES - READ
        // PERSON
        p20.setEmail("changed@prueba.com");
        System.out.println("\nActual person email: " + new PersonService().getById(20));
        new PersonService().update(p20);
        System.out.println("Updated person email: " + new PersonService().getById(20));

        // DOCTOR
        d1.setSpecialization("Neurology");
        System.out.println("\nActual doctor specialization: " + new PersonService().getById(1));
        new DoctorService().update(d1);
        System.out.println("Updated doctor specialization: " + new DoctorService().getById(1));

        // NURSE
        n1.setShift("Night");
        System.out.println("Actual nurse shift: " + new NurseService().getById(1));
        new NurseService().update(n1);
        System.out.println("Updated nurse shift: " + new NurseService().getById(1));

        // PATIENT
        pa1.setDischargeDate(Date.valueOf("2024-10-02"));
        System.out.println("Actual patient discharge date: " + new PatientService().getById(1));
        new PatientService().update(pa1);
        System.out.println("Updated patient discharge date: " + new PatientService().getById(1));

        // MANAGEMENT
        m1.setPosition("CEO");
        System.out.println("Actual management position: " + new ManagementService().getById(1));
        new ManagementService().update(m1);
        System.out.println("Updated management position: " + new ManagementService().getById(1));

        // ADMINISTRATIVE EMPLOYEE
        a1.setDepartment("Operations");
        System.out.println("Actual Administrative employee department: " + new AdministrativeEmployeeService().getById(1));
        new AdministrativeEmployeeService().update(a1);
        System.out.println("Updated Administrative employee department: " + new AdministrativeEmployeeService().getById(1));

        // SUPPLIER
        s1.setContactPerson("Bob Blue");
        System.out.println("Actual supplier contact person: " + new SupplierService().getById(1));
        new SupplierService().update(s1);
        System.out.println("Updated supplier contact person: " + new SupplierService().getById(1));

        // EQUIPMENT
        e1.setWarrantyEnd(Date.valueOf("2026-05-05"));
        System.out.println("Actual equipment warranty: " + new EquipmentService().getById(1));
        new EquipmentService().update(e1);
        System.out.println("Updated equipment warranty: " + new EquipmentService().getById(1));

        // MEDICAL SUPPLY
        me1.setQuantity(1200);
        System.out.println("Actual supply quantity: " + new MedicalSuppliesService().getById(1));
        new MedicalSuppliesService().update(me1);
        System.out.println("Updated supply quantity: " + new MedicalSuppliesService().getById(1));

        // APPOINTMENT
        ap1.setReasonForVisit("Follow-up on blood work");
        System.out.println("Actual appointment reason: " + new AppointmentService().getById(1));
        new AppointmentService().update(ap1);
        System.out.println("Updated appointment reason: " + new AppointmentService().getById(1));

        // DELETE - READ
        // PERSON
        new PersonService().deleteById(20);
        System.out.println("Person deleted: " + new PersonService().getById(20));

        // APPOINTMENT
        new AppointmentService().deleteById(1);
        System.out.println("Person deleted: " + new AppointmentService().getById(1));

        // DOCTOR
        new DoctorService().deleteById(3);
        System.out.println("Doctor deleted: " + new DoctorService().getById(3));

        // NURSE
        new NurseService().deleteById(3);
        System.out.println("Person deleted: " + new NurseService().getById(3));

        // PATIENT
        new PatientService().deleteById(3);
        System.out.println("Person deleted: " + new PatientService().getById(3));

        // MANAGEMENT
        new ManagementService().deleteById(3);
        System.out.println("Person deleted: " + new ManagementService().getById(3));

        // ADMINISTRATIVE EMPLOYEE
        new AdministrativeEmployeeService().deleteById(3);
        System.out.println("Person deleted: " + new AdministrativeEmployeeService().getById(3));

        // SUPPLIER
        new SupplierService().deleteById(2);
        System.out.println("Person deleted: " + new SupplierService().getById(2));

        // EQUIPMENT
        new EquipmentService().deleteById(1);
        System.out.println("Person deleted: " + new EquipmentService().getById(1));

        // MEDICAL SUPPLY
        new MedicalSuppliesService().deleteById(1);
        System.out.println("Person deleted: " + new MedicalSuppliesService().getById(1));

        System.out.println("---THE END---");
    }
}