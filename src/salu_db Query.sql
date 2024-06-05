CREATE DATABASE `salu_db`; 


CREATE TABLE `course_type` (
  `Course_Type_ID` int NOT NULL AUTO_INCREMENT,
  `Course_Type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Course_Type_ID`)
);

CREATE TABLE `courses` (
  `Course_ID` int NOT NULL AUTO_INCREMENT,
  `Course_Name` varchar(50) DEFAULT NULL,
  `course_duration` varchar(50) DEFAULT NULL,
  `Course_Type_ID` int DEFAULT NULL,
  `Sems_ID` int DEFAULT NULL,
  `dept_id` int DEFAULT NULL,
  `Semester` varchar(50) DEFAULT NULL,
  `Department` varchar(50) DEFAULT NULL,
  `course_Type` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`Course_ID`),
  KEY `Course_Type_ID` (`Course_Type_ID`),
  KEY `Sems_ID` (`Sems_ID`),
  KEY `dept_id` (`dept_id`),
  CONSTRAINT `courses_ibfk_1` FOREIGN KEY (`Course_Type_ID`) REFERENCES `course_type` (`Course_Type_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `courses_ibfk_2` FOREIGN KEY (`Sems_ID`) REFERENCES `semester` (`Sems_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `dept_id` FOREIGN KEY (`dept_id`) REFERENCES `department` (`Dept_ID`)
);

CREATE TABLE `department` (
  `Dept_ID` int NOT NULL AUTO_INCREMENT,
  `Department` varchar(50) DEFAULT NULL,
  `Emp_ID` int DEFAULT NULL,
  `HOD` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Dept_ID`),
  KEY `Emp_ID` (`Emp_ID`),
  CONSTRAINT `department_ibfk_1` FOREIGN KEY (`Emp_ID`) REFERENCES `employee` (`Emp_ID`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `employe_leave` (
  `l_id` int NOT NULL AUTO_INCREMENT,
  `date` varchar(30) DEFAULT NULL,
  `duration` varchar(30) DEFAULT NULL,
  `emp_id` int DEFAULT NULL,
  PRIMARY KEY (`l_id`),
  KEY `emp_id_idx` (`emp_id`),
  CONSTRAINT `emp_id` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`Emp_ID`)
);

CREATE TABLE `employee` (
  `Emp_ID` int NOT NULL AUTO_INCREMENT,
  `employee` varchar(50) DEFAULT NULL,
  `Designation` varchar(50) DEFAULT NULL,
  `Emp_Type_ID` int DEFAULT NULL,
  `Gender` varchar(30) DEFAULT NULL,
  `Father_Name` varchar(50) DEFAULT NULL,
  `cnic` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `City` varchar(50) DEFAULT NULL,
  `emp_Type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Emp_ID`),
  KEY `Emp_Type_ID` (`Emp_Type_ID`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`Emp_Type_ID`) REFERENCES `employee_type` (`Emp_Type_ID`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `employee_type` (
  `Emp_Type_ID` int NOT NULL AUTO_INCREMENT,
  `Emp_Type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Emp_Type_ID`)
);

CREATE TABLE `exam_type` (
  `Exam_Type_ID` int NOT NULL AUTO_INCREMENT,
  `Exam_Type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Exam_Type_ID`)
);

CREATE TABLE `fee_structure` (
  `fee_str_id` int NOT NULL AUTO_INCREMENT,
  `department` varchar(50) DEFAULT NULL,
  `amount_per_sems` double DEFAULT NULL,
  `dept_id` int DEFAULT NULL,
  PRIMARY KEY (`fee_str_id`),
  KEY `dept_id` (`dept_id`),
  CONSTRAINT `fee_structure_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `department` (`Dept_ID`)
);

