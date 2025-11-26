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
-- Table structure for table `exerciselibrary`
--

DROP TABLE IF EXISTS `exerciselibrary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exerciselibrary` (
  `exercise_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8mb3_bin NOT NULL,
  `description` text COLLATE utf8mb3_bin,
  `master_video_url` varchar(255) COLLATE utf8mb3_bin DEFAULT NULL,
  `difficulty_level` varchar(255) COLLATE utf8mb3_bin DEFAULT NULL,
  `focus_area` varchar(255) COLLATE utf8mb3_bin DEFAULT NULL,
  `category_id` int DEFAULT NULL,
  PRIMARY KEY (`exercise_id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `exerciselibrary_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `exercisecategories` (`category_id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exerciselibrary`
--

LOCK TABLES `exerciselibrary` WRITE;
/*!40000 ALTER TABLE `exerciselibrary` DISABLE KEYS */;
INSERT INTO `exerciselibrary` VALUES (1,'Giãn cơ vai gáy','Bài tập đơn giản giúp giảm mỏi vai gáy khi ngồi lâu.','https://example.com/videos/gian_vai_gay','Dễ','Cổ - Vai',1),(2,'Xoay khớp cổ chân','Tăng cường sự linh hoạt cho cổ chân, khởi động trước khi đi bộ.','https://example.com/videos/xoay_co_chan','Dễ','Chân',1),(3,'Giãn cơ lưng dưới (ôm gối)','Nằm ngửa và kéo gối về phía ngực để giảm đau lưng dưới.','https://example.com/videos/gian_lung_duoi','Dễ','Lưng',1),(4,'Đứng một chân (vịn ghế)','Tập giữ thăng bằng cơ bản, luôn có ghế bên cạnh để vịn.','https://example.com/videos/dung_mot_chan','Dễ','Chân & Thăng bằng',2),(5,'Bước đi gót-chạm-mũi (vịn tường)','Cải thiện sự phối hợp và ổn định khi di chuyển.','https://example.com/videos/buoc_got_cham_mui','Trung bình','Thăng bằng',2),(6,'Nhón gót chân (vịn ghế)','Tăng cường sức mạnh cơ bắp chân, hỗ trợ thăng bằng.','https://example.com/videos/nhon_got_chan','Dễ','Chân & Thăng bằng',2),(7,'Đi bộ tại chỗ','Bài tập cardio đơn giản có thể thực hiện mọi lúc trong nhà.','https://example.com/videos/di_bo_tai_cho','Dễ','Toàn thân & Tim mạch',3),(8,'Đạp xe tại chỗ (trên ghế)','Ngồi trên ghế, mô phỏng động tác đạp xe.','https://example.com/videos/dap_xe_ghe','Trung bình','Chân & Tim mạch',3),(9,'Hít thở bằng bụng','Bài tập thở cơ bản giúp thư giãn sâu và tăng cường oxy.','https://example.com/videos/hit_tho_bung','Dễ','Thư giãn & Hô hấp',4),(10,'Tư thế Ngồi vặn mình (trên ghế)','Giãn nhẹ cột sống và cải thiện tiêu hóa, an toàn khi thực hiện trên ghế.','https://example.com/videos/yoga_van_minh_ghe','Dễ','Lưng & Tiêu hóa',4);
/*!40000 ALTER TABLE `exerciselibrary` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-26 21:24:01
