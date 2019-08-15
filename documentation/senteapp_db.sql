-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: senteapp_db
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accounts` (
  `account_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_name` varchar(255) DEFAULT NULL,
  `account_number` varchar(255) DEFAULT NULL,
  `date_created` date DEFAULT NULL,
  `account_manager_member_id` bigint(20) DEFAULT NULL,
  `account_type_id` bigint(20) NOT NULL,
  PRIMARY KEY (`account_id`),
  KEY `FKe6rb7y88xi90h2ecmntyc990m` (`account_manager_member_id`),
  KEY `FKt0unjbb1cct10si7nymsbut42` (`account_type_id`),
  CONSTRAINT `FKe6rb7y88xi90h2ecmntyc990m` FOREIGN KEY (`account_manager_member_id`) REFERENCES `members` (`member_id`),
  CONSTRAINT `FKt0unjbb1cct10si7nymsbut42` FOREIGN KEY (`account_type_id`) REFERENCES `accounttypes` (`account_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` VALUES (1,'Nigerian Hustlers','1001','2019-08-04',NULL,2),(2,'Rwandese Francs','10003','2019-08-04',NULL,2),(3,'Ethopian White Walkers','9023','2019-08-04',NULL,2),(4,'Japanese Donkeys','73364','2019-08-05',NULL,2);
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `accounttypes`
--

DROP TABLE IF EXISTS `accounttypes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accounttypes` (
  `account_type_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_type_name` varchar(255) DEFAULT NULL,
  `account_type_number` int(11) DEFAULT NULL,
  PRIMARY KEY (`account_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounttypes`
--

LOCK TABLES `accounttypes` WRITE;
/*!40000 ALTER TABLE `accounttypes` DISABLE KEYS */;
INSERT INTO `accounttypes` VALUES (1,'Farmers',1000),(2,'Savings',1002),(3,'Saaco',1003);
/*!40000 ALTER TABLE `accounttypes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `addresses`
--

DROP TABLE IF EXISTS `addresses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `addresses` (
  `address_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `zip` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addresses`
--

LOCK TABLES `addresses` WRITE;
/*!40000 ALTER TABLE `addresses` DISABLE KEYS */;
INSERT INTO `addresses` VALUES (1,'Fairfield','United States','IA','1000 North 4th Street','52557'),(2,'Fairfield','United States','IA','1000 North 4th Street','52557'),(3,'Fairfield','United States','IA','1000 North 4th Street','52557'),(4,'Fairfield','United States','IA','1000 North 4th Street','52557');
/*!40000 ALTER TABLE `addresses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `approval`
--

