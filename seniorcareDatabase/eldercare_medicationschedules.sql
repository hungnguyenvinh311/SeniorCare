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
-- Table structure for table `medicationschedules`
--

DROP TABLE IF EXISTS `medicationschedules`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicationschedules` (
  `schedule_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `prescription_id` int NOT NULL,
  `scheduled_time` datetime NOT NULL,
  `status` varchar(50) COLLATE utf8mb3_bin DEFAULT 'Pending',
  PRIMARY KEY (`schedule_id`),
  KEY `user_id` (`user_id`),
  KEY `prescription_id` (`prescription_id`),
  CONSTRAINT `medicationschedules_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `medicationschedules_ibfk_2` FOREIGN KEY (`prescription_id`) REFERENCES `prescriptions` (`prescription_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicationschedules`
--

LOCK TABLES `medicationschedules` WRITE;
/*!40000 ALTER TABLE `medicationschedules` DISABLE KEYS */;
INSERT INTO `medicationschedules` VALUES (1,6,1,'2025-11-25 08:00:00','Notified'),(2,6,1,'2025-11-25 14:00:00','Notified'),(3,6,1,'2025-11-25 20:00:00','Notified'),(4,6,1,'2025-11-26 08:00:00','Notified'),(5,6,1,'2025-11-26 14:00:00','Notified'),(6,6,1,'2025-11-26 20:00:00','Pending'),(7,6,1,'2025-11-27 08:00:00','Pending'),(8,6,1,'2025-11-27 14:00:00','Pending'),(9,6,1,'2025-11-27 20:00:00','Pending'),(10,6,1,'2025-11-28 08:00:00','Pending'),(11,6,1,'2025-11-28 14:00:00','Pending'),(12,6,1,'2025-11-28 20:00:00','Pending'),(13,6,1,'2025-11-29 08:00:00','Pending'),(14,6,1,'2025-11-29 14:00:00','Pending'),(15,6,1,'2025-11-29 20:00:00','Pending'),(16,6,2,'2025-11-25 08:00:00','Notified'),(17,6,2,'2025-11-25 14:00:00','Notified'),(18,6,2,'2025-11-26 08:00:00','Notified'),(19,6,2,'2025-11-26 14:00:00','Notified'),(20,6,2,'2025-11-27 08:00:00','Pending'),(21,6,2,'2025-11-27 14:00:00','Pending'),(22,6,2,'2025-11-28 08:00:00','Pending'),(23,6,2,'2025-11-28 14:00:00','Pending'),(24,6,2,'2025-11-29 08:00:00','Pending'),(25,6,2,'2025-11-29 14:00:00','Pending');
/*!40000 ALTER TABLE `medicationschedules` ENABLE KEYS */;
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
