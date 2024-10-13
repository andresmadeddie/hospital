-- DROP SCHEMA, RECREATED, AND USE IT
DROP SCHEMA IF EXISTS hospital;
CREATE SCHEMA hospital;
USE hospital;

-- CREATE TABLES
CREATE TABLE person (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    dob DATE,
    gender ENUM('M', 'F', 'Other'),
    address VARCHAR(100),
    phone_number VARCHAR(20),
    email VARCHAR(50)
);

CREATE TABLE doctor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    person_id INT,
    specialization VARCHAR(50),
    license_number VARCHAR(20),
    hire_date DATE,
    FOREIGN KEY (person_id) REFERENCES person(id)
    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE nurse (
    id INT AUTO_INCREMENT PRIMARY KEY,
    person_id INT,
    shift ENUM('Day', 'Night', 'Evening'),
    hire_date DATE,
    FOREIGN KEY (person_id) REFERENCES person(id)
    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE patient (
    id INT AUTO_INCREMENT PRIMARY KEY,
    person_id INT,
    admission_date DATE,
    discharge_date DATE,
    medical_history TEXT,
    FOREIGN KEY (person_id) REFERENCES person(id)
    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE management (
    id INT AUTO_INCREMENT PRIMARY KEY,
    person_id INT,
    department VARCHAR(50),
    position VARCHAR(50),
    hire_date DATE,
    FOREIGN KEY (person_id) REFERENCES person(id)
    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE administrative_employee (
    id INT AUTO_INCREMENT PRIMARY KEY,
    person_id INT,
    department VARCHAR(50),
    hire_date DATE,
    FOREIGN KEY (person_id) REFERENCES person(id)
    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE supplier (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    contact_person VARCHAR(50),
    phone_number VARCHAR(20),
    email VARCHAR(50)
);

CREATE TABLE equipment (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    type VARCHAR(50),
    purchase_date DATE,
    warranty_end DATE,
    supplier_id INT,
    FOREIGN KEY (supplier_id) REFERENCES supplier(id)
    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE medical_supplies (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    quantity INT,
    unit_price DECIMAL(10, 2),
    supplier_id INT,
    FOREIGN KEY (supplier_id) REFERENCES supplier(id)
    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE appointment (
    id INT AUTO_INCREMENT PRIMARY KEY,
    doctor_id INT,
    patient_id INT,
    appointment_date DATETIME,
    reason_for_visit VARCHAR(255),
    FOREIGN KEY (doctor_id) REFERENCES doctor(id)
    ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (patient_id) REFERENCES patient(id)
    ON UPDATE CASCADE ON DELETE CASCADE
);