DROP TABLE IF EXISTS `approval`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `approval` (
  `approval_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_account_id` bigint(20) DEFAULT NULL,
  `loan_loan_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`approval_id`),
  KEY `FKb3p2sbwx6ll6g95pc7v4geeb5` (`account_account_id`),
  KEY `FKa5gfvml5a6feuad0koex4weju` (`loan_loan_id`),
  CONSTRAINT `FKa5gfvml5a6feuad0koex4weju` FOREIGN KEY (`loan_loan_id`) REFERENCES `loans` (`loan_id`),
  CONSTRAINT `FKb3p2sbwx6ll6g95pc7v4geeb5` FOREIGN KEY (`account_account_id`) REFERENCES `accounts` (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `approval`
--

LOCK TABLES `approval` WRITE;
/*!40000 ALTER TABLE `approval` DISABLE KEYS */;
/*!40000 ALTER TABLE `approval` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1),(1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `installments`
--

DROP TABLE IF EXISTS `installments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `installments` (
  `installment_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `installment_amount` double DEFAULT NULL,
  `installment_number` int(11) DEFAULT NULL,
  `payment_date` date DEFAULT NULL,
  PRIMARY KEY (`installment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `installments`
--

LOCK TABLES `installments` WRITE;
/*!40000 ALTER TABLE `installments` DISABLE KEYS */;
/*!40000 ALTER TABLE `installments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loans`
--

DROP TABLE IF EXISTS `loans`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loans` (
  `loan_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `application_date` date DEFAULT NULL,
  `date_of_issue` date DEFAULT NULL,
  `due_date` date DEFAULT NULL,
  `loan_amount` double DEFAULT NULL,
  `loan_number` varchar(255) DEFAULT NULL,
  `applicant_member_id` bigint(20) DEFAULT NULL,
  `first_seconder` bigint(20) DEFAULT NULL,
  `second_seconder` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`loan_id`),
  KEY `FKcw3jeumsay10q44tpkmr2wrb3` (`applicant_member_id`),
  KEY `FK14xqv74gg5t8w37wdlxb93sgk` (`first_seconder`),
  KEY `FKs0idr1mguacl7tmb30en78690` (`second_seconder`),
  CONSTRAINT `FK14xqv74gg5t8w37wdlxb93sgk` FOREIGN KEY (`first_seconder`) REFERENCES `members` (`member_id`),
  CONSTRAINT `FKcw3jeumsay10q44tpkmr2wrb3` FOREIGN KEY (`applicant_member_id`) REFERENCES `members` (`member_id`),
  CONSTRAINT `FKs0idr1mguacl7tmb30en78690` FOREIGN KEY (`second_seconder`) REFERENCES `members` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loans`
--

LOCK TABLES `loans` WRITE;
/*!40000 ALTER TABLE `loans` DISABLE KEYS */;
/*!40000 ALTER TABLE `loans` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loans_installments`
--

DROP TABLE IF EXISTS `loans_installments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loans_installments` (
  `loan_loan_id` bigint(20) NOT NULL,
  `installment_list_installment_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_ip310makin1dxhya5a1yrb0tm` (`installment_list_installment_id`),
  KEY `FKp9miv725lhxckhe86mlk83pt8` (`loan_loan_id`),
  CONSTRAINT `FKjlycxpr8y99pr3kr0v9u80shi` FOREIGN KEY (`installment_list_installment_id`) REFERENCES `installments` (`installment_id`),
  CONSTRAINT `FKp9miv725lhxckhe86mlk83pt8` FOREIGN KEY (`loan_loan_id`) REFERENCES `loans` (`loan_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loans_installments`
--

LOCK TABLES `loans_installments` WRITE;
/*!40000 ALTER TABLE `loans_installments` DISABLE KEYS */;
/*!40000 ALTER TABLE `loans_installments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `members`
--

DROP TABLE IF EXISTS `members`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `members` (
  `member_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `contact_number` varchar(255) DEFAULT NULL,
  `date_joined` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `member_number` bigint(20) DEFAULT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `account_account_id` bigint(20) DEFAULT NULL,
  `address_id` bigint(20) DEFAULT NULL,
  `record_id` bigint(20) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`member_id`),
  KEY `FKoqaj8sfj3fe2254gxfqhmg9p4` (`account_account_id`),
  KEY `FK4ud9unvdkt00qkhmy802jvye0` (`address_id`),
  KEY `FK9xpwfixgh4ctpgbxrgn93c1vi` (`record_id`),
  KEY `FKpj3n6wh5muoeakc485whgs3x5` (`user_id`),
  CONSTRAINT `FK4ud9unvdkt00qkhmy802jvye0` FOREIGN KEY (`address_id`) REFERENCES `addresses` (`address_id`),
  CONSTRAINT `FK9xpwfixgh4ctpgbxrgn93c1vi` FOREIGN KEY (`record_id`) REFERENCES `records` (`record_id`),
  CONSTRAINT `FKoqaj8sfj3fe2254gxfqhmg9p4` FOREIGN KEY (`account_account_id`) REFERENCES `accounts` (`account_id`),
  CONSTRAINT `FKpj3n6wh5muoeakc485whgs3x5` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `members`
--

LOCK TABLES `members` WRITE;
/*!40000 ALTER TABLE `members` DISABLE KEYS */;
INSERT INTO `members` VALUES (1,'6415837205','2019-08-15','curbanus @senteapp.com','Chinedu','Urbanus ',10001,'Kinyozi',1,1,4,5),(2,'6415837205','2019-08-15','fnduwayo@senteapp.com','Fabrice','Nduwayo',3001,'',2,2,2,3),(3,'6415837205','2019-08-15','ktaye@senteapp.com','Kirubel','Taye',72733,'',3,3,3,4),(4,'6415837205','2019-08-15','gjujo@senteapp.com','Gaetano','Jujo',2383,'',3,3,6,6);
/*!40000 ALTER TABLE `members` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `records`
--

DROP TABLE IF EXISTS `records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `records` (
  `record_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `record_number` bigint(20) DEFAULT NULL,
  `total_saving` double DEFAULT NULL,
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `records`
--

LOCK TABLES `records` WRITE;
/*!40000 ALTER TABLE `records` DISABLE KEYS */;
INSERT INTO `records` VALUES (1,NULL,NULL),(2,NULL,NULL),(3,NULL,NULL),(4,NULL,NULL),(5,NULL,NULL),(6,NULL,NULL);
/*!40000 ALTER TABLE `records` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `records_loans`
--

DROP TABLE IF EXISTS `records_loans`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `records_loans` (
  `record_record_id` bigint(20) NOT NULL,
  `loan_list_loan_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_jxiudl4qu3ykuayejeekyq9fl` (`loan_list_loan_id`),
  KEY `FKsp4qxyjspw46rqw5da18wuq5q` (`record_record_id`),
  CONSTRAINT `FKf94qs7rnrnhnql5op6saaih9k` FOREIGN KEY (`loan_list_loan_id`) REFERENCES `loans` (`loan_id`),
  CONSTRAINT `FKsp4qxyjspw46rqw5da18wuq5q` FOREIGN KEY (`record_record_id`) REFERENCES `records` (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `records_loans`
--

LOCK TABLES `records_loans` WRITE;
/*!40000 ALTER TABLE `records_loans` DISABLE KEYS */;
/*!40000 ALTER TABLE `records_loans` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `records_savings`
--

DROP TABLE IF EXISTS `records_savings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `records_savings` (
  `record_record_id` bigint(20) NOT NULL,
  `saving_list_saving_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_brptw23vynhaqh0bytm1hchlk` (`saving_list_saving_id`),
  KEY `FKcedabowa7y5uao40nm9glryws` (`record_record_id`),
  CONSTRAINT `FKcedabowa7y5uao40nm9glryws` FOREIGN KEY (`record_record_id`) REFERENCES `records` (`record_id`),
  CONSTRAINT `FKhj6j3qpeek9p58jwkt9gjhvx7` FOREIGN KEY (`saving_list_saving_id`) REFERENCES `savings` (`saving_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `records_savings`
--

LOCK TABLES `records_savings` WRITE;
/*!40000 ALTER TABLE `records_savings` DISABLE KEYS */;
/*!40000 ALTER TABLE `records_savings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ofx66keruapi6vyqpv6f2or37` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_MANAGER'),(3,'ROLE_MEMBER');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `savings`
--

DROP TABLE IF EXISTS `savings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `savings` (
  `saving_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `amount_paid` double DEFAULT NULL,
  `deposit_type` varchar(255) DEFAULT NULL,
  `payment_date` date DEFAULT NULL,
  `verified_payment` bit(1) DEFAULT NULL,
  PRIMARY KEY (`saving_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `savings`
--

LOCK TABLES `savings` WRITE;
/*!40000 ALTER TABLE `savings` DISABLE KEYS */;
/*!40000 ALTER TABLE `savings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`),
  UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin@senteapp.com','$2a$10$pp418WOQMXjc3UFsbQQSkOATEwaKxIpiI6g.7vSOSYTTdd7G/xSIq','admin@senteapp.com'),(2,'curbanus@senteapp.com','$2a$10$pp418WOQMXjc3UFsbQQSkOATEwaKxIpiI6g.7vSOSYTTdd7G/xSIq','curbanus@senteapp.com'),(3,'fnduwayo@senteapp.com','$2a$10$pp418WOQMXjc3UFsbQQSkOATEwaKxIpiI6g.7vSOSYTTdd7G/xSIq','fnduwayo@senteapp.com'),(4,'ktaye@senteapp.com','$2a$10$pp418WOQMXjc3UFsbQQSkOATEwaKxIpiI6g.7vSOSYTTdd7G/xSIq','ktaye@senteapp.com'),(5,'curbanus @senteapp.com','$2a$10$pp418WOQMXjc3UFsbQQSkOATEwaKxIpiI6g.7vSOSYTTdd7G/xSIq','curbanus @senteapp.com'),(6,'gjujo@senteapp.com','$2a$10$pp418WOQMXjc3UFsbQQSkOATEwaKxIpiI6g.7vSOSYTTdd7G/xSIq','gjujo@senteapp.com');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_roles` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  KEY `FKj6m8fwv7oqv74fcehir1a9ffy` (`role_id`),
  KEY `FK2o0jvgh89lemvvo17cbqvdxaa` (`user_id`),
  CONSTRAINT `FK2o0jvgh89lemvvo17cbqvdxaa` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKj6m8fwv7oqv74fcehir1a9ffy` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_roles`
--

LOCK TABLES `users_roles` WRITE;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` VALUES (1,1),(2,2),(3,2),(4,2),(5,3),(6,3);
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-15 16:16:13
