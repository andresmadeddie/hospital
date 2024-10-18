package com.solvd.db.jaxb;

import com.solvd.db.jdbc.models.Doctor;
import com.solvd.db.jdbc.models.Person;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.sql.Date;

public class XmlParser {

    public static Doctor parseDoctorDataFromFile(String xmlFilePath) {
        try {
            // Load XML file
            File xmlFile = new File(xmlFilePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            // Create Doctor object
            Doctor doctor = new Doctor();

            // Access elements and set Doctor Object using DOM methods
            Element doctorElement = (Element) doc.getElementsByTagName("doctor").item(0);
            Element personElement = (Element) doc.getElementsByTagName("person").item(0);
            doctor.setSpecialization(doctorElement.getElementsByTagName("specialization").item(0).getTextContent());
            doctor.setLicenseNumber(doctorElement.getElementsByTagName("licenseNumber").item(0).getTextContent());
            doctor.setHireDate(Date.valueOf(doctorElement.getElementsByTagName("hireDate").item(0).getTextContent()));
            doctor.setDoctorId(Integer.parseInt(doctorElement.getAttribute("doctorId")));

            // Create and set Person Object
            Person person = new Person();
            person.setPersonId(Integer.parseInt(personElement.getAttribute("personId")));
            person.setFirstName(personElement.getElementsByTagName("firstName").item(0).getTextContent());
            person.setLastName(personElement.getElementsByTagName("lastName").item(0).getTextContent());
            person.setDob(Date.valueOf(personElement.getElementsByTagName("dob").item(0).getTextContent()));
            person.setGender(personElement.getElementsByTagName("gender").item(0).getTextContent());
            person.setAddress(personElement.getElementsByTagName("address").item(0).getTextContent());
            person.setPhoneNumber(personElement.getElementsByTagName("phoneNumber").item(0).getTextContent());
            person.setEmail(personElement.getElementsByTagName("email").item(0).getTextContent());

            // Add person at Doctor
            doctor.setPerson(person);

            // Print the parsed values
            System.out.println("Doctor id: " + doctor.getDoctorId());
            System.out.println("Person id: " + doctor.getPerson().getPersonId());
            System.out.println("specialization: " + doctor.getSpecialization());
            System.out.println("licenseNumber: " + doctor.getLicenseNumber());
            System.out.println("hireDate: " + doctor.getHireDate());
            System.out.println("firstName: " + doctor.getPerson().getFirstName());
            System.out.println("lastName: " + doctor.getPerson().getLastName());
            System.out.println("dob: " + doctor.getPerson().getDob());
            System.out.println("gender: " + doctor.getPerson().getGender());
            ;
            System.out.println("address: " + doctor.getPerson().getAddress());
            System.out.println("phoneNumber: " + doctor.getPerson().getPhoneNumber());
            System.out.println("email: " + doctor.getPerson().getEmail());

            System.out.println("\nObject returned: ");
            return doctor;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
