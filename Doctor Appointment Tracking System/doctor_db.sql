-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: doctor_db
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `doctor_details`
--

DROP TABLE IF EXISTS `doctor_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctor_details` (
  `DoctorID` varchar(45) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `Gender` varchar(45) NOT NULL,
  `Phone` varchar(10) NOT NULL,
  `Days` varchar(28) NOT NULL,
  `Timing` varchar(45) NOT NULL,
  `Qualification` varchar(45) NOT NULL,
  `Field` varchar(100) NOT NULL,
  `Experience` varchar(20) NOT NULL,
  PRIMARY KEY (`DoctorID`),
  UNIQUE KEY `Phone_UNIQUE` (`Phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor_details`
--

LOCK TABLES `doctor_details` WRITE;
/*!40000 ALTER TABLE `doctor_details` DISABLE KEYS */;
INSERT INTO `doctor_details` VALUES ('100','Aman','LKO','@aman','Male','9874563215','Mon,Tue,Wed,Thu,Fri,Sat,','9am-6pm','MBBS','Surgery','5 Years'),('101','Sumya','Lucknow','@sumys1111','Female','1111111111','Thu,Fri,','7am-4pm','MBBS','Heart','7 Years'),('102','Rohan','LKO','@rohan','Male','2222222222','Mon,Tue,Wed,Thu,Fri,Sat,Sun,','9am-5pm','MS','Nose','3 Years'),('103','Rajesh','LKO','@rajesh','Male','1478523690','Mon,Tue,Wed,Thu,Fri,Sat,','8am-4pm','MS','Ear','5 Years'),('104','Neha','SPN','@neha','Female','4444444444','Mon,Thu,Fri,Sat,Sun,','10am-3pm','MBBS','nose','4 Years'),('106','Aryan','LKO','@aryan','Male','7897739391','Tue,Wed,Sat,','6am-2pm','MD','Legs','6 Years'),('108','ARYAN','LKO','@aryan','Male','8888888888','Mon,Thu,Sat,','6am-2pm','Legs','MD','6 Years'),('109','Manish','spn','@mohit','Female','1091091091','Tue,Wed,Sat,Sun,','8am-3pm','MD','leg','2 Years'),('111','Gunnu','LKO','@gunnu','Female','1111111110','Mon,Tue,Thu,Fri,Sat,Sun,','10am-4pm','MBBS','heart','1 Years');
/*!40000 ALTER TABLE `doctor_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_details`
--

DROP TABLE IF EXISTS `patient_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient_details` (
  `AppointmentNo` int NOT NULL AUTO_INCREMENT,
  `PatientName` varchar(45) NOT NULL,
  `Gender` varchar(12) NOT NULL,
  `Age` varchar(3) NOT NULL,
  `Phone` varchar(10) NOT NULL,
  `Problem` varchar(225) NOT NULL,
  `DoctorID` varchar(45) NOT NULL,
  `Date` varchar(10) DEFAULT NULL,
  `AppointmentDate` varchar(10) DEFAULT NULL,
  `Token` varchar(10) NOT NULL,
  `AppointmentMode` varchar(20) NOT NULL,
  `PatientVisit` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`AppointmentNo`,`Token`),
  UNIQUE KEY `Phone_UNIQUE` (`Phone`),
  UNIQUE KEY `AppointmentNo_UNIQUE` (`AppointmentNo`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_details`
--

LOCK TABLES `patient_details` WRITE;
/*!40000 ALTER TABLE `patient_details` DISABLE KEYS */;
INSERT INTO `patient_details` VALUES (1,'s','Female','45','87451275','tfgyh','101','19-08-2022','19-08-2022','Tok2193','Mannual','Yes'),(2,'s','Female','45','6789876','dfcgvbh','106','05-08-2022','05-08-2022','Tok9233','Phone','Yes'),(4,'gg','Female','33','56786554','head','107','12-08-2022','19-08-2022','Tok7275','Phone','No'),(6,'tt','Male','54','567765','ear','106','18-08-2022','18-08-2022','Tok9615','Phone','Yes'),(7,'dd','Male','33','1111111111','teeth','106','04-08-2022','04-08-2022','Tok1125','Phone','Yes'),(8,'qq','Transgender','44','8888811111','nose','105','01-08-2022','01-08-2022','Tok8810','Mannual','Yes'),(9,'ee','Transgender','66','5666','hand','103','04-08-2022','04-08-2022','Tok4524','Phone','No'),(11,'ee','Transgender','66','566621','hand','103','04-08-2022','04-08-2022','Tok9903','Phone','No'),(12,'ee','Male','66','566621232','hand','101','06-08-2022','06-08-2022','Tok5983','Phone','No'),(16,'ee','Male','22','567876541','hh','100','10-08-2022','10-08-2022','Tok4476','Phone','No'),(17,'ww','Male','11','152634','ff','100','08-08-2022','08-08-2022','Tok1752','Phone','No'),(18,'mohit','Male','40','6663725','heart','104','20-08-2022','20-08-2022','Tok8805','Phone','No'),(21,'Rishu','Male','24','8194725','heart','102','20-08-2022','18-08-2022','Tok5137','Phone','No'),(22,'Anshu','Male','31','292929292','Nose','101','20-08-2022','22-08-2022','Tok2929','Mannual','Yes'),(26,'Riya','Female','22','6785725','Nose','102','20-08-2022','22-08-2022','Tok9948','Mannual','No'),(29,'Riya','Female','22','5555725','Nose','102','20-08-2022','22-08-2022','Tok8081','Mannual','No'),(30,'xyz','Male','16','98171527','Pain','102','19-08-2022','23-08-2022','Tok9620','Mannual','No'),(33,'asd','Male','15','52471527','Pain','104','19-08-2022','24-08-2022','Tok7692','Phone','No'),(34,'Soni','Male','10','22224365','Chest','108','20-08-2022','23-08-2022','Tok3472','Phone','No'),(35,'arya','Female','25','66664365','Hnd','104','20-08-2022','23-08-2022','Tok9211','Phone','Yes'),(38,'ff','Transgender','34','000000000','dfcgvb','108','20-08-2022','27-08-2022','Tok1731','Phone','No'),(40,'cc','Male','45','87494','rdtfgyhj','102','20-08-2022','27-08-2022','Tok2778','Phone','No'),(44,'cc','Male','45','7794','rdtfgyhj','102','20-08-2022','27-08-2022','Tok6144','Phone','No'),(45,'Rohit','Male','88','5555555','pain','103','20-08-2022','27-08-2022','Tok8230','Mannual','No'),(48,'Scott','Male','22','1234567890','pain','111','2022-08-21','23-08-2022','Tok6739','Phone','No'),(49,'Scott','Male','22','9876543210','asd','111','2022-08-21','23-08-2022','Tok7289','Phone','No'),(50,'Aman','Male','21','5769846123','pain','102','2022-08-21','23-08-2022','Tok2708','Phone','No'),(51,'Ansu','Male','43','7548962130','pain','104','2022-08-21','23-08-2022','Tok5141','Mannual','No'),(52,'Ayush','Male','54','3698741250','eye','109','2022-08-22','24-08-2022','Tok2455','Phone','No'),(53,'Rina','Female','36','5824716930','brain','103','2022-08-22','24-08-2022','Tok4293','Phone','No');
/*!40000 ALTER TABLE `patient_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-22  1:09:14
