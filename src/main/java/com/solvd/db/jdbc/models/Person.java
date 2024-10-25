package com.solvd.db.jdbc.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.solvd.db.jaxb.DateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.sql.Date;

@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName("person")
public class Person {

    @XmlAttribute
    @JsonProperty("personId")
    private int personId;

    @XmlElement (name = "firstName")
    @JsonProperty("firstName")
    private String firstName;

    @XmlElement (name = "lastName")
    @JsonProperty("lastName")
    private String lastName;

    @XmlElement (name = "dob")
    @XmlJavaTypeAdapter(DateAdapter.class)
    @JsonProperty("dob")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dob;

    @XmlElement (name = "gender")
    @JsonProperty("gender")
    private String gender;

    @XmlElement (name = "address")
    @JsonProperty("address")
    private String address;

    @XmlElement (name = "phoneNumber")
    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @XmlElement (name = "email")
    @JsonProperty("email")
    private String email;


    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
