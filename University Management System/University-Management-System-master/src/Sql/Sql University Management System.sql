-- Create a database
CREATE DATABASE UniversityManagementSystem;

-- Use the created database
USE UniversityManagementSystem;

-- Create table for Departments
CREATE TABLE Departments (
    DepartmentID INT AUTO_INCREMENT PRIMARY KEY,
    DepartmentName VARCHAR(100) NOT NULL,
    HeadOfDepartment VARCHAR(100),
    EstablishedYear YEAR
);

-- Create table for Faculty
CREATE TABLE Faculty (
    FacultyID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    Email VARCHAR(100) UNIQUE NOT NULL,
    PhoneNumber VARCHAR(15),
    DepartmentID INT,
    Designation VARCHAR(50),
    FOREIGN KEY (DepartmentID) REFERENCES Departments(DepartmentID)
);

-- Create table for Courses
CREATE TABLE Courses (
    CourseID INT AUTO_INCREMENT PRIMARY KEY,
    CourseName VARCHAR(100) NOT NULL,
    Credits INT NOT NULL,
    DepartmentID INT,
    FacultyID INT,
    FOREIGN KEY (DepartmentID) REFERENCES Departments(DepartmentID),
    FOREIGN KEY (FacultyID) REFERENCES Faculty(FacultyID)
);

-- Create table for Students
CREATE TABLE Students (
    StudentID INT AUTO_INCREMENT PRIMARY KEY,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    DateOfBirth DATE,
    Email VARCHAR(100) UNIQUE NOT NULL,
    PhoneNumber VARCHAR(15),
    Address TEXT,
    DepartmentID INT,
    EnrollmentYear YEAR,
    FOREIGN KEY (DepartmentID) REFERENCES Departments(DepartmentID)
);

-- Create table for Enrollments
CREATE TABLE Enrollments (
    EnrollmentID INT AUTO_INCREMENT PRIMARY KEY,
    StudentID INT,
    CourseID INT,
    EnrollmentDate DATE,
    Grade CHAR(2),
    FOREIGN KEY (StudentID) REFERENCES Students(StudentID),
    FOREIGN KEY (CourseID) REFERENCES Courses(CourseID)
);

-- Insert sample data into Departments
INSERT INTO Departments (DepartmentName, HeadOfDepartment, EstablishedYear)
VALUES 
('Computer Science', 'Dr. John Doe', 1995),
('Mechanical Engineering', 'Dr. Jane Smith', 1980),
('Electrical Engineering', 'Dr. Emily Davis', 1985);

-- Insert sample data into Faculty
INSERT INTO Faculty (Name, Email, PhoneNumber, DepartmentID, Designation)
VALUES 
('Dr. Alan Turing', 'alan.turing@university.edu', '123-456-7890', 1, 'Professor'),
('Dr. Nikola Tesla', 'nikola.tesla@university.edu', '987-654-3210', 3, 'Associate Professor');

-- Insert sample data into Courses
INSERT INTO Courses (CourseName, Credits, DepartmentID, FacultyID)
VALUES 
('Introduction to Programming', 4, 1, 1),
('Circuits and Electronics', 3, 3, 2);

-- Insert sample data into Students
INSERT INTO Students (FirstName, LastName, DateOfBirth, Email, PhoneNumber, Address, DepartmentID, EnrollmentYear)
VALUES 
('Alice', 'Johnson', '2003-04-15', 'alice.johnson@student.edu', '555-1234', '123 Main St', 1, 2021),
('Bob', 'Smith', '2002-11-22', 'bob.smith@student.edu', '555-5678', '456 Elm St', 3, 2020);

-- Insert sample data into Enrollments
INSERT INTO Enrollments (StudentID, CourseID, EnrollmentDate, Grade)
VALUES 
(1, 1, '2023-01-15', 'A'),
(2, 2, '2023-01-20', 'B');

-- Query to fetch all enrolled students with their courses
SELECT 
    s.StudentID, 
    CONCAT(s.FirstName, ' ', s.LastName) AS StudentName, 
    c.CourseName, 
    e.EnrollmentDate, 
    e.Grade
FROM 
    Enrollments e
JOIN Students s ON e.StudentID = s.StudentID
JOIN Courses c ON e.CourseID = c.CourseID;
