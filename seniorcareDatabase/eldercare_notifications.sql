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
-- Table structure for table `notifications`
--

DROP TABLE IF EXISTS `notifications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notifications` (
  `notification_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `notification_type` varchar(100) COLLATE utf8mb3_bin DEFAULT NULL,
  `reference_id` int DEFAULT NULL,
  `message` varchar(255) COLLATE utf8mb3_bin NOT NULL,
  `is_read` tinyint(1) DEFAULT '0',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `alert_level` varchar(255) COLLATE utf8mb3_bin DEFAULT NULL,
  `alert_status` varchar(255) COLLATE utf8mb3_bin DEFAULT NULL,
  `recipient_type` varchar(255) COLLATE utf8mb3_bin NOT NULL,
  `doctor_id` int DEFAULT NULL,
  PRIMARY KEY (`notification_id`),
  KEY `notifications_ibfk_2` (`doctor_id`),
  KEY `FK9y21adhxn0ayjhfocscqox7bh` (`user_id`),
  CONSTRAINT `FK9y21adhxn0ayjhfocscqox7bh` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `notifications_ibfk_2` FOREIGN KEY (`doctor_id`) REFERENCES `doctors` (`doctor_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notifications`
--

LOCK TABLES `notifications` WRITE;
/*!40000 ALTER TABLE `notifications` DISABLE KEYS */;
INSERT INTO `notifications` VALUES (1,3,'APPOINTMENT_CONFIRMED',456,'Bác sĩ đã xác nhận lịch hẹn của bạn.',0,'2025-11-03 20:29:28',NULL,NULL,'',NULL),(2,3,'Medication Taking',456,'Bạn có thông báo uống thuốc vào lúc 7h30 tối',0,'2025-11-03 20:32:30',NULL,NULL,'',NULL),(3,3,'Medication Taking',456,'Bạn có thông báo uống thuốc vào lúc 7h30 tối',0,'2025-11-03 20:36:34',NULL,NULL,'',NULL),(4,4,'APPOINTMENT_CONFIRMED',55,'Bác sĩ Trần Hoàng Minh đã xác nhận lịch hẹn của bạn vào lúc 14:00 ngày 10/11/2025.',1,'2025-11-06 04:20:52',NULL,NULL,'USER',NULL),(5,4,'MEDICATION_REMINDER',NULL,'Đã đến giờ uống thuốc buổi tối (Thuốc X).',1,'2025-11-06 04:21:57','INFO','RAISED','USER',NULL),(6,NULL,'NEW_APPOINTMENT',901,'Bạn có lịch hẹn mới từ bệnh nhân \'Nguyễn Văn A\' vào lúc 9:00 sáng mai.',0,'2025-11-06 04:25:43',NULL,NULL,'DOCTOR',1),(7,NULL,'ABNORMAL_ALERT',305,'Cảnh báo: Bệnh nhân \'Trần Thị B\' báo cáo chỉ số nhịp tim cao bất thường (135 bpm).',0,'2025-11-06 04:26:42',NULL,NULL,'DOCTOR',1),(8,NULL,'SYSTEM_UPDATE',NULL,'Hệ thống EMR (Bệnh án điện tử) sẽ được cập nhật vào 2:00 sáng nay.',0,'2025-11-06 04:27:32',NULL,NULL,'DOCTOR',1),(9,4,'ABNORMAL_ALERT',82,'Cảnh báo: Chỉ số đường huyết của bạn (180 mg/dL) cao hơn mức an toàn. Vui lòng kiểm tra lại.',1,'2025-11-06 04:45:50','WARNING','RESOLVED','USER',NULL),(10,NULL,NULL,NULL,'Bạn có lịch hẹn mới từ bệnh nhân Dũng Gay với mã lịch hẹn là 3 vào lúc 09:30',0,'2025-11-23 08:43:05',NULL,NULL,'DOCTOR',1),(11,6,NULL,NULL,'Bạn có lịch hẹn mới từ bệnh nhân Dũng Gay với mã lịch hẹn là 3 vào lúc 09:30',0,'2025-11-23 08:43:28',NULL,NULL,'DOCTOR',NULL),(12,NULL,NULL,NULL,'Bạn có lịch hẹn mới từ bệnh nhân Dũng Gay với mã lịch hẹn là 4 vào lúc 09:30',0,'2025-11-23 08:44:41',NULL,NULL,'DOCTOR',1),(13,6,NULL,NULL,'Bạn có lịch hẹn mới từ bệnh nhân Dũng Gay với mã lịch hẹn là 4 vào lúc 09:30',0,'2025-11-23 08:44:42',NULL,NULL,'DOCTOR',NULL),(14,NULL,NULL,NULL,'Bạn có lịch hẹn mới từ bệnh nhân Dũng Gay với mã lịch hẹn là 5 vào lúc 09:30',0,'2025-11-23 08:51:00',NULL,NULL,'DOCTOR',1),(15,6,NULL,NULL,'Bạn có lịch hẹn mới từ bệnh nhân Dũng Gay với mã lịch hẹn là 5 vào lúc 09:30',0,'2025-11-23 08:51:28',NULL,NULL,'PATIENT',NULL),(16,NULL,NULL,NULL,'Bạn có lịch hẹn mới từ bệnh nhân Dũng Gay với mã lịch hẹn là 6 vào lúc 09:30',0,'2025-11-23 08:54:30',NULL,NULL,'DOCTOR',1),(17,6,NULL,NULL,'Bạn đã đặt lịch với bác sĩ Trần Hoàng Minh vào khoảng thời gian 2025-11-15T09:30 với mã của buổi hẹn là 6',0,'2025-11-23 08:54:30',NULL,NULL,'PATIENT',NULL),(18,NULL,NULL,NULL,'Cuộc hẹn có mã là 3 với bệnh nhân Dũng Gay vào khoảng thời gian 2025-11-15T09:30 đã bị hủy',0,'2025-11-23 09:10:27',NULL,NULL,'DOCTOR',1),(19,6,NULL,NULL,'Cuộc hẹn có mã là 3 với bác sĩ Trần Hoàng Minh vào khoảng thời gian 2025-11-15T09:30 đã bị hủy',0,'2025-11-23 09:11:10',NULL,NULL,'PATIENT',NULL),(20,NULL,NULL,NULL,'Cuộc hẹn có mã là 3 với bệnh nhân Dũng Gay vào khoảng thời gian 2025-11-15T09:30 đã bị hủy',0,'2025-11-23 09:13:37',NULL,NULL,'DOCTOR',1),(21,NULL,NULL,NULL,'Cuộc hẹn có mã là 4 với bệnh nhân Dũng Gay vào khoảng thời gian 2025-11-15T09:30 đã bị hủy',0,'2025-11-23 09:13:59',NULL,NULL,'DOCTOR',1),(22,6,NULL,NULL,'Cuộc hẹn có mã là 4 với bác sĩ Trần Hoàng Minh vào khoảng thời gian 2025-11-15T09:30 đã bị hủy',0,'2025-11-23 09:14:34',NULL,NULL,'PATIENT',NULL),(23,6,NULL,NULL,'Cuộc hẹn có mã là 3 với bác sĩ Trần Hoàng Minh vào khoảng thời gian 2025-11-15T09:30 đã bị hủy',0,'2025-11-23 09:14:34',NULL,NULL,'PATIENT',NULL),(24,6,NULL,NULL,'Cuộc hẹn có mã là 5 với bác sĩ Trần Hoàng Minh vào khoảng thời gian 2025-11-15T09:45 đã thay đổi, bệnh nhân chú ý theo dõi thông báo để cập nhật thông tin kịp thời',0,'2025-11-23 09:28:45',NULL,NULL,'PATIENT',NULL),(25,6,'MEDICATION_REMINDER',1,'Đã đến giờ uống thuốc: Panadol Extra. Liều lượng: 1 viên',0,'2025-11-25 08:11:44','INFO','RAISED','USER',NULL),(26,6,'MEDICATION_REMINDER',2,'Đã đến giờ uống thuốc: Panadol Extra. Liều lượng: 1 viên',0,'2025-11-25 08:12:27','INFO','RAISED','USER',NULL),(27,6,'MEDICATION_REMINDER',3,'Đã đến giờ uống thuốc: Panadol Extra. Liều lượng: 1 viên',0,'2025-11-25 08:12:27','INFO','RAISED','USER',NULL),(28,6,'MEDICATION_REMINDER',16,'Đã đến giờ uống thuốc: Thuốc mẹ mày béo. Liều lượng: 10 viên',0,'2025-11-25 08:16:33','INFO','RAISED','USER',NULL),(29,6,'MEDICATION_REMINDER',17,'Đã đến giờ uống thuốc: Thuốc mẹ mày béo. Liều lượng: 10 viên',0,'2025-11-25 08:16:37','INFO','RAISED','USER',NULL),(30,6,'MEDICATION_REMINDER',4,'Đã đến giờ uống thuốc: Panadol Extra. Liều lượng: 1 viên',0,'2025-11-26 01:32:06','INFO','RAISED','USER',NULL),(31,6,'MEDICATION_REMINDER',5,'Đã đến giờ uống thuốc: Panadol Extra. Liều lượng: 1 viên',0,'2025-11-26 01:32:07','INFO','RAISED','USER',NULL),(32,6,'MEDICATION_REMINDER',18,'Đã đến giờ uống thuốc: Thuốc mẹ mày béo. Liều lượng: 10 viên',0,'2025-11-26 01:32:09','INFO','RAISED','USER',NULL),(33,6,'MEDICATION_REMINDER',19,'Đã đến giờ uống thuốc: Thuốc mẹ mày béo. Liều lượng: 10 viên',0,'2025-11-26 01:32:10','INFO','RAISED','USER',NULL);
/*!40000 ALTER TABLE `notifications` ENABLE KEYS */;
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
