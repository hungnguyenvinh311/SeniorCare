-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: eldercare
-- ------------------------------------------------------
-- Server version	9.4.0

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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `full_name` varchar(255) COLLATE utf8mb3_bin NOT NULL,
  `date_of_birth` datetime(6) DEFAULT NULL,
  `phone_number` varchar(255) COLLATE utf8mb3_bin NOT NULL,
  `password_hash` varchar(255) COLLATE utf8mb3_bin NOT NULL,
  `hometown` varchar(255) COLLATE utf8mb3_bin DEFAULT NULL,
  `current_address` varchar(255) COLLATE utf8mb3_bin DEFAULT NULL,
  `profile_picture_url` varchar(255) COLLATE utf8mb3_bin DEFAULT NULL,
  `hobbies` varchar(255) COLLATE utf8mb3_bin DEFAULT NULL,
  `personal_story` varchar(255) COLLATE utf8mb3_bin DEFAULT NULL,
  `emergency_contact_phone` varchar(255) COLLATE utf8mb3_bin DEFAULT NULL,
  `emergency_contact_email` varchar(255) COLLATE utf8mb3_bin DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `phone_number` (`phone_number`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (3,'Nguyen','2000-03-25 00:00:00.000000','0123456788','$2a$10$Ye8e19.efFb8KObparO4eep4BHTwoilRzS3.VuIoL6JzRl4tz/Q1S','Ho Chi Minh City','Binh Thanh Ho Chi Minh City',NULL,'Cooking',NULL,NULL,NULL,'2025-11-04 03:07:10'),(4,'Nguyen Van A','2000-06-25 00:00:00.000000','0123456787','$2a$10$fwbqe0NkmkBYvv6UW2T1A.muI7YssGtLb0AQLVphBpemevv9JpCeC','Ho Chi Minh City','Binh Thanh Ho Chi Minh City',NULL,'Cooking',NULL,NULL,NULL,'2025-11-04 03:10:07'),(5,'An Khuềnh','2000-03-25 07:00:00.000000','0123456589','$2a$10$I97LbfEFRYugUT1m/Mrure1Cg1dpVzknEHs8amRw94mmws.JM.Aue',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2025-11-08 10:08:33'),(6,'Dũng Gay','2003-04-12 07:00:00.000000','0123456581','$2a$10$Cf48pf5IbkACarzUOjgvsuBUtMTRb/Z8yT.gzRt6TCFUNfgRCe5Ta',NULL,NULL,NULL,'lọ',NULL,NULL,NULL,'2025-11-08 10:09:47');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-26 21:24:02
