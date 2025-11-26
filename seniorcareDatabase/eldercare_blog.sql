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
-- Table structure for table `blog`
--

DROP TABLE IF EXISTS `blog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blog` (
  `content_id` int NOT NULL AUTO_INCREMENT,
  `content_type` varchar(255) COLLATE utf8mb3_bin NOT NULL,
  `title` varchar(255) COLLATE utf8mb3_bin NOT NULL,
  `description` text COLLATE utf8mb3_bin,
  `content_body_or_url` text COLLATE utf8mb3_bin NOT NULL,
  `thumbnail_url` varchar(255) COLLATE utf8mb3_bin DEFAULT NULL,
  `author` varchar(255) COLLATE utf8mb3_bin DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `category_id` int DEFAULT NULL,
  PRIMARY KEY (`content_id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `blog_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `blogcategories` (`category_id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog`
--

LOCK TABLES `blog` WRITE;
/*!40000 ALTER TABLE `blog` DISABLE KEYS */;
INSERT INTO `blog` VALUES (1,'NEWS','Giá xăng tăng mạnh, vượt mốc 30.000 đồng/lít','Giá xăng RON95 đã chính thức tăng thêm 1.500 đồng, ảnh hưởng lớn đến chi phí vận tải.','https://example-news.com/gia-xang-tang-manh-hom-nay','https://example-news.com/images/xang-tang.jpg','Nguyễn Văn A','2025-11-12 01:34:18',NULL),(2,'VIDEO','Hướng dẫn nấu phở bò Hà Nội chuẩn vị','Bí quyết để có nồi nước dùng trong, ngọt thanh và thơm lừng vị phở truyền thống.','https://www.youtube.com/watch?v=abcdef123','https://i.ytimg.com/vi/abcdef123/hqdefault.jpg','Trần Thị B','2025-11-12 02:33:55',1),(3,'NEWS','Chỉ số VN-Index phục hồi ấn tượng cuối phiên','Dòng tiền bắt đáy đổ vào nhóm cổ phiếu ngân hàng và bất động sản giúp thị trường hồi phục.','https://example-news.com/chung-khoan-phuc-hoi-103','https://example-news.com/images/vn-index.jpg','Lê Minh C','2025-11-12 02:35:25',6);
/*!40000 ALTER TABLE `blog` ENABLE KEYS */;
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
