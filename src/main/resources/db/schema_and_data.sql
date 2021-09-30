-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: oswap
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `cart_id` bigint NOT NULL,
  `cart_token` varchar(255) DEFAULT NULL,
  `session_id` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`cart_id`),
  KEY `FKl70asp4l4w0jmbm1tqyofho4o` (`user_id`),
  CONSTRAINT `FKl70asp4l4w0jmbm1tqyofho4o` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (2,'46s791g328h453l278u65','46s791g328h453l278u65',1);
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart_item`
--

DROP TABLE IF EXISTS `cart_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart_item` (
  `cart_item_id` bigint NOT NULL,
  `cart_item_created_at` date NOT NULL,
  `quantity` int NOT NULL,
  `cart_id` bigint NOT NULL,
  `product_id` bigint NOT NULL,
  PRIMARY KEY (`cart_item_id`),
  KEY `FK1uobyhgl1wvgt1jpccia8xxs3` (`cart_id`),
  KEY `FKjcyd5wv4igqnw413rgxbfu4nv` (`product_id`),
  CONSTRAINT `FK1uobyhgl1wvgt1jpccia8xxs3` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`cart_id`),
  CONSTRAINT `FKjcyd5wv4igqnw413rgxbfu4nv` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_item`
--

LOCK TABLES `cart_item` WRITE;
/*!40000 ALTER TABLE `cart_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `country` (
  `country_id` bigint NOT NULL,
  `country_isd_code` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`country_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (3);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image`
--

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `image` (
  `image_id` bigint NOT NULL,
  `file_name` varchar(255) NOT NULL,
  `product_id` bigint DEFAULT NULL,
  PRIMARY KEY (`image_id`),
  KEY `FKgpextbyee3uk9u6o2381m7ft1` (`product_id`),
  CONSTRAINT `FKgpextbyee3uk9u6o2381m7ft1` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_item`
--

DROP TABLE IF EXISTS `order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_item` (
  `order_item_id` bigint NOT NULL,
  `order_item_added_at` date NOT NULL,
  `order_item_price` double NOT NULL,
  `order_item_quantity` int NOT NULL,
  `product_id` bigint DEFAULT NULL,
  `order_settings_id` bigint DEFAULT NULL,
  PRIMARY KEY (`order_item_id`),
  KEY `FK551losx9j75ss5d6bfsqvijna` (`product_id`),
  KEY `FKd8ucrjbxfk2xna396vx8qdov5` (`order_settings_id`),
  CONSTRAINT `FK551losx9j75ss5d6bfsqvijna` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `FKd8ucrjbxfk2xna396vx8qdov5` FOREIGN KEY (`order_settings_id`) REFERENCES `order_settings` (`order_settings_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_item`
--

LOCK TABLES `order_item` WRITE;
/*!40000 ALTER TABLE `order_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_settings`
--

DROP TABLE IF EXISTS `order_settings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_settings` (
  `order_settings_id` bigint NOT NULL,
  `sub_total` double NOT NULL,
  `created_at` date DEFAULT NULL,
  `session_id` int NOT NULL,
  `shipping` double DEFAULT NULL,
  `order_status` varchar(255) NOT NULL,
  `total` double DEFAULT NULL,
  `user_id` int NOT NULL,
  `vat` double DEFAULT NULL,
  PRIMARY KEY (`order_settings_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_settings`
--

LOCK TABLES `order_settings` WRITE;
/*!40000 ALTER TABLE `order_settings` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_settings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `payment_id` bigint NOT NULL,
  `account_number` varchar(255) NOT NULL,
  `expiry` date NOT NULL,
  `payment_type` varchar(255) NOT NULL,
  `provider` varchar(255) NOT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`payment_id`),
  KEY `FK4spfnm9si9dowsatcqs5or42i` (`user_id`),
  CONSTRAINT `FK4spfnm9si9dowsatcqs5or42i` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `product_id` bigint NOT NULL,
  `product_created_at` date DEFAULT NULL,
  `product_short_description` varchar(255) NOT NULL,
  `product_price` double NOT NULL,
  `product_quantity` int NOT NULL,
  `product_name` varchar(255) NOT NULL,
  `product_category_id` bigint DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `FKcwclrqu392y86y0pmyrsi649r` (`product_category_id`),
  CONSTRAINT `FKcwclrqu392y86y0pmyrsi649r` FOREIGN KEY (`product_category_id`) REFERENCES `product_category` (`product_category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'2021-09-21','The Samsung Galaxy Z Fold3 5G speaks volumes about the South Korean electronics maker Samsung’s efforts to add finesse to its foldable devices.',1620,15,'Samsung Galaxy Z Fold3 5G',1),(2,'2021-09-20','Samsung Galaxy s21 5G',830.25,32,'Samsung Galaxy s21 5G',1),(3,'2021-09-19','The iPhone 13 Pro and iPhone 13 Pro Max are Apple\'s new high-end flagship iPhones. Now available.',1599,10,'Apple iPhone 13 Pro Max',1),(4,'2021-09-18','Text text text text text text text text text text text text text text text text text',456,15,'HONOR Magic3 PRO',1),(5,'2021-09-17','Text text text text text text text text text text text text text text text text text',258,26,'HTC Desire 20+',2),(6,'2021-09-16','Text text text text text text text text text text text text text text text text text',985,32,'NOKIA C30',2),(7,'2021-09-15','Text text text text text text text text text text text text text text text text text',1256.45,5,'XIAOMI Redmi 10 Prime',2),(8,'2021-09-14','Text text text text text text text text text text text text text text text text text',999.99,41,'OPPO  Reno6',2),(9,'2021-09-13','Text text text text text text text text text text text text text text text text text',300,30,'SONY Xperia 5 III',1),(10,'2021-09-12','Text text text text text text text text text text text text text text text text text',687.49,0,'MOTOROLA Moto E20',1),(11,'2021-09-25','Sākuma nots: aldehīdi, ananass, zaļais mandarīns, galbanums, persiks. Sirds nots: neļķe, āda, dzeltenā narcise, muskuss, orhideja. Beigu nots: ambra, sandalkoks, tonka pupiņas, vaniļa, vetivērija.',122.31,6,' Tualetes ūdens Cartier Must de Cartier 100ml EDT',3),(12,'2021-09-24','Sākuma nots: zaļās notis un bergamote. Sirds nots: rozmarīns, lilija, ceriņi, jasmīns, boronija, amarilis, īlang-īlang, maijpuķīte. Beigu nots: sandalkoks un civets.',144.11,25,'Tualetes ūdens Christian Dior Diorissimo 100ml EDT',3),(13,'2021-09-17','ProSense technology® automātiski nosver ievietotās drēbes, lai izveidotu individuāli piemērotu ciklu. Sensori precīzi regulē mazgāšanas laiku, nodrošinot optimālu katra apģērba mazgāšanu.',549,5,'Veļas mašīna AEG L8FEC68S',3),(14,'2021-09-21','The Samsung Galaxy Z Fold3 5G speaks volumes about the South Korean electronics maker Samsung’s efforts to add finesse to its foldable devices.',1620,15,'Samsung Galaxy Z Fold3 5G',1),(15,'2021-09-20','Samsung Galaxy s21 5G',830.25,32,'Samsung Galaxy s21 5G',1),(16,'2021-09-19','The iPhone 13 Pro and iPhone 13 Pro Max are Apple\'s new high-end flagship iPhones. Now available.',1599,10,'Apple iPhone 13 Pro Max',1),(17,'2021-09-18','Text text text text text text text text text text text text text text text text text',456,15,'HONOR Magic3 PRO',1),(18,'2021-09-17','Text text text text text text text text text text text text text text text text text',258,26,'HTC Desire 20+',2),(19,'2021-09-16','Text text text text text text text text text text text text text text text text text',985,32,'NOKIA C30',2),(20,'2021-09-15','Text text text text text text text text text text text text text text text text text',1256.45,5,'XIAOMI Redmi 10 Prime',2),(21,'2021-09-14','Text text text text text text text text text text text text text text text text text',999.99,41,'OPPO  Reno6',2),(22,'2021-09-13','Text text text text text text text text text text text text text text text text text',300,30,'SONY Xperia 5 III',1),(23,'2021-09-12','Text text text text text text text text text text text text text text text text text',687.49,0,'MOTOROLA Moto E20',1),(24,'2021-09-25','Sākuma nots: aldehīdi, ananass, zaļais mandarīns, galbanums, persiks. Sirds nots: neļķe, āda, dzeltenā narcise, muskuss, orhideja. Beigu nots: ambra, sandalkoks, tonka pupiņas, vaniļa, vetivērija.',122.31,6,' Tualetes ūdens Cartier Must de Cartier 100ml EDT',3),(25,'2021-09-21','The Samsung Galaxy Z Fold3 5G speaks volumes about the South Korean electronics maker Samsung’s efforts to add finesse to its foldable devices.',1620,15,'Samsung Galaxy Z Fold3 5G',1),(26,'2021-09-20','Samsung Galaxy s21 5G',830.25,32,'Samsung Galaxy s21 5G',1),(27,'2021-09-19','The iPhone 13 Pro and iPhone 13 Pro Max are Apple\'s new high-end flagship iPhones. Now available.',1599,10,'Apple iPhone 13 Pro Max',1),(28,'2021-09-18','Text text text text text text text text text text text text text text text text text',456,15,'HONOR Magic3 PRO',1),(29,'2021-09-17','Text text text text text text text text text text text text text text text text text',258,26,'HTC Desire 20+',2),(30,'2021-09-16','Text text text text text text text text text text text text text text text text text',985,32,'NOKIA C30',2),(31,'2021-09-15','Text text text text text text text text text text text text text text text text text',1256.45,5,'XIAOMI Redmi 10 Prime',2),(32,'2021-09-14','Text text text text text text text text text text text text text text text text text',999.99,41,'OPPO  Reno6',2),(33,'2021-09-13','Text text text text text text text text text text text text text text text text text',300,30,'SONY Xperia 5 III',1),(34,'2021-09-12','Text text text text text text text text text text text text text text text text text',687.49,0,'MOTOROLA Moto E20',1),(35,'2021-09-25','Sākuma nots: aldehīdi, ananass, zaļais mandarīns, galbanums, persiks. Sirds nots: neļķe, āda, dzeltenā narcise, muskuss, orhideja. Beigu nots: ambra, sandalkoks, tonka pupiņas, vaniļa, vetivērija.',122.31,6,' Tualetes ūdens Cartier Must de Cartier 100ml EDT',3),(36,'2021-09-21','The Samsung Galaxy Z Fold3 5G speaks volumes about the South Korean electronics maker Samsung’s efforts to add finesse to its foldable devices.',1620,15,'Samsung Galaxy Z Fold3 5G',1),(37,'2021-09-20','Samsung Galaxy s21 5G',830.25,32,'Samsung Galaxy s21 5G',1);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_category`
--

DROP TABLE IF EXISTS `product_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_category` (
  `product_category_id` bigint NOT NULL,
  `product_category_created_at` date NOT NULL,
  `product_category_name` varchar(255) NOT NULL,
  PRIMARY KEY (`product_category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_category`
--

LOCK TABLES `product_category` WRITE;
/*!40000 ALTER TABLE `product_category` DISABLE KEYS */;
INSERT INTO `product_category` VALUES (1,'2021-09-19','Phones & Accessories'),(2,'2021-09-16','Garden'),(3,'2021-09-21','Computers & Netbooks'),(4,'2021-09-25','Household Appliances');
/*!40000 ALTER TABLE `product_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `role_id` bigint NOT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (2,'USER'),(3,'EDITOR'),(4,'ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` bigint NOT NULL,
  `user_username` varchar(100) NOT NULL,
  `user_password` varchar(100) NOT NULL,
  `user_first_name` varchar(100) NOT NULL,
  `user_last_name` varchar(200) NOT NULL,
  `user_dob` date DEFAULT NULL,
  `user_phone` varchar(255) DEFAULT NULL,
  `user_email` varchar(255) NOT NULL,
  `user_gender` varchar(255) NOT NULL,
  `user_created_at` date DEFAULT NULL,
  `user_last_login` date DEFAULT NULL,
  `enabled` tinyint DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_j09k2v8lxofv2vecxu2hde9so` (`user_email`),
  UNIQUE KEY `UK_jnu1quvkutdk73q9fa4d7abe3` (`user_username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'user','$2a$10$krGWP3CUfNc4bjwAK50V2.R4VoyCMMB1UhesKYJFgXzics9DR3wAu','Ilmars','Mednis','1965-12-25','28742994','ilmarsm@gmail.com','male','2021-09-26','2021-09-18',1),(2,'admin','$2a$10$uMdQOzz.qT3AeR3xJOAbD.tryYvRCSW3nZ2UheCaYJn.0gze7sxee','Administrator','Super','1999-05-25','12345678','admin@ad,im.com','male','2021-09-02','2021-09-27',1),(3,'janis','$2a$10$eZbgLydjmeWwCw0U4Dw.cuzt1ezHovAaKshQYngcJTFEhrrx/b2MG','Jānis','Dreimanis','1970-01-01','12345678','janis@gmail.com','male','2021-09-20','2021-09-27',1),(4,'ilmars','$2a$10$gJuiHVllO0GZoa4jY8wt9.XMZwKUH/YB9m9o7K2YkpmV9W4hTbPCG','Ilmars','Mednis','1965-12-25','28742994','ilmasm@gmail.com','male','2021-09-27','2021-08-29',1),(5,'linda','$2a$10$ruNBfk/3AR2uvVhkvGdxVuzrJwEgu3tDy8DqkWfQekGxgHu9sD8mq','Linda','Aušte','1990-01-01','12345678','linda@gmail.com','female','2021-09-25','2021-09-26',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_address`
--

DROP TABLE IF EXISTS `user_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_address` (
  `user_address_id` bigint NOT NULL,
  `user_address_line_1` varchar(255) NOT NULL,
  `user_address_line_2` varchar(255) DEFAULT NULL,
  `user_address_city` varchar(255) NOT NULL,
  `user_address_region` varchar(255) NOT NULL,
  `user_address__zip_code` varchar(255) NOT NULL,
  `country_country_id` bigint DEFAULT NULL,
  `user_user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`user_address_id`),
  KEY `FKlsxee070n0ut1litg89bouy6e` (`country_country_id`),
  KEY `FKcp5ewg2f9dl5bi95u5ebqu265` (`user_user_id`),
  CONSTRAINT `FKcp5ewg2f9dl5bi95u5ebqu265` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKlsxee070n0ut1litg89bouy6e` FOREIGN KEY (`country_country_id`) REFERENCES `country` (`country_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_address`
--

LOCK TABLES `user_address` WRITE;
/*!40000 ALTER TABLE `user_address` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_review`
--

DROP TABLE IF EXISTS `user_review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_review` (
  `user_review_id` bigint NOT NULL,
  `user_review` varchar(255) NOT NULL,
  `user_review_created_at` date NOT NULL,
  `user_rating` int DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `product_id` bigint DEFAULT NULL,
  PRIMARY KEY (`user_review_id`),
  KEY `FKk4378yigvs29qpwh8ughgs4gk` (`user_id`),
  KEY `FKdar2k0tl4t2m2j7pbvgxn9reo` (`product_id`),
  CONSTRAINT `FKdar2k0tl4t2m2j7pbvgxn9reo` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `FKk4378yigvs29qpwh8ughgs4gk` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_review`
--

LOCK TABLES `user_review` WRITE;
/*!40000 ALTER TABLE `user_review` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `user_id` bigint DEFAULT NULL,
  `role_id` bigint DEFAULT NULL,
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,2),(2,4),(3,4),(4,4),(5,4);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-30 19:52:26
