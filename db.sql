CREATE DATABASE  IF NOT EXISTS `product` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `product`;
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: product
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
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `category` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `brand` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `type` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `description` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UX_product_code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'P001','MASK ADULT Surgical 3 ply 50\'S MEDICOS with box','Health Accessories','Medicos','Hygiene','Colour: Blue (ear loop outside, ear loop inside- random assigned), Green, Purple, White, Lime Green, Yellow, Pink','2024-08-27 02:30:31','2024-08-27 02:30:31'),(2,'P002','Party Cosplay Player Unknown Battlegrounds Clothes Hallowmas PUBG','Men\'s Clothing','No Brand',NULL,'Suitable for adults and children.','2024-08-27 02:30:31','2024-08-27 02:30:31'),(3,'P003','Xiaomi REDMI 8A Official Global Version 5000 mAh battery champion 31 days 2GB+32GB','Mobile & Gadgets','Xiaomi','Mobile Phones','Xiaomi Redmi 8A','2024-08-27 02:30:31','2024-08-27 02:30:31'),(4,'P004','Naelofar Sofis - Printed Square','Hijab','Naelofar','Multi Colour Floral','Ornate Iris flower composition with intricate growing foliage','2024-08-27 02:30:31','2024-08-27 02:30:31'),(6,'P006','Gemei GM-6005 Rechargeable Trimmer Hair Cutter Machine','Hair Styling Tools','Gemei','Trimmer','The GEMEI hair clipper is intended for professional use.','2024-08-27 02:30:31','2024-08-27 02:30:31'),(7,'P007','Oreo Crumb Small Crushed Cookie Pieces 454g','Snacks','Oreo','Biscuits & Cookies','Oreo Crumb Small Crushed Cookie Pieces 454g - Retail & Wholesale New Stock Long Expiry!!!','2024-08-27 02:30:31','2024-08-27 02:30:31'),(8,'P008','Non-contact Infrared Forehead Thermometer ABS','Kids Health & Skincare','No Brand',NULL,'Non-contact Infrared Forehead Thermometer ABS for Adults and Children with LCD Display Digital','2024-08-27 02:30:31','2024-08-27 02:30:31'),(9,'P009','Nordic Marble Starry Sky Bedding Sets','Bedding','No Brand','Bedding Sheets','Printing process: reactive printing. Package：quilt cover ,bed sheet ,pillow case. Not include comforter or quilt.','2024-08-27 02:30:31','2024-08-27 02:30:31'),(10,'P010','Samsung Galaxy Tab A 10.1\"','Mobile & Gadgets','Samsung','Tablets','4GB RAM. - 64GB ROM. - 1.5 ghz Processor. - 10.1 inches LCD Display','2024-08-27 02:30:31','2024-08-27 02:30:31'),(11,'P011','REALME 5 PRO 6+128GB','Mobile & Gadgets','Realme','Mobile Phones','REALME 5 PRO 6+128GB','2024-08-27 02:30:31','2024-08-27 02:30:31'),(13,'P013','AKEMI Cotton Select Fitted Bedsheet Set - Adore 730TC','Bedding','Akemi','Bedding Sheets','100% Cotton Twill. Super Single.','2024-08-27 02:30:31','2024-08-27 02:30:31'),(14,'P014','Samsung Note10+ Phone','Mobile & Gadgets','OEM','Mobile Phones','OEM Phone Models','2024-08-27 02:30:31','2024-08-27 02:30:31'),(19,'P018','MASK ADULT Surgical 3 ply 50\'S MEDICOS with box','Health Accessories','Medicos','Hygiene',' Blue (ear loop outside, ear loop inside- random assigned), Green, Purple, White, Lime Green, Yellow, Pink','2024-08-29 20:59:37','2024-08-29 20:59:37'),(22,'P0020','MASK ADULT Surgical 3 ply 50\'S MEDICOS with box','Health Accessories','Medicos','Hygiene',': Blue (ear loop outside, ear loop inside- random assigned), Green, Purple, White, Lime Green, Yellow, Pink','2024-08-30 01:13:40','2024-08-30 01:13:40'),(23,'P024','Party Cosplay Player Unknown Battlegrounds Clothes Hallowmas PUBG','Men\'s Clothing','No Brand',NULL,'Suitable for adults and children.','2024-08-30 03:23:51','2024-08-30 03:23:51'),(24,'P019','MASK ADULT Surgical 3 ply 50\'S MEDICOS with box','Health Accessories','Medicos','Hygiene',' Blue (ear loop outside, ear loop inside- random assigned), Green, Purple, White, Lime Green, Yellow, Pink','2024-09-05 10:20:55','2024-09-05 10:20:55'),(25,'P0024','Non-contact Infrared Forehead Thermometer ABS','Kids Health & Skincare','No Brand',NULL,'Non-contact Infrared Forehead Thermometer ABS for Adults and Children with LCD Display Digital','2024-09-05 11:17:20','2024-09-05 11:17:20'),(26,'string','string','string','string','string','string','2024-09-05 21:55:59','2024-09-05 21:55:59'),(28,'ps009','string','string','string','string','string','2024-09-15 23:39:34','2024-09-15 23:39:34'),(29,'ps34','string','string','string','string','string',NULL,NULL),(30,'ps07','string','string','string','string','string',NULL,NULL),(31,'ps9','string','string','string','string','string',NULL,NULL),(33,'ps999','string','string','string','string','string',NULL,NULL),(38,'ps233','string','string','string','string','string',NULL,NULL);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKob8kqyqqgmefl0aco34akdtpe` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'john.doe@example.com','User','$2a$10$R.mNDyr8m8P/Mxj6jCdsw.Xs1ZjEmG9K4zoTDDwY5bGmTLK0QoyyC','USER'),(2,'jane.admin@example.com','Admin','$2a$10$2.mASuiMk.PZkSyworj9se2cc30OCY7ZWSpVVVVLtBJ1Ek6uyVaka','ADMIN');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_seq`
--

DROP TABLE IF EXISTS `user_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_seq`
--

LOCK TABLES `user_seq` WRITE;
/*!40000 ALTER TABLE `user_seq` DISABLE KEYS */;
INSERT INTO `user_seq` VALUES (1);
/*!40000 ALTER TABLE `user_seq` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-20 16:02:59