CREATE TABLE `fees` (
  `fee_id` int NOT NULL AUTO_INCREMENT,
  `amount` double DEFAULT NULL,
  `fee_date` varchar(30) DEFAULT NULL,
  `Roll_no` int DEFAULT NULL,
  `semester` varchar(20) DEFAULT NULL,
  `Stu_Roll_No` int DEFAULT NULL,
  `fee_str_id` int DEFAULT NULL,
  `department` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`fee_id`),
  KEY `Stu_Roll_No` (`Stu_Roll_No`),
  KEY `fee_str_id` (`fee_str_id`),
  CONSTRAINT `fee_str_id` FOREIGN KEY (`fee_str_id`) REFERENCES `fee_structure` (`fee_str_id`),
  CONSTRAINT `fees_ibfk_1` FOREIGN KEY (`Stu_Roll_No`) REFERENCES `student` (`Roll_No`)
);

CREATE TABLE `login_data` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(30) DEFAULT NULL,
  `last_name` varchar(30) DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `results` (
  `Result_ID` int NOT NULL AUTO_INCREMENT,
  `Course1` varchar(50) DEFAULT NULL,
  `Course2` varchar(50) DEFAULT NULL,
  `Course3` varchar(50) DEFAULT NULL,
  `Course4` varchar(50) DEFAULT NULL,
  `exam_type_id` int DEFAULT NULL,
  `Stu_Roll_No` int DEFAULT NULL,
  `course_id` int DEFAULT NULL,
  `Roll_No` int DEFAULT NULL,
  `CGPA` double DEFAULT NULL,
  `Grade` varchar(4) DEFAULT NULL,
  `Average` double DEFAULT NULL,
  `Remarks` double DEFAULT NULL,
  `Course1_Marks` int DEFAULT NULL,
  `Course2_Marks` int DEFAULT NULL,
  `Course3_Marks` int DEFAULT NULL,
  `Course4_Marks` int DEFAULT NULL,
  PRIMARY KEY (`Result_ID`),
  KEY `exam_type_id` (`exam_type_id`),
  KEY `Stu_Roll_No` (`Stu_Roll_No`),
  KEY `course_id` (`course_id`),
  CONSTRAINT `course_id` FOREIGN KEY (`course_id`) REFERENCES `courses` (`Course_ID`),
  CONSTRAINT `results_ibfk_1` FOREIGN KEY (`exam_type_id`) REFERENCES `exam_type` (`Exam_Type_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `results_ibfk_2` FOREIGN KEY (`Stu_Roll_No`) REFERENCES `student` (`Roll_No`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `semester` (
  `Sems_ID` int NOT NULL AUTO_INCREMENT,
  `Semester_No` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Sems_ID`)
);

CREATE TABLE `student` (
  `Roll_No` int NOT NULL AUTO_INCREMENT,
  `student` varchar(50) DEFAULT NULL,
  `Father_Name` varchar(50) DEFAULT NULL,
  `Address` varchar(150) DEFAULT NULL,
  `DateOfBirth` varchar(30) DEFAULT NULL,
  `HSC_Per` varchar(5) DEFAULT NULL,
  `Phone_No` varchar(20) DEFAULT NULL,
  `CNIC` varchar(40) DEFAULT NULL,
  `Batch` varchar(10) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `Dept_ID` int DEFAULT NULL,
  `Department` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Roll_No`),
  KEY `Dept_ID` (`Dept_ID`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`Dept_ID`) REFERENCES `department` (`Dept_ID`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `student_leave` (
  `l_id` int NOT NULL AUTO_INCREMENT,
  `date` varchar(30) DEFAULT NULL,
  `duration` varchar(30) DEFAULT NULL,
  `roll_no` int DEFAULT NULL,
  PRIMARY KEY (`l_id`),
  KEY `roll_no_idx` (`roll_no`),
  CONSTRAINT `roll_no` FOREIGN KEY (`roll_no`) REFERENCES `student` (`Roll_No`) ON DELETE CASCADE ON UPDATE CASCADE
);